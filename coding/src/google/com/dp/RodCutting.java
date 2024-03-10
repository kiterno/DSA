package google.com.dp;

public class RodCutting {
    public static int cutRod(int price[], int n) {
        //code here

        int[] dp = new int[n+1];
        int index = 1;

        for (int price_ : price) {
            for (int i = index; i <= n; i++) {
                dp[i] = Math.max(dp[i], price_ + dp[i - index]);
            }
            index++;
//            printDp(dp);
        }

        int max = 0;
        for (int m: dp)
            max = Math.max(m, max);

        return max;
    }

    private static void printDp(int[] dp) {
        for(int i:dp)
            System.out.printf(i+"\t");
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 8;
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};

        System.out.println(RodCutting.cutRod(price, n));
    }
}
