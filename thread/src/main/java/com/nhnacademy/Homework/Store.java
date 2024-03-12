package com.nhnacademy.Homework;

/*
 * 매장은 물건을 납품 받아서 판매한다.

매장에는 최대 10개의 물건만 전시할 수 있다.

매장은 최대 5명까지만 동시 입장 가능하다.

매장에서 물건 구매는 동시에 1명만 가능하다.

매장에서 물건 판매 후 빈 공간에 생기면 생산자에게 알려 준다.

매장에서 물건 납품은 동시에 1명만 가능하다.

매장에서 물건이 들어오면 소비자에게 알려 준다.
 */

public class Store {
    int[] item = new int[10];
    
    public Store() {

    }

    public void enter() {

        
    }

    public void exit() {

    }

    public synchronized void buy() {

    }

    public synchronized void sell() {

    }

}
