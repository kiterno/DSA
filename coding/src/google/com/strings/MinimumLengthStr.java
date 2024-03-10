package google.com.strings;

public class MinimumLengthStr {
    public int minimumLength(String s) {

        int i = 0, j = 0;


        while (i<j) {
            if(s.charAt(i) != s.charAt(j)) {
                return j-i+1;
            }

            char ch = s.charAt(i);
            while (i<s.length() && (i+1)<j && (ch == s.charAt(i+1))) {
                i++;
            }

            ch = s.charAt(j);
            while (j-1>i && s.charAt(j-1) == ch) {
                j--;
            }
            i++;
            j--;
        }

        return 0;
    }
}
