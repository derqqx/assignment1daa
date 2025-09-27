package assignment1;

public class Metrics {
    public long cmp, moves, alloc;
    public int depth;

    public void reset() { cmp = moves = alloc = 0; depth = 0; }

    public int cmp(int a, int b) { cmp++; return Integer.compare(a, b); }
    public void move() { moves++; }
    public void alloc() { alloc++; }
    public void d(int d) { if (d > depth) depth = d; }
}