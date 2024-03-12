package com.nhnacademy;

import java.awt.Color;


public class MoveableBall extends PaintableBall implements Moveable{
    final Vector motion = new Vector();

    public MoveableBall(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
    }
    // 단위 시간당 x축으로 이동량 가져오기
    public int getDX(){
        return motion.getDX();
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
    public Vector getMotion() {
        return motion;
    }
    @Override
    public void move() {
        if (Math.abs(getDX()) > 0 || Math.abs(getDY()) > 0) {
            moveTo(getX() + getDX(), getY() + getDY());
        }
    }
    public void moveTo(int x, int y) {
        setX(x);
        setY(y);

    }
 
    
}
