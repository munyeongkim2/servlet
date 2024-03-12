package com.nhnacademy;

public class Data {
    private String packet;

    private boolean transfer = true;
    public synchronized String receive(){
        while (transfer) {
            
            try {
                wait();
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                System.err.println("thread interrupted");
            }
        }
        transfer = true;
        String returnPacket = packet;
        notifyAll();
        return returnPacket;
    }

    public synchronized void send(String packet){
        while (!transfer) {
            try {
                wait();
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                System.err.println("thread interrupted");
            }
            
        }
        transfer = false;
        
        this.packet = packet;
        notifyAll();
    }

    public static void main(String[] args) {
        // Data data = new Data();
        // Thread sender = new Thread(new Sender(data));
        // Thread receiver = new Thread(new Receiver(data));
        
        // sender.start();
        // receiver.start();

        // Thread thread = new Thread(()->{
        //     for (int i = 0; i < 10; i++) {
        //         try {
        //             Thread.sleep(1000);
        //         } catch (Exception e) {
        //             Thread.currentThread().interrupt();
        //         }
                
        //     }
        // });
        // System.out.println(thread.getState());
        // thread.start();
        // while (thread.isAlive()) {
        //     System.out.println(thread.getState());
        // }
        // System.out.println(thread.getState());
        Object lock = new Object();

        Thread blockedThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });

        // 두 번째 스레드
        Thread blockingThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println(blockedThread.getState());
                }
            }
        });

        System.out.println(blockedThread.getState());
        blockedThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(blockingThread.getState());
        blockingThread.start();

        while (blockedThread.isAlive() || blockingThread.isAlive()) {
            System.out.println(blockedThread.getState());
            System.out.println(blockingThread.getState());
            // 두 스레드가 모두 종료될 때까지 대기
        }

        System.out.println(blockedThread.getState());
        System.out.println(blockingThread.getState());
    }

    }
    
    

    class Printer extends Thread {
        int num = 0;
        String name;
        public Printer(String name) {
            this.name = name;
        }
    
        @Override
        public void run() {
            synchronized(this) {
                while (num < 5) {
                    System.out.println(name + ": " + num);
                    num++;
                }
            }
            
        }
    }
