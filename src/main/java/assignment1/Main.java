package assignment1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        if (args.length < 6) {
            System.out.println("Usage: --algo mergesort|quicksort|select|closest --n <size> --csv <file>");
            return;
        }

        String algo = args[1];
        int n = Integer.parseInt(args[3]);
        String csv = args[5];

        int[] arr = new Random(42).ints(n, 0, 10000).toArray();
        Metrics m = new Metrics();
        long start = System.currentTimeMillis();

        switch (algo) {
            case "mergesort" -> MergeSort.sort(arr, m);
            case "quicksort" -> QuickSort.sort(arr, 42, m);
            case "select" -> Select.deterministicSelect(arr, n / 2, m);
            case "closest" -> {
                ClosestPair.Point[] pts = new ClosestPair.Point[n];
                Random rnd = new Random(42);
                for (int i = 0; i < n; i++) pts[i] = new ClosestPair.Point(rnd.nextInt(1000), rnd.nextInt(1000));
                ClosestPair.closestPair(pts);
            }
            default -> System.out.println("Unknown algorithm");
        }

        long end = System.currentTimeMillis();
        CsvWriter.write(csv, algo, n, m, end - start);
        System.out.println("Done. Results written to " + csv);
    }
}