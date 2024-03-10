package google.com.leetcode.dp;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {

        int dp[] = new int[amount+1];
        Arrays.sort(coins);
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i=1;i<=amount;i++){

            for(int coin: coins){
                if(coin <= i){
                    dp[i] = Math.min(dp[i-coin] + 1, dp[i]);
                }
                else
                    break;
            }

        }
//        display(dp);
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }

    public static void display(int coins[]){
        for(int coin: coins)
            System.out.print(coin+"\t");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] coins =new int[]{2, 5};

        int amount = 7;
        CoinChange coinChange=new CoinChange();

        System.out.println(coinChange.coinChange(coins, amount));
    }
}
