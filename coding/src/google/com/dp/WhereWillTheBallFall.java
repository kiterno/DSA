package google.com.dp;

public class WhereWillTheBallFall {
    public int[] findBall(int[][] grid) {
        int[] res = new int[grid[0].length];
        int k=0;

        int n = grid[0].length, m = grid.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = i;
        }

        // x = 0

        /*
          0, 1, 2,  3,  4
        [[1, 1, 1, -1, -1]
        ,[1, 1, 1, -1, -1]
        ,[-1, -1, -1, 1, 1]
        ,[1, 1, 1, 1, -1],
        [-1, -1, -1, -1, -1]]
        x = 1;
        j = 3
         */

        for (int i = 0; i < n; i++) {
            int x = i;
            boolean pass = true;

            for (int j = 0; j<m;j++) {
                if (grid[j][x] == 1 && x+1<n && grid[j][x+1] == 1) {
                    x = x+1;
                } else if (grid[j][x] == -1 && x-1>=0 && grid[j][x-1] == -1) {
                    x = x-1;
                } else {
                    pass = false;
                }
            }

            if (pass) {
                res[k++] = x;
            } else {
                res[k++] = -1;
            }
        }


        return res;
    }
}
