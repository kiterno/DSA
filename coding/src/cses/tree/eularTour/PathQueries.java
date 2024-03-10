package cses.tree.eularTour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PathQueries {
    static ArrayList<Integer>[] neighbour;
    static int[] start;
    static int[] end;
    static int timer = 0;

    static int[] segment;
    static int size;

    PathQueries(int n) {
        size = 1;
        while (size<n) size = size*2;

        segment = new int[2*size];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int q = Integer.parseInt(input1[1]);

        String[] input2 = br.readLine().split(" ");
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            value[i] = Integer.parseInt(input2[i]);
        }

        neighbour = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            neighbour[i] = new ArrayList<>();
        }
        start = new int[n];
        end = new int[n];

        for (int i = 0; i < n-1; i++) {
            String[] input3 = br.readLine().split(" ");
            int u = Integer.parseInt(input3[0]);
            int v = Integer.parseInt(input3[1]);

            neighbour[--u].add(--v);
            neighbour[v].add(u);

        }

        eularTour(0, -1);
        PathQueries pathQueries = new PathQueries(2*n);

        for (int i = 0; i < n; i++) {
            pathQueries.constructSegment(start[i], value[i], 0, 0, size);
            pathQueries.constructSegment(end[i], -value[i], 0, 0, size);
        }

//        pathQueries.displaySegment();
        while (q-->0) {
            String[] input4 = br.readLine().split(" ");
            int one = Integer.parseInt(input4[0]);

            if (one == 2) {
                int s = Integer.parseInt(input4[1]);
                s--;
                System.out.println(pathQueries.getSum(0, end[s], 0, 0, size));
            } else {
                int s = Integer.parseInt(input4[1]);
                int x = Integer.parseInt(input4[2]);
                s--;
                pathQueries.constructSegment(start[s], x, 0, 0, size);
                pathQueries.constructSegment(end[s], -x, 0, 0, size);
            }
        }
    }

    private void constructSegment(int i, int val, int x, int lx, int rx) {
        if (rx-lx == 1) {
            segment[x] = val;
            return;
        }

        int mid = lx + (rx-lx)/2;

        if (i<mid) {
            constructSegment(i, val, 2*x+1, lx, mid);
        } else {
            constructSegment(i, val, 2*x+2, mid, rx);
        }

        segment[x] = segment[2*x+1] + segment[2*x+2];
    }

    private long getSum(int l, int r, int x, int lx, int rx) {
        if (l>=rx || r<=lx) {
            return 0;
        } else if (l <= lx && r >= rx) {
            return segment[x];
        }
        int mid = lx + (rx-lx)/2;

        long left = getSum(l, r, 2*x+1, lx, mid);
        long right = getSum(l, r, 2*x+2, mid, rx);

        return left+right;
    }

    private static void eularTour(int at, int prev) {
        start[at] = timer++;

        for (int n: neighbour[at]) {
            if (n!=prev) eularTour(n, at);
        }

        end[at] = timer++;
    }

    private static void display() {
        for (int i = 0; i < neighbour.length; i++) {
            System.out.println(neighbour[i]);
        }
        for(int i = 0; i< start.length; i++)
            System.out.println(start[i]+" "+end[i]);
    }

    private void displaySegment() {
        for (long i: segment) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

}
