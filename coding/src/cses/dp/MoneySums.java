package cses.dp;

import java.util.*;

public class MoneySums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();

            for(int it: set) {
                list.add(it+a[i]);
            }
            set.add(a[i]);
            set.addAll(list);
        }

        List<Integer> res = new ArrayList<>(set);

        Collections.sort(res);
        System.out.println(res.size());

        for(int i: res)
            System.out.print(i+" ");
        System.out.println();
    }
}
