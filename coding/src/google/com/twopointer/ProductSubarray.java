package google.com.twopointer;

public class ProductSubarray {
    long maxProduct(int[] arr, int n) {
        int max = arr[0], min = arr[0];
        int max_ans = 1;

        for (int i=1;i<n;i++) {

            if(arr[i]<0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(arr[i], max * arr[i]);
            min = Math.min(arr[i], min*arr[i]);

            max_ans = Math.max(max, min);
        }

        return max_ans;
    }
}
