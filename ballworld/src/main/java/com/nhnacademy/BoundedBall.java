package com.nhnacademy;

import java.awt.Color;
import java.awt.Rectangle;


public class BoundedBall extends MoveableBall implements Bounded{ 

    Rectangle bounds;

    public BoundedBall(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
        
    }
    
    public Rectangle getBounds(){
        return bounds;

    }
    public void setBounds(Rectangle bounds){
        this.bounds = bounds;

    }
    public boolean isOutOfBounds() {
        return bounds.intersects(getRegion());
    }
    
    @Override
    public void move(){
        super.move();
        if(isOutOfBounds()){
            bounce();
            
        }
        
    }
    
    public void bounce(){

        if (getX() - getRadius() < getBounds().getMinX() || getX() + getRadius() > getBounds().getMaxX() ) {
            setDX(-getDX());
        }

        if (getY() - getRadius() < getBounds().getMinY() || getY() + getRadius() > getBounds().getMaxY() ){
            setDY(-getDY());
        }

    }
    @Override
    public void bounce(Regionable other){

        Rectangle intersection = getRegion().intersection(other.getRegion());
        if(getRegion().getWidth() != intersection.getWidth()){
            setDX(-getDX());
        }
        if(getRegion().getHeight() != intersection.getHeight()){
            setDY(-getDY());
        }

    }
}