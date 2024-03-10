package leetcode.practice.dp;

import java.util.HashMap;
import java.util.Map;

public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        Map<String, Boolean> map = new HashMap<>();
        return isMatch(s, p, 0, 0, map);
    }

    private boolean isMatch(String s, String p, int i, int j, Map<String, Boolean> map) {
        String key = i + "" + j;

        if (map.containsKey(key)) return map.get(key);
        if (i>=s.length() && j>=p.length()) {
            map.put(key, true);
            return true;
        }

        if (i>=s.length() && allStars(p, j)) {
            map.put(key, true);
            return true;
        }

        if (i>=s.length()) {
            map.put(key, true);
            return false;
        }
        if (j>=p.length()) {
            map.put(key, true);
            return false;
        }

        boolean isMatch = s.charAt(i) == p.charAt(j) || p.charAt(j) == '?';

        if (p.charAt(j) == '*') {
            map.put(key, isMatch(s, p, i+1, j, map) || isMatch(s, p, i, j+1, map));
            return map.get(key);
        }

        map.put(key, isMatch && isMatch(s, p, i+1, j+1, map));
        return map.get(key);
    }

    private boolean allStars(String p, int j) {
        while (j<p.length()) {
            if (p.charAt(j) != '*') return false;
            j++;
        }

        return true;
    }
}
