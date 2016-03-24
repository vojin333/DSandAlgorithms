package com.assigment;

/**
 * Created by nikov on 3/22/2016.
 */
public class Process {

    private int processId;
    private double totalBurstTime;
    private boolean isPerformIO;
    private int timeIO;
    private int currentCycleCounter;
    private long totalWaitingTime;
    private long timeLastExecution;

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public double getTotalBurstTime() {
        return totalBurstTime;
    }

    public void setTotalBurstTime(double totalBurstTime) {
        this.totalBurstTime = totalBurstTime;
    }

    public boolean isPerformIO() {
        return isPerformIO;
    }

    public void setPerformIO(boolean performIO) {
        isPerformIO = performIO;
    }

    public int getTimeIO() {
        return timeIO;
    }

    public void setTimeIO(int timeIO) {
        this.timeIO = timeIO;
    }

    public int getCurrentCycleCounter() {
        return currentCycleCounter;
    }

    public void setCurrentCycleCounter(int currentCycleCounter) {
        this.currentCycleCounter = currentCycleCounter;
    }

    public long getTotalWaitingTime() {
        return totalWaitingTime;
    }

    public void setTotalWaitingTime(long totalWaitingTime) {
        this.totalWaitingTime = totalWaitingTime;
    }

    public long getTimeLastExecution() {
        return timeLastExecution;
    }

    public void setTimeLastExecution(long timeLastExecution) {
        this.timeLastExecution = timeLastExecution;
    }

    public void display(){
        System.out.println("Process with id : " + processId + " and total burst time " + totalBurstTime);
    }
}
