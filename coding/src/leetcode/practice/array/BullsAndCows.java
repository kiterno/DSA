package leetcode.practice.array;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int a = 0, b = 0;


        int[] me = new int[10];
        int[] friend = new int[10];


        for(int i=0;i<secret.length();i++) {
            char u = secret.charAt(i);
            char v = guess.charAt(i);


            if(u == v) {
                a++;
            } else {
                me[u-'0']++;
                friend[v-'0']++;
            }
        }


        for(int i=0;i<10;i++) {
            b+=Math.min(me[i], friend[i]);
        }


        return a+"A"+b+"B";
    }

}
