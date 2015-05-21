package linkedList;

public class CircleList {

	private Link current;
	
	public CircleList() {
		current  = null;
	}
	
	public boolean isEmpty() {
		return (current == null);
	}
	
	public void insertNextToCurrent(int iD, double dD) {
		if (isEmpty()) {
			current = new Link(iD, dD, null);
			current.next = current;
		} else {
			current.next = new Link(iD, dD, current.next);
		}
	}
	//this implementation is for inserting 
	public void insertNextToCurrentWithoutConstruct(int iD, double dD) {
		Link newLink = new Link(iD, dD);
		if (isEmpty()) {
			current = newLink;
			current.next = current;
		} else {
			newLink.next = current.next;
			current.next = newLink;
		}
	}
	
	public void displayList() {
		System.out.print("List (first-->last): ");
		Link starting = current.next;
		while (starting.dData != current.dData) {
			starting.displayLink();
			starting = starting.next;
		}
		current.displayLink();
		System.out.println("");
	}
	
	public void displayCurrent() {
		System.out.print("Current : ");
		current.displayLink();
		System.out.println("");
	}
	
	public void moveCurrent() {
		current = current.next;
	}
	
	public void displayListReverse() {
		System.out.print("List (first-->last): ");
		Link starting = current.next;
		while (starting.dData != current.dData) {
			starting.displayLink();
			starting = starting.next;
		}
		current.displayLink();
		System.out.println("");
	}
}
