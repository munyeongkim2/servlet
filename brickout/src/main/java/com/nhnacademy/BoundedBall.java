package com.nhnacademy;

import java.awt.Color;
import java.awt.Rectangle;

public class BoundedBall extends MovableBall implements Bounded{
    // Rectangle bounds;
    
    public BoundedBall(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
        // bounds = new Rectangle(x - radius, y- radius, 2 * radius, 2 * radius);
    }

    // public Rectangle getBounds() {
    //     return bounds;
    // }

    // public void setBounds(Rectangle bounds) {
    //     this.bounds = bounds;
    // }
    // public boolean isOutOfBounds() {
    //     return bounds.intersects(getRegion());
    // }
    // @Override
    // public void move(){
    //     super.move();
    //     // if(isOutOfBounds()){
    //     //     bounce();
            
    //     // }
        
    // }
    // public void bounce() {
    //     if(getX()+getRadius() > getBounds().getMaxX() || getX() - getRadius() < getBounds().getMinX()){
    //         setDX(-getDX());
    //     }
    //     if (getY() - getRadius() < getBounds().getMinY() || getY() + getRadius() > getBounds().getMaxY() ){
    //         setDY(-getDY());
    //     }
    
    // }
    
    @Override
    public void bounce(Regionable other){
        Rectangle intersection = getRegion().intersection(other.getRegion());

        if ((getRegion().getHeight() != intersection.getHeight())
                && (other.getRegion().getHeight() != intersection.getHeight())) {
            setDY(-getDY());
        }

        if ((getRegion().getWidth() != intersection.getWidth())
                && (other.getRegion().getWidth() != intersection.getWidth())) {
            setDX(-getDX());
        }

    }
}

