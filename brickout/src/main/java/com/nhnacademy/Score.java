package com.nhnacademy;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
public class Score extends PaintableBox {
    int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public Score(int x, int y, int width, int height) {
        super(x, y, width, height);
        score=0;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman",Font.BOLD,40));
        g.drawString(String.format("Score : %d", getScore()),getX(), getY());
    }
}
