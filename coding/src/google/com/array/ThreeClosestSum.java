package google.com.array;

import java.util.Arrays;

public class ThreeClosestSum {
    static int closest3Sum(int A[], int N, int X)
    {
        // code here
        Arrays.sort(A);
        int closestSum = Integer.MAX_VALUE;

        for(int i=0;i<N-2;i++){

            int b = i+1, c = N-1;

            while (b<c){
                int sum = A[i] + A[b] + A[c];

                if(Math.abs(X-sum) < Math.abs(X-closestSum)){
                    closestSum = sum;
                }

                if(sum>X)
                    c--;
                else
                    b++;
            }
        }
        return closestSum;
    }
}
