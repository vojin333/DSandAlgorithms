package com.assigment;

import java.io.*;

/**
 * Created by nikov on 3/21/2016.
 */
public class Testing {

    public static void main(String[] args) {


        Queue readyQueue = new Queue(100);

        File file = new  File("C:\\Users\\nikov\\Downloads\\project3spring2016data.txt");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Construct BufferedReader from InputStreamReader
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        try {
            //read line by line
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] splitedLine = line.split("\\s+");
                Process newProcess = new Process();
                newProcess.setProcessId(Integer.valueOf(splitedLine[0]));
                newProcess.setTotalBurstTime(Double.valueOf(splitedLine[1]));
                newProcess.setTimeIO(Integer.valueOf(splitedLine[2]));
                newProcess.setPerformIO(newProcess.getTimeIO() == 0 ? false : true);
                newProcess.setTimeLastExecution(0);
                readyQueue.priorityEnqueue(newProcess);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        readyQueue.printQueue();
        System.out.println("Peek Front");
        readyQueue.peekMin().display();

    }
}
