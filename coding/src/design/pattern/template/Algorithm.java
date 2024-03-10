package design.pattern.template;

public abstract class Algorithm {
    protected int[] nums;

    public Algorithm(int[] nums) {
        this.nums = nums;
    }

    protected abstract void initialize();
    protected abstract void sorting();
    protected abstract void show();

    protected void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sort() {
        initialize();
        sorting();
        show();
    }
}
