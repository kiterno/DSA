package cses.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i=0;i<2;i++) {
            int j = n-1;

            while (j >= 0) {
                while (!stack.isEmpty() && stack.peek() <= nums[j]) {
                    stack.pop();
                }

                result[j] = !stack.isEmpty() ? stack.peek() : -1;

                stack.add(nums[j]);
                j--;
            }
//            System.out.println(Arrays.toString(result));
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};

        System.out.println(Arrays.toString(nextGreaterElements(nums)));

        nums = new int[]{1,2,3,4,3};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
}
