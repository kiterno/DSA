package cses.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// TODO
public class ConcertTickets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);

        int[] arr = new int[n];
        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }

        Arrays.sort(arr);

        int index = 0;
        String[] input3 = br.readLine().split(" ");

        for (int i = 0; i < m; i++) {
            int t = Integer.parseInt(input3[i]);
            int near = index<n ? arr[index] : -1;
            while (index<n && t>=arr[index]) {
                if (t == arr[index]) {
                    near = arr[index];
                    index++;
                    break;
                }
                near = arr[index];
                index++;
            }

            System.out.println(near);
        }
    }
}
