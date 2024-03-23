package mac;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubarraysKDifferentIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int i=0, j=0;
        int count = 0;

        while (i<nums.length && j<=i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            while (map.size() > k) {
                if(map.get(nums[j]) > 1) {
                    map.put(nums[j], map.get(nums[j])-1);
                } else {
                    map.remove(nums[j]);
                }
                j++;
            }
            count += i-j+1;
            i++;
        }

        return count;
    }
}
