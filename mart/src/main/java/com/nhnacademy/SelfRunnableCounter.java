package com.nhnacademy;

public class SelfRunnableCounter implements Runnable {
    private String name;
    private int count;
    private int maxCount;
    private Thread thread;

    SelfRunnableCounter(String name, int maxCount) {
        this.count = 0;
        this.name = name;
        this.maxCount = maxCount;
        thread = new Thread(this, name);
    }

    public void start() {
        thread.start();
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted() && maxCount > count) {
            try {
                Thread.sleep(1000);
                count++;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        stop();
    }

    public int getCount() {
        return count;
    }

    public void stop() {
        thread.interrupt(); // Interrupt 요청을 보냄
        Thread.currentThread().interrupt();
    }

    public boolean isAlive() {
        return thread.isAlive();
    }

    public void setDaemon(boolean b) {
        thread.setDaemon(b);
    }
}
