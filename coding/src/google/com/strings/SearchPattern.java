package google.com.strings;

import java.util.ArrayList;

public class SearchPattern {
    public static void main(String[] args) {
        SearchPattern searchPattern=new SearchPattern();
        System.out.println(searchPattern.search("bat","batsnbatma"));
        System.out.println(searchPattern.search("a", "batsnbssatma"));
    }

    ArrayList<Integer> search(String pat, String s)
    {
        ArrayList<Integer> result = new ArrayList<>();
        int[] kmp=new int[pat.length()];
        kmpArray(pat, kmp);

        int i=0, j=0;
        int m = pat.length(), n = s.length();

        while((n-i)>=(m-j)){
            if(pat.charAt(j) == s.charAt(i)){
                j++;
                i++;
            }
            if(m == j){
                result.add(i-j);
                j = kmp[j-1];
            }
            else if(i<n && pat.charAt(j) != s.charAt(i)){
                if(j!=0)
                    j = kmp[j-1];
                else i++;
            }
        }
        if(result.size() == 0){
            result.add(-1);
        }
        return result;
    }

    private static void kmpArray(String pat, int[] kmp){
        int i=0, j=1;

        while(j<pat.length()){
            if(pat.charAt(i) == pat.charAt(j)){
                kmp[j] = i+1;
                i++;
                j++;
            }else{
                if(i != 0)
                    i = kmp[i-1];
                else{
                    kmp[j] = i;
                    j++;
                }
            }
        }
    }
}
