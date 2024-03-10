package google.com.array;

import java.util.Arrays;
import java.util.HashMap;

public class SurpasserCount {

    public static void main(String[] args) {
        int a[] = {2, 7, 5, 3, 0, 8, 1};
        int copy[] = new int[a.length];
        for(int i=0;i<a.length;i++){
            copy[i] = a[i];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        mergeSort(a, 0, a.length-1, map);
        System.out.println(map);
        for (int i=0;i<a.length;i++){
            System.out.println((a.length - 1) - i - map.getOrDefault(copy[i], 0));
        }
    }

    private static void mergeSort(int[] arr, int left, int right, HashMap<Integer, Integer> map) {

        if(left<right){
            int mid = left + (right-left) / 2;
            mergeSort(arr, left, mid, map);
            mergeSort(arr, mid+1, right, map);
            merge(arr, left, mid, right, map);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, HashMap<Integer, Integer> map) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid+1);
        int[] rightArr = Arrays.copyOfRange(arr, mid+1, right+1);

        int c = 0;

        int  i=0,j=0,k=left;

        while (i<leftArr.length & j<rightArr.length){
             if(leftArr[i] <= rightArr[j]){
                 map.put(leftArr[i], map.getOrDefault(leftArr[i], 0)+c);
                 arr[k++] = leftArr[i++];
             }
             else{
                 arr[k++] = rightArr[j++];
                 c++;
             }
        }
        while (i<leftArr.length){
            map.put(leftArr[i], map.getOrDefault(leftArr[i], 0)+c);
            arr[k++] = leftArr[i++];
        }

        while (j<rightArr.length)
            arr[k++] = rightArr[j++];
    }
}
