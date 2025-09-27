package assignment1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MetricsTest {
    @Test
    void testCmpAndMoves() {
        Metrics m = new Metrics();

        assertEquals(-1, m.cmp(1, 2)); // 1 < 2
        assertEquals(0, m.cmp(2, 2));  // 2 == 2
        assertEquals(1, m.cmp(3, 2));  // 3 > 2

        m.move();
        assertTrue(m.moves > 0, "moves counter should increment");
    }
}