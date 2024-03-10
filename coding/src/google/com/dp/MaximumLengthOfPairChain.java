package google.com.dp;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthOfPairChain {
    public void findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        int count = 0;
        int max = pairs[0][1];

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > max) {
                count++;
                max = pairs[i][1];
            }
        }

    }

    private void display(int[][] pairs) {
        for (int[] pair: pairs) {
            System.out.println(pair[0] + "\t" + pair[1]);
        }
    }

    public static void main(String[] args) {
        int[][] pairs = {{1,2},{2,3},{3,4}};
        new MaximumLengthOfPairChain().findLongestChain(pairs);
    }
}
