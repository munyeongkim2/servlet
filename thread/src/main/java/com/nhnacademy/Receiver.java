package com.nhnacademy;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable{

    private Data load;  

    public Receiver(Data load) {
        this.load = load;
    }

    @Override
    public void run() {
        for (String reciveMessageString = load.receive(); ! "end".equals(reciveMessageString); reciveMessageString = load.receive()){

            
            System.out.println(reciveMessageString);

            //Thread.sleep() to mimic heavy server-side processing
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                System.err.println("Thread Interrupted"); 
            }
        }
    }
    
}
