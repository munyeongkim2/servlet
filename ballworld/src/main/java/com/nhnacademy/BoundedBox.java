package com.nhnacademy;

import java.awt.Color;
import java.awt.Rectangle;


public class BoundedBox extends MoveableBox implements Bounded{ 
    Rectangle bounds;

    public BoundedBox(int x, int y, int wight, int height, Color color) {
        super(x, y, wight, height,color);
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

        if (getX() - getWidth()/2 < getBounds().getMinX() || getX() + getWidth()/2 > getBounds().getMaxX() ) {
            setDX(-getDX());
        }

        if (getY() - getHeight()/2 < getBounds().getMinY() || getY() + getHeight()/2 > getBounds().getMaxY() ){
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
