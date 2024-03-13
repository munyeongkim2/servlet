package com.nhnacademy;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Store {
    
    final int MAX_COUNT = 5;
    int count;
    String itemName;
    Semaphore semaphore;
    // boolean flag = false;
    Random random = new Random();
    public Store(String itemName) {
        this.count = 0;
        this.itemName = itemName;
        this.semaphore = new Semaphore(1);
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count += count;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public Semaphore getSemaphore() {
        return semaphore;
    }
    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }
    public void buy() {
        while (getCount() > 0){
            try{
                if(semaphore.tryAcquire()){
                    setCount(-1);
                    System.out.println(getItemName()+" 구매했습니다. 재고 : "+getCount());
                    break;
                }
                else{
                    System.out.println("구매대기중..");
                    if(!semaphore.tryAcquire(random.nextInt(5),TimeUnit.SECONDS)){
                        System.out.println("구매를 포기하였습니다.");
                        break;
                    
                    }
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally{
                semaphore.release(); // 품목에서 퇴장
            }
            
        }
    }

    private void sell() {
        System.out.println(getItemName() + " 팔렸습니다. 재고 : " + getCount());
    }

    public void deliver() {
        while (getCount() < MAX_COUNT){
            try {
                if(semaphore.tryAcquire()){
                    setCount(1);
                    System.out.println(getItemName()+" 입고되었습니다. 재고 : "+getCount());
                    break;
                }
                else{
                    System.out.println("입고대기중..");
                    if(!semaphore.tryAcquire(random.nextInt(5),TimeUnit.SECONDS)){
                        System.out.println("입고를 포기하였습니다.");
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally{
                semaphore.release(); // 품목에서 퇴장
            }
        
        };

    
    }
    
}
