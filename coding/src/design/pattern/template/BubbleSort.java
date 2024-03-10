package design.pattern.template;

public class BubbleSort extends Algorithm {

    public BubbleSort(int[] nums) {
        super(nums);
    }

    @Override
    protected void initialize() {
        System.out.println("Initializing bubble sort...");
    }

    @Override
    protected void sorting() {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (nums[j] > nums[j + 1]) {
                   swap(j, j+1);
                }
    }

    @Override
    protected void show() {
        for (int i=0; i < nums.length; i++){
            System.out.print(nums[i]+"\t");
        }
    }
}
