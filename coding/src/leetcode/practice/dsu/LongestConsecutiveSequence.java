package leetcode.practice.dsu;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num: nums) set.add(num);

        int max = 0;
        for (int num: nums) {

            if (!set.contains(num-1)) {
                int count = 0, x = num;
                while (set.contains(x)) {
                    count++;
                    x++;
                }
                max = Math.max(count, max);
            }
        }

        return max;
    }
}
