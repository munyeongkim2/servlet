package com.nhnacademy.ThreadPool;

public class RunnableCounter implements Runnable{
    int maxCount;
    Thread thread;

    public RunnableCounter(ThreadGroup group, String name, int maxCount) {
        thread = new Thread(group, this, name);
        this.maxCount = maxCount;
    }
    
    @Override
    public void run() {
        
        
    }
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("group");

        RunnableCounter thread1 = new RunnableCounter(group, "worker1", 100);
        RunnableCounter thread2 = new RunnableCounter(group, "worker2", 100);

        // thread1.start();
        // thread2.start();

        // Thread.sleep(5000);
        // group.interrupt();

    }
}
