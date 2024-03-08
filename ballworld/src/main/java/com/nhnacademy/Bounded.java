package com.nhnacademy;

import java.awt.Rectangle;

interface Bounded {

    public void move();
    public void bounce(Regionable object);
    public boolean crashBounds(Rectangle region);
}
