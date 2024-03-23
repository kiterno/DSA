package mac;

import java.util.Arrays;

public class LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int[] inc = new int[n];
        int[] dec = new int[n];

        inc[0] = 1;
        dec[0] = 1;
        Arrays.fill(inc, 1);
        Arrays.fill(dec, 1);
        int max = 1;

        for(int i = 1; i < arr.length; i++) {

            if(arr[i] < arr[i - 1]) {
                dec[i] = inc[i - 1] + 1;
            } else if(arr[i] > arr[i - 1]) {
                inc[i] = dec[i - 1] + 1;
            }

            max = Math.max(max, Math.max(inc[i], dec[i]));

        }

        return max;
    }
}
