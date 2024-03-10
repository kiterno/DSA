package google.com.strings;

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbobaoo";
        boolean res = new PermutationInString().checkInclusion(s1, s2);

        System.out.println(res);

        boolean res2 = new PermutationInString().checkInclusion("adc", "dcda");
        System.out.println(res2);
    }

    /*
    adc
    dcda
     */

    private void print(int[] first) {
        for(int i: first) {
            System.out.print(i+"\t");
        }
        System.out.println();
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] first = new int[26];

        for (char ch: s1.toCharArray()) {
            first[ch-'a']++;
        }

        int[] second = new int[26];
        int pos = 0;

        for (int i = 0; i < s2.length(); i++) {
            second[s2.charAt(i) - 'a']++;
            if(second[s2.charAt(i)-'a'] > first[s2.charAt(i)-'a']){
                while(s2.charAt(i) != s2.charAt(pos)){
                    second[s2.charAt(pos)-'a']--;
                    pos++;
                }
                second[s2.charAt(pos)-'a']--;
                pos++;
            } else if(second[s2.charAt(i)-'a'] == first[s2.charAt(i)-'a'] && compare(first, second)){
                return true;
            }
        }

        return false;
    }

    private boolean compare(int[] first, int[] second) {

        for (int i = 0; i < 26; i++) {
            if(first[i] != second[i])
                return false;
        }
        return true;
    }
}
