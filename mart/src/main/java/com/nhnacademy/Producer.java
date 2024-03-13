package com.nhnacademy;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {
    private List<Store> stores;
    Random random = new Random();

    public Producer(List<Store> stores) {
        this.stores = stores;
    }

    @Override
    public void run() {
        int randomDelivery = random.nextInt(stores.size());
        Collections.shuffle(stores);
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 10001)); // 1 to 10 seconds interval
            for (int i = 0; i < randomDelivery; i++) {
                stores.get(i).deliver();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}