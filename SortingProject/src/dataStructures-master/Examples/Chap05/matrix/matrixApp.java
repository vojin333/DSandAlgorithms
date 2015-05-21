package Ch05;

//Matrix App using Singly Linked List
//User will enter the required no. of rows and columns in matrix
//Each link (except those on the top row and left side) 
//is pointed to by the link directly above it and by the link on its left.
//You should be able to insert values in specified links 
//and display the contents of the matrix.

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class Link {
	private int data;
	private Link next;
	private Link down;

	public Link() {
		data = 0;
		next = null;
		down = null;
	}

	public void displayLink() {
		System.out.print(data + " ");
	}

	// Setters
	public void setData(int d) {
		data = d;
	}

	public void setNext(Link n) {
		next = n;
	}

	public void setDown(Link d) {
		down = d;
	}

	// Getters
	public int getData() {
		return data;
	}

	public Link getNext() {
		return next;
	}

	public Link getDown() {
		return down;
	}
}

class circularSinglyLinkedList {
	private int size;
	private Link current;

	public circularSinglyLinkedList() {
		size = 0;
		current = null;
	}

	public boolean isEmpty() {
		return (current == null);
	}

	public void create(int s) {
		size = s;
		for (int i = 1; i <= size; i++) {
			Link newLink = new Link();
			if (isEmpty()) {
				current = newLink;
				//current.setNext(null);
			} else if (current.getNext() == null) {
				current.setNext(newLink);
				newLink.setNext(current);
				current = newLink;
			} else {
				newLink.setNext(current.getNext());
				current.setNext(newLink);
				current = newLink;
			}
		}
		if (!(current.getNext() == null)) {
			step(); // To point current back to first Link
		}

	}

	public void display() {
		//System.out.println("Current --> End");
		for (int i = 1; i <= getSize(); i++ ) {
			current.displayLink();
			if (!(current.getNext() == null)) {
				step();
			}
		}
		System.out.println();
	}

	public void step() {
		current = current.getNext();
	}

	public Link getCurrent() {
		return current;
	}

	public int getSize() {
		return size;
	}
}

class matrixApp {
	private static int rows;
	private static int columns;
	private static circularSinglyLinkedList[] cLinkedLists;

	public static void main(String[] args) throws IOException {
		System.out.println("For Matrix, Enter the number of rows: ");
		rows = getInput();
		System.out.println("For Matrix, Enter the number of columns: ");
		columns = getInput();

		cLinkedLists = new circularSinglyLinkedList[5];
		for (int i = 0; i < rows; i++) {
			cLinkedLists[i] = new circularSinglyLinkedList();
			cLinkedLists[i].create(columns);
			//cLinkedLists[i].display();
		}
		//displayMatrix();

		// Now use down to point to next row
		for (int i = 0; i < rows-1 ; i++) {
			for (int j = 0; j < columns; j++) {
				cLinkedLists[i].getCurrent().setDown(cLinkedLists[i+1].getCurrent());
				cLinkedLists[i].step();
				cLinkedLists[i+1].step();
			}
		}

		System.out.println("Matrix with Single Linked List created as required...Yayy ...!!!");

		System.out.println("Now lets insert some data to Matrix...");
		while(true) {
			System.out.println("1. Insert, 2. Display, 3. Quit App");
			int choice = getInput();

			switch (choice) {
			case 1:
				Link pointer = cLinkedLists[0].getCurrent();
				System.out.println("Input the row number where you want to insert data in Matrix: ");
				int r = getInput();
				System.out.println("Input the column number where you want to insert data in Matrix: ");
				int c = getInput();

				if (r > rows || c > columns ) {
					System.out.println("There is no cell with row number: " + r + " and column number: " + c + " try again BOY..");
				} else {
					System.out.println("Input data that you want to insert at Row: " + r + " and  Column: " + c + " :");
					int rcData = getInput();
					System.out.println("Lets move to the requested row...");
					for (int k = 1; k < r; k++) {
						pointer = pointer.getDown(); 
					}
					System.out.println("Lets move to the requested column now...");
					for (int l = 0; l < c-1; l++) {
						pointer = pointer.getNext();
					}
					pointer.setData(rcData);
					System.out.println("Inserted data, check by displaying Matrix... :-) ");
				}
				break;
			case 2:
				System.out.println("Displaying Matrix....");
				displayMatrix();
				break;
			case 3:
				System.out.println("Quiting App as requested ....Bye..  :-( ");
				System.exit(0);
				break;
			default:
				System.out.println("BOY...!!! Huuhh you selected invalid menu option, try again :-) ");
				break;
			} 
		}

	}

	public static void displayMatrix() {
		for (int i = 0; i < rows; i++ ) {
			cLinkedLists[i].display();
		}
	}

	public static int getInput() throws IOException {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		return Integer.parseInt(br.readLine());
	}
}
