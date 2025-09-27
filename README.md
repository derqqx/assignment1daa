# Assignment 1
Assignment 1 — Divide & Conquer Algorithms
1)Architecture
1.1)MergeSort — sorting by dividing the array into halves, merging with a reusable buffer. For small arrays, the algorithm switches to insertion sort (cutoff optimization).

1.2)QuickSort — randomized pivot selection; always recurses into the smaller half and processes the larger one iteratively, which keeps recursion depth bounded by O(log n).

1.3)Deterministic Select (Median of Medians, MoM5) — finds the k-th smallest element. The array is divided into groups of 5, median of medians is chosen as pivot, and recursion continues only in the part that contains the desired element.

1.4)Closest Pair of Points (2D) — the set of points is split by X-coordinate, recursive calls are made for each half, and in the “strip” only up to 7–8 neighboring points are checked by Y.


2)Recurrence Analysis
2.1)MergeSort
•	Recurrence: T(n) = 2T(n/2) + Θ(n)
•	Explanation: each level does Θ(n) work for merging, and there are log n levels of recursion.
•	Result: Θ(n log n)

2.2)QuickSort
•	Recurrence (average): T(n) = T(n/2) + T(n/2) + Θ(n) → Θ(n log n)
•	Worst case: pivot splits as (n-1, 0) → T(n) = T(n-1) + Θ(n) = Θ(n^2)
•	Randomization + smaller-half recursion keep depth at O(log n) and make the average case dominant.

2.3)Deterministic Select (MoM5)
•	Recurrence: T(n) = T(n/5) + T(7n/10) + Θ(n)
•	Intuition: at least 30% of elements are discarded each step thanks to a “good” pivot.
•	Solved by Akra–Bazzi: Θ(n)

2.4)Closest Pair of Points
•	Recurrence: T(n) = 2T(n/2) + Θ(n)
•	Explanation: sorting + recursive division, then a linear scan of the strip.
•	Result: Θ(n log n)


3)Results and Discussion

3.1)Time vs n: MergeSort and QuickSort follow the theoretical n log n growth. QuickSort is a bit faster on average but more variable due to random pivot.

3.2)Depth vs n: Both MergeSort and QuickSort keep recursion depth around log n, confirming theoretical bounds.

3.3)Constant factors: insertion cutoff speeds up small arrays; cache effects make QuickSort faster for arrays up to 100k; JVM garbage collector sometimes causes noise in timings.

3.4)Overall: Experiments align with theory. MergeSort and QuickSort → Θ(n log n), Select → Θ(n), Closest Pair → Θ(n log n). The differences come mainly from constant factors, not from asymptotics.

4)CSV Results

Benchmark results are written into bench-results.csv in the following format:

algorithm,n,timeMs,depth,comparisons,moves
mergesort,1000,5,10,998,1200
mergesort,10000,65,14,12250,13500
quicksort,1000,4,9,987,1180
quicksort,10000,52,13,12110,13020
select,1000,2,7,900,910
closest,1000,10,11,2500,—

This CSV file makes it easy to visualize performance (time vs n, depth vs n) and confirm theoretical predictions with experiments.
