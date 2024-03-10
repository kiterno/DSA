package google.com.binary.search;

import static google.com.leetcode.dp.CoinChange.display;

public class MajorityElementsToTheRight {
    static int majorityElement(int a[], int size)
    {
        mergeSort(a, 0, size-1);
        display(a);
        return -1;
    }


    static void mergeSort(int a[], int low, int high) {

        if(low<high) {
            int mid = (low+high)/2;
            mergeSort(a, low, mid);
            mergeSort(a, mid+1, high);
            merge(a, low, mid, high);
        }
    }

    private static void merge(int[] a, int low, int mid, int high) {
        int leftSize = mid - low + 1;
        int rightSize = high - mid;
        int[] left = new int[leftSize];
        for (int i = 0; i < leftSize; i++) {
            left[i] = a[low+i];
        }
        int[] right = new int[rightSize];
        for (int i = 0; i < rightSize; i++) {
            right[i] = a[mid+1+i];
        }
        int i = 0, j = 0, k = low;

        while (i<leftSize && j<rightSize) {
            if(left[i] < right[j]) {
                a[k++] = left[i++];
            } else {
                a[k++] = right[j++];
            }
        }

        while (i<leftSize) {
            a[k++] = left[i++];
        }

        while (j<rightSize) {
            a[k++] = right[j++];
        }
    }

    private static int[] copyArray(int[] a, int low, int high) {
        int[] copy = new int[high-low+1];
        int k = low;
        while (low<=high) {
            copy[low-k] = a[low++];
        }

        return copy;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] a = {12, 1, 2, 3, 0, 11, 4};
        majorityElement(a, a.length);
    }
}
