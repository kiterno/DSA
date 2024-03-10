package google.com.array;

import java.util.*;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;

        Sort[] sorts = new Sort[n];
        for (int i = 0; i < n; i++) {
            sorts[i] = new Sort();
            sorts[i].number = arr[i];
            sorts[i].diff = Math.abs(x-arr[i]);
        }
        Arrays.sort(sorts);
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            res.add(sorts[i].number);
        }
        Collections.sort(res);
        return res;
    }

    class Sort implements Comparable<Sort> {
        int number, diff;

        @Override
        public int compareTo(Sort temp) {
            return this.diff - temp.diff;
        }
    }
}
