package leetcode.practice;

import java.util.HashSet;
import java.util.Set;

public class GoodWaysSplitString {
    static int alphabets = 26;
    public int numSplits(String s) {
        char[] ch = new char[alphabets];

        int n = s.length();

        for (int i = 0; i < n; i++) {
            ch[s.charAt(i)-'a']++;
        }

        int right = 0;
        for (int i = 0; i < alphabets; i++) {
            if (ch[i]!=0) {
                right++;
            }
        }

        int count = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            char sh = s.charAt(i);

            ch[sh-'a']--;
            if (ch[sh-'a'] == 0) {
                    right--;
            }
            set.add(sh);

            if (right == set.size()) {
                count++;
            }
        }

        return count;
    }
}
