package com.nhnacademy.Homework;

import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {
    private String name;
    private Store store;

    public Consumer(String name, Store store) {
        this.name = name;
        this.store = store;
    }

    @Override
    public void run() {
        try {
            store.enter();
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 10001)); // 1 to 10 seconds interval
            store.buy();
            store.exit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

