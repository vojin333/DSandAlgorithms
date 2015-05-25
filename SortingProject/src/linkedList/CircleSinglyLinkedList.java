package linkedList;

public class CircleSinglyLinkedList {

	private Link current;
	private int nElemes;
	
	public CircleSinglyLinkedList() {
		current = null;
		nElemes = 0;
	}
	
	public boolean isEmpty() {
		return (current == null);
	}
	
	public void insert() {
		Link newLink = new Link(0, 0);
		if(isEmpty()) {
			current = newLink;
		} else if(current.next == null) {
			//only one element is in list
			current.next = newLink;
			newLink.next = current;
			current = newLink;
		} else {
			current.next = newLink;
			newLink.next = current.next;
			current = newLink;
		}
		nElemes++;
	}
	
	public void display() {
		for (int i = 0; i <= nElemes; i++) {
			current.displayLink();
			current = current.next;
		}
	}
	
	
}
