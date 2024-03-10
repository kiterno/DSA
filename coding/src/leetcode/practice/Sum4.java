package leetcode.practice;

import java.util.*;

public class Sum4 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> re = new HashSet<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i+1; j < nums.length-2; j++) {
                    int low = j+1, high = nums.length-1;
                    while (low<high) {
                        int sum = nums[i]+nums[j]+nums[low]+nums[high];

                        if (sum == target) {
                            List<Integer> curr = new ArrayList<>();
                            curr.add(nums[i]);
                            curr.add(nums[j]);
                            curr.add(nums[low++]);
                            curr.add(nums[high--]);
                            re.add(curr);
                        } else if (sum>target) {
                            high--;
                        }
                        else {
                            low++;
                        }
                }
            }
        }

        return new ArrayList<>(re);
    }

    public static void main(String[] args) {
        int[] nums = {-3,-2,-1,0,0,1,2,3};

        System.out.println(new Sum4().fourSum(nums, 0));
    }
}
// [[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]