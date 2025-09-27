package assignment1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Random;

public class SelectTest {
//ап
    @Test
    void testDeterministicSelect() {
        Metrics m = new Metrics();
        Random rnd = new Random(1);
        int[] arr = rnd.ints(50, 0, 100).toArray();

        int k = 10;
        int result = Select.deterministicSelect(arr.clone(), k, m);

        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        assertEquals(sorted[k], result);
    }
}