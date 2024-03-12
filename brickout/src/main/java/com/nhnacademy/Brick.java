package com.nhnacademy;

import java.awt.Color;

public class Brick extends PaintableBox{
    int broken = 1;
    
    public Brick(int x, int y, int wight, int height, Color color, int broken) {
        super(x, y, wight, height, color);
        this.broken = broken;
    }
    
}
