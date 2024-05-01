package com.nhnacademy;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Consumer implements Runnable {
    Logger logger = LogManager.getLogger(Consumer.class.getName());
    private List<Store> stores;
    Random random = new Random();

    public Consumer(List<Store> stores) {
        this.stores = stores;
    }

    @Override
    public void run() {
        logger.info("구매자 입장했습니다.");
        int randomBuy = random.nextInt(stores.size());
        Collections.shuffle(stores);
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 10001)); // 1 to 10 seconds interval
            for (int i = 0; i < randomBuy; i++) {
                stores.get(i).buy();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        logger.info("구매자 퇴장했습니다.");
    }
}
