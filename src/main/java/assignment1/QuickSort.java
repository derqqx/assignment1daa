package assignment1;

import java.util.Random;

public class QuickSort {
    public static void sort(int[] a, long seed, Metrics m) {
        rec(a, 0, a.length - 1, seed, 1, m);
    }

    private static void rec(int[] a, int l, int r, long seed, int depth, Metrics m) {
        while (l < r) {
            m.d(depth);
            int p = partition(a, l, r, seed, m);
            int leftSize = p - l;
            int rightSize = r - p;
            if (leftSize < rightSize) {
                if (l < p) rec(a, l, p - 1, seed + 1, depth + 1, m);
                l = p + 1;
            } else {
                if (p < r) rec(a, p + 1, r, seed + 1, depth + 1, m);
                r = p - 1;
            }
        }
        m.d(depth);
    }

    private static int partition(int[] a, int l, int r, long seed, Metrics m) {
        Random rnd = new Random(seed + l + r);
        int p = l + rnd.nextInt(r - l + 1);
        swap(a, p, r, m);
        int pivot = a[r], i = l;
        for (int j = l; j < r; j++) {
            if (m.cmp(a[j], pivot) <= 0) swap(a, i++, j, m);
        }
        swap(a, i, r, m);
        return i;
    }
//2
    private static void swap(int[] a, int i, int j, Metrics m) {
        if (i != j) {
            int t = a[i]; a[i] = a[j]; a[j] = t; m.move();
        }
    }
}