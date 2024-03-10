package algorithms;

import java.util.Scanner;

public class BinaryLifting {
    static int MS = 18;
    static int MX = (int) (1e5+5);

    static int[][] up = new int[MS][MX];;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 2; i <= n; i++) {
            up[0][i] = sc.nextInt();
        }

        createBinaryLifting(n);
//        printLift(n);
        int q = sc.nextInt();
        while (q-- > 0) {
            int x = sc.nextInt();
            int d = sc.nextInt();
            System.out.println(jump(x, d));
        }
    }

    private static int jump(int x, int d) {
        for (int i = 0; i < MS; i++) {
            if ((d>>i & 1) == 1) {
                x = up[i][x];
                System.out.println(x);
            }
        }

        return x == 0 ? -1: x;
    }

    /*
10
6 10 3 1 1 5 4 2 7
     */

    private static void printLift(int n) {
        for (int i = 0; i < MS; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(up[i][j]+" ");
            }
            System.out.println();
        }
    }



    private static void createBinaryLifting(int n) {

        for (int i = 1; i < MS; i++) {
            for (int j = 1; j <= n; j++) {
                up[i][j] = up[i-1][up[i-1][j]];
            }
        }
    }
}
