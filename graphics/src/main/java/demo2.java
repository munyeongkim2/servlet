
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class demo2 extends JFrame {

        public demo2() {
            setTitle("Triangle Demo");
            setSize(500, 500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            add(new TrianglePanel());
            setLocationRelativeTo(null);
        }
    
        public static void main(String[] args) {
            javax.swing.SwingUtilities.invokeLater(() -> {
                new demo2().setVisible(true);
            });
        }
    }
    
    class TrianglePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawRecursiveTriangle(g, 50, 400, 450, 400, 250, 50, 4);
        }
    
        private void drawRecursiveTriangle(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int depth) {
            if (depth == 0) {
                return;
            }
            g.drawLine(x1, y1, x2, y2);
            g.drawLine(x2, y2, x3, y3);
            g.drawLine(x3, y3, x1, y1);
    
            int x12 = (x1 + x2) / 2;
            int y12 = (y1 + y2) / 2;
            int x23 = (x2 + x3) / 2;
            int y23 = (y2 + y3) / 2;
            int x31 = (x3 + x1) / 2;
            int y31 = (y3 + y1) / 2;
  
            drawRecursiveTriangle(g, x1, y1, x12, y12, x31, y31, depth - 1);
            drawRecursiveTriangle(g, x12, y12, x2, y2, x23, y23, depth - 1);
            drawRecursiveTriangle(g, x23, y23, x3, y3, x31, y31, depth - 1);
        }
    }