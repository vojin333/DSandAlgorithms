// Josephus Problem
// Take input from user for number of people in circle
// Take input from user for counting off the people
// Create a circular Linked List with data as whole number (i.e. 1, 2, 3, 4 ..n)
// We will start from number 1 initially and then from the next of deleted item
// Display the items being deleted and finally the number that got Freedom

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class Link {
    private int data;
    private Link next;

    public Link(int d) {
        data = d;
    }

    public void displayLink() {
        System.out.print(data + " ");
    }

    // Setters
    public void setData(int d) {
        data = d;
    }

    public void setNext(Link n) {
        next = n;
    }

    // Getter
    public int getData() {
        return data;
    }

    public Link getNext() {
        return next;
    }
}

class Josephus {
    private int size;
    private Link current;

    public Josephus() {
        size = 0;
        current = null;
    }

    public boolean isEmpty() {
        return (current == null);
    }

    public void insert(int d) {
        Link newLink = new Link(d);

        if (isEmpty()) {
            current = newLink;
            current.setNext(null);
        } else {
            if (current.getNext() == null) {
                newLink.setNext(current);
            } else {
                newLink.setNext(current.getNext());
                current.setNext(null);
            }
            current.setNext(newLink);
            current = newLink;
        }
        size++;
    }

    public void execute(int skip) {
        for (int i = 1; i <= skip; i++) {
            step();
        }
        delete();
        if (!(current.getNext() == null)) {
            step();
        }
    }

    public void delete() {
        System.out.println("Deleting Current: " + current.getData());
        if (current.getNext().getNext().getData() == current.getData()) { // Only two Links
            step();
            current.getNext().setNext(null);
            current.setNext(null);
        } else {
            for (int i = 1; i < size; i++ ){
                step();
            }
            Link temp = current.getNext().getNext();
            //System.out.println("Temp: " + temp.getData());
            //System.out.println("Current: " + current.getData());
            current.getNext().setNext(null);
            //current.setNext(null);
            current.setNext(temp);
        }
        size--;
        //System.out.println("Deleted, now displaying...");
        //display();
    }

    public void display() {
        System.out.println("Current --> End");
        for (int i = 1; i <= size; i++) {
            current.displayLink();
            if(!(current.getNext() == null)) {
                step();
            }
        }
        //step();
        System.out.println();
    }

    public void step() {
        current = current.getNext();
    }

    // Getter
    public int getSize() {
        return size;
    }

    public Link getCurrent() {
        return current;
    }
}

class JosephusApp {
    public static void main(String[] args) throws IOException {
        Josephus jp = new Josephus();
        System.out.println("Choose from below menu options:");
        while (true) {
            System.out.println("1. Create. 2. Execute. 3. Display. 4. Quit App");
            int choice = getInput();
            switch (choice) {
                case 1:
                    System.out.println("Enter the number of people from which you want to create circle..");
                    int nPeople = getInput();
                    for (int i = 1; i <= nPeople; i++) {
                        jp.insert(i);
                    }
                    System.out.println("Circle ready, check by displaying it.. :-)");
                    break;
                case 2:
                    if (jp.isEmpty()) {
                        System.out.println("No one to execute...There is no one in circle :-) ");
                    } else if (jp.getCurrent().getNext() == null) {
                        System.out.println("You are the only one in circle, so you are FREE Boy..!!! :D ..");
                    } else {
                        System.out.println("Please enter how many you want to skip: ");
                        int sk = getInput();
                        int jpSize = jp.getSize();
                        // Pointing current to first
                        jp.step();
                        for (int i = 1; i< jpSize; i++) {
                            jp.execute(sk);
                        }
                        System.out.println(jp.getCurrent().getData() + " Got FREEDOM");
                    }
                    break;
                case 3:
                    if (jp.isEmpty()) {
                        System.out.println("There is no one in Circle....Add few before displaying...");
                    } else {
                        jp.display();
                    }
                    break;
                case 4:
                    System.out.println("Quiting App as requested ...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("BOY ...!!! Choose correct menu option...try again :-) ");
                    break;
            }
        }
    }

    public static int getInput() throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        return Integer.parseInt(br.readLine());
    }
}
