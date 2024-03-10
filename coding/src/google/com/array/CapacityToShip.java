package google.com.array;

public class CapacityToShip {
    public static void main(String[] args) {
        int[] weight = {7, 9, 8, 10, 19};
        int days = 3;
        int n = weight.length;

        shipWithInDays(weight, days, n);
    }

    private static void shipWithInDays(int[] weight, int days, int n) {
        int high = 0;

        for(int i:weight)
            high+=i;

        int low = weight[0];
        for(int i=1;i<n;i++){
            if(low<weight[i])
                low = weight[i];
        }

        int result = -1;

        while (low<=high){
            int mid = low+(high-low)/2;

            if(isValid(weight, n, days, mid)){
                result = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        System.out.println(result);
    }

    private static boolean isValid(int[] weight, int n, int days, int mid) {
        int steps = 1, sum = 0;
        for(int i=0;i<n;i++){
            sum+=weight[i];

            if(sum>mid){
                steps++;
                sum = weight[i];
            }

            if(steps > days)
                return false;
        }
        return true;
    }
}
