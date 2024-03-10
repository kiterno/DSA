package cses.dp.googlepractice;

import java.util.ArrayList;
import java.util.List;

public class Chocolate {
    static int count = 0;
    static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        int chocolate = 9;
        int[] bite = {1, 2, 3};
        List<Integer> temp = new ArrayList<>();
        recur(bite, chocolate, temp);
        System.out.println(count);
//        System.out.println(result);
        System.out.println(chocolateViaDp(bite, chocolate));
        System.out.println(chocolateViaDp(chocolate));
    }

    public static void recur(int[] bite, int chocolate, List<Integer> temp) {
        if(chocolate == 0) {
            result.add(new ArrayList<>(temp));
            count++;
            return;
        }
        if (chocolate<0) return;

        for(int i=0;i<bite.length;i++) {
            temp.add(bite[i]);
            recur(bite, chocolate - bite[i], temp);
            temp.remove(temp.size()-1);
        }
    }

    public static int chocolateViaDp(int[] bite, int chocolate) {
        int[] dp = new int[chocolate+1];

        dp[0] = 1;

        for (int i=1;i<=chocolate;i++) {
            for(int j=1;j<=bite.length;j++) {
                if(bite[j-1]<=i) {
                    dp[i] += dp[i-bite[j-1]];
                }
            }
        }

        return dp[chocolate];
    }

    public static int chocolateViaDp(int chocolate) {
        int[] dp = new int[chocolate+1];

        dp[0] = dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i=4;i<=chocolate;i++) {
            dp[i] += dp[i-1]+dp[i-2]+dp[i-3];
        }

        return dp[chocolate];
    }
}
