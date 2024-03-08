package com.nhnacademy;
import java.awt.Graphics;

import java.util.ArrayList;

import java.util.List;
import javax.swing.JPanel;

public class World extends JPanel{//볼을 출력하는 게 일
    List<Regionable> regionableList = new ArrayList<>();
   
    public void add(Regionable object){
        if(object == null){
            throw new IllegalArgumentException("볼 정보가 없습니다.");
        }

        if ((object.getX() - object.getRegion().getWidth() /2 < 0)
            || (object.getX() + object.getRegion().getWidth() /2  > getWidth())
            || (object.getY() - object.getRegion().getWidth() /2  < 0)
            || (object.getY() + object.getRegion().getWidth() /2  > getHeight())) {
            throw new IllegalArgumentException();
        }
        for (Regionable exist : regionableList) {

            if((exist).getRegion().intersects(object.getRegion())){
                throw new IllegalArgumentException();
            }
        }
        
        this.regionableList.add(object);
        
    }
    @Override
    public void remove(int index){
        this.regionableList.remove(index);
    }
    public int getCount(){
        return regionableList.size();
    }
    public Regionable get(int index){
        return regionableList.get(index);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);  

        for (Regionable object : regionableList) {
            if(object instanceof Paintable){
                ((Paintable) object).paint(g);

            }  
        }

    }

}
