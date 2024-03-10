package google.com.binary.search;

public class Floor {
    int floorSearch(int arr[], int n, int x) {

        int low = 0, high = n;

        while (low<=high) {
            int mid = low + (high-low)>>1;

            if(arr[mid] == x)
                return mid;
            else if (arr[mid] > x)
                high = mid - 1;
            else
                low = mid;
        }

        return low;
    }
}
