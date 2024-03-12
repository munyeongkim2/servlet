package com.nhnacademy;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("start : "+LocalTime.now());
        // Counter counter = new Counter("counter", 10);
        // counter.run();
        // Counter counter2 = new Counter("counter2", 10);
        // counter2.run();
        // RunnableCounter counter1 = new RunnableCounter("counter1", 10);
        // counter1.run();
        // RunnableCounter counter3 = new RunnableCounter("counter2", 10);
        // counter3.run();
        // Thread thread1=new Thread(counter1);
        // Thread thread2=new Thread(counter3);
        // thread1.start();
        // thread2.start();
        // ThreadCounter counter1 = new ThreadCounter("counter", 10);
        // counter1.start();
        // ThreadCounter counter3 = new ThreadCounter("counter", 10);
        // counter3.start();

        SelfRunnableCounter counter1 = new SelfRunnableCounter("count1", 10);
        SelfRunnableCounter counter2 = new SelfRunnableCounter("count2", 10);
        counter1.start();
        counter2.start();
        while (counter1.thread.isAlive()||counter2.thread.isAlive()) {
            if(counter1.getCount() > 5 && counter2.getCount() >5){
                counter1.thread.interrupt();
                counter2.thread.interrupt();
            }
        }
        System.out.println("end : "+LocalTime.now());

    }
}