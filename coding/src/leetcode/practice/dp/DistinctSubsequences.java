package leetcode.practice.dp;

import java.util.HashMap;
import java.util.Map;

public class DistinctSubsequences {
    int count = 0;

    public int numDistinct(String s, String t) {
        count = 0;
        Map<String, Integer> map = new HashMap<>();
        numDistinct(s, 0, t, 0, "", map);

        return count;
    }

    private void numDistinct(String s1, int i, String s2, int j, String s, Map<String, Integer> map) {
        if (map.containsKey(j+""+i)) {
            if(map.get(j+""+i) >= 1) count++;
            return;
        }
        if(j>=s2.length() && s.equals(s2)) {
            map.put(j+""+i, count+1);
            count++;
            return;
        }

        if(i>=s1.length()) {
            map.put(j+""+i, 0);
            return;
        }
        if(s.length()>s2.length()) {
            map.put(j+""+i, 0);
            return;
        }

        if(s1.charAt(i) == s2.charAt(j)) {
            numDistinct(s1, i+1, s2, j+1, s+s1.charAt(i), map);

        }
        numDistinct(s1, i+1, s2, j, s, map);
    }


    public static void main(String[] args) {
        DistinctSubsequences d = new DistinctSubsequences();

        String s= "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc";
        String t = "bcddceeeebecbc";
        System.out.println(d.numDistinct("rabbbit", "rabbit"));
        System.out.println(d.numDistinct("babgbag", "bag"));
        System.out.println(d.numDistinct(s, t));
    }
}
