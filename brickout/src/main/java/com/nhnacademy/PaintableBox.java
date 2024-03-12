package com.nhnacademy;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PaintableBox extends Box implements Paintable{ 


    Color color;
    public static final Color DEFAULT_COLOR = Color.BLACK;

    public PaintableBox(int x , int y, int width, int height){
        this(x, y, width, height, DEFAULT_COLOR);
    }


    public PaintableBox(int x, int y, int wight, int height, Color color){
        super(x,y,wight,height);
        if(color == null){
            throw new IllegalArgumentException();
        }
        this.color = color;
    }

    public synchronized Color getColor() {
        return color;
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
        g.fillRect((int) getRegion().getX(), (int) getRegion().getY(), (int) getRegion().getWidth(),
                (int) getRegion().getHeight());
                        // 굵기 설정
        float strokeWidth = 4.0f; // 굵기 값 조정
        ((Graphics2D) g).setStroke(new BasicStroke(strokeWidth));
                
        g.setColor(DEFAULT_COLOR);
        g.drawRect((int) getRegion().getX(), (int) getRegion().getY(), (int) getRegion().getWidth(),
                (int) getRegion().getHeight());

        g.setColor(origiColor);//색깔 원복
        
    }
}
