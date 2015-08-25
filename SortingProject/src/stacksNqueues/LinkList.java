package stacksNqueues;

public class LinkList {

	private Link first;
	
	public LinkList() {
		first = null;
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	public void insertFirst(long value) {
		Link newLink = new Link(value);
		newLink.next = first;
		first = newLink;
	}
	
	public long deleteFirst() {
		Link temp = first;
		first  = first.next;
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
}
