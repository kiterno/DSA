package cses.stack;

import java.util.Stack;

public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        int count = 0;

        for (int i=0;i<arr.length;i++) {
            while (!stack.isEmpty() && stack.peek() > arr[i]) {
                stack.pop();
                count++;
            }

            stack.push(arr[i]);
        }

        return arr.length - count;
    }
}
