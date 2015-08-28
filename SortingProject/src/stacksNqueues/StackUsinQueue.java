package stacksNqueues;

public class StackUsinQueue {

	LinkListQ queue;
	
	public StackUsinQueue () {
		queue = new LinkListQ();
	}
	
	public void push (long value) {
		queue.insertLast(value);
	}
	
	public long pop() {
		int size = queue.size();
		for (int i = 0; i < size - 1; i++) {
			queue.insertLast(queue.deleteFirst());
		}
		long removedElement = queue.deleteFirst();
		return removedElement;
	}
	
	public void displaySTack() {
		queue.displayList();
	}
}
