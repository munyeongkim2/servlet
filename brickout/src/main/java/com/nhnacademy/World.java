package com.nhnacademy;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import java.awt.event.MouseMotionListener;


public class World extends JPanel implements  MouseMotionListener{
    
    List<Regionable> regionableList = new LinkedList<>();
    private boolean mouseEntered = false;
    MoveableBox controlBar;

    Random random = new Random();
    
    public World() {
        super();
        addMouseMotionListener(this);
    }

    public MoveableBox getControlBar() {
        return controlBar;
    }

    public void setControlBar(MoveableBox controlBar) {
        this.controlBar = controlBar;
        add(getControlBar());
    }
    /**
     *
     * @param object
     * @throw IllegalArgumentException 공간을 벗어나거나, null인 경우, 볼간 충돌된 경우
     */
    public void add(Regionable object) {
        if (object == null) {
            throw new IllegalArgumentException();
        }

        for (Regionable item : regionableList) {
            if (((object instanceof Bounded || (item instanceof Bounded))
                    && (object.getRegion().intersects(item.getRegion())))) {
                throw new IllegalArgumentException();
            }
        }

        regionableList.add(object);
    }

    public void remove(Regionable object) {
        regionableList.remove(object);
    }

    @Override
    public void remove(int index) {
        regionableList.remove(index);
    }

    public int getCount() {
        return regionableList.size();
    }

    public Regionable get(int index) {
        return regionableList.get(index);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (Regionable object : regionableList) {
            if (object instanceof Paintable) {
                ((Paintable) object).paint(g);
            }
        }

    }


    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(mouseEntered){

        }
        controlBar.setX(e.getX());
        controlBar.move(); 


   }
}

     


