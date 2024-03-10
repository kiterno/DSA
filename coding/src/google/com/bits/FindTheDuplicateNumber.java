package google.com.bits;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i: nums) {
            if (set.contains(i))
                return i;
            set.add(i);
        }
        return -1;
    }
}
