package com.assigment;

/**
 * Created by nikov on 3/21/2016.
 */
public class Queue {

    private int maxSize;
    private Process[] queArray;
    private int front;
    private int rear;
    private int nItems;
    private boolean isPriorityQueue;

    public Queue (int size) {
        maxSize = size;
        queArray = new Process[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void enqueue(Process process) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = process;
        nItems++;
    }

    public Process dequeue() {
        Process temp  = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }

    public void setFlag(boolean isPriorityQueue) {
        this.isPriorityQueue = isPriorityQueue;
    }

    public boolean getFlag() {
        return this.isPriorityQueue;
    }

    public Process peekFront() {
        return queArray[front];
    }

    public Process peekRear() {
        return queArray[rear];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public Process peekMin() { return queArray[nItems-1]; }

    //for Priority queue insertMethode
    public void priorityEnqueue(Process process) {
        int i;
        if (nItems == 0) {
            queArray[nItems++] = process;

        } else {
            for (i = nItems - 1; i >= 0; i--) {
                if (process.getTotalBurstTime() >= queArray[i].getTotalBurstTime()) {
                    queArray[i + 1] = queArray[i];
                } else {
                    break;
                }
            }
            queArray[i + 1] = process;
            nItems++;
        }
    }

    // remove minimum item
    public Process priorityDequeue() { return queArray[--nItems]; }

    //print out queue from head to tail
    public void printQueue() {
        System.out.println("First --> Last");
        for (int i = nItems-1; i >=0; i--) {
            queArray[i].display();
        }
        System.out.println("");
    }
}
