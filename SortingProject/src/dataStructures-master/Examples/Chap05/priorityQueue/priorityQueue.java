// Prirority Queue java app based on Linked list
// Remove method needs to remove the smallest key
// It will be implemented same as sorted linked list

class Link {
    private long data;
    private Link next;

    public Link(long d) {
        data = d; 
    }

    public void  displayLink() {
        System.out.print( data + " ");
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link l) {
        next = l;
    }

    public long getData() {
        return data;
    }

    public void setData(long d) {
        data = d;
    }
}

class priorityQueue {
    private Link first;

    public priorityQueue() {
        first = null; 
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insert(long key) {
        Link newLink = new Link(key);

        Link previous = null;
        Link current = first;
        
        while (current != null && key > current.getData()) {
            previous = current;
            current = current.getNext();
        }
        
        if (previous == null) {
            first = newLink;
        } else {
            previous.setNext(newLink);
        }
        newLink.setNext(current);
    }

    public long remove() {
        long temp = first.getData();
        first = first.getNext();
        return temp;
    }

    public void displayPriorityQueue() {
        System.out.println("First --> Next ---> Next");
        Link current = first;

        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println();
    }
}

class priorityQueueApp {
    public static void main(String[] args) {
        priorityQueue pQueue = new priorityQueue();

        pQueue.insert(45);
        pQueue.insert(55);

        pQueue.displayPriorityQueue();

        pQueue.insert(15);
        pQueue.insert(35);
        pQueue.insert(25);
        
        pQueue.displayPriorityQueue();

        long rem1 = pQueue.remove();
        long rem2 = pQueue.remove();

        pQueue.displayPriorityQueue();
    }
}
