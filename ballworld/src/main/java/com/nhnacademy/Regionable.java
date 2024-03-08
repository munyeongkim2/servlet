package com.nhnacademy;

import java.awt.Rectangle;

interface Regionable {
    public int getX();
    public int getY();
    public Rectangle getRegion();
    public boolean crashBounds(Rectangle region);
    
}
