package google.com.array;

public class BestTimeToBuySellStock2 {
    public int maxProfit(int[] prices) {

        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            sum += Math.max(0, prices[i]-prices[i-1]);
        }
        return sum;
    }
}
