package leetcode.practice.binarySearch;

import java.util.ArrayList;
import java.util.List;

public class Calender1 {
    List<int[]> schedule;
    public Calender1() {
        schedule = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        int[] interval = new int[] {start, end};

        int low = 0, high = schedule.size();

        while (low<=high) {
            int mid = low + (high-low)/2;

            if (isConflict(schedule.get(mid), interval)) {
                return false;
            }

            int mStart = schedule.get(mid)[0], mEnd = schedule.get(mid)[1];

            if (start>=mEnd) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        schedule.add(low, interval);
        return true;
    }

    private boolean isConflict(int[] a, int[] b) {
        return (a[0]>=b[0] && a[0]<b[1]) || (b[0]>=a[0] && b[0]<a[1]);
    }
}
