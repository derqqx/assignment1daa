package assignment1;

import java.util.Arrays;
import java.util.Random;

public class BenchHarness {
    public static void main(String[] args) {
        Random rnd = new Random(42);
        int[] arr = rnd.ints(10000, 0, 100000).toArray();

        Metrics m1 = new Metrics();
        long t1 = System.currentTimeMillis();
        int res = Select.deterministicSelect(arr.clone(), arr.length / 2, m1);
        long t2 = System.currentTimeMillis();
        System.out.println("Select result=" + res + " time=" + (t2 - t1) + "ms");

        Metrics m2 = new Metrics();
        long t3 = System.currentTimeMillis();
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        long t4 = System.currentTimeMillis();
        System.out.println("Arrays.sort result=" + sorted[sorted.length / 2] + " time=" + (t4 - t3) + "ms");
    }
}