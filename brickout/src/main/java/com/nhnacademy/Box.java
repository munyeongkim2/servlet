package com.nhnacademy;

import java.awt.Rectangle;

public class Box implements Regionable{
    private Rectangle region;

    public Box(int x, int y, int width, int height) {
        if((width <=0) || (height <=0)){
            throw new IllegalArgumentException();
        }
        if ((x + (long) width / 2> Integer.MAX_VALUE)
        || (x - (long) width / 2< Integer.MIN_VALUE)
        || (y + (long) height / 2> Integer.MAX_VALUE)
        || (y - (long) width / 2< Integer.MIN_VALUE)) 
        {
            throw new IllegalArgumentException("박스가 정수 공간을 벗어납니다.");
        }
        this.region = new Rectangle(x - width / 2, y - height / 2, width, height);

    }

    @Override
    public int getX() {
        return (int) region.getCenterX();
    }

    @Override
    public int getY() {
        return (int) region.getCenterY();
    }

    public int getWidth() {
        return (int) region.getWidth();
    }

    public int getHeight() {
        return (int) region.getHeight();
    }

    public void setX(int x) {
        region.setLocation(x - getWidth() / 2, getY() - getHeight() / 2);
    }

    public void setY(int y) {
        region.setLocation(getX() - getWidth() / 2, y - getHeight() / 2);
    }

    @Override
    public Rectangle getRegion() {
        return region;
    }
    public boolean crashBounds(Rectangle r) {
        return getRegion().intersects(r);
    }
    
}
