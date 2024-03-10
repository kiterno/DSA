package leetcode.practice.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemp {
    public int[] dailyTemperature(int[] temp) {
        Stack<Integer> stack = new Stack<>();
        int n = temp.length;

        int[] result = new int[n];
        for(int i=n-1;i>=0;i--) {
            while(!stack.isEmpty() && temp[i]>=temp[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()) result[i] = 0;
            else result[i] = stack.peek()-i;
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] temp = {73,74,75,71,69,72,76,73};

        System.out.println(Arrays.toString(new DailyTemp().dailyTemperature(temp)));
        temp =new int[] {89,62,70,58,47,47,46,76,100,70};
        System.out.println(Arrays.toString(new DailyTemp().dailyTemperature(temp)));
    }
}
