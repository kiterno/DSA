package leetcode.graph;

import java.util.Arrays;

public class LongestIncreasingPathMatrix {
     int[] dir = {0, 1, 0, -1, 0};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i=0; i< m; i++){
            Arrays.fill(dp[i], -1);
        }
        int ans = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                ans = Math.max(ans, findMaxPath(matrix, dp, i, j, -1));
            }
        }
        return ans;
    }

    private int findMaxPath(int[][] matrix, int[][] dp, int row, int col, int parentVal){
        if(!isValid(matrix, row, col)) return 0;
        if(parentVal >= matrix[row][col]) return 0;
        if(dp[row][col] == -1){
            int max = -1;
            for(int i=0; i<4; i++){
                int x = row + dir[i];
                int y = col + dir[i+1];
                max = Math.max(max, findMaxPath(matrix, dp, x, y, matrix[row][col]));
            }
            dp[row][col] = 1 + max;
        }
        return dp[row][col];
    }

    private boolean isValid(int[][] matrix, int row, int col){
        if(row < 0 || row>=matrix.length) return false;
        if(col < 0 || col >= matrix[0].length) return false;
        //if(matrix[row][col] < val) return false;
        return true;
    }
}
