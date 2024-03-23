package mac;

import java.util.HashMap;
import java.util.Map;

public class ScrambleString {
    Map<String, Boolean> cache = new HashMap<>();
    public boolean isScramble(String s1, String s2) {

        int n = s1.length();
        if (n != s2.length()) return false;
        if (s1.isEmpty()) return true;
        if (s1.equals(s2)) return true;
        if (n <= 1) return false;

        boolean flag = false;
        String key = s1+" "+s2;
        if (cache.containsKey(key)) return cache.get(key);

        for (int i = 1; i< n; i++) {
            if ((isScramble(s1.substring(0, i), s2.substring((n -i))) && isScramble(s1.substring(i), s2.substring(0, n -i)))
                || (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))) {
                flag = true;
                break;
            }
        }

        cache.put(key, false);
        return flag;
    }
}
