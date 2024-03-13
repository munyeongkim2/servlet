package com.nhnacademy;

import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {
    // private String name;
    private Store store;

    public Consumer( Store store) {

        this.store = store;
    }

    @Override
    public void run() {

        try {

            Thread.sleep(1000); // 1 to 10 seconds interval
            store.purchaseItem();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        

    }
}

