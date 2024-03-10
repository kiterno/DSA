package cses.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StickLengths {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int lo = arr[0], hi = arr[0];

        for (int i = 0; i < n; i++) {
            lo = Math.min(lo, arr[i]);
            hi = Math.max(hi, arr[i]);
        }

        int ans = lo;

        while (lo<=hi) {
            int mid = lo + (hi-lo)/2;
            long diff = difference(arr, mid);
            long hidiff = difference(arr, mid+1);
            long lodiff = difference(arr, mid-1);

            if (diff<=hidiff && diff<= lodiff) {
                ans = mid;
                break;
            }
            if (lodiff<=hidiff) {
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }
        long hidiff = difference(arr, hi);
        long lodiff = difference(arr, lo);
        long diff = difference(arr, ans);

        if (lodiff<=hidiff && lodiff<=diff) {
            ans = lo;
        } else if (hidiff<=lodiff && hidiff<=diff){
            ans = hi;
        }

        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum+=Math.abs(ans-arr[i]);
        }
        System.out.println(sum);
    }

    private static long difference(int[] arr, int mid) {
        long sum = 0;
        for(int i: arr) {
            sum+= Math.abs(mid-i);
        }

        return sum;
    }
}
