package com.nhnacademy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.awt.Rectangle;


public class Box implements Regionable{

    int newx;
    int newy;
    private Rectangle region;


    Logger logger = LogManager.getLogger(this.getClass().getName());
    
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

        this.region = new Rectangle(x , y , width, height);

    }

    public int getX() {
        return (int) region.getX();
    }

    public int getY() {
        return (int) region.getY();
    }
    public int getWidth() {
        return (int) region.getWidth();
    }
    public int getHeight() {
        return (int) region.getHeight();
    }

    public void setX(int x) {
        
        region.setLocation(x, getY());
    }
    public void setY(int y) {

        region.setLocation(getX(), y);
    }
    public Rectangle getRegion() {
        return region;
    }
    @Override
    public String toString() {

        return String.format("(%d, %d, %d, %d)", getX(),getY(),getWidth(),getHeight());
        
    }
    public boolean crashBounds(Rectangle r) {
        return getRegion().intersects(r);
    }

 
}
