package assignment1;

import java.util.Random;

public class BenchHarness {
    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000};
        Random rnd = new Random(42);

        for (int n : sizes) {
            int[] arr = rnd.ints(n, 0, 100000).toArray();

            // --- MergeSort ---
            Metrics m1 = new Metrics();
            long t1 = System.currentTimeMillis();
            MergeSort.sort(arr.clone(), m1);
            long t2 = System.currentTimeMillis();
            CsvWriter.write("bench-results.csv", "mergesort", n, m1, (t2 - t1));

            // --- QuickSort ---
            Metrics m2 = new Metrics();
            long t3 = System.currentTimeMillis();
            QuickSort.sort(arr.clone(), 42L, m2);
            long t4 = System.currentTimeMillis();
            CsvWriter.write("bench-results.csv", "quicksort", n, m2, (t4 - t3));

            // --- Deterministic Select ---
            Metrics m3 = new Metrics();
            long t5 = System.currentTimeMillis();
            Select.deterministicSelect(arr.clone(), arr.length / 2, m3);
            long t6 = System.currentTimeMillis();
            CsvWriter.write("bench-results.csv", "select", n, m3, (t6 - t5));

            // --- Closest Pair ---
            Metrics m4 = new Metrics();
            ClosestPair.Point[] points = new ClosestPair.Point[n];
            for (int i = 0; i < n; i++) {
                points[i] = new ClosestPair.Point(
                        rnd.nextInt(100000),
                        rnd.nextInt(100000)
                );
            }
            long t7 = System.currentTimeMillis();
            ClosestPair.closestPair(points);
            long t8 = System.currentTimeMillis();
            CsvWriter.write("bench-results.csv", "closest", n, m4, (t8 - t7));
        }

        System.out.println("✅ Done. Results written to bench-results.csv");
    }
}