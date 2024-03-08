package com.nhnacademy;

public class MoveableWorld extends World{
    int moveCount;//실행하는 동안 이동 횟수 
    int maxMoveCount;//최대 이동 횟수

    public void reset(){//이동 횟수(moveCount) 초기화
        setMoveCount(0);
    }
    public int getMoveCount(){
        return moveCount;
    }
    public void setMoveCount(int moveCount){
        this.moveCount = moveCount;
    }
    public int getMaxMoveCount(){
        return maxMoveCount;
    }
    public void setMaxMoveCount(int count){
        if(count<0){
            throw new IllegalArgumentException();
        }
        maxMoveCount = count;
    }
    public void move() {
        if ((getMaxMoveCount() == 0) || (getMoveCount() < getMaxMoveCount())) {
            for (int i = 0; i < getCount(); i++) {
                Regionable object = get(i);
                if (object instanceof Moveable) {
                    ((Moveable) object).move();

                    if (object instanceof Bounded) {
                        for (int j = 0; j < getCount(); j++) {
                            Regionable other = get(j);

                            if ((object != other) && (object.getRegion().intersects(other.getRegion()))) {
                                ((Bounded) object).bounce(other);
                            }
                        }
                    }
                }
            }

            moveCount++;
            repaint();
        }
    }
    // public void move(){//단위 시간 단위 이동

        
    //     if((getMaxMoveCount() == 0)||(getMoveCount()<getMaxMoveCount())){
    //         for (int i = 0; i < super.getCount() ; i++) {
    //             Regionable object = get(i);
                
    //             if(object instanceof Moveable){
    //                 ((Moveable) object).move();
    //                 if(object instanceof Bounded){
    //                     for (int j = 0; j < super.getCount(); j++) {
    //                         Regionable other = get(j);
    //                         if(object.crashBounds(other.getRegion()) && object != other){
    //                             ((Bounded) object).bounce(other);
    //                         }
    //                     }
    //                 }

    //             moveCount++;
    //         }
    //         repaint();
  
    //     }}
    // }

    public void run(){
        while (!Thread.currentThread().isInterrupted()) {
            move();
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    
    
}
