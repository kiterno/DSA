package leetcode.practice;

public class SegmentTree {
    int size;
    int[] segment;

    SegmentTree(int n) {
        size = 1;
        while (size<n) {
            size = size*2;
        }
        size = size*2;
        segment = new int[size*2];
    }

    public void construct(int i, int val, int x, int lx, int rx) {
        if (rx-lx == 1) {
            segment[x] = val;
            return;
        }

        int mid = (lx+rx)/2;

        if (i<mid) {
            construct(i, val, 2*x+1, lx, mid);
        } else {
            construct(i, val, 2*x+2, mid, rx);
        }

        segment[x] = Math.min(segment[2*x+1], segment[2*x+2]);
    }

    public int find(int l, int r, int x, int  lx, int rx) {
        if (lx>=r || rx<=l) {
            return Integer.MAX_VALUE;
        }

        if (lx>=l && rx<=r) {
            return segment[x];
        }

        int mid = (lx+rx)/2;

        int left = find(l, r, 2*x+1, lx, mid);
        int right = find(l, r, 2*x+2, mid, rx);

        return Math.min(left, right);
    }


    public static void main(String[] args) {
        int[] a = {2, 5, 6, 1, 7, 8, 10, -1, 7};

        SegmentTree segmentTree = new SegmentTree(a.length);
        for (int i = 0; i < a.length; i++) {
            segmentTree.construct(i, a[i], 0, 0, segmentTree.size);
        }

        System.out.println(segmentTree.find(0, 5, 0, 0, segmentTree.size));
        System.out.println(segmentTree.find(1, 3, 0, 0, segmentTree.size));
        System.out.println(segmentTree.find(5, 8, 0, 0, segmentTree.size));
    }
}
