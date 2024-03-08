import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.nhnacademy.MoveableBall;

public class TestMoveableBall {
    @Test
    public void testConstructor(){
        //디폴드값 맞는지 확인
    }

    @ParameterizedTest
    @MethodSource("setXY")
    // @Test
    public void testSetXY(int x, int y, int radius,int dx,int dy) {
        assertDoesNotThrow(() -> {
            MoveableBall r = new MoveableBall(x,y,radius,Color.black);
            r.setDX(dx);
            r.setDY(dy);
            // r.move();
            assertEquals(dx, r.getDX());
            assertEquals(dy, r.getDY());
            // assertEquals(1, r.getDenominator());
        });
    }

    public static Stream<Arguments> setXY() {
        List<Arguments> argumentsList = new LinkedList<>();

        argumentsList.add(Arguments.arguments(0,0,2,10,10));
        argumentsList.add(Arguments.arguments(0,0,2,Integer.MAX_VALUE,0));
        argumentsList.add(Arguments.arguments(0,0,2,0,Integer.MAX_VALUE));
        argumentsList.add(Arguments.arguments(0,0,2,Integer.MAX_VALUE,Integer.MAX_VALUE));
        argumentsList.add(Arguments.arguments(0,0,2,Integer.MIN_VALUE,0));
        argumentsList.add(Arguments.arguments(0,0,2,-1,-1));
        // argumentsList.add(Arguments.arguments(Integer.MAX_VALUE));
        // argumentsList.add(Arguments.arguments(1));
        // argumentsList.add(Arguments.arguments(-1));
        // argumentsList.add(Arguments.arguments(0));

        return argumentsList.stream();
    }

    @ParameterizedTest
    @MethodSource("mover")
    // @Test
    public void testMover(int x, int y, int radius,int dx,int dy,int count) {
        assertDoesNotThrow(() -> {
            MoveableBall r = new MoveableBall(x,y,radius,Color.black);
            r.setDX(dx);
            r.setDY(dy);

            int curX =x;
            int curY =y;
            for (int i = 0; i < count; i++) {
                r.move();
                curX += dx;
                curY += dy;

                assertEquals(curX, r.getX());
                assertEquals(curY, r.getY());

            }
            assertEquals(x+dx*count, r.getX());
            assertEquals(y+dy*count, r.getY());

        });
    }
    static Stream<Arguments> mover(){
        return Stream.of(
            Arguments.arguments(10,20,3,30,30,3),
            Arguments.arguments(10,20,3,-30,30,3),
            Arguments.arguments(10,20,3,30,-30,3)
        );
    }
    
}
