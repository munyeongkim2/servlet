package com.nhnacademy;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class GameEndString extends PaintableBox{
    boolean gameEnd;
    String gameEndStr;



    public GameEndString(int x, int y, int width, int height) {
        super(x, y, width, height);
        gameEnd = false;
    }

    public String getGameEndString() {
        return gameEndStr;
    }

    public void setGameEndString(boolean gameEnd) {
        if(gameEnd){gameEndStr = "GAME CLEAR!";}
        else{gameEndStr = "GAME OVER!";}
    }


    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman",Font.BOLD,100));
        g.drawString(getGameEndString(),65,500);
    }
    
}
