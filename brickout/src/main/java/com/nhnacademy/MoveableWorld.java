package com.nhnacademy;

public class MoveableWorld extends World {
    int moveCount;//실행하는 동안 이동 횟수 
    int maxMoveCount;//최대 이동 횟수
    static final int DEFAULT_DT = 50;
    int dt = DEFAULT_DT;

    private Score scoreObject ; // Score 객체를 저장할 변수
    private GameEndString gameEndString; 

    public void setGameEndString(boolean gameEnd) {
        gameEndString = new GameEndString(getX(),getY(),getWidth(),getHeight());
        gameEndString.setGameEndString(gameEnd);
        super.add(gameEndString);
    }
    
    public void setDT(int dt) {
        if (dt < 0) {
            throw new IllegalArgumentException();
        }
        this.dt = dt;
    }

    public int getDT() {
        return dt;
    }

    public void reset() {
        moveCount = 0;
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
    // Score 객체를 가져오는 메소드
    public void setScoreObject(Score scoreObject) {
        this.scoreObject = scoreObject;
        super.add(scoreObject);
    }

    public void move() {
        if ((getMaxMoveCount() == 0) || (getMoveCount() < getMaxMoveCount())) {
            if(regionableList.size() == 6){
                setGameEndString(true);
            }
            for (int i = 0; i < getCount(); i++) {
                Regionable object = get(i);
                
                if (object instanceof Moveable) {
                    ((Moveable) object).move();
                    if (object instanceof Bounded) {
                        for (int j = 0; j < getCount(); j++) {
                            Regionable other = get(j);

                            if ((object != other) && (object.getRegion().intersects(other.getRegion()))) {
                                ((Bounded) object).bounce(other);
                                if(regionableList.get(0) != other
                                && regionableList.get(1) != other
                                && regionableList.get(2) != other
                                && regionableList.get(3) != other
                                && regionableList.get(4) != other
                                && regionableList.get(5) != other){
                                    regionableList.remove(other);
                                    scoreObject.setScore(1);
                                }
                                else if(regionableList.get(3) == other){
                                    setGameEndString(false);
                                    moveCount = 1000000;
                                    }
                                    
                                }
                            }
                        
                        }
                    }
                }
  
            }

            moveCount++;
            repaint();
        }
    

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            move();
            try {
                Thread.sleep(getDT());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
