package com.nhnacademy;

public class SelfRunnableCounter implements Runnable{ //스레드 멈추기. 
    String name;
    int maxCount;
    int count;
    Thread thread;
    boolean allStop = true;
    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public SelfRunnableCounter(String name, int maxCount){
        this.name = name;
        this.maxCount = maxCount;
        thread = new Thread(this,name);
        
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count += count;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMaxCount() {
        return maxCount;
    }
    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }
    public void run(){
        SelfRunnableCounter[] counters = new SelfRunnableCounter[10];
        for (int i = 0; i < counters.length; i++) {
            counters[i] = new SelfRunnableCounter("counter"+(i+i), 10);
            counters[i].getThread().start();
        }
        
        while (allStop) {
            if(counters[0].getCount() > 5){
                for (int i = 0; i < counters.length; i++) {
                    counters[i].getThread().interrupt();
                    
                }
            }
        
            for (int i = 0; i < counters.length; i++) {
                if(counters[i].getThread().isAlive()){
                    allStop = false;
                }
            }
        }
    }
    public void start(){
        thread.start();
    }
}
