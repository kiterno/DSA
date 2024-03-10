package cses.dp.googlepractice;

import java.util.ArrayList;
import java.util.List;

public class Parentheses {
        List<String> result = new ArrayList<>();
        public List<String> generateParentheses(int n) {
            generate("", n, n);
            return result;
        }

        private void generate(String s, int open, int close) {
            if(open == close && open == 0) {
                result.add(s);
                return;
            }

            if(open>0) {
                generate(s+"(", open-1, close);
            }

            if(close>0 && close>open) {
                generate(s+")", open, close-1);
            }
        }

    public static void main(String[] args) {
        System.out.println(new Parentheses().generateParentheses(3));
    }
}
