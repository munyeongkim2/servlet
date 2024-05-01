package com.nhnacademy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class PlayGround { 
    static final int FRAME_WIDTH = 1000;
    static final int FRAME_HEIGHT = 1000;
    static final int MIN_RADIUS = 10;
    static final int MAX_RADIUS = 50;
    static final int FIXED_BALL_COUNT = 0;
    static final int FIXED_BOX_COUNT = 40;
    static final int BOUNDED_BALL_COUNT = 1;
    // static final int BOUNDED_BOX_COUNT = 5;
    static final int MIN_DELTA = 5;
    static final int MAX_DELTA = 20;
    static final int MAX_MOVE_COUNT = 0;
    static final int DT = 10;
    static final int WALL_THICKNESS = 10;
    static final Color[] COLOR_TABLE = {
            Color.RED,
            Color.ORANGE,
            Color.YELLOW,
            Color.GREEN,
            Color.BLUE
    };

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setSize(1200,1200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        MovableWorld world = new MovableWorld();

        frame.add(world);
        world.setBounds(0,0,FRAME_WIDTH, FRAME_HEIGHT);

        world.add(new PaintableBox(-WALL_THICKNESS / 2, FRAME_HEIGHT / 2, WALL_THICKNESS, FRAME_HEIGHT + 2 * WALL_THICKNESS)); //brick 클래스 하나 만들기
        
        world.add(new PaintableBox(FRAME_WIDTH / 2, WALL_THICKNESS / 2, FRAME_WIDTH + 2 * WALL_THICKNESS, WALL_THICKNESS/10));
        world.add(new PaintableBox(FRAME_WIDTH + WALL_THICKNESS / 2, FRAME_HEIGHT / 2, WALL_THICKNESS, FRAME_HEIGHT + 2 * WALL_THICKNESS));
        world.add(new PaintableBox(FRAME_WIDTH / 2, FRAME_HEIGHT + WALL_THICKNESS / 2, FRAME_WIDTH + 2 * WALL_THICKNESS, WALL_THICKNESS));
        
        world.setControlBar(new MovableBox(FRAME_WIDTH / 2, FRAME_HEIGHT -40, 100,20,Color.BLACK));
        world.setScoreObject(new Score(0,30,50,50));
        
        //brick 샤이즈
        int width = 100;
        int height = 50;
        int x = width / 2;
        int y = height/2 + height + WALL_THICKNESS/20;

        int colorCount=0;

        for (int i = 0; i < FIXED_BOX_COUNT; i++) {
            try {
                world.add(new PaintableBox(x,y,width,height, COLOR_TABLE[colorCount]));
                x += width;
                if( (world.getCount() - 6) % 8 == 0 ){
                    x = width /2;
                    y += height;
                    colorCount ++;
                }

            } catch (IllegalArgumentException ignore) {
                //
            }
        }
        while (world.getCount() < FIXED_BOX_COUNT + BOUNDED_BALL_COUNT + 6) {
            try {
                BoundedBall ball = new BoundedBall(FRAME_WIDTH / 2,FRAME_HEIGHT -100,
                                                    20,
                                                    Color.DARK_GRAY);


                ball.setDX(-MIN_DELTA);
                ball.setDY(-MIN_DELTA);
                world.add(ball);


            } catch (IllegalArgumentException ignore) {
                
            }
        }
            
        frame.setVisible(true);
        world.setMaxMoveCount(1000000);
        world.setDT(DT);
        world.run();
        System.exit(0);
}
    }
