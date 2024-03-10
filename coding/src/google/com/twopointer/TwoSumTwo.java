package google.com.twopointer;

public class TwoSumTwo {
    public static void main(String[] args) {
        TwoSumTwo twoSumTwo=new TwoSumTwo();
        int[] numbers = new int[]{0,0,3,4};
        int target = 0;
        int[] result = twoSumTwo.twoSum(numbers, target);
        System.out.println(result[0] +"\t" + result[1]);
    }

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            if(binarySearch(numbers, i+1, numbers.length, target-numbers[i]) != -1){
                return new int[]{i+1, binarySearch(numbers, i+1, numbers.length-1, target-numbers[i])+1};
            }
        }
        return new int[]{-1,-1};
    }

    private int binarySearch(int[] numbers, int low, int high, int target) {
        while (low<=high) {
            int mid = low + (high-low)/2;

            if(numbers[mid] == target)
                return mid;
            else if (numbers[mid] > target)
                high = mid -1;
            else
                low = mid+1;
        }
        return -1;
    }
}
