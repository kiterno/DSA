package google.com.binary.search;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0]-b[0]);

        for (int i: nums1) {
            priorityQueue.add(new int[]{i+nums2[0], 0});
        }

        while (k-->0 && !priorityQueue.isEmpty()) {
            int[] pair = priorityQueue.poll();

            List<Integer> list = new ArrayList<>();
            list.add(pair[0]-nums2[pair[1]]);
            list.add(nums2[pair[1]]);

            result.add(list);

            if (pair[1]+1<nums2.length) {
                priorityQueue.add(new int[]{pair[0]-nums2[pair[1]]+nums2[pair[1]+1], pair[1]+1});
            }
        }
        return result;
    }
}
