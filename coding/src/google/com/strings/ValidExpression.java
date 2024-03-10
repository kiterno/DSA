package google.com.strings;

import java.util.Stack;

public class ValidExpression {
    boolean valid(String s)
    {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }

            if(st.isEmpty()){
                return false;
            }
            char top;
            switch (ch){
                case ')':
                    top = st.pop();
                    if(top == '{' || top == '[')
                        return false;
                    break;
                case '}':
                    top = st.pop();
                    if(top == '[' || top == '(')
                        return false;
                    break;
                case ']':
                    top = st.pop();
                    if(top == '{' || top == '(')
                        return false;
                    break;
            }
        }
        return st.isEmpty();
    }
}
