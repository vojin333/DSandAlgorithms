package linkedList;

public class DLink {

	public double dData;
	public DLink next;
	public DLink previous;
	
	public DLink(double dD) {
		dData = dD;
	}
	
	public void displayLink() {
		System.out.print("{" + dData + ", " + dData + "} ");
	}
}
