package design.pattern.template;

public class SelectionSort extends Algorithm {

    public SelectionSort(int[] nums) {
        super(nums);
    }

    @Override
    protected void initialize() {
        System.out.println("Initializing selection sort...");
    }

    @Override
    protected void sorting() {
        for (int i = 0; i < nums.length-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[min_idx])
                    min_idx = j;
            }
            if (min_idx!=i)
                swap(i, min_idx);
        }
    }

    @Override
    protected void show() {
        for (int i=0; i < nums.length; i++){
            System.out.print(nums[i]+"\t");
        }
    }
}
