/**
 * 
 * @author Matt Matero
 *
 */

public class HashTable {
	private int size;
	private  Record[] table;
	private int numKeys = 0;
	
	
	/**
	 * default constructor
	 * Sets initial size to 1000
	 */
	public HashTable(){
		size = 1000;
		table = new Record[size];
	}

	/**
	 * Constructor that takes in a size parameter to set the initial size
	 * @param size - the initial size of the table
	 */
	public HashTable(int size){
		this.size = size;
		table = new Record[size];
	}

	/**
	 *  insert will take the given record and put it into the table. If there is a collision we will move to the next available spot
	 *  and put the object there, unless the records are equal then it will call the Record's update method
	 * @param myRecord - the record you are attempting to insert into the table
	 */
	public void insert(Record myRecord){
		int hashLoc = this.checkHash(myRecord.hashCode()%size); //index
		this.checkHash2(hashLoc);
		this.growTable();
		if(table[hashLoc] == null || table[hashLoc] instanceof BlankRecord){ //check if spot is open
			table[hashLoc] = myRecord;
			numKeys++;
		}else if(table[hashLoc].getKey().equals(myRecord.getKey())){ //collide but records are the same
			table[hashLoc].update(); //calls the records update method
		}else{ //there was a collision
			for(;hashLoc < table.length; hashLoc++){ //move to next open spot and insert
				if(table[hashLoc] == null || table[hashLoc] instanceof BlankRecord){
					table[hashLoc] = myRecord;
					numKeys++;
					break;
				}else if(hashLoc == size){
					size++;
					table[hashLoc+1] = myRecord;
				}
			}
		}
	}
	
	/**
	 * Helper method to insure the hash stays in bounds
	 * @param hash the hashed key
	 * @return the working hash
	 */
	private int checkHash(int hash){
		if(hash < 0 ){
			return hash*-1;
		}
		
		return hash;
	}
	
	/**
	 * Helper method used to fixup inserts done on the last spot of the table
	 * @param hash
	 * @return
	 */
	private void checkHash2(int hash){
		if(hash == size && table[size] != null){
			size++;
		}
	}

	/**
	 * Finds a record by the given key and deletes it if they are the same, replaces the record with a BlankRecord flag
	 * to make sure find still works
	 * @param myRecord - the record to delete
	 */
	public void delete(Record myRecord){
		int hashLoc = this.checkHash(myRecord.hashCode()%size);
		if(table[hashLoc].getKey().equals(myRecord.getKey())){
			table[hashLoc] = new BlankRecord();
			numKeys--;
		}else{
			hashLoc++;
			for(;hashLoc<table.length; hashLoc++){
				if(table[hashLoc].getKey().equals(myRecord.getKey())){
					table[hashLoc] = new BlankRecord();
					numKeys--;
					break;
				}
			}
		}
	}

	/**
	 * Looks for a record in the table and gets its value
	 * @param myRecord - the record we are searching for
	 * @return int - the value of the record. if not found it returns -1
	 */
	public int find(Record myRecord){
		int hashLoc = this.checkHash(myRecord.hashCode()%size); //index
		if(table[hashLoc] == null || table[hashLoc] instanceof BlankRecord){ //no record at the location
			return -1;
		}
		else if(table[hashLoc].getKey().equals(myRecord.getKey())){ //record is there and they are the same
			return table[hashLoc].getValue();
		}else{ //record is there but they are not the same, we had a collision
			hashLoc++;
			for(;hashLoc<table.length; hashLoc++){ //continue looking for the key.
				if(table[hashLoc] == null){ //stops if open spot is found. Insert would've put it in the next open spot if it collided
					return -1;
				}else{
					if(table[hashLoc].getKey().equals(myRecord.getKey())){
						return table[hashLoc].getValue();
					}
				}

			}

			return -1;
		}
	}

	/**
	 * if the size of the table becomes too small it will double
	 */
	private void growTable(){
		if(numKeys >= size){
			Record[] newTable = new Record[size*2];
			for(int i = 0; i < numKeys; i++){ //copy elements
				newTable[i] = table[i];
			}
			table = newTable; //alias
		}

	}

	/**
	 *  Tests if the hashtable maps no keys to values
	 * @return true if hashtable is empty false otherwise
	 */
	public boolean isEmpty(){
		for(int i =0; i < table.length; i++){
			if(table[i] != null){
				return false; //if an element is there, the table is not empty
			}
		}	
		return true; //table is empty
	}


	/**
	 * @return a collection of all keys currently in the table. In the form of an array
	 */
	public String[] getKeys(){
		String[] keys = new String[numKeys];
		int i = 0;
		int j = 0;
		while(i < table.length){
			if(table[i] != null && !(table[i] instanceof BlankRecord)){
				keys[j] = table[i].getKey();
				j++;
			}
			i++;
		}
		return keys;
	}

	/**
	 * @return a collection of all values currently in the table
	 */
	private int[] getValues(){
		int[] values = new int[numKeys];
		int i = 0;
		int j = 0;
		while(i < table.length){
			if(table[i] != null && !(table[i] instanceof BlankRecord)){
				values[j] = table[i].getValue();
				j++;
			}
			i++;
		}
		return values;
	}
	
	/**
	 *  prints the table
	 */
	public void print(){
		String[] keys = this.getKeys();
		int[] values = this.getValues();

		
		
		sort(keys, values);
		
		for(int i = 0; i < keys.length; i++){
			System.out.println(keys[i] + " " + values[i] + " ");
		}
		System.out.println();
	}
	
	public void sort(String[] k, int[] v)
	{
		boolean swapped;
		
		do
		{
			swapped = false;
			for(int i = 0; i < k.length - 1; i++)
			if( k[i].compareTo( k[i + 1]) > 0)
			{
				String temp = k[i];
				k[i] = k[i + 1];
				k[i + 1] = temp;
				
				int temp1 = v[i];
				v[i] = v[i + 1];
				v[i + 1] = temp1;
				
				swapped = true;	
			}
			
		}while(swapped);
	}
	
	/**
	 * clears the table
	 */
	public void clear(){
		table = new Record[size];
		numKeys = 0;
	}
	

}
