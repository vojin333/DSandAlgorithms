// Circular linked List app
// Only current pointer
// We need to insert, search, delete
// We all need step method

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class Link {
    private int data;
    private Link next;

    public Link (int d) {
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

    public Link getNext() {
        return next;
    }

    public void setNext(Link n) {
        next = n;
    }
}

class circularList {
    private Link current;
    private int nElems;

    public circularList() {
        current = null;
        nElems  = 0;
    }

    public boolean isEmpty() {
        return (current == null);
    }

    public void insert(int key) {
       Link newLink = new Link(key);

       if (isEmpty()) {
            current = newLink;
            current.setNext(null);
       } else {
            if (current.getNext() == null) { // if only one Link
                newLink.setNext(current); 
            } else {
                newLink.setNext(current.getNext());
            }
            current.setNext(newLink);
            current = newLink;
       }
       nElems++;
    }

    public boolean search(int key) {
        for (int i = 1; i <= nElems; i++) {
            if (current.getData() == key) {
                return true;
            }
            if (current.getNext() != null) {
                current = current.getNext();
            }
        }
        return false;
    }

    public Link delete(int key) {
        boolean status = search(key);
        if (!status) {
            return null;
        }

        if (current.getNext() == null) { // only one Link
            Link tempD = current;
            current = null;
            return tempD;
        } else {
            Link deletedLink = current;
            if (current.getNext().getNext().getData() == current.getData()) { // Omly two links
                current = current.getNext();
                current.getNext().setNext(null);
                current.setNext(null);
            } else {
                for (int i = 1; i<nElems; i++) {
                    current = current.getNext();
                }
                Link temp = current.getNext().getNext();
                current.getNext().setNext(null);
                current.setNext(temp);
            }
            nElems--;
            return deletedLink;
        }
    }

    public void displayCircularList() {
        System.out.println("Current --> to end");
        for (int i = 1; i <= nElems; i++) {
            current.displayLink();
            if (current.getNext() != null) {
                current = current.getNext();
            }
        }
        System.out.println();
    }

    public Link pop() {
       return delete(current.getData()); 
    }
}

class circularLinkedListApp {
    public static void main(String[] args) throws IOException {
        circularList cList = new circularList();

        System.out.println("Choose from below menu options...");
        System.out.println("For stimulating Stack use only 1 & 6 options...");
        while (true) {
            System.out.println("1. Insert. 2. Search, 3. Delete, 4. Display, 5. Quit, 6. Pop");
            int choose = getInput();
            switch (choose) {
                case 1:
                    System.out.println("Enter the key for Link you want to insert in Circular Linked List:");
                    int aData = getInput();
                    cList.insert(aData);
                    break;
                case 2:
                    if (cList.isEmpty()) {
                        System.out.println("Circular List Empty...First add few Links before searching :P ..");
                    } else {
                        System.out.println("Enter data for a Link to search:");
                        int sKey = getInput();
                        boolean searchedStatus = cList.search(sKey);
                        if (!searchedStatus) {
                            System.out.println("Could not find Link with data: " + sKey);
                        } else {
                            System.out.println("Found Link in Circular Linked List...");
                        }
                    }
                    break;
                case 3:
                    if (cList.isEmpty()) {
                        System.out.println("Circular List already Empty...Nothing to delete.. :-( ");
                    } else {
                        System.out.println("Enter the data of a Link to delete..");
                        int nKey = getInput();
                        Link deletedLink = cList.delete(nKey);
                        if (deletedLink == null) {
                            System.out.println("Could not find any Link with data: " + nKey);
                        } else {
                            System.out.println("Deleted " + deletedLink.getData() + " successfully...check by displaying Circular List");
                        }
                    }
                    break;
                case 4:
                    if (cList.isEmpty()) {
                        System.out.println("Circular List Empty...Nothing to display :-) ..");
                    } else {
                        cList.displayCircularList();
                    }
                    break;
                case 5:
                    System.out.println("Quiting App....as requested");
                    System.exit(0);
                    break;
                case 6:
                    if (cList.isEmpty()) {
                        System.out.println("Stack empty nothing to pop..");
                    } else {
                        Link popedLink = cList.pop();
                        System.out.println("Poped " + popedLink.getData() + " from Stack");
                    }
                    break;
                default:
                    System.out.println("Not a valid menu option selected lol ...try again BOY :-) ");
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
