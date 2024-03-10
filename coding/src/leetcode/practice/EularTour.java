package leetcode.practice;

import java.util.List;

public class EularTour {
    int n;
    int[] start;
    int[] end;
    static int timer;

    EularTour(int n) {
        this.n = n;
        timer = 0;
        start = new int[n];
        end = new int[n];
    }

    public void createEularTour(int curr, List<Integer>[] neighbour, int prev) {
        start[curr] = timer++;

        for (int i: neighbour[curr]) {
            if (i!=prev) createEularTour(i, neighbour, curr);
        }

        end[curr] = timer++;
    }
}
