package leetcode.practice.dp;

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        for(int i=1;i<matrix.length;i++) {
            for(int j=0;j<matrix[i].length;j++) {
                if(j == 0 && matrix[i].length>1) {
                    matrix[i][j] = Math.min(matrix[i-1][j], matrix[i-1][j+1]) + matrix[i][j];
                }
                else if(j == matrix[i].length-1 && matrix[i].length>1) {
                    matrix[i][j] = Math.min(matrix[i-1][j], matrix[i-1][j-1]) + matrix[i][j];
                } else {
                    matrix[i][j] = Math.min(Math.min(matrix[i-1][j], matrix[i-1][j-1]), matrix[i-1][j+1])+ matrix[i][j];

                }
            }
        }

        int min = Integer.MAX_VALUE;
        int n = matrix[0].length;
        for(int i=0;i<matrix[n-1].length;i++) {
            min = Math.min(min, matrix[matrix.length][i]);
        }

        return min;
    }

}
