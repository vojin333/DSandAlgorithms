package linkedList;

public class JosephusCircle {

	Person current;
	int size;
	
	public JosephusCircle() {
		current = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return (current == null);
	}
	
	
	//this implementation is for inserting 
	public void insertNextToCurrentWithoutConstruct(int pos, String name) {
		Person newPerson = new Person(pos, name);
		if (isEmpty()) {
			current = newPerson;
			current.next = current;
			size++;
			
		} else {
			newPerson.next = current.next;
			current.next = newPerson;
			size++;
		}
	}
	
	public void displayList() {
		System.out.print("List (first-->last): ");
		Person starting = current.next;
		
		for (int i = 0; i < size; i++) {
			starting.displayPerson();
			starting = starting.next;
		}
		System.out.println("");
	}
	
	public int size(){
		return size;
	}
	
	public void remove(int pos) {
		Person starting = current.next;
		Person previous = current.next;
		while (starting.position != pos) {
			previous = starting;
			starting = starting.next;
		}
		current = starting.next;
		previous.next = starting.next;
		size--;
	} 
	
	public Person findByPostion(int pos) {
		Person starting = current;
		while (starting.position != pos) {
			starting = starting.next;
		}
		return starting;
	}
	
	public void displayCurrent() {
		System.out.print("Current : ");
		current.displayPerson();
		System.out.println("");
	}
	
	public void moveCurrent() {
		current = current.next;
	}
	
	public void moveCurrentNPositions(int n) {
		for (int start = 1; start <= n ; start++) {
			moveCurrent();
		}
	}
	
	public void suicideCircle(int startingPos, int cutOfInterval) {
		Person startingPer = findByPostion(startingPos);
		current = startingPer;
		while(size > 1) {
			moveCurrentNPositions(cutOfInterval);
			displayCurrent();
			remove(current.position);
		}
		
	}
}
