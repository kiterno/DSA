package google.com.bits;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindMissingAndRepeating {
    int[] findTwoElement(int arr[], int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int x=0, y=0;
        for (int i = 0; i < n; i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
                x = arr[i];
            } else map.put(arr[i], 1);
        }

        for (int i=1;i<=n;i++) {
            if(!map.containsKey(i)){
                y = i;
                break;
            }
        }


        return new int[]{x, y};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int arr[] = new int[n];
        for (int i=0;i<n;i++)
            arr[i] = scanner.nextInt();

        FindMissingAndRepeating f = new FindMissingAndRepeating();
        int[] res = f.findTwoElement(arr, n);
        System.out.println(res[0] +" " + res[1]);
    }
}
