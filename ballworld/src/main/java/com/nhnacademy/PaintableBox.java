package com.nhnacademy;
import java.awt.Color;
import java.awt.Graphics;

public class PaintableBox extends Box implements Paintable{ 


    Color color;
    public static final Color DEFAULT_COLOR = Color.BLACK;

    public PaintableBox(int x , int y, int wight, int height){
        super(x, y, wight, height);
    }


    public PaintableBox(int x, int y, int wight, int height, Color color){
        super(x,y,wight,height);
        if(color == null){
            throw new IllegalArgumentException();
        }
        this.color = color;
    }

    public Color getColor(){
        return this.color;
    }

    /**
     * 
     * @param color
     * @throws IllegalArgumentException 컬러는 null 허용하지 않습니다.
     */
    public synchronized void setColor(Color color){ //set 하는 순간에 set 못하도록 저 키워드를 쓴다.
        if(color == null){
            throw new IllegalArgumentException();
        }
        this.color = color;
    }
    @Override
    public void paint(Graphics g){
        if(g == null){
            throw new IllegalArgumentException();
        }
        Color origiColor = g.getColor();

        g.setColor(getColor());
        g.fillRect(getX() ,getY(), getWidth(), getHeight());

        g.setColor(origiColor);//색깔 원복
        
    }
}
