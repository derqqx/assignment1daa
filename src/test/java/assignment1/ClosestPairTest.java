package assignment1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClosestPairTest {

    @Test
    void testClosestPair() {
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(0, 0),
                new ClosestPair.Point(3, 4),
                new ClosestPair.Point(7, 7),
                new ClosestPair.Point(1, 1)
        };

        double d = ClosestPair.closestPair(pts);
        assertEquals(Math.sqrt(2), d, 0.0001);
    }
}