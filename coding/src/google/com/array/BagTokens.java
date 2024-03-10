package google.com.array;

import java.util.Arrays;

public class BagTokens {
    public int bagOfTokensScore(int[] tokens, int power) {

        int count = 0, max = 0;


        Arrays.sort(tokens);
        int i=0, j=tokens.length-1;

        while (i<=j) {
            if (tokens[i] == power) {
                max = Math.max(max, count+1);
            }

            if (tokens[i] < power) {
                power = power - tokens[i];
                i++;
                count++;
                max = Math.max(max, count);
            }
            else if (count > 0){
                count--;
                power = power + tokens[j--];
            }

        }

        return max;
    }
}
