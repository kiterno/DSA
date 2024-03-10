package google.com.leetcode.other;

import java.util.Stack;

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a+b);
            }
            else if(tokens[i].equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a-b);
            }
            else if(tokens[i].equals("*")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a*b);
            }
            else if(tokens[i].equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a/b);
            }
            else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }
}
