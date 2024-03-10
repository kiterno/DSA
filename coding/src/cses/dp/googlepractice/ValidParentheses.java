package cses.dp.googlepractice;

public class ValidParentheses {
    public int longestValidParentheses(String s) {
        int max = Integer.MIN_VALUE;

        int open = 0, close = 0;

        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);

            if(ch == '(') {
                open++;
            } else {
                close++;
            }

            if(close>open) {
                close = 0;
                open = 0;
            }

            max = Math.max(max, close);
        }
        return max*2;
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().longestValidParentheses("(()"));
        System.out.println(new ValidParentheses().longestValidParentheses(")()())"));
    }

}
