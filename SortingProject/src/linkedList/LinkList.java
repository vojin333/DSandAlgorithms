package linkedList;

public class LinkList {

	private Link first;
	
	public LinkList() {
		first = null;
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	public void  insertFirst(int id, double dd) {
		Link newLink = new Link(id, dd);
		newLink.next = first;
		first = newLink;
	}
	
	public Link  deleteFirst() {
		Link temp = first;
		first = first.next;
		return temp;
	}
	
	public void displayList() {
		System.out.print("List (first-->last): ");
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}
	
	public Link find(int key) {
		Link current = first;
		while (current.iData != key) {
			if (current.next == null) {
				return null;
			} else {
				current = current.next;	
			}
		}
		//found it
		return current;
	}
	
	public Link delete(int key) {
		Link previous = first;
		Link current = first;
		while (current.iData != key) {
			if (current.next == null) {
				return null;
			} else {
				previous = current;	
				current = current.next;
			}
		}
		//found it
		if (current == first) {
			first = current.next;
		} else {
			previous.next = current.next;	
		}
		return current;
	}
	
	public void insertAfter(int key, double dD, int afterKey) {
		Link newLink = new Link(key, dD);
		Link current = first;
		while (current.iData != afterKey) {
			if (current.next == null) {
				break;
			} else {
				current = current.next;	
			}
		}
		//found it
		if (current.next == null) {
			current.next = newLink;
		} else {
			newLink.next = current.next;
			current.next = newLink;
		}
		
	}
	//ordered Link list
	public void insertInOrder(int key, double dD) {
		Link newLink = new Link(key, dD);
		Link current = first;
		Link previous = null;
		while (current != null && key > current.iData) {
			current = current.next;
			previous = current;
		}
		//Beginning of the list
		if (previous == null) {
			first = newLink;
		} else {
			previous.next = newLink;
		}
		//link newly added to the current - squeeze in between previous and current
		newLink.next = current;
	}

	/**
	 * @return the first
	 */
	public Link getFirst() {
		return first;
	}

	/**
	 * @param first the first to set
	 */
	public void setFirst(Link first) {
		this.first = first;
	}
	
	/*
	 * returns an Iterator
	 */
	public ListIterator getIterator() {
		return new ListIterator(this); // initialized with this  one
	}
}
