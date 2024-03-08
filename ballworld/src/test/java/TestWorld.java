import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.nhnacademy.BoundedBall;
import com.nhnacademy.BoundedBox;

import com.nhnacademy.MoveableWorld;
import com.nhnacademy.Paintable;
import com.nhnacademy.PaintableBox;


public class TestWorld {
    static final int FRAME_WIDTH = 400;
    static final int FRAME_HEIGHT = 400;
    static final int MIN_RADIUS = 20;
    static final int MAX_RADIUS = 50;
    static final int MIN = 20;
    static final int MAX = 50;

    static final int BALL_COUNT = 7;
    static final int BOX_COUNT = 8;
    static final int MIN_DELTA = 10;
    static final int MAX_DELTA = 30;
    static final Color[] COLOR_TABLE = {
            Color.BLACK,
            Color.RED,
            Color.BLUE,
            Color.YELLOW
    };

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        MoveableWorld world = new MoveableWorld();
        world.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.add(world);

        Random random = new Random();

      

        while (world.getCount() < BALL_COUNT) {
            try {
                BoundedBall ball = new BoundedBall(random.nextInt(FRAME_WIDTH),
                                                    random.nextInt(FRAME_HEIGHT),
                                                    MIN_RADIUS + random.nextInt(MAX_RADIUS - MIN_RADIUS + 1),
                                                    COLOR_TABLE[random.nextInt(COLOR_TABLE.length)]);
 

                int dx = MIN_DELTA - random.nextInt(MAX_DELTA - MIN_DELTA + 1);
                int dy = MIN_DELTA - random.nextInt(MAX_DELTA - MIN_DELTA + 1);

                ball.setDX(dx);
                ball.setDY(dy);


                ball.setBounds(world.getBounds());


                
                world.add(ball);


            } catch (IllegalArgumentException ignore) {
                //
            }
            try {

                BoundedBox box = new BoundedBox(random.nextInt(FRAME_WIDTH),
                                random.nextInt(FRAME_HEIGHT),
                                MIN_RADIUS + random.nextInt(MAX_RADIUS - MIN_RADIUS + 1),
                                MIN_RADIUS + random.nextInt(MAX_RADIUS - MIN_RADIUS + 1),
                                COLOR_TABLE[random.nextInt(COLOR_TABLE.length)]);
 

                int dx = MIN_DELTA - random.nextInt(MAX_DELTA - MIN_DELTA + 1);
                int dy = MIN_DELTA - random.nextInt(MAX_DELTA - MIN_DELTA + 1);

                box.setDX(dx);
                box.setDY(dy);

                box.setBounds(world.getBounds());

                world.add(box);

            } catch (IllegalArgumentException ignore) {
                //
            }
        }


        frame.setVisible(true);
        world.setMaxMoveCount(1000000);
        world.run();
        System.exit(0);
}
}