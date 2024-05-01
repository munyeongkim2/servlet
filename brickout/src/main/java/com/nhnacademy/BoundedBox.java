package com.nhnacademy;

import java.awt.Color;
import java.awt.Rectangle;


public class BoundedBox extends MovableBox implements Bounded{ 
    // Rectangle bounds;

    public BoundedBox(int x, int y, int width, int height, Color color) {
        super(x, y, width, height,color);
        // bounds =  new Rectangle(x - width / 2, y - height / 2, width, height);
    }
    
    // public Rectangle getBounds(){
    //     return bounds;

    // }
    // public void setBounds(Rectangle bounds){
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
    
    // public void bounce(){

    //     if (getX() - getWidth()/2 < getBounds().getMinX() || getX() + getWidth()/2 > getBounds().getMaxX() ) {
    //         setDX(-getDX());
    //     }

    //     if (getY() - getHeight()/2 < getBounds().getMinY() || getY() + getHeight()/2 > getBounds().getMaxY() ){
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
