package google.com.strings;

import java.util.Arrays;

public class AlternateVowelAndConsonantString {
    public static void main(String[] args) {
        String s = "aeroplane";
        System.out.println(new AlternateVowelAndConsonantString().rearrange(s, s.length()));
    }

    public String rearrange(String s, int n){
        char[] sh = new char[n];
        char[] dh = new char[n];

        int k=0, c=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                sh[k++] = ch;
            } else {
                dh[c++] = ch;
            }
        }
        Arrays.sort(sh, 0, k);
        Arrays.sort(dh, 0, c);
        StringBuilder stringBuilder = new StringBuilder();
        if(k == c || k-c == 1 || k-c == -1){
            int p = 0, q = 0;
            if(k>c){
                for(int i=0;i<n;i+=2){
                    if(p<k) stringBuilder.append(sh[p++]);
                    if(q<c) stringBuilder.append(dh[q++]);
                }
            }
            else if(k<c){
                for(int i=0;i<n;i+=2){
                    if(q<c) stringBuilder.append(dh[q++]);
                    if(p<k) stringBuilder.append(sh[p++]);
                }
            }
            else{
                if(sh[0]<dh[0]){
                    for(int i=0;i<n;i+=2){
                        if(p<k) stringBuilder.append(sh[p++]);
                        if(q<c) stringBuilder.append(dh[q++]);
                    }
                } else{
                    for(int i=0;i<n;i+=2){
                        if(q<c) stringBuilder.append(dh[q++]);
                        if(p<k) stringBuilder.append(sh[p++]);
                    }
                }
            }
            return stringBuilder.toString();
        }else {
            return "-1";
        }
    }
}
