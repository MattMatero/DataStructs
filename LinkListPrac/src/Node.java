
public class Node<E> {
	private Node<E> next;
	private E data;
	
	public Node(){
		next = null;
		data = null;
	}
	
	public Node(E data, Node<E> nextNode){
		this.data = data;
		next = nextNode;
	}
	
	public Node<E> setNext(Node<E> n){
		next = n;
		return next;
	}
	
	public Node<E> next(){
		return this.next;
	}
	
	public E setData(E data){
		this.data = data;
		return this.data;
	}
	
	public E getData(){
		return data;
	}
	
	public String toString(){
		return "data: " + data;
	}
}
