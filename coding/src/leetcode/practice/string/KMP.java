package leetcode.practice.string;

import java.util.Arrays;

public class KMP {
    public static void main(String[] args) {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";

        KMPSearch(pat, txt);
    }

    private static void KMPSearch(String pat, String txt) {
        int n = pat.length();
        int m = txt.length();

        int[] lps = new int[n];
        int j=0;

        computeLpsArray(pat, n, lps);

        printLps(lps);

        int i=0;

        while (i<m) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            if (j == n) {
                System.out.println("Found Pattern at " + (i-j));
                j = lps[j-1];
            }
            else if (i<m && pat.charAt(j) != txt.charAt(i)) {
                if(j!=0) j = lps[j-1];
                else i++;
            }
        }
    }

    private static void printLps(int[] lps) {
        System.out.println(Arrays.toString(lps));
    }

    private static void computeLpsArray(String pat, int n, int[] lps) {
        int i=1;
        int len = 0;

        while (i<n) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i++] = len;
            }

            else {
                if (len != 0) len = lps[len-1];

                else {
                    lps[i++] = len;
                }
            }
        }
    }
}
