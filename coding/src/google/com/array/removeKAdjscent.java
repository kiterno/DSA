package google.com.array;

import java.util.Stack;

public class removeKAdjscent {
    public static void main(String[] args) {
        System.out.println(removeK(2, "assassinate"));
        System.out.println(removeK(2, "geeksforgeeks"));
        System.out.println(removeK(3, "qddxxxd"));
        System.out.println(removeK(1, "juopkgctbfqvoyzypfhitjxomnczsdulnlrzzyskscietacwidqvljiyubczzrgzylslyexgvzsuopqdemarvuereqnfxabhisve"));

    }

    static String removeK(int k, String s) {
        if(k<=1)
            return "";
        Stack<Pair> stack = new Stack<>();

        for (int i = 0;i<s.length();i++) {
            char ch = s.charAt(i);

            if(stack.isEmpty()) {
                stack.push(new Pair(1, ch));
            }
            else {
                Pair pair = stack.peek();
                if(pair.ch == ch) {
                    if(pair.index+1 == k) {
                        int x = pair.index;
                        while (x-->0) {
                            stack.pop();
                        }
                    } else {
                        stack.push(new Pair(pair.index+1, ch));
                    }
                } else {
                    stack.push(new Pair(1, ch));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Pair p: stack) {
            sb.append(p.ch);
        }

        return sb.toString();
    }

    static class Pair {
        int index;
        char ch;

        Pair(int index, char ch) {
            this.index = index;
            this.ch = ch;
        }
    }
}
