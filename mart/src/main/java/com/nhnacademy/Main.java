package com.nhnacademy;

class Mart {
    

    public static void main(String[] args) {
        Store store = new Store();
        Producer producer1 = new Producer(store);
        Producer producer2 = new Producer(store);
        Producer producer3 = new Producer(store);
        
        Consumer consumer1 = new Consumer(store);
        Consumer consumer2 = new Consumer(store);
        Consumer consumer3 = new Consumer(store);


        store.enterProducer(producer3);
        store.enterProducer(producer1);
        store.enterProducer(producer2);
        store.enterCunsumer(consumer1);
        store.enterCunsumer(consumer2);
        store.enterCunsumer(consumer3);
        
    
    }
}
