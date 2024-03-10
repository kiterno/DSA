package cses.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FerrisWheel {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int x = Integer.parseInt(input1[1]);

        int[] arr = new int[n];
        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }

        Arrays.sort(arr);

        int i = 0, j = n-1;
        int count = 0;
        while (i<j) {
            if (arr[i]+arr[j] <= x) {
                i++;
                count++;
            } else if (arr[j] <= x) {
                count++;
            }
            j--;
        }

        if(i==j)
            count++;

        System.out.println(count);
    }
}
