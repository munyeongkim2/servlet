
package com.nhnacademy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;



public class Store {
    
    static List<CustomSemaphore> itemInventory= new ArrayList<>();
    ExecutorService producerPool;
    ExecutorService consumerPool;

    // int defaltCount = 5;
    int maxPool = 5;
    Random random = new Random();

    public Store() {
        itemInventory.add(new CustomSemaphore("Apple"));
        itemInventory.add(new CustomSemaphore("Banana"));
        itemInventory.add(new CustomSemaphore("Orange"));
        itemInventory.add(new CustomSemaphore("Grapes"));
        itemInventory.add(new CustomSemaphore("Watermelon"));

        producerPool = Executors.newFixedThreadPool(maxPool);
        consumerPool = Executors.newFixedThreadPool(maxPool);


    }
    public void enterProducer( Producer producer){
        producerPool.submit(producer);
    }
    public void enterCunsumer(Consumer consumer){
        consumerPool.submit(consumer);
    }

    public void buy() throws InterruptedException {
        int name = random.nextInt(itemInventory.size());
        boolean buyflag = itemInventory.get(name).tryAcquire(0);
        if(itemInventory.get(name).getCount() > 0){
            if(buyflag){
                try {
                    itemInventory.get(name).setCount(-1);
                    System.out.println(itemInventory.get(name).getItemName() +" 구매했습니다. 재고 : "+itemInventory.get(name).getCount());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                finally {
                    itemInventory.get(name).release(); // 품목에서 퇴장
                }
            }
            // else{
            //     // try {
            //     //     if(itemInventory.get(name).tryAcquire(5) && itemInventory.get(name).getCount() >0){
            //     //         itemInventory.get(name).setCount(-1);
            //     //         System.out.println(itemInventory.get(name).getItemName() +" 구매했습니다. 재고 : "+itemInventory.get(name).getCount());
            //     //     }
            //     //     else{
            //     //         System.out.println("구매를 포기하였습니다. 재고 : "+itemInventory.get(name).getCount());
            //     //     }
            //     // } catch (Exception e) {
            //     //     e.printStackTrace();
            //     // }
            //     // finally {
            //     //     itemInventory.get(name).release(); // 품목에서 퇴장
            //     // }
            // }
        
        }
    }
    
    public void deliverItem() throws InterruptedException {
        int name = random.nextInt(itemInventory.size());
        if(itemInventory.get(name).getMaxNum() > itemInventory.get(name).getCount()){
            try {
                if(itemInventory.get(name).tryAcquire(0)){
                    itemInventory.get(name).setCount(1);
                    System.out.println(itemInventory.get(name).getItemName() +" 입고되었습니다. 재고 : "+itemInventory.get(name).getCount());
                }
                else{
                    if(itemInventory.get(name).tryAcquire(5)){
                        itemInventory.get(name).setCount(1);
                        System.out.println(itemInventory.get(name).getItemName() +" 입고되었습니다. 재고 : "+itemInventory.get(name).getCount());
                    }else{
                        System.out.println("입고를 포기하였습니다. 재고 : "+itemInventory.get(name).getCount());
                    }
                    
                }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                finally {
                    itemInventory.get(name).release(); // 품목에서 퇴장
                }
        }
    
    }

    // public void openMart() {
    //     try {
    //         System.out.println("Mart is now open!");

    //         // 마트를 5분 동안 오픈
    //         Thread.sleep(5 * 60 * 1000);

    //         // 마트 오픈 종료 후 스레드 풀 종료
    //         System.out.println("Mart is closed!");
    //         System.exit(0);
    //     } catch (InterruptedException e) {
    //         e.printStackTrace();
    //     }
    // }

}
