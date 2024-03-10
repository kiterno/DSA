package google.com.leetcode.array;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> res = new HashSet<>();

        for(int i=0;i<nums.length-2;i++){
            int low = i+1;
            int high = nums.length-1;

            while(low<high){
                if(nums[i]+nums[low]+nums[high] == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]); temp.add(nums[low]); temp.add(nums[high]);
                    res.add(temp);
                }
                if(nums[i]+nums[low]+nums[high] > 0){
                    high--;
                }
                else{
                    low++;
                }
            }
        }
        //System.out.println();
        return res.stream().toList();
    }
}
