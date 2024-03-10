package google.com.stack;

import java.util.Stack;

public class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        Stack<String> st = new Stack<>();

        String move = "../", current = "./";

        for (String s : logs) {
            if(s.equals(move)) {
                if(!st.isEmpty())
                    st.pop();
            } else if (!s.equals(current)) {
                st.push(s);
            }
        }
        return st.size();
    }
}
