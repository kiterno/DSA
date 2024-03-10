package cses;

import java.util.Scanner;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int l = s.length();
        int result = 0, index = 0;
        for(int i=0;i<l;i++){
            int odd = findPalindrome(i,i,s,l);
            int even = findPalindrome(i, i+1, s, l);
            int newRes = Math.max(odd, even);

            if(newRes>result){
                result = newRes;
                index = i;
            }
        }
        int left =0, right=0;
        if(result%2 == 0){
            left = index-(int)Math.ceil(result*1.0/2)+1;
            right = index+(int)Math.ceil(result*1.0/2)+1;
        }else{
            left = index-(int)Math.ceil(result*1.0/2)+1;
            right = index+(int)Math.ceil(result*1.0/2);
        }
//        System.out.println(left+" left-right "+right);
        String newStr = s.substring(left, right);
//        System.out.println(result+" result-index "+index);
        return newStr;
    }

    private int findPalindrome(int left, int right, String s, int l) {
        while(left>=0 && right<l && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s = "";
        while (!s.equals("x")) {
            s = scanner.next();
            String result = new LongestPalindromicSubstring().longestPalindrome(s);
            System.out.println(result);
        }
    }
}
