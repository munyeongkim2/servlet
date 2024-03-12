package com.nhnacademy;

import java.awt.Color;
import java.awt.Graphics;

public class PaintableBall extends Ball implements Paintable{  
    Color color;

    public static final Color DEFAULT_COLOR = Color.BLACK;

    public PaintableBall(int x, int y, int radius) {
        this(x, y, radius, DEFAULT_COLOR);

    }
    public PaintableBall(int x, int y, int radius, Color color) {
        super(x, y, radius);

        if(color == null){
            throw new IllegalArgumentException();
        }
        this.color = color;
    }

    @Override
    public void paint(Graphics g) {
        if(g == null){
            throw new IllegalArgumentException();
        }
        Color origiColor = g.getColor();

        g.setColor(getColor());
        g.fillOval(getX()-getRadius(),getY()-getRadius(),getRadius() * 2,getRadius() * 2);

        g.setColor(origiColor);//색깔 원복
    }
    public synchronized Color getColor() {
        return color;
    }
    public synchronized void setColor(Color color) {
        if(color == null){
            throw new IllegalArgumentException();
        }
        this.color = color;
    }
}
