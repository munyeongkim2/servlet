package com.nhnacademy;

import java.util.concurrent.ThreadLocalRandom;

public class Sender implements Runnable{
    
    private Data data;

    public Sender(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        String packets[]=   {
            "first p",
            "secode p",
            "third p",
            "end"
        };

        for (String string : packets) {
            data.send(string);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000,5000));

            } catch (Exception e) {
                Thread.currentThread().interrupt();
                System.err.println("tread interrupted");
            }
            
        }
    }
    
}
