package design.pattern.template;

public class App {
    public static void main(String[] args) {
        int[] nums =  {1, 5, 3, -3, 6, -10, 9, 24};

        Algorithm sorting = new SelectionSort(nums);
        sorting.sort();
    }
}
