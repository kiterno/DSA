package cses.tree.binaryLifting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryLifting {
    static int MX = (int) (2e5 + 5);  // maximum N
    static int MS = 18;       // 18 is calculated by $\log_2 2e5$

    static int[][] up = new int[MS][MX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0].trim());
        int q = Integer.parseInt(input1[1].trim());
        String[] input2 = br.readLine().split(" ");

        for (int i=2;i<=n;i++) {
            up[0][i] = Integer.parseInt(input2[i-2]);
        }

        constructParentArray(n);

        printParent(up, n);
        for (int i = 0; i < q; i++) {
            String[] queries = br.readLine().split(" ");
            int x = Integer.parseInt(queries[0].trim());
            int d = Integer.parseInt(queries[1].trim());
            System.out.println(jump(x, d));
        }
    }

    private static int jump(int x, int d) {
        for (int i = 0; i < MS; i++) {
            if (((d>>i) & 1) == 1) x = up[i][x];
        }
        return x == 0 ? -1 : x;
    }

    private static void printParent(int[][] up, int n) {
        for (int i = 0; i < MS; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(up[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void constructParentArray(int n) {
        for (int i = 1; i < MS; i++) {
            for (int j = 1; j <= n; j++) {
                up[i][j] = up[i-1][up[i-1][j]];
            }
        }
    }
}
