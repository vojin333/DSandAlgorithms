package linkedList;

public class ListIterator {

	private Link current; 
	private Link previous;
	private LinkList ourList;
	
	public ListIterator(LinkList list) {
		ourList = list;
		reset();
	}
	
	public void reset() {
		current = ourList.getFirst();
		previous = null;
	}
	
	public boolean atEnd() {
		return (current.next == null);
	}
	
	public void nextLink() {
		previous = current;
		current = current.next;
	}
	
	public Link getCurrent() {
		return current;
	}
	
	public void insertAfter(int iD, double dD) {
		Link newLink = new Link(iD, dD);
		
		if (ourList.isEmpty()) {
			ourList.setFirst(newLink);
			current = newLink;
		} else {
			newLink.next = current.next;
			current.next = newLink;
			nextLink();
		}
	}
	
	public void insertBefore(int iD, double dD) {
		Link newLink = new Link(iD, dD);
		
		if (previous == null) {
			newLink.next = ourList.getFirst();
			ourList.setFirst(newLink);
			reset();
		} else {
			
			newLink.next = current;
			previous.next = newLink;
			current = newLink;
		}
	}
	
	public Link deleteCurrent() {
		Link temp = current;
		
		if (previous == null) {
			ourList.setFirst(current.next);
			reset();
		} else {
			
			previous.next = current.next;
			if(atEnd()) {
				reset();
			} else {
				current = current.next;
			}
		}
		return temp;
	}
}
