package cses.dp.googlepractice;

public class ExpressionMatching {
    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

    private boolean isMatch(String s, int i, String p, int j) {

        if(i>=s.length() && j>=p.length()) return true;

        if(j>=p.length()) {
            return false;
        }

        boolean match = i<s.length() && (s.charAt(i) == p.charAt(j)) || p.charAt(j) == '.';

        if(j+1<p.length() && p.charAt(j+1) == '*') {
            return isMatch(s, i, p, j+2) ||  isMatch(s, i+1, p, j);
        }

        return match && isMatch(s, i+1, p, j+1);

    }

    public static void main(String[] args) {
        String s = "aa", p = "a*";

        ExpressionMatching m = new ExpressionMatching();
        System.out.println(m.isMatch(s, p));
    }
}
