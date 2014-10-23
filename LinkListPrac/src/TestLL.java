
public class TestLL {
	public static void main(String[] args){
		test();
	}
	
	public static void test(){
		System.out.println("BEGIN TEST");
		LinkedList<String> myLL = new LinkedList<String>();
		myLL.insert("matt");
		myLL.insert("dave");
		myLL.insert("mike");
		myLL.print();
	}
}
