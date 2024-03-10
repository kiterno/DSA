package google.com.bits;

import java.util.ArrayList;
import java.util.Arrays;

public class ConstructListXor {
    static ArrayList<Integer> constructList(ArrayList<ArrayList<Integer>> Q, int N) {

        int[] a = new int[N+1];
        ArrayList<Integer> list = new ArrayList<>();

        for (ArrayList<Integer> val: Q) {
            if(val.get(0) == 0) {
                list.add(val.get(1));
            } else {
                a[list.size()] ^= val.get(1);
            }
        }

        int xor = a[N];

        for (int i=N-1;i>=0;i--) {
            xor ^= a[i];

            if(i<=list.size()) {
                list.set(i, list.get(i)^xor);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int N = 5;
        ArrayList<ArrayList<Integer>> Q = new ArrayList<>();
        ArrayList<Integer> one = new ArrayList<>();
    }
}
