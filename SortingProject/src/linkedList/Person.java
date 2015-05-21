package linkedList;

public class Person {

	public int position;
	public String name;
	public Person next;
	
	public Person(int pos, String nameP) {
		this.position = pos;
		this.name = nameP;
		this.next = null;
	}
	
	public void displayPerson() {
		System.out.print("{" + position + ", " + name + "} ");
	}
	
}
