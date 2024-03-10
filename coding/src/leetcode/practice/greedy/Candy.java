package leetcode.practice.greedy;

public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;

        if (n == 1) {
            return 1;
        }

        int count = 0, sum = 0;
        if (ratings[0] > ratings[1]) {
            sum = 2;
            count = 1;
        } else {
            sum = 1;
            count = 2;
        }

        for (int i = 1; i < n; i++) {
            if (ratings[i]>ratings[i-1]) {
                count++;
                sum+=count;
            } else {
                count = 1;
                sum+=count;
            }
        }
        return sum;
    }
}
