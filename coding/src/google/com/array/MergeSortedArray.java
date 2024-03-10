package google.com.array;

import java.util.Arrays;

class MergeSortedArray {
    /*

    nums1 = [4,5,6,0,0,0]
    nums2 = [1,2,3]

    */

    public static void main(String[] args) {
        Sort[] arr=new Sort[5];
        for (int i=0;i<5;i++){
            arr[i] = new Sort();
        }
        arr[0].number = 1;
        arr[0].freq = 4;
        arr[1].number = 4;
        arr[1].freq = 1;
        arr[2].number = 3;
        arr[2].freq = 2;
        arr[3].number = 7;
        arr[3].freq = 5;
        arr[4].number = 0;
        arr[4].freq = 9;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;n--;
        int size = nums1.length - 1;

        while (m>=0 && n>=0){
            if(nums1[m] < nums2[n])
                nums1[size--] = nums2[n--];
            else
                nums1[size--] = nums1[m--];
        }
        while (m>=0) {
            nums1[size--] = nums1[m--];
        }
        while (n>=0) {
            nums1[size--] = nums2[n--];
        }
    }

    static class Sort implements Comparable<Sort>{
        int number, freq;
        @Override
        public int compareTo(Sort temp) {
            return temp.freq - this.freq;
        }

        @Override
        public String toString() {
            return "Sort{" +
                    "number=" + number +
                    ", freq=" + freq +
                    '}';
        }
    }
}
