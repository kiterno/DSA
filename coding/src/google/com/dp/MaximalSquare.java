package google.com.dp;

import java.util.Stack;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {

        int n = matrix.length, m = matrix[0].length;
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = matrix[i][j]-'0';
            }
        }
        int max_area = getFromHistogram(arr[0]);
        for (int i=1; i<n; i++) {
            for (int j=0;j<m;j++) {
                if (arr[i][j] == 1) {
                    arr[i][j] = arr[i][j] + arr[i-1][j];
                }
            }

            max_area = Math.max(max_area, getFromHistogram(arr[i]));
        }

        return max_area;
    }

    private int getFromHistogram(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        stack.push(-1);

        int max = 0;
        int i = 0;
        while (i<arr.length){
            if (stack.size() == 1) {
                stack.push(i);
            }
            else {
                while (stack.size() > 1 && arr[stack.peek()] >= arr[i]) {
                    int side = Math.min(arr[stack.pop()], i-stack.peek());
                    max = Math.max(max, side*side);
                }

                stack.push(i);
            }
            i++;
        }

        while (stack.size() > 1) {
            int length = stack.pop();
            int side = Math.min(arr[length], i-stack.peek());
            max = Math.max(max, side*side);
        }

        return max;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};

        System.out.println(new MaximalSquare().maximalSquare(matrix));

        matrix = new char[][]{{'0','1'},{'1','0'}};
        System.out.println(new MaximalSquare().maximalSquare(matrix));
    }
}
