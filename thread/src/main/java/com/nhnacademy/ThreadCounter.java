package com.nhnacademy;

public class ThreadCounter extends Thread{
    String name;
    // @Override
    // public String getName() {
    //     return name;
    // }

    // @Override
    // public void setName(String name) {
    //     this.name = name;
    // }
    int maxCount;
    int count;

    public ThreadCounter(String name, int maxCount){
        this.name = name;
        this.maxCount = maxCount;
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count += count;
    }

    public int getMaxCount() {
        return maxCount;
    }
    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }
    @Override
    public void run(){
        while (!Thread.currentThread().isInterrupted() && count<maxCount ) {
            try {
                setCount(1);
                System.out.println(getName() + " : "+getCount());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();//이 지금 코드를 수행하고 있는 스레드
            }
        }
    }
}
