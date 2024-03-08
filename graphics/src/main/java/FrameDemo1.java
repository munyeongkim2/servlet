// import javax.swing.JFrame;
// import java.awt.*;

// public class FrameDemo1 {
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

//             // for (int i = 50; i < 11; i++) {
//             //     // g.drawRect(i*20,i*20,i*5,i*5);
//             //     g.drawLine(i*10,i*10,i,i);
//             // }

//             int x1 = (int)(x*0.5);
//             int y1 = (int)(y*0.6);
//             int x2 = (int)(x*0.6);
//             int y2 = (int)(y*0.5);
         
//             g.drawLine((int)(x*0.5),(int)(y*0.6),(int) (x*0.5),y);
//             g.drawLine((int)(x*0.5),(int)(y*0.6),(int) (x*0.6),(int)(y*0.5));
//             g.drawLine((int)(x*0.5),(int)(y*0.6),(int) (x*0.4),(int)(y*0.5));
            
//         }
//     }

//     public static void main(String[] args) {
//         // 1. Frame 만들기
//         JFrame frame = new JFrame("Demo01");
//         // 2. Frame의 크기를 지정한다.

//         int x = 1000;
//         int y = 1000;
//         frame.setSize(x, y);
//         // 3. Frame을 보여 준다
//         // 4. Graphics 객체를 가져와 사각형을 그린다
//         //frame.getGraphics().fillRect(50, 50, 100, 100);

//         MyCanvas panel = new MyCanvas(x,y);
//         frame.add(panel);
//         frame.setVisible(true);
            
//     }
// }

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class FrameDemo1 extends JPanel {


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = getWidth() / 2; 
        int y = getHeight(); 

        drawTree(g, x, y, 200, Math.PI / 2); 
    }

    private void drawTree(Graphics g, int x, int y, int length, double angle) {
        if (length == 0) {
            return; 
        }

        int xEnd = x + (int) (Math.cos(angle) * length);
        int yEnd = y - (int) (Math.sin(angle) * length);

        g.drawLine(x, y, xEnd, yEnd);

        int newLength = (int) (length * 0.7); 

        drawTree(g, xEnd, yEnd, newLength, angle - Math.PI / 6); 
        drawTree(g, xEnd, yEnd, newLength, angle + Math.PI / 6); 
        // drawTree(g, xEnd, yEnd, (int) (newLength * 0.8), angle - Math.PI / 4); // 왼쪽 아래 추가 가지
        // drawTree(g, xEnd, yEnd, (int) (newLength * 0.8), angle + Math.PI / 4); // 오른쪽 아래 추가 가지
    }

    
    public static void main(String[] args) {
        JFrame frame = new JFrame("나무 그리기");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1000);
        frame.add(new FrameDemo1());
        frame.setVisible(true);
    }
}
