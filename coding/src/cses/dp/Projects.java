package cses.dp;

import java.util.*;

public class Projects {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] a = new int[n][3];

        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
            a[i][2] = sc.nextInt();
        }

        Arrays.sort(a, Comparator.comparingInt(x -> x[1]));

        System.out.println(solve(a));
    }

    private static long solve(int[][] a) {
        int n = a.length;

        long[] dp = new long[n+1];
        dp[0] = 0;

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(a[i][1]);
        }

        for (int i = 0; i < n; i++) {
            long opt1 = dp[i];
            long opt2 = a[i][2];

            int j = findBest(set, a[i][0]);
            opt2 = opt2 + dp[j+1];

            dp[i+1] = Math.max(opt1, opt2);
        }

        return dp[n];
    }

    private static int findBest(TreeSet<Integer> set, int val) {
        Integer i = set.lower(val);

        if (i == null) {
            return 0;
        } else {
            return i-1;
        }
    }
}
