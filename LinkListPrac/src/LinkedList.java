
public class LinkedList<E> {
	private int numElements;
	private Node<E> head;
	private Node<E> curr; //current position in the list(all operations are done on the position just past this)
	private Node<E> tail;
	
	//basic constructor
	public LinkedList(){
		head = new Node<E>();
		tail = new Node<E>();
		numElements = 0; 
		curr = head;
	}
	
	/**
	 * clears the entire list
	 */
	public void clear(){
		head.setNext(null); //clear links to rest of the list
		curr = tail = head; //sets the rest of the list to null
		numElements = 0; // resets counter
	}
	
	/**
	 * inserts a new node with the given element right after the current position
	 * then moves the current position to the newly inserted element
	 * @param element the data that wishes to be inserted
	 */
	public void insert(E element){
		curr.setNext(new Node<E>(element, curr.next())); //inserts new node with data after the current and before current's next
		if( tail == curr){
			tail = curr.next(); //increments the tail pointer
		}
		
		numElements++;
		curr = curr.next();
	}
	
	/**
	 * Adds an element to the end of the list
	 * @param element the data that wishes to be appended
	 */
	public void append(E element){
		tail = tail.setNext(new Node<E>(element,null)); //sets the tail to a new node with the data and a null next(since it's the tail)
	}
	
	/**
	 * removes the element after the current node
	 * @return null if no element exists, otherwise returns the data of the removed item
	 */
	public E remove(){
		if(curr.next() == null){ //checks if there is a node there to begin with 
			return null;
		}
		
		E ele = curr.next().getData(); //grabs data
		if(tail == curr.next()){ //if we are at the end of the list
			tail = curr; //pull tail back 1 element
		}
		
		curr.setNext(curr.next().next()); //currents next is now the one after
		numElements--; //obvious
		
		return ele;
	}
	
	/**
	 * set current to the head 
	 */
	public void moveToBegin(){
		curr = head;
	}
	
	/**
	 * set current to the tail
	 */
	public void moveToEnd(){
		curr = tail;
	}
	
	/**
	 * Moves curr position to one previous. If the list is already at the head then nothing happens.
	 */
	public void previous(){
		if(curr == head){ //no change if already at the start of the list
			return;
		}
		
		Node<E> temp = head; //temp node to loop through list
		while(temp.next() != curr){ //check the next node of the temp and compare to current
			temp = temp.next(); //move down list
		}
		
		curr = temp; //if temp.next() == curr we want to move current to temp, to pull it back one spot
	}
	
	/**
	 * moves curr position to the next element unless the list is already at the tail
	 */
	public void next(){
		if(curr != tail){ //if not at end of list
			curr = curr.next(); //move down one
		}
	}
	
	/**
	 * @return the number of elements in the list
	 */
	public int length(){
		return numElements;
	}
	
	/**
	 * @return the numerical position the list is currently at
	 */
	public int currPos(){
		Node<E> temp = head;
		int pos = 0;
		while(temp != curr){
			temp = temp.next(); //counts up until we reach our position
			pos++;
		}
		
		return pos;
	}
	
	/**
	 * moves the current pointer to a desired position. 
	 * @param pos The index of the list to increment to
	 */
	public void moveToPos(int pos){
		if( pos <= 0 || pos >= numElements){
			return; //out of range
		}
		
		curr = head; //start at beginning
		for(int i = 0; i < pos; i++){ 
			curr = curr.next(); //move down until desired position is reached
		}
	}
	
	/**
	 * Prints the entire list from start to end
	 */
	public void print(){
		Node<E> temp = head.next();
		for(int i = 0; i < numElements; i++){
			System.out.println(temp.toString());
			temp = temp.next();
		}
	}
	
	/**
	 * @return the data of the node after the current
	 */
	public E getValue(){
		return curr.next().getData(); //grab data of element after current
	}
}
