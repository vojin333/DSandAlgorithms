package stacksNqueues;

public class LinkQueue {

	private LinkListQ theList;
	
	public LinkQueue() {
		theList = new LinkListQ();
	}
	
	public boolean isEmpty() {
		return theList.isEmpty();
	}
	
	public void insert(long value) {
		theList.insertLast(value);
	}
	
	public long remove() {
		return theList.deleteFirst();
	}
	
	public void displayQueue() {
		System.out.println("First->Last");
		theList.displayList();
	}
}
