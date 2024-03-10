package google.com.bits;

public class ValidPermutations {
    public static int countValidPermutations(int n) {
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        int[] result = { 0 };
        permute(nums, 0, result);
        return result[0];
    }

    private static void permute(int[] nums, int index, int[] result) {
        if (index == nums.length) {
            result[0]++;
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if ((nums[i] % (index + 1) == 0) || ((index + 1) % nums[i] == 0)) {
                swap(nums, index, i);
                permute(nums, index + 1, result);
                swap(nums, index, i);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int n = 2; // Change this to the desired value of n
        int result = countValidPermutations(n);
        System.out.println("Number of valid permutations for n = " + n + ": " + result);
    }
}
