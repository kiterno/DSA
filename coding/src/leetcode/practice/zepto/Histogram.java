package leetcode.practice.zepto;

import java.util.Stack;

public class Histogram {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};

        int max_area = getHistogramArea(heights);

        System.out.println(max_area);
    }

    private static int getHistogramArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();

        int i=0;
        stack.push(-1);

        int max_area = 0;
        while (i<heights.length) {
            if(stack.size() == 1 || heights[i] > heights[stack.peek()]) {
                stack.push(i);
            }
            else {
                while (stack.size() > 1 && heights[i] < heights[stack.peek()]) {
                    int pop = stack.pop();

                    int area = heights[pop] * (i - stack.peek() -1);
                    max_area = Math.max(area, max_area);
                }
                stack.push(i);
            }
            i++;
        }

        while (stack.size() > 1) {
            int pop = stack.pop();

            int area = heights[pop] * (i - stack.peek() -1);
            max_area = Math.max(area, max_area);
        }

        return max_area;
    }
}
