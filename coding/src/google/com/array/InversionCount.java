package google.com.array;

import java.util.Arrays;

public class InversionCount {
    public static void main(String[] args) {
        int a[] = {7, 4, 3, 6, 2};

        System.out.println(inversions(a));
    }

    private static int inversions(int[] a) {
        int n= a.length;
        return mergeSort(a, 0, n-1);
    }

    private static int mergeSort(int[] a, int l, int r) {
        int count = 0;

        if(l<r){
            int mid = (l+r) / 2;

            count += mergeSort(a, l, mid);
            count += mergeSort(a, mid+1, r);

            count += merge(a, l, mid, r);
        }

        return count;
    }

    private static int merge(int[] a, int l, int mid, int r) {
        int[] left = Arrays.copyOfRange(a, l, mid+1);
        int[] right = Arrays.copyOfRange(a, mid+1, r+1);

        int i=0, j=0, k=l, swaps=0;

        while (i<left.length && j<right.length){
            if(left[i]<=right[j])
                a[k++] = left[i++];
            else{
                a[k++] = right[j++];
                swaps += (mid+1) - (l+i);
            }
        }
        while (i<left.length)
            a[k++] = left[i++];
        while (j<right.length)
            a[k++] = right[j++];

        return swaps;
    }
}
