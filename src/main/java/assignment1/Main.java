package assignment1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String csv = "bench-results.csv";
        int[] sizes = {1000, 5000, 10000}; // можно расширить до 100000

        // прогоняем все алгоритмы на всех размерах
        for (int n : sizes) {
            int[] arr = new Random().ints(n, 0, 1000000).toArray();

            // MergeSort
            runExperiment("mergesort", arr.clone(), n, csv);

            // QuickSort
            runExperiment("quicksort", arr.clone(), n, csv);

            // Select (ищем k-й элемент, k = n/2)
            runExperiment("select", arr.clone(), n, csv);

            // Closest Pair
            runClosestExperiment(n, csv);
        }

        System.out.println("Done. Results written to " + csv);
    }

    private static void runExperiment(String algo, int[] arr, int n, String csv) {
        Metrics m = new Metrics();
        long start = System.nanoTime();

        switch (algo) {
            case "mergesort" -> MergeSort.sort(arr, m);
            case "quicksort" -> QuickSort.sort(arr, 0, m);
            case "select" -> Select.deterministicSelect(arr, n / 2, m);
        }

        long time = System.nanoTime() - start;
        CsvWriter.write(csv, algo, n, m, time);
    }

    private static void runClosestExperiment(int n, String csv) {
        Metrics m = new Metrics();
        Random rnd = new Random();
        ClosestPair.Point[] pts = new ClosestPair.Point[n];
        for (int i = 0; i < n; i++) {
            pts[i] = new ClosestPair.Point(rnd.nextInt(10000), rnd.nextInt(10000));
        }

        long start = System.nanoTime();
        ClosestPair.closestPair(pts);
        long time = System.nanoTime() - start;

        CsvWriter.write(csv, "closest", n, m, time);
    }
}