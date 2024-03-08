package com.nhnacademy;

public class MoveableBox extends Ball implements Moveable{
    final Vector motion = new Vector();
    
    public MoveableBox(int x, int y, int radius) {
        super(x, y, radius);
    }

    @Override
    public void move() {

    }
    
}
