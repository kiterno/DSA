//package cses.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class MovieFestival {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

//        displayArray(arr);

        int count = 1;
        int left = 1, right = 0;

        while (left<n && right<n) {
            if (arr[left][0] >= arr[right][1]) {
                count++;
                right = left;
            }
            left++;
        }

        System.out.println(count);
    }

    private static void displayArray(int[][] arr) {
        for (int[] i: arr) {
            System.out.println(i[0]+" "+i[1]);
        }
    }
}
