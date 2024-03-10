package leetcode.practice.sorting;

import java.util.HashMap;
import java.util.Map;

public class Duplicate3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0;i<nums.length;i++) {
            if(count < indexDiff) {
                if(map.containsKey(nums[i]+valueDiff) || map.containsKey(nums[i]-valueDiff)) return true;

                else {
                    int x = map.getOrDefault(nums[i], 0);
                    map.put(nums[i], x+1);
                }
            }

            if(i>=indexDiff) {
                if(map.get(nums[i-indexDiff]) == 1) {
                    map.remove(nums[i-indexDiff]);
                } else {
                    map.put(nums[i-indexDiff], map.get(nums[i-indexDiff])-1);
                }
            }
        }
        return false;
    }
}
