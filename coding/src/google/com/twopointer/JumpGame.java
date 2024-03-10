package google.com.twopointer;

import java.util.Scanner;

public class JumpGame {

    /*
    * 10
    * 2 3 1 1 2 4 2 0 1 1
    * 1 3 5 8 9 2 6 7 6 8 9
    * */
    static int minJumps(int[] arr){
        int max_jump = arr[0], count = 0, next_max_jump = arr[0];

        for (int i=0;i<arr.length-1;i++) {
            next_max_jump = Math.max(next_max_jump, arr[i]+i);

            if(i == max_jump) {
                max_jump = next_max_jump;
                count++;
                System.out.println(max_jump);
            }

            if(i>max_jump)
                return -1;
        }

        return count+1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        System.out.println(minJumps(arr));
    }
}
