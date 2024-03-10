package google.com.array;

import java.util.ArrayList;

public class SubarraySum {
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        int sum = arr[0], start = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=1;i<=n;i++){
            while (sum>s && start<i-1){
                sum-=arr[start++];
            }
            if(sum==s){
                result.add(start+1);
                result.add(i);
                return result;
            }
            if(i<n)
                sum+=arr[i];
        }
        result.add(-1);
        return result;
    }
}
