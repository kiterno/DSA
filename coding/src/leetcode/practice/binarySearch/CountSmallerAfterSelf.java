package leetcode.practice.binarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountSmallerAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        List<Integer> result= new ArrayList<>();

        for(int i=0;i<nums.length;i++) {
            arr.add(nums[i]);
        }

        Collections.sort(arr);

        for(int i: arr) {
            int x = binarySearch(i, arr);
            result.add(x);
            arr.remove(x);
        }
        return result;
    }

    private int binarySearch(int i, List<Integer> arr) {
        int low = 0, high = arr.size()-1;

        while(low<=high) {
            int mid = low + (high-low)/2;

            if(arr.get(mid) == i) {
                return mid;
            } else if(arr.get(mid) > i) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return -1;
    }

}
