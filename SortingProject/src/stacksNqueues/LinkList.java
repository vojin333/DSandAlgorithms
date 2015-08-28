package stacksNqueues;

public class LinkList {

	private Link first;
	private int size;
	
	public LinkList() {
		first = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	public void insertFirst(long value) {
		Link newLink = new Link(value);
		newLink.next = first;
		first = newLink;
		size++;
	}
	
	public long deleteFirst() {
		Link temp = first;
		first  = first.next;
		size--;
		return temp.dData;
	}
	
	public void displayLinkList() {
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println(" ");
	}
	
	public int size() {
		return size;
	}
}
