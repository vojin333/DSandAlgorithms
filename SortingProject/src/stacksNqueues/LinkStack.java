package stacksNqueues;

public class LinkStack {

	private LinkList theList;
	
	public LinkStack() {
		theList = new LinkList();
	}
	
	public void push(long value) {
		theList.insertFirst(value);
	}
	
	public long pop() {
		return theList.deleteFirst();
	}
	
	public boolean isEmpty() {
		return theList.isEmpty();
	}
	
	public void displayStack() {
		System.out.println("Top->Bottom");
		theList.displayLinkList();
	}
}
