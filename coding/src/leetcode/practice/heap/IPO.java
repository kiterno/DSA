package leetcode.practice.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
    
        int[][] arr = new int[n][2];

        for(int i=0;i<n;i++) {
            arr[i][0] = profits[i];
            arr[i][1] = capital[i];
        }

        Arrays.sort(arr, (a, b) -> a[1]-b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);

        int i = 0;
        while (k>0) {
            while (i<n && w>=arr[i][1]) {
                pq.add(arr[i++][0]);
            }

            if (!pq.isEmpty()) {
                w = w+pq.remove();
            }

            k--;
        }
        return w;
    }
}
