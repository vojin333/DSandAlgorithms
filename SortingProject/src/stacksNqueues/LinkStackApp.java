package stacksNqueues;

public class LinkStackApp {

	/**
	 * @param args
	 * @see 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		LinkStack linkStack = new LinkStack();
//		
//		linkStack.push(10);
//		linkStack.push(20);
//		linkStack.push(30);
//		linkStack.push(40);
//		linkStack.push(50);
//		
//		linkStack.displayStack();
//		
//		linkStack.pop();
//		linkStack.displayStack();
//		
//		
//		linkStack.pop();
//		linkStack.displayStack();
		
		
//		LinkQueue linkQueue = new LinkQueue();
//		
//		linkQueue.insert(10);
//		linkQueue.insert(20);
//		linkQueue.insert(30);
//		linkQueue.insert(40);
//		linkQueue.displayQueue();
//		linkQueue.insert(50);
//		
//		linkQueue.displayQueue();
//		
//		linkQueue.remove();
//		linkQueue.displayQueue();
//		
//		linkQueue.remove();
//		linkQueue.displayQueue();
		
		
//		StackUsinQueue stackUsingQueue  = new StackUsinQueue();
//		stackUsingQueue.push(1);
//		stackUsingQueue.push(2);
//		stackUsingQueue.push(3);
//		stackUsingQueue.push(4);
//		
//		stackUsingQueue.displaySTack();
//		
//		System.out.println("Poped element = " + stackUsingQueue.pop());
//		
//		stackUsingQueue.displaySTack();
//		
//		System.out.println("Poped element = " + stackUsingQueue.pop());
//		
//		stackUsingQueue.displaySTack();
		
		
		QueueUsinStack queueUsingStack = new QueueUsinStack();
		queueUsingStack.insert(1);
		queueUsingStack.insert(2);
		queueUsingStack.insert(3);
		queueUsingStack.insert(4);
		
		queueUsingStack.displayQueue();
		
		System.out.println("Poped element = " + queueUsingStack.delete());
		
		queueUsingStack.displayQueue();
		
		System.out.println("Poped element = " + queueUsingStack.delete());
		
		queueUsingStack.displayQueue();
		
	}

}
