package com.nhnacademy;

import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {
    private Store store;


    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
            try {
                Thread.sleep(1000); // Sleep for 1 to 10 seconds
                store.deliverItem();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    
}

