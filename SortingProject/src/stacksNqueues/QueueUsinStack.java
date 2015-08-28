package stacksNqueues;

public class QueueUsinStack {

	LinkList stack;
	
	public QueueUsinStack() {
		stack = new LinkList();
	}
	
	public void insert (long value) {
		stack.insertFirst(value);
	}
	
	public long delete () {
		long renoveItem;
		int size = stack.size();
		LinkList stackToHelp = new LinkList();
		for (int i = 0; i < size - 1; i++) {
			stackToHelp.insertFirst(stack.deleteFirst());
		}
		renoveItem = stack.deleteFirst();
		System.out.println("stackToHelp size before " + stackToHelp.size());
		System.out.println("stack size  before " + stackToHelp.size());
		
		while (!stackToHelp.isEmpty()) {
			
			stack.insertFirst(stackToHelp.deleteFirst());
		}
//		for (int i = 0; i <= stackToHelp.size(); i++) {
//			stack.insertFirst(stackToHelp.deleteFirst());
//		}
		System.out.println("stackToHelp size later " + stackToHelp.size());
		System.out.println("stack size  " + stackToHelp.size());
		return renoveItem;
	}
	
	public void displayQueue() {
		stack.displayLinkList();
	}
}
