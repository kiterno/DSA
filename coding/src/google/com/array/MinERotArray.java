package google.com.array;

public class MinERotArray {
    int findMin(int arr[], int n)
    {
        return binarySearch(arr, 0, n-1);
    }

    int binarySearch(int arr[], int low, int high){
        if(low > high)
            return arr[0];

        if(low == high)
            return arr[high];

        int mid = low + (high - low) / 2;

        if(mid < high && arr[mid+1] < arr[mid])
            return arr[mid+1];

        if(mid > low && arr[mid-1] > arr[mid])
            return arr[mid];

        if(arr[high] > arr[mid])
            return binarySearch(arr, low, mid - 1);
        return binarySearch(arr, mid + 1, high);
    }
}
