package com.nhnacademy;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class CustomSemaphore {
    private Semaphore semaphore;
    private int maxNum = 5;
    private int count;
    private String itemName;


    public CustomSemaphore(String itemName) {
        this.semaphore = new Semaphore(1);
        this.count = 0;
        this.itemName = itemName;

    }
    public boolean tryAcquire(int seconds) throws InterruptedException {
        return semaphore.tryAcquire(seconds, TimeUnit.SECONDS);
    }
    public void acquire() throws InterruptedException {
        semaphore.acquire();
    }

    public void release() {
        semaphore.release();
    }

    public int getMaxNum() {
        return maxNum;
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count += count;
    }
    public String getItemName() {
        return itemName;
    }
    public int availablePermits() {
        return semaphore.availablePermits();
    }
}
    // int num;

    // public CustomSemaphore(int maxNum) {
    //     super(maxNum);
        
    // }

    // public CustomSemaphore(int num, int maxNum) {
    //     super(maxNum);
    //     this.num = num;
    // }

    // public synchronized void semPurchase() throws InterruptedException{
    //     if(num <= 0){
    //         this.wait((long) (Math.random() * 10000));
    //         if(num > 0 ){
    //             num--;
    //         }
    //         else{
    //             Thread.interrupted();
    //         }
    //     }
    //     else{
    //         num--;
    //     }
        
    // }
    // public synchronized void semDeliver() throws InterruptedException{
    //     if(num >= availablePermits()) {
    //         this.wait((long) (Math.random() * 10000));
    //         if(num < availablePermits()){
    //             num++;
    //             System.out.println("전시대가 꽉 찼습니다. 더 이상 물건을 납품할 수 없습니다.");
    //         }
    //         else{
    //             Thread.interrupted();
    //             //포기인포 남기기.
    //         }
            
    //     }
    //     else{
    //         num++;
    //     }
        
    // }
    
    // public synchronized void semNotify() {
    //     if(num <= availablePermits() && num >0) {
    //         this.notifyAll();
    //     }
    // }

    // @Override
    // public void acquire() throws InterruptedException {

    //     super.acquire();
    // }
    // @Override
    // public void acquire(int permits) throws InterruptedException {

    //     super.acquire(permits);
    // }
    // @Override
    // public void release() {

    //     super.release();
    // }
    // @Override
    // public void release(int permits) {

    //     super.release(permits);
    // }
    // @Override
    // public boolean tryAcquire(int permits) {

    //     return super.tryAcquire(permits);
    // }
    // @Override
    // public boolean tryAcquire(long timeout, TimeUnit unit) throws InterruptedException {

    //     return super.tryAcquire(timeout, unit);
    // }
    // @Override
    // public boolean tryAcquire(int permits, long timeout, TimeUnit unit) throws InterruptedException {

    //     return super.tryAcquire(permits, timeout, unit);
    // }

// }
