package leetcode.practice.binarySearch;

import java.util.Arrays;

public class QuickSort {
    int partition(int[] a, int start, int end) {
        int pivot = a[end];

        int i = start-1;

        for (int j=start;j<=end-1;j++) {
            if (a[j]<pivot) {
                i++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }

        int t = a[i+1];
        a[i+1] = a[end];
        a[end] = t;

        return i+1;
    }

    void quick(int[] a, int start, int end) {
        if (start<end) {
            int p = partition(a, start, end);
            quick(a, start, p-1);
            quick(a, p+1, end);
        }
    }


    public static void main(String[] args) {
        int[] a = {2, 5, 1, 6, 0, 9};

        QuickSort quickSort = new QuickSort();
        quickSort.quick(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
