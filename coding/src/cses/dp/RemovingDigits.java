package cses.dp;

import java.util.Scanner;

public class RemovingDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int count = 0;
        while (n!=0) {
            int max = getMaxDigit(n);
            n = n-max;
            count++;
        }

        System.out.println(count);
    }

    private static int getMaxDigit(int n) {
        int max = 0;

        while (n!=0) {
            max = Math.max(n%10, max);
            n = n/10;
        }

        return max;
    }
}
