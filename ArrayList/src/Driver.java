import java.util.Comparator;
/**
 * Test cases for the list
 * @author Matt Matero
 *
 */

public class Driver {
	public static void main(String[] args){
		ArrayLink<String> test = new ArrayLink<String>(10);
		
		test.append("This");
		test.append("is");
		test.append("a");
		test.append("test");
		System.out.println(test.toString());
		
		test.moveToEnd();
		System.out.println(test.toString());
	
		test.moveToPos(3);
		System.out.println(test.toString());
		
		test.clear();
		System.out.println(test.toString());
				
		test.append("This");
		test.append("is");
		test.append("a");
		test.append("test");
		System.out.println(test.toString());
		
		test.remove();
		System.out.println(test.toString());
		
		test.insert("this");
		System.out.println(test.toString());
		
		test.moveToEnd();
		System.out.println(test.toString());
	
		test.moveToStart();
		System.out.println(test.toString());
		
		test.next();
		System.out.println(test.toString());
		
		test.prev();
		System.out.println(test.toString());
		
		System.out.println(test.length());
		
		test.moveToPos(3);
		System.out.println(test.toString());
		
		System.out.println(test.currentElementExists());
		
		System.out.println(test.getValue());
		
	/*	test.moveToPos(15);
		System.out.println(test.toString());
		*/
		test.append("more");
		test.append("text");
		test.append("is");
		test.append("needed");
		test.append("for");
		test.append("testing");
		test.append("this");
		test.append("list");
		
		System.out.println(test.toString());
		
		ArrayLink<String> test2 = new ArrayLink<String>();
		
		for(int i = 0; i < 25; i++){
			test2.insert("num " + i);
		}
		System.out.println(test2.toString());
		
		for(int i = 0; i < 25; i++){
			test2.remove();
		}
		System.out.println(test2.toString() + "empty?");
		
		System.out.println(test.currPos());
		System.out.println(test);
		test.next();
		System.out.println(test.currPos());
		System.out.println(test);
	}
}
