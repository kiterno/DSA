package cses.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RestaurantCustomers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arrival = new int[n];
        int[] departure = new int[n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            arrival[i] = Integer.parseInt(input[0]);
            departure[i] = Integer.parseInt(input[1]);
        }

        Arrays.sort(arrival);
        Arrays.sort(departure);

        int i = 0, j = 0;
        int count = 0, max = 0;

        while (i<n && j<n) {
            if (arrival[i]<=departure[j]) {
                i++;count++;
            } else {
                j++;
                count--;
            }

            if (max<count) max = count;
        }

        System.out.println(max);
    }
}
