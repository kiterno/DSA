package google.com.twopointer;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {

        if (s == null || t == null || s.length() ==0 || t.length() == 0 ||
                s.length() < t.length()) {
            return new String();
        }

        int[] tchar = new int[256];
        for (char ch: t.toCharArray()) {
            tchar[ch-'A']++;
        }

        int count = t.length();
        int start = 0, end = 0, startIndex = 0, minlength = Integer.MAX_VALUE;

        while (end<s.length()) {
            if (tchar[s.charAt(end++)-'A']-- > 0) {
                count--;
            }

            while (count == 0) {
                if (end-start < minlength) {
                    startIndex = start;
                    minlength = end-start;
                }

                if (tchar[s.charAt(start++)-'A']++ == 0) {
                    count++;
                }
            }
        }

        return Integer.MAX_VALUE == minlength ? "" : s.substring(startIndex, startIndex+minlength);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";

        System.out.println(new MinimumWindowSubstring().minWindow(s, t));
    }
}
