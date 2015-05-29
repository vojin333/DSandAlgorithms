package linkedList;

public class DoublyLinkedList {

	
	private DLink first;
	private DLink last;
	
	public DoublyLinkedList() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	public void insertFirst(double dD) {
		DLink newLink = new DLink(dD);
		
		if (isEmpty()) {
			last = newLink;
		} else {
			first.previous = newLink;
		}
		newLink.next = first;
		first = newLink;
	}
	
	public void insertLast(double dD) {
		DLink newLink = new DLink(dD);
		
		if (isEmpty()) {
			first = newLink;
		} else {
			last.next = newLink;
			newLink.previous = last;
		}
		
		last = newLink;
	}
	
	public DLink deleteFirst() {
		DLink temp = first;
		
		if (first.next == null) {
			last = null;
		} else {
			first.next.previous = null;
		}
		first = first.next;
		return temp;
	}
	
	public DLink deleteLast() {
		DLink temp = last;
		
		if (first.next == null) {
			first = null;
		} else {
			last.previous.next = null;
		}
		last = last.previous;
		return temp;
	}
	
	public boolean inserAfterKey(double key, double value) {
		DLink newLink = new DLink(value);
		
		DLink current = first;
		while(current != null && value > current.dData) {
			current = current.next;
			if (current == null) {
				return false;
			}
		}
		
		if (current == last) {
			newLink.next = null;
			last = newLink;
		} else {
			newLink.next = current.next;
			current.next.previous = newLink;
		}
		current.next = newLink;
		newLink.previous = current;
		return true;
	}
	
	
	public DLink deleteKey(double key, double value) {
		
		DLink current = first;
		while(current != null && value != current.dData) {
			current = current.next;
			if (current == null) {
				return null; //can't find it
			}
		}
		
		if (current == first) {
			first = current.next;
		} else {
			current.previous.next = current.next;
		}

		if (current == last) {
			last = current.previous;
		} else {
			current.next.previous = current.previous;
		}
		return current;
	}
	
	public void displayForward() {
		System.out.println("Dispaly First => Last");
		DLink current = first;
		while(current.next != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}
	
	
	public void displayBackward() {
		System.out.println("Dispaly Last => First");
		DLink current = last;
		while(current.previous != null) {
			current.displayLink();
			current = current.previous;
		}
		System.out.println("");
	}
}
