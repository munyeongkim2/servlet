package com.nhnacademy;

import java.awt.Rectangle;

/**
 * Regionable
 */
public interface Regionable {
    public int getX();
    public int getY();
    public void setX(int x);
    public void setY(int y);
    public Rectangle getRegion();
} 
