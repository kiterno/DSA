package google.com.twopointer;

import java.util.Scanner;

import static google.com.leetcode.dp.CoinChange.display;

public class WindowAnotherString {
    public static String smallestWindow(String s, String p)
    {
        // Your code here
        int max_char = 26;
        int[] pattern = new int[max_char];
        int[] str = new int[max_char];

        for (int i = 0; i < p.length(); i++) {
            pattern[p.charAt(i)-'a']++;
        }

        boolean contains = false;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        String result = s;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            str[ch-'a']++;
            sb.append(ch);

            if(str[ch-'a'] == pattern[ch-'a']) {
                if(patternFound(str, pattern)) {
                    contains = true;

                    while (index<s.length() && patternFound(str, pattern)) {
                        if(result.length() > sb.length())
                            result = sb.toString();
                        str[s.charAt(index++)-'a']--;
                        sb.deleteCharAt(0);
                    }
                }
            }
        }

        if(contains) {
            return result;
        }
        return "-1";
    }

    private static boolean patternFound(int[] str, int[] pattern) {
        for (int i=0;i<26;i++) {
            if(str[i] < pattern[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String S = "timetopractice";
        String P = "toc";

        Scanner scanner = new Scanner(System.in);

        String s = scanner.next();
        String p = scanner.next();

        String result = WindowAnotherString.smallestWindow(s, p);
        System.out.println(result);
    }
}
