import java.util.Comparator;

/**
 * Array based list implementation 
 * @author Matt Matero 
 * @since 10/10/13
 * @param <E> The type of object this list holds
 * 
 * 
 */
public class ArrayLink<E> implements MList<E> {
	private final int defaultSize = 10;
	private int max; //max size of list
	private int listElements; //actual number of elements
	private int curr; //current pos
	private E[] list; // the actual list
	
	
	/**
	 * Constructor for a default list
	 */
	public ArrayLink(){
		list = (E[]) new Object[defaultSize];
		max = defaultSize;
		listElements = 0;
		curr = 0;
	}
	
	/**
	 * Constructor that takes in a single integer that determines the maximum size of the list
	 * @param size - the max size of the list
	 */
	public ArrayLink(int size){
		max = size;
		list = (E[]) new Object[max];
		listElements = 0; 
		curr = 0;
	}
	
	/**
	 * Clears the list by reinitializing the values
	 */
	public void clear(){
		listElements = 0;
		curr = 0;
	}
	
	/**
	 * removes an item from the list at current pos
	 * @return E the item
	 */
	public E remove(){
		if(curr >= listElements){
			return null; //if current is past the list
		}
		
		E item = list[curr];
		for(int i = curr; i <listElements -1; i++){
			list[i] = list[i + 1];
		}
		
		listElements -= 1;
		return item;
	}
	
	/**
	 * Inserts a given item into the list at position current
	 * @param item - an item to be inserted into the list
	 */
	public void insert(E item){
		
		if(listElements >= max){
			this.max = this.max *2; //if we don't have the room, we double the array size
			E[] newList = (E[]) new Object[max]; //new array with the larger size
			for(int i = 0; i < listElements; i++){ //copy elements
				newList[i] = list[i];
			}
			list = newList; //alias the arrays
		}
		
		for(int i = listElements; i > curr; i--){
			list[i] = list[i - 1]; 
		}
		
		list[curr] = item;
		listElements++;
	}
	
	/**
	 * Adds an item to the end of the list
	 * @param item - an item to be appended to the list
	 */
	public void append(E item){
		if(listElements >= max){
			this.max = this.max*2;
			E[] newList = (E[]) new Object[max]; //new array with the larger size
			for(int i = 0; i < listElements; i++){ //copy elements
				newList[i] = list[i];
			}
			list = newList; //alias the arrays
		}
		list[listElements++] = item;
	}
	
	/**
	 * Sets current position to the start of the list
	 */
	public void moveToStart(){
		curr = 0; //sets list to beginning
	}
	
	/**
	 * Sets current position to the end of the list + 1 (just past the last element)
	 */
	public void moveToEnd(){
		curr = listElements + 1;
	}
	
	/**
	 * moves current position to the previous item in the list as long as it isn't already at the head
	 */
	public void prev(){
		if(curr != 0)
			curr = --curr;
	}
	
	/**
	 * moves current position to the next item in the list as long as there is one
	 */
	public void next(){
		if(curr < listElements)
			curr = ++curr;
	}
	
	/**
	 * @return int - the number of elements in the list
	 */
	public int length(){
		return listElements;
	}
	
	/**
	 * Moves the current position to the given position. If the position is out of bounds, current is unchanged and a message is printed.
	 * @param position - The position we would like to move to
	 */
	public void moveToPos(int position){
		try{
			if(position > max)
				throw new IndexOutOfBoundsException();
			
			curr = position;
		}catch(IndexOutOfBoundsException e){
			System.out.println(e.toString());
			System.out.println("Current position not changed");
		}
	}
	
	/**
	 * Determines if the current position has an element or doesn't.  
	 */
	public boolean currentElementExists(){
		if(curr < 0 || curr > listElements)
			return false;
		if(list[curr] == null)
			return false;
		
		
		return true;
	}
	
	/**
	 * Currents a String that represents the List. An element marked with << element >> is the current element
	 * @return theList - A string representing the current list
	 */
	public String toString(){
		String theList = "";
		
		for(int i = 0; i < listElements; i++){		
			if(i == curr){
				theList += "<<" + list[i] + ">>";
			}else{
				theList += list[i] + " ";
			}		
		}
		return theList;
	}
	
	/**
	 * @return The current position
	 */
	public int currPos(){
		return curr;
	}
	
	/**
	 * Gets the element at current position. If the curr pos is out of bounds it will return the first element
	 * @return item - the item in the list
	 */
	public E getValue(){
		if(curr < 0 || curr > listElements){
			return list[0]; //if current position is out of bounds just return the first element in the list
		}
		
		return list[curr];
	}

	/**
	 * sort - Sorts the list from lowest value to highest using a bubble sort
	 * @param order - a comparator to compare the elements
	 */
	public void sort(Comparator<E> order){
		
		if(listElements == 0){
			return;
		}
		
		if(listElements == 1){
			return;
		}
		
		E temp; //temp variable to hold elements
		
		//Bubble sort 
		for(int i = 0; i < listElements; i++){
			for(int j = i; j < listElements-1; j++){
				if(order.compare(this.list[i],this.list[j + 1])  == -1 ){
					temp = this.list[j+1];
					this.list[j+1] = this.list[i];
					this.list[i] = temp;
				}
			}
		}
	}
	
	@Override
	/**
	 * Makes the list empty(Clears the list)
	 */
	public MList<E> makeEmpty() {
		this.clear();
		return this;
	}
}
