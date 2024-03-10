package medium;

import java.util.ArrayList;
import java.util.List;

public class EqualSumProblem {
    public static void main(String[] args) {
        int[] arr = {5, 5, 1, 11, 1};

        createEqualParts(arr);
    }

    private static void createEqualParts(int[] arr) {
        List<Integer> set1 = new ArrayList<>();
        List<Integer> set2 = new ArrayList<>();

        if(!createEqualParts(arr, set1, set2, 0, 0, 0))
            System.out.println("NO");
    }

    private static boolean createEqualParts(int[] arr, List<Integer> set1, List<Integer> set2, int index, int sum1, int sum2) {
        if (arr.length == index) {
            if (sum2 == sum1) {
                print(set2, set1);

                return true;
            }
            else
                return false;
        }

        set1.add(arr[index]);

        boolean res = createEqualParts(arr, set1, set2, index+1, sum1+arr[index], sum2);

        if (res) return true;

        set1.remove(set1.size()-1);
        set2.add(arr[index]);

        res = createEqualParts(arr, set1, set2, index+1, sum1, sum2+arr[index]);

        if (!res) set2.remove(set2.size()-1);

        return res;
    }

    private static void print(List<Integer> set2, List<Integer> set1) {
        System.out.println(set1);
        System.out.println(set2);
    }
}
