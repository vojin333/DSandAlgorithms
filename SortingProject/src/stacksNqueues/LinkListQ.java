package stacksNqueues;

public class LinkListQ {

	private Link first;
	private Link last;
	
	public LinkListQ() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	public void insertLast(long value) {
		Link newLink  = new Link(value);
		if (isEmpty()) {
			first = newLink;
		} else {
			last.next = newLink;
		}
		last = newLink;
	}
	
	public long deleteFirst() {
		Link temp = first;
		if(first.next == null) {
			last = null;
		} else {
			first = first.next;
		}
		return temp.dData;
	}
	
	public void displayList() {
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println(" ");
	}
}
