package com.nhnacademy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class Main {
    ExecutorService producerPool;
    ExecutorService consumerPool;

    int maxPool = 3;
    Random random = new Random();

    public Main(){
        DaemonThreadFactory daemonThreadFactory = new DaemonThreadFactory();
        producerPool = Executors.newFixedThreadPool(maxPool, daemonThreadFactory);
        consumerPool = Executors.newFixedThreadPool(maxPool, daemonThreadFactory);
    }

    public void enterProducer(Producer producer){
        producerPool.submit(producer);
    }

    public void enterCunsumer(Consumer consumer){
        consumerPool.submit(consumer);
    }
    
}
class Test{
    public static void main(String[] args) {
        List<Store> stores = new ArrayList<>();

        stores.add(new Store("Apple"));
        stores.add(new Store("Banana"));
        stores.add(new Store("Orange"));
        // stores.add(new Store("Grapes"));
        // stores.add(new Store("Watermelon"));



        Consumer consumer1 = new Consumer(stores);
        Consumer consumer2 = new Consumer(stores);
        Consumer consumer3 = new Consumer(stores);
        Consumer consumer4 = new Consumer(stores);
        Consumer consumer5 = new Consumer(stores);

        Producer producer1 = new Producer(stores);
        Producer producer2 = new Producer(stores);
        Producer producer3 = new Producer(stores);
        Producer producer4 = new Producer(stores);
        Producer producer5 = new Producer(stores);

        Main main = new Main();

        SelfRunnableCounter selfRunnableCounter = new SelfRunnableCounter("counter1", 300);// 5분
        selfRunnableCounter.start();

        

        while (selfRunnableCounter.isAlive()) {
    
            main.enterProducer(producer1);
            // main.enterProducer(producer2);
            // main.enterProducer(producer3);
            // main.enterProducer(producer4);
            // main.enterProducer(producer5);

            main.enterCunsumer(consumer1);
            // main.enterCunsumer(consumer2);
            // main.enterCunsumer(consumer3);
            // main.enterCunsumer(consumer4);
            // main.enterCunsumer(consumer5);

        }
        main.producerPool.shutdown();
        main.consumerPool.shutdown();

        while (!main.producerPool.isShutdown() || !main.consumerPool.isShutdown()) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                
            }
        }

        while (true) {
            if (main.producerPool.isShutdown() && main.consumerPool.isShutdown()) {
                System.out.println("영업 종료");
                // logger.info();
                break;
            }
        }



    }
}

class DaemonThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r) {
        Thread thread = Executors.defaultThreadFactory().newThread(r);
        thread.setDaemon(true);
        return thread;
    }
}