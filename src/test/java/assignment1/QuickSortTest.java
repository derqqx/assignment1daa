package assignment1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

public class QuickSortTest {
    @Test
    void testSortRandom() {
        Metrics m = new Metrics();
        Random rnd = new Random(123);
        int[] a = rnd.ints(1000, 0, 10000).toArray();
        QuickSort.sort(a, 123, m);
        for (int i = 1; i < a.length; i++) {
            assertTrue(a[i - 1] <= a[i]);
        }
    }
}