import java.util.Arrays;
import java.util.Comparator;
/**
 * 
 * @author Matt Matero
 *
 */

public class Record {
	private String key;
	private int value;

	//default constructor
	public Record(){
	}

	/**
	 * returns a readable format of a record as a string
	 */
	public String toString() {
		return "Record [key=" + key + ", value=" + value + "]";
	}
	/**
	 * Constructor that sets class attributes
	 * @param newKey - the key that you wish to use
	 * @param newVal - the value it holds
	 */
	public Record(String newKey,int newVal){
		key = newKey;
		value = newVal;
	}

	/**
	 * adds one to the value of a record(used for concordance)
	 */
	public void update(){
		value = value+1;
	}

	/**
	 * simple getter for the key
	 * @return the key of a record
	 */
	public String getKey(){
		return key;
	}

	/**
	 * simple getter for the value of a record
	 * @return the value of a record
	 */
	public int getValue(){
		return value;
	}

	/*	public int hashCode() {
		int hash=2;
		int sum = 0;	
		for (int i=0; i < key.length(); i++) { 
			sum = key.charAt(i);
		}
		return hash*sum;
	}*/

	/**
	 * Hash function for a record
	 */
	public int hashCode(){
		int hash=3;
		for (int i=0; i < key.length(); i++) {
			hash = hash*31+key.charAt(i);
		}
		return hash;
	}

	/**
	 * Equals method for a record
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Record other = (Record) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (value != other.value)
			return false;
		return true;
	}


	/**
	 * A helper method for concordance, takes in an array of strings and creates a record for each one
	 * with a value of 1 and then returns an array of those records
	 * @param arr - an array of strings that are to be made into records
	 * @return an array of records 
	 */
	public static Record[] makeRecords(String[] arr){
		Record[] newRecords = new Record[arr.length];

		for(int i =0; i < arr.length; i++){
			newRecords[i] = new Record(arr[i],1);
		}
        //Record temp = new Record();
        //temp.sort(newRecords);
		return newRecords;
	}

	/*public void sort(Record[] records){
		
		if(records == null){
			return;
		}
		
		if(records.length == 1){
			return;
		}
		
		Record temp = new Record(); //temp variable to hold elements
		
		for (int k = 0; k < records.length; k++)
		{
		
		for(int i = 0, j = 1; j < records.length; i++, j++){
			
			System.out.println(records[i].getKey());
			System.out.println(records[j].getKey());
			
			System.out.println(records[i].getKey().compareTo(records[j].getKey()));
			
			System.out.println();
				if(records[i].getKey().compareTo(records[j].getKey()) > 0){
					
					System.out.println("SWAPPED!");
					
					//System.out.println("Record 1: " + records[i]);
					//System.out.println("Record 2: " + records[j]);
					temp = records[j];
					records[j] = records[i];
					records[i] = temp;
				}
		}
		}
	}*/
	
	/**
	 * checks alphabetical order of strings. if the first parameter is alphabetically before the second, it returns positive. If they are equal
	 * 0 is return. if the first parameter is alphabetically after the second, it returns negative. 
	 * @param one
	 * @param two
	 * @return
	 */
	private int checkAlphabetical(String one, String two){
		int length = Math.min(one.length(), two.length());
		
		if(one.equals(two)){
			return 0;
		}
		for(int i = 0; i < length; i++){
			if(one.charAt(i) < two.charAt(i)){
				return 1;
			}
			if(one.charAt(i) > two.charAt(i)){
				return -1;
			}
		}
		
		return -1;
	}
}
	

