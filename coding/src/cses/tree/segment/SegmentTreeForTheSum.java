//package cses.tree.segment;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SegmentTreeForTheSum {
    static int size;
    static long[] segment;

    SegmentTreeForTheSum(int n) {
        size = 1;
        while (size<n) {
            size = size*2;
        }
        segment = new long[2*size];
    }

    private void constructSegment(int i, int value, int x, int lx, int rx) {
        if (rx-lx == 1) {
            segment[x] = value;
            return;
        }
        int mid = (lx+rx)/2;
        if (i<mid) {
            constructSegment(i, value, 2*x+1, lx, mid);
        } else {
            constructSegment(i, value, 2*x+2, mid, rx);
        }

        segment[x] = segment[2*x+1] + segment[2*x+2];
    }

    private long getSum(int l, int r, int x, int lx, int rx) {
        if (l>=rx || r<=lx) {
            return 0;
        }

        else if (lx>=l && rx<=r) {
            return segment[x];
        }

        int mid = (lx+rx)/2;

        long left = getSum(l, r, 2*x+1, lx, mid);
        long right = getSum(l, r, 2*x+2, mid, rx);

        return left+right;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0].trim());
        int m = Integer.parseInt(input1[1].trim());
        SegmentTreeForTheSum sum = new SegmentTreeForTheSum(n);

        String[] input2 = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input2[i]);
            sum.constructSegment(i, arr[i], 0, 0, size);
        }
//        sum.displaySegment();

        for (int i = 0; i < m; i++) {
            String[] input3 = br.readLine().split(" ");
            int u = Integer.parseInt(input3[0]);
            int v = Integer.parseInt(input3[1]);
            int k = Integer.parseInt(input3[2]);

            if (u == 1) {
                sum.constructSegment(v, k, 0, 0, size);

            } else {
                System.out.println(sum.getSum(v, k, 0, 0, size));
            }
        }
    }

    private void displaySegment() {
        for (long i: segment) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
