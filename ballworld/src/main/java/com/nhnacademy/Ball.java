package com.nhnacademy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.awt.Rectangle;


public class Ball implements Regionable{

    int newx;
    int newy;
    private int radius;
    private Rectangle region;



    Logger logger = LogManager.getLogger(this.getClass().getName());
    
    public Ball(int x, int y, int radius) {
        if(radius <= 0){
            throw new IllegalArgumentException("반지름은 0보다 커야 합니다.");
        }
        if ((x + (long) radius > Integer.MAX_VALUE)
        || (x - (long) radius < Integer.MIN_VALUE)
        || (y + (long) radius > Integer.MAX_VALUE)
        || (y - (long) radius < Integer.MIN_VALUE)) 
        {
            throw new IllegalArgumentException("볼이 정수 공간을 벗어납니다.");
        }

        this.radius = radius;
        this.region = new Rectangle(x -radius, y-radius, 2 * radius, 2 * radius);
        // logger.trace("new add Ball : {}, {}, {}}", x,y,radius);


    }

    public int getX() {
        return (int) region.getCenterX();
    }

    public int getY() {
        return (int) region.getCenterY();
    }
    public int getRadius() {
        return radius;
    }
    public void setX(int x) {
        
        region.setLocation(x-getRadius(), getY() - getRadius());
    }
    public void setY(int y) {

        region.setLocation(getX()-getRadius(), y - getRadius());
    }
    public Rectangle getRegion() {
        return region;
    }
    // public void setRegion(int x, int y) { // setRegion을 이렇게만 쓸 수 있는게 아니기 때문에 이렇게 하면 안됀다.
    //     this.region.translate(x, y);
    // }
    @Override
    public String toString() {

        return String.format("(%d, %d, %d)", getX(),getY(),getRadius());
        
    }
    public boolean crashBounds(Rectangle r) {
        return getRegion().intersects(r);
    }
}
