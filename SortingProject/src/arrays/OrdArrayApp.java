package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import linkedList.CircleList;
import linkedList.JosephusCircle;
import linkedList.Person;

import stacksNqueues.Reverser;

public class OrdArrayApp {

	/**
	 * @param args
	 * @see 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Arrrays
//		int maxSize = 100; // array size
//		OrdArray arr; // reference to array
//		
//		arr = new OrdArray(maxSize); // create the array
//		arr.insert(77); // insert 10 items
//		arr.insert(99);
//		arr.insert(44);
//		arr.insert(55);
//		arr.insert(22);
//		arr.insert(88);
//		arr.insert(11);
//		arr.insert(00);
//		arr.insert(66);
//		arr.insert(33);
//		System.out.println("Size : " + arr.size());
//		int searchKey = 55; // search for item
//		if(arr.find(searchKey) != arr.size() ) {
//			System.out.println("Found " + searchKey);
//		} else {
//			System.out.println("Can’t find " + searchKey);
//		}
//		arr.display(); // display items
//		arr.delete(00); // delete 3 items
//		arr.delete(55);
//		arr.delete(99);
//		arr.display();
		
//		String input, output;
//		
//		while (true) {
//			System.out.print("Enter a string: ");
//			System.out.flush();
//			input = getString(); // read a string from kbd
//			if (input.equals("")) {
//				break;
//			} // quit if [Enter]
//			// make a Reverser
//			Reverser theReverser = new Reverser(input);
//			output = theReverser.doRev(); // use it
//			System.out.println("Reversed: " + output);
//		} 
		
		//Josephus Circle example
		JosephusCircle theList = new JosephusCircle();
		
		theList.insertNextToCurrentWithoutConstruct(1, "Mike");
		theList.insertNextToCurrentWithoutConstruct(2, "Nina");
		theList.insertNextToCurrentWithoutConstruct(3, "Marko");
		theList.insertNextToCurrentWithoutConstruct(4, "Vojin");
		theList.insertNextToCurrentWithoutConstruct(5, "Dejan");
		theList.insertNextToCurrentWithoutConstruct(6, "Lazar");
		theList.insertNextToCurrentWithoutConstruct(8, "Dusan");
		theList.insertNextToCurrentWithoutConstruct(9, "Mirko");
		theList.insertNextToCurrentWithoutConstruct(10, "Slavko");
		theList.insertNextToCurrentWithoutConstruct(11, "Gagi");
		theList.insertNextToCurrentWithoutConstruct(12, "Zox");
		
		theList.displayList();
		theList.displayCurrent();
		
		theList.suicideCircle(1, 3);
	
		System.out.println("The left one");
		theList.displayList();
		theList.displayCurrent();
		
		
//		//move current one postion
//		theList.moveCurrent();
//		theList.displayCurrent();
//		
//		//move current one postion
//		theList.moveCurrent();
//		theList.displayCurrent();
//
//		//move current one postion
//		theList.moveCurrent();
//		theList.displayCurrent();
//
//		theList.displayList();
//		
//		System.out.println("Size : "  + theList.size());
//		
//		Person toFind = theList.findByPostion(2);
//		
//		toFind.displayPerson();
		
		

		
	}

	public static String getString() throws IOException
	{
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(isr);
	String s = br.readLine();
	return s;
	}
	
}
