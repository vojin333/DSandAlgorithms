package stacksNqueues;

public class LinkListQ {

	private Link first;
	private Link last;
	private int size;
	
	public LinkListQ() {
		first = null;
		last = null;
		size = 0;
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
		size++;
		
	}
	
	public long deleteFirst() {
		Link temp = first;
		if(first.next == null) {
			last = null;
		} else {
			first = first.next;
		}
		size--;
		return temp.dData;
	}
	
	public int size() {
		return size;
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
