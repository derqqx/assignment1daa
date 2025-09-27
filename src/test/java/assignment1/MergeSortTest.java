package assignment1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
//проо
public class MergeSortTest {
    @Test
    void testSortRandom() {
        Metrics m = new Metrics();
        Random rnd = new Random(42);
        int[] a = rnd.ints(1000, 0, 10000).toArray();
        MergeSort.sort(a, m);
        for (int i = 1; i < a.length; i++) {
            assertTrue(a[i - 1] <= a[i]);
        }
    }
}