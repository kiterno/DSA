package google.com.queue;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] res = new int[nums.length-k+1];
        int pos = 0;

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            while (i>=k && !deque.isEmpty() && deque.peekFirst() <= nums[i-k]) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[i]>=deque.peekFirst()) {
                deque.pollFirst();
            }
            deque.addFirst(nums[i]);

            if (i>=k-1) {
                res[pos++] = deque.peekLast();
            }
        }
        return res;
    }
}
