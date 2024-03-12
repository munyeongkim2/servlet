package com.nhnacademy;

import java.awt.Color;

public class MoveableBox extends PaintableBox implements Moveable{

    final Vector motion = new Vector();

    public MoveableBox(int x, int y, int wight, int height, Color color) {
        super(x, y, wight, height, color);
    }
    // 단위 시간당 x축으로 이동량 가져오기
    public int getDX(){
        return motion.getDX();
    }
    public Vector getMotion() {
        return motion;
    }
    // 단위 시간당 y축으로 이동량 가져오기
    public int getDY(){
        return motion.getDY();
    }
    // 단위 시간당 x축으로 이동량 설정
    public void setDX(int dx){
        
        motion.setDX(dx);
    }
    // 단위 시간당 y축으로 이동량 설정d
    public void setDY(int dy){
        motion.setDY(dy);
    }

    
    // 단위 시간만큼 이동시키기
    public void move(){
        moveTo(getX()+getDX(), getY()+getDY());
    }

    
    // 특정 위치로 옮기기
    public void moveTo(int x, int y){
        setX(x);
        setY(y);
    }
    
}
