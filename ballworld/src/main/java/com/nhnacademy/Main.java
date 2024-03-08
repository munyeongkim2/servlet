// package com.nhnacademy;
// import java.awt.Graphics;
// import javax.swing.JFrame;
// import java.awt.*;

// public class Main {
//     public static class MyCanvas extends Panel {
//         int x;
//         int y;
//         public MyCanvas(int x, int y){
//             this.x=x;
//             this.y=y;
//         }
//         @Override
//         public void paint(Graphics g) {
//             super.paint(g);
//             System.out.println("paint mycanvas");  
//             // Ball ball = new Ball(x/2,y/2,10);
//         }
//     }
//     public static void main(String[] args) {
//         JFrame frame = new JFrame("ball world");
        
        
//         int x = 1000;
//         int y = 1000;
//         // frame.setSize(x, y);
//         // // 3. Frame을 보여 준다
//         // // 4. Graphics 객체를 가져와 사각형을 그린다
//         frame.getGraphics().fillRect(50, 50, 100, 100);

//         MyCanvas panel = new MyCanvas(x,y);
//         // frame.add(panel);
//         // frame.setVisible(true);

//         PaintableBall paintBall  = new PaintableBall(x, y, 50);
//         // paintBall.paint(frame);
//         PaintableBall paintBall2  = new PaintableBall(x, y, 50, Color.ORANGE);
//     }
// }