package google.com.stack;

import java.util.Stack;

public class HistogramArea {

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = matrix[i][j]-'0';
            }
        }

        int ans = 0;

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 1)
                    dp[i][j] = dp[i][j]+dp[i-1][j];
            }

            ans = Math.max(ans, largestRectangleArea(dp[i]));
        }
        ans = Math.max(ans, largestRectangleArea(dp[0]));

        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        int ans = 0;
        stack.push(-1);

        while (i<heights.length) {
            if (stack.size()==1 || heights[i]>heights[stack.peek()]) {
                stack.push(i);
            } else {
                while (stack.size() > 1 && heights[i]<=heights[stack.peek()]) {
                    int pop = stack.pop();
                    ans = Math.max ((i-stack.peek()-1)*heights[pop], ans);
                }
                stack.push(i);
            }
            i++;
        }

        while (stack.size() > 1) {
            int pop = stack.pop();
            ans = Math.max ((i-stack.peek()-1)*heights[pop], ans);
        }

        return ans;
    }
}
