package assignment1;

import java.util.Arrays;

import java.util.Arrays;

public class Select {

    public static int deterministicSelect(int[] arr, int k, Metrics m) {
        if (arr.length == 1) return arr[0];

        int n = arr.length;
        int numGroups = (n + 4) / 5;
        int[] medians = new int[numGroups];

        for (int i = 0; i < numGroups; i++) {
            int left = i * 5;
            int right = Math.min(left + 5, n);
            int[] group = Arrays.copyOfRange(arr, left, right);
            Arrays.sort(group);
            medians[i] = group[group.length / 2];
        }


        int pivot = (medians.length == 1)
                ? medians[0]
                : deterministicSelect(medians, medians.length / 2, m);//ап

        int[] left = Arrays.stream(arr).filter(x -> x < pivot).toArray();
        int[] equal = Arrays.stream(arr).filter(x -> x == pivot).toArray();
        int[] right = Arrays.stream(arr).filter(x -> x > pivot).toArray();

        if (k < left.length) return deterministicSelect(left, k, m);
        else if (k < left.length + equal.length) return pivot;
        else return deterministicSelect(right, k - left.length - equal.length, m);
    }
}