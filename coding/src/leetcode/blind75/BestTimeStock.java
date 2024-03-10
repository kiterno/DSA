package leetcode.blind75;

import java.util.Map;

public class BestTimeStock {
    public int maxProfit(int[] prices) {
        int sum = 0, max = 0;

        for (int i = 1; i < prices.length; i++) {
            sum+=prices[i]-prices[i-1];

            if (sum<0) sum = 0;
            max = Math.max(sum, max);
        }

        return max;
    }
}
