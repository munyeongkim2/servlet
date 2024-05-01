package com.nhnacademy;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Store {
    Logger logger = LogManager.getLogger(this.getClass().getSimpleName());
    static final int MAX_COUNT = 5;
    int count;
    String itemName;
    Semaphore semaphore;

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
        if (getCount() > 0){
            try{
                if(semaphore.tryAcquire()){
                    setCount(-1);
                    System.out.println(getItemName()+" 구매했습니다. 재고 : "+getCount());
                    semaphore.release(); // 품목에서 퇴장
                    logger.info("구매했습니다. 재고 : {} ",getCount());
                }
                else{
                    System.out.println("구매대기중..");
                    if(!semaphore.tryAcquire(random.nextInt(5),TimeUnit.SECONDS)){
                        logger.warn("구매를 포기하였습니다.");
                    }
                    else{
                        setCount(-1);
                        logger.info(" 구매했습니다. 재고 : {}",getCount());
                        semaphore.release(); // 품목에서 퇴장
                    }
                }

            }
            catch (Exception e) {
                Thread.currentThread().interrupt();
            }
            
        }
    }

    public void deliver() {
        if (getCount() < MAX_COUNT){
            try {
                if(semaphore.tryAcquire()){
                    setCount(1);
                    logger.info(" 입고되었습니다. 재고 : {}",getCount());
                    semaphore.release(); // 품목에서 퇴장
                }
                else{
                    System.out.println("입고대기중..");
                    if(!semaphore.tryAcquire(random.nextInt(5),TimeUnit.SECONDS)){
                        logger.warn("입고를 포기하였습니다.");
                    }
                    else{
                        setCount(1);
                        logger.info(" 입고되었습니다. 재고 : {}",getCount());
                        semaphore.release(); // 품목에서 퇴장
                    }
                }
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }

        }

    
    }
    
}
