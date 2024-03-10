package medium;

public class SubsetSumProblem {
    public static void main(String[] args) {
        int[] set = {3, 34, 4, 12, 5, 2};
        int sum = 14;

        System.out.println(checkIfSumExists(set, sum));
        System.out.println(getSumDp(set, sum));
    }

    private static boolean checkIfSumExists(int[] set, int sum) {
        return getSum(set, sum, set.length);
    }

    private static boolean getSum(int[] set, int sum, int index) {
        if (sum == 0) return true;

        if (index == 0) return false;

        if (set[index-1] > sum) return getSum(set, sum, index-1);

        return getSum(set, sum, index-1) || getSum(set, sum-set[index-1], index-1);
    }

    private static boolean getSumDp(int[] set, int sum) {
        int n = set.length;

        boolean[][] dp = new boolean[n+1][sum+1];

        for (int i = 0; i <= n; i++) dp[i][0] = true;
        for (int i=1;i<=sum;i++) dp[0][i] = false;

        for (int i=1;i<=n;i++) {
            for (int j = 1; j <= sum; j++) {
                if (j<set[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-set[i-1]];
                }
            }
        }

        return dp[n][sum];
    }

}
