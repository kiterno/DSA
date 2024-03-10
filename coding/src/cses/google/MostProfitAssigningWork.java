package cses.google;

import java.util.Arrays;
import java.util.Comparator;

public class MostProfitAssigningWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        int n = difficulty.length;
        Profit[] profits = new Profit[n];
        for (int i = 0; i < n; i++) {
            profits[i] = new Profit(difficulty[i], profit[i]);
        }

        Arrays.sort(profits, Comparator.comparingInt(o -> o.diff));

        int max = profits[0].profit;
        for (int i = 1; i < n; i++) {
            max = Math.max(profits[i].profit, max);
            profits[i].profit = max;
        }

        int sum = 0;
        display(profits);
        for (int i = 0; i < worker.length; i++) {
            int position = binarySearch(profits, worker[i], 0, n-1);
            if (position>=0 && position<n) {
                System.out.print("("+position+" "+profits[position].profit+") ");
                sum += profits[position].profit;
            }
        }
        System.out.println();
        return sum;
    }

    private int binarySearch(Profit[] profits, int val, int low, int high) {

        while (low<=high) {
            int mid = low + (high-low)/2;
            if (profits[mid].diff > val) {
                high = mid - 1;
            } else  {
                low = mid + 1;
            }
        }

        return high;
    }

    private void display(Profit[] profits) {
        for (Profit profit: profits) {
            System.out.println(profit.diff + " " + profit.profit);
        }
    }

    static class Profit {
        int diff, profit;

        public Profit(int diff, int profit) {
            this.diff = diff;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        int[] difficulty = {2,4,6,8,10};
//        int[] difficulty = {23,30,35,35,43,46,47,81,83,98};
        int[] profit = {10,20,30,40,50};
//        int[] profit = {8,11,11,20,33,37,60,72,87,95};
        int[] worker = {4,5,6,7};
//        int[] worker = {95,46,47,97,11,35,99,56,41,92};

        MostProfitAssigningWork pro = new MostProfitAssigningWork();
        System.out.println(pro.maxProfitAssignment(difficulty, profit, worker));
    }
}
