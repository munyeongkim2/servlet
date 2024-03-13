package com.nhnacademy.Homework;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<String> displayedItems;
    private int maxDisplayItems;
    private int maxCustomers;
    private List<String> producerNotifications;
    

    public Store() {
        this.displayedItems = new ArrayList<>();
        this.maxDisplayItems = 10;
        this.maxCustomers = 5;
        this.producerNotifications = new ArrayList<>();
    }

    public void enter() {
        if (maxCustomers > 0) {
            maxCustomers--; 
            System.out.println("고객이 입장했습니다. 남은 자리: " + maxCustomers);
        } else {
            System.out.println("가게가 만석입니다. 나가신 후에 다시 시도해주세요.");
        }
    }

    public void exit() {
        maxCustomers++;
        System.out.println("고객이 퇴장했습니다. 남은 자리: " + maxCustomers);
    }

    public synchronized void buy() {
        if (!displayedItems.isEmpty()) {
            String purchasedItem = displayedItems.remove(0);
            System.out.println("고객이 구매한 물건: " + purchasedItem);
        } else {
            System.out.println("구매할 물건이 없습니다. 새로운 재고를 기다려주세요.");
        }
    }

    public synchronized void sell() {
        if (displayedItems.size() < maxDisplayItems) {
            String newItem = "Item" + (displayedItems.size() + 1);
            displayedItems.add(newItem);
            System.out.println("판매할 물건 추가: " + newItem);
        } else {
            System.out.println("전시대가 꽉 찼습니다. 고객이 구매할 때까지 기다려주세요.");
        }
    }

    public synchronized void deliverItems() {
        if (displayedItems.size() < maxDisplayItems) {
            String newItem = "DeliveredItem" + (displayedItems.size() + 1);
            displayedItems.add(newItem);
            notifyConsumers(newItem);
            System.out.println("납품된 물건: " + newItem);
        } else {
            System.out.println("전시대가 꽉 찼습니다. 더 이상 물건을 납품할 수 없습니다.");
        }
    }

    private void notifyConsumers(String newItem) {
        if (maxCustomers < 5) {
            System.out.println("새로운 물건이 도착했습니다. 소비자에게 알립니다: " + newItem);
        } 
        // else {
        //     System.out.println("소비자에게 알릴 수 없습니다. 가게가 만석입니다.");
        // }
    }
    public static void main(String[] args) {
        Store store = new Store();
        Thread producerThread = new Thread(new Producer(store));
        producerThread.start();

        for (int i = 1; i <= 10; i++) {
            Thread consumerThread = new Thread(new Consumer("Consumer " + i, store));
            consumerThread.start();
        }
    }

}
