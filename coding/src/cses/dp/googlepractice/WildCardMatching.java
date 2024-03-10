package cses.dp.googlepractice;

import java.util.HashMap;
import java.util.Map;

public class WildCardMatching {
    public static boolean wildCardMatching(String s, String p) {
        Map<String, Boolean> map = new HashMap<>();
        return matching(s, 0, p, 0, map);
    }

    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length()+1][s.length()+1];
        for(int i = dp.length-1; i >= 0; i--) {
            for(int j = dp[0].length-1; j >= 0; j--) {
                if(i == dp.length-1 && j == dp[0].length-1) {
                    dp[i][j] = true;
                } else if(i == dp.length-1) {
                    dp[i][j] = false;
                } else if(j == dp[0].length-1) {
                    if(p.charAt(i) == '*') {
                        dp[i][j] = dp[i+1][j];
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if(p.charAt(i) == '?') {
                        dp[i][j] = dp[i+1][j+1];
                    } else if(p.charAt(i) == '*') {
                        dp[i][j] = dp[i+1][j] || dp[i][j+1];
                    } else if(p.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i+1][j+1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[0][0];
    }

    public static boolean matching(String s, int i, String p, int j, Map<String, Boolean> map) {
        if(map.containsKey(i+""+j)) return map.get(i+""+j);
        if(i>=s.length() && j>=p.length()){
            map.put(i+""+j, true);
            return true;
        }

        if(i>=s.length() && remainingStars(p, j)) {
            map.put(i+""+j, true);
            return true;
        }

        if(j>=p.length()) {
            map.put(i+""+j, false);
            return false;
        }
        if(i>=s.length()){
            map.put(i+""+j, false);
            return false;
        }

        boolean match = i<s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?');

        if(p.charAt(j) == '*') {
            map.put(i+""+j, matching(s, i, p, j+1, map) || matching(s, i+1, p, j, map) || matching(s, i+1, p, j+1, map));
            return map.get(i+""+j);
        }

        map.put(i+""+j, match && matching(s, i+1, p, j+1, map));
        return map.get(i+""+j);
    }

    private static boolean remainingStars(String p, int j) {
        while(j<p.length()) {
            if(p.charAt(j++) != '*') return false;
        }
        return true;
    }

    public static void main(String[] argos){
        String s = "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaabab";
        String p = "a*******b";
        long startTime = System.nanoTime();
        System.out.println(wildCardMatching(s, p));
        long endTime = System.nanoTime();
        System.out.println(endTime-startTime);

        System.out.println(isMatch(s, p));
    }
}
