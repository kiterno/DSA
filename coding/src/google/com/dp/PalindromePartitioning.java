package google.com.dp;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        PalindromePartitioning p = new PalindromePartitioning();


        System.out.println(p.partition("aab"));
    }
    public List<List<String>> partition(String s) {

        List<List<String >> result = new ArrayList<>();
        List<String> current = new ArrayList<>();

        partition(result, current, s, 0);
        return result;
    }

    private void partition(List<List<String>> result, List<String> current, String s, int start) {
        if (start >= s.length()) {
//            System.out.println(current);
            result.add(new ArrayList<>(current));
        }

        for (int i=start; i<s.length();i++) {
            if(isPalindrome(s, start, i)) {
                current.add(s.substring(start, i+1));
                partition(result, current, s, i+1);
                current.remove(current.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int i) {
        while (start<i && s.charAt(i) == s.charAt(start)) {
            start++;
            i--;
        }
        return i<=start;
    }
}
