package linkedList;

public class Link {

	public int iData;
	public double dData;
	public Link next;
	
	public Link(int id, double dd) {
		iData = id;
		dData = dd;
		next = null;
	}
	
	public Link(int id, double dd, Link newlink) {
		iData = id;
		dData = dd;
		next = newlink;
	}
	
	public void displayLink() {
		System.out.print("{" + iData + ", " + dData + "} ");
	}
}
