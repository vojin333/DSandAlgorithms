package stacksNqueues;

public class Queue {

	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	private int nItems;
	
	public Queue (int s) {
		maxSize = s;
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	
	public void insert(long value) {
		if (rear == maxSize - 1) {
			rear = -1;
		}
		queArray[++rear] = value;
		nItems++;
	}
	
	public long remove() {
		long temp  = queArray[front++];
		if (front == maxSize) {
			front = 0;
		}
		nItems--;
		return temp;
	}
	
	public long peekFront() {
		return queArray[front];
	}
	
	public long peekRear() {
		return queArray[rear];
	}
	
	public boolean isEmpty() {
		return (nItems == 0);
	}
	
	public boolean isFull() {
		return (nItems == maxSize);
	}
	
	//for Priority queue insertMethode
	public void inserPQ(long value) {
		int i;
		if (nItems == 0) {
			queArray[nItems++] = value;
			
		} else {
			for (i = nItems-1; i >=0; i--) {
				if (value > queArray[i]) {
					queArray[i + 1] = queArray[i];
				} else {
					break;
				}
				queArray[i + 1] = value;
				nItems++;
			}
		}
	}
}
