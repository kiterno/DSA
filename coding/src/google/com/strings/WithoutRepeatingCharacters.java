package google.com.strings;

import java.util.HashSet;
import java.util.Set;

public class WithoutRepeatingCharacters {
    public static void main(String[] args) {
        int length = new WithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew");

        System.out.println(length);
    }

    public int lengthOfLongestSubstring(String s) {
        int l = s.length();

        Set<Character> set = new HashSet<>();
        int result = 0;
        int pos = 0;

        for(int i=0;i<l;i++) {
            char ch = s.charAt(i);

            if (set.contains(ch)) {
                result = Math.max(set.size(), result);
                while (!set.isEmpty() && set.contains(ch)) {
                    set.remove(s.charAt(pos++));
                }
            }
            set.add(ch);
        }
        result = Math.max(set.size(), result);

        return result;
    }
}
