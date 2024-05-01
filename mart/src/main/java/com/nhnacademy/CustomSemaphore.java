package com.nhnacademy;
import java.util.concurrent.TimeUnit;

public class CustomSemaphore {
    private int permits;

    public CustomSemaphore(int permits) {
        this.permits = permits;
    }

    public synchronized void acquire() throws InterruptedException {
        while (permits == 0) {
            wait();
        }
        permits--;
    }

    public synchronized void release() {
        permits++;
        notifyAll();
    }

    public synchronized boolean tryAcquire(long timeout) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        long elapsedTime = 0;

        while (permits == 0 && elapsedTime < timeout) {
            wait(timeout - elapsedTime);
            elapsedTime = System.currentTimeMillis() - startTime;
        }

        if (permits > 0) {
            permits--;
            return true;
        }
        return false;
    }

    public synchronized boolean tryAcquire(long timeout, TimeUnit unit) throws InterruptedException {
        long timeoutInMillis = unit.toMillis(timeout);
        return tryAcquire(timeoutInMillis);
    }
}