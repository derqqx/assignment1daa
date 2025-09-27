package assignment1;

public class MergeSort {
    private static final int CUTOFF = 16; // маленькие массивы сортируем вставкой

    public static void sort(int[] a, Metrics m) {
        if (a.length <= 1) return;
        int[] buf = new int[a.length];
        m.alloc();
        rec(a, 0, a.length - 1, buf, 1, m);
    }

    private static void rec(int[] a, int l, int r, int[] buf, int depth, Metrics m) {
        m.d(depth);
        if (r - l + 1 <= CUTOFF) { insert(a, l, r, m); return; }
        int mid = (l + r) / 2;
        rec(a, l, mid, buf, depth + 1, m);
        rec(a, mid + 1, r, buf, depth + 1, m);
        if (m.cmp(a[mid], a[mid + 1]) <= 0) return; // уже отсортировано
        merge(a, l, mid, r, buf, m);
    }

    private static void insert(int[] a, int l, int r, Metrics m) {
        for (int i = l + 1; i <= r; i++) {
            int x = a[i];
            int j = i - 1;
            while (j >= l && m.cmp(a[j], x) > 0) {
                a[j + 1] = a[j]; m.move(); j--;
            }
            a[j + 1] = x; m.move();
        }
    }

    private static void merge(int[] a, int l, int m, int r, int[] buf, Metrics mt) {
        int i = l, j = m + 1, k = l;
        while (i <= m && j <= r) {
            if (mt.cmp(a[i], a[j]) <= 0) { buf[k++] = a[i++]; mt.move(); }
            else { buf[k++] = a[j++]; mt.move(); }
        }
        while (i <= m) { buf[k++] = a[i++]; mt.move(); }
        while (j <= r) { buf[k++] = a[j++]; mt.move(); }
        for (int t = l; t <= r; t++) { a[t] = buf[t]; mt.move(); }
    }
}