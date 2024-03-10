package google.com.strings;

public class LongestPrefixSuffix {
    public static void main(String[] args) {
        LongestPrefixSuffix longestPrefixSuffix=new LongestPrefixSuffix();
        System.out.println(longestPrefixSuffix.lps("abab"));
        System.out.println(longestPrefixSuffix.lps("aaaa"));
        System.out.println(longestPrefixSuffix.lps("baabbbabba"));
        System.out.println(longestPrefixSuffix.lps("acccbaaacccbaac"));
    }
    
    int lps(String s) {

        int n=s.length();
        int dp[] = new int[n];

        int start = 0, end = 1;

        while (end < n){
            if(s.charAt(start) == s.charAt(end)){
                dp[end] = start+1;
                start++;
                end++;
            }
            else{
                if(start == 0){
                    dp[end] = 0;
                    end++;
                }else{
                    start = dp[start-1];
                }
            }
        }
        return dp[n-1];
    }
}
