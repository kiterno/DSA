package google.com.strings;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int[] first = new int[26];
        for(char ch: p.toCharArray()) {
            first[ch-'a']++;
        }
        List<Integer> res = new ArrayList<>();
        int[] second = new int[26];
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            second[ch-'a']++;
            while (second[ch-'a'] > first[ch-'a']) {
                second[s.charAt(pos++)-'a']--;
            }
            if(second[ch-'a'] == first[ch-'a'] && check(first, second)) {
                res.add(i-p.length()+1);
            }
        }
        return res;
    }

    private boolean check(int[] first, int[] second) {
        for (int i = 0; i < 26; i++) {
            if(first[i] != second[i])
                return false;
        }
        return true;
    }
}
