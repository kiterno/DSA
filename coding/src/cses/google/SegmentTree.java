package cses.google;

import java.util.Scanner;

public class SegmentTree {
    static int[] segment;
    static int size;

    SegmentTree(int n) {
        size = 1;
        while (size<n){
            size*=2;
        }
        segment = new int[2*size];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        SegmentTree segmentTree = new SegmentTree(n);
        for (int i=0;i<n;i++) {
            arr[i] = scanner.nextInt();
            segmentTree.construct(i, arr[i], 0, 0, size);
        }

        int q = scanner.nextInt();
        while (q-->0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();

            System.out.println(segmentTree.get(l,r, 0, 0, size));
        }
    }

    private void construct(int i, int v, int x, int lx, int rx) {

        if (rx-lx == 1) {
            segment[x] = v;
            return;
        }

        int mid = (lx+rx)/2;

        if (i<mid) {
            construct(i, v, 2*x+1, lx, mid);
        } else {
            construct(i, v, 2*x+2, mid, rx);
        }

        segment[x] = Math.max(segment[2*x+1], segment[2*x+2]);
    }

    private int get(int l, int r, int x, int lx, int rx) {
        if (r<=lx || l>=rx)
            return Integer.MIN_VALUE;

        else if (l<=lx && r>=rx) {
            return segment[x];
        }

        int mid = (lx+rx)/2;

        int left = get(l, r, 2*x+1, lx, mid);
        int right = get(l, r, 2*x+2, mid, rx);

        return Math.max(left, right);
    }
}
