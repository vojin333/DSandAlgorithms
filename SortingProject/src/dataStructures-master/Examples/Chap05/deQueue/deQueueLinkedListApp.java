// DeQueue App using linked list in this
// We need to add remove elements from either end
// We will use Doubly linked list to implement it
// We will take input from user for diffrent opertaions
// insertLeft, insertRight, RemoveLeft, RemoveRight, Display, Quit

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

class Link {
    private int data;
    private Link previous;
    private Link next;

    public Link(int d) {
        data = d;
    }

    public void displayLink() {
        System.out.print(data + " ");
    }

    // Getter and Setters
    public int getData() {
        return data;
    }

    public void setData(int d) {
        data = d;
    }

    public Link getPrevious() {
        return previous;
    }

    public void setPrevious(Link prev) {
        previous = prev;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link nx) {
        next = nx;
    }
}

class doublyLinkedList {
    private Link first;
    private Link last;

    public doublyLinkedList() {
        first   = null;
        last    = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertLeft(int key) {
        Link newLink = new Link(key);

        if (isEmpty()) {
            first   = newLink;
            last    = newLink;
            newLink.setNext(null);
            newLink.setPrevious(null);
        } else {
            newLink.setPrevious(null);
            newLink.setNext(first);
            first.setPrevious(newLink);
            first = newLink;
        }
    }

    public void insertRight(int key) {
        Link newLink = new Link(key);

        if(isEmpty()) {
            first   = newLink;
            last    = newLink;
            newLink.setNext(null);
            newLink.setPrevious(null);
        } else {
            last.setNext(newLink);
            newLink.setPrevious(last);
            newLink.setNext(null);
            last = newLink;
        }
    }

    public int removeLeft() {
        int temp = first.getData();

        if (first.getNext() == null) { // if Linked list has only one element
            first   = null;
            last    = null;
        } else {
            first = first.getNext();
            first.getPrevious().setNext(null);
            first.setPrevious(null);
        }
        return temp;
    }

    public int removeRight() {
        int temp = last.getData();

        if (first.getNext() == null) { //if only one element
            first   = null;
            last    = null;
        } else {
            last = last.getPrevious();
            last.getNext().setPrevious(null);
            last.setNext(null);
        }

        return temp;
    }

    public void displayDoublyLinkedList() {
        System.out.println("Left --> Right");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println();
    }
}

class deQueueLinkedListApp {
    public static void main(String[] args) throws IOException {
        doublyLinkedList doubly = new doublyLinkedList();
        
        System.out.println("Select menu option:");
        while (true) {
        System.out.println("1. Insert, 2. Remove, 3. Display, 4. Quit");
        int choice = getInput();
            switch (choice) {
                case 1: System.out.println("1. Insert Left, 2. Insert Right");
                        int opt = getInput();
                        System.out.println("Enter number to insert...");
                        int key = getInput();
                        switch (opt) {
                            case 1: doubly.insertLeft(key);
                                    break;
                            case 2: doubly.insertRight(key);
                                    break;
                            default: System.out.println("Invalid input");
                                     break;
                        }
                        break;
                case 2: System.out.println("1. Remove Left, 2. Remove Right");
                        opt = getInput();
                        switch (opt) {
                            case 1: int temp;
                                    if (!doubly.isEmpty()) {
                                        temp = doubly.removeLeft();
                                        System.out.println(temp + " Removed from left.");
                                    } else {
                                        System.out.println("List empty nothing to remove");
                                    }
                                    break;
                            case 2: 
                                    if (!doubly.isEmpty()) {
                                        temp = doubly.removeRight();
                                        System.out.println(temp + " Removed from Right");
                                    } else {
                                        System.out.println("List empty nothing to remove");
                                    }
                                    break;
                            default: System.out.println("Invalid remove option...");
                                     break;
                        }
                        break;
                case 3: if (doubly.isEmpty()) {
                            System.out.println("List empty nothing to display...");
                        } else {
                           doubly.displayDoublyLinkedList();
                        }
                        break;
                case 4: System.out.println("Quiting App as requested...");
                        System.exit(0);
                        break;
                default: System.out.println("Invalid option selected, Try again..");
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
