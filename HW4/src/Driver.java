
public class Driver {
	public static void main(String[] args){
		Record word1 = new Record("matt",1);
		Record word2 = new Record("dave",2);
		Record word3 = new Record("bloch",3);
		HashTable myTable = new HashTable();
		
		
		myTable.insert(word1); 
		myTable.insert(word2); 
		myTable.insert(word3); 
		System.out.println("testing find");
		System.out.println(myTable.find(word1));//should print a 1
		System.out.println(myTable.find(word2));//should print a 2
		System.out.println(myTable.find(word3));//should print a 3
		System.out.println(myTable.find(new Record("blarh",5))); //should print a -1
		
		System.out.println();
		myTable.print(); //prints the table
						//should be bloch 3, dave 2, matt 1
		

		
		
		System.out.println("testing delete");
		myTable.delete(word2); 
		myTable.print(); //should print bloch 3, matt 1
		
		System.out.println("testing find after deleting dave's record");
		System.out.println(myTable.find(word1)); //should be a 1
		System.out.println(myTable.find(word2)); //should be a -1
		System.out.println(myTable.find(word3)); //should be a 3
		System.out.println(myTable.find(new Record("blarh",5))); //should be a -1
		
		
		myTable.delete(word1);
		System.out.println("testing find after deleting matt's record");
		System.out.println(myTable.find(word1)); //should be a -1
		System.out.println(myTable.find(word2)); //should be a -1
		System.out.println(myTable.find(word3)); //should be a 3
		
		System.out.println("testing clear(nothing should print)");
		myTable.clear();
		myTable.print();
		
		System.out.println("re-inserting and printing");
		myTable.insert(word1); //same as above
		myTable.insert(word2);
		myTable.insert(word3);
		myTable.print();
		
		
		System.out.println("\ntesting isEmpty/clear");
		System.out.println(myTable.isEmpty()); //should be false
		myTable.clear();
		System.out.println(myTable.isEmpty()); //should be true
		
		
		
		System.out.println("\n**Testing concordance**");
		String concordance = "Dr. Siegfried's traditional project for this course: a \"concordance\" program that takes in a bunch of text, breaks it into words, " +
				  "and produces an alphabetized list of words, with the number of times each word appears in the text." +
				 " A \"word\" is defined, for purposes of this problem," +
				  " as a sequence of one or more letters: you can throw away spaces, punctuation, numbers, newlines, etc";
		
		String concord2 = "a apple bat word, word test word test yours with the of times each word appears in the text";
		
		
		String[] words = concordance.split(" ");
		String[] words2 = concord2.split(" ");
		Record[] records = Record.makeRecords(words);
		Record[] records2 = Record.makeRecords(words2);
	
		
		for(int i = 0; i < records.length; i++){
			myTable.insert(records[i]);
		}
		myTable.print();
		
		myTable.clear();
		System.out.println("END OF FIRST CONCORDANCE \n");
		System.out.println("\n START OF SECOND CONCORDANCE");
		for(int i = 0; i < records2.length; i++){
			myTable.insert(records2[i]);
		}
		
		myTable.print();
		
		myTable.clear();
		
		
	}
}
