package google.com.array;

public class Thrice {
    static int singleElement(int[] arr , int n) {
        int max_bit = 32;

        int result = 0;
        for(int i=0;i<max_bit;i++){

            int x = 1<<i;
            int sum = 0;
            for(int j=0;j<n;j++){
                if((x & arr[j]) == 1)
                    sum++;
            }

            if(sum%3 == 1){
                result |= x;
            }
        }

        return result;
    }
}
