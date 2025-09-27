package assignment1;

import java.util.Arrays;

public class ClosestPair {
    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
    }

    public static double closestPair(Point[] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a.x, b.x));
        return divide(points, 0, points.length - 1);
    }

    private static double divide(Point[] pts, int l, int r) {
        if (r - l <= 3) return bruteForce(pts, l, r);

        int mid = (l + r) / 2;
        double d1 = divide(pts, l, mid);
        double d2 = divide(pts, mid + 1, r);
        double d = Math.min(d1, d2);
        return d;
    }

    private static double bruteForce(Point[] pts, int l, int r) {
        double min = Double.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            for (int j = i + 1; j <= r; j++) {
                double dist = Math.hypot(pts[i].x - pts[j].x, pts[i].y - pts[j].y);
                min = Math.min(min, dist);
            }
        }
        //тестовая
        return min;
    }
}