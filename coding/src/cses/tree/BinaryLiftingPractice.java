package cses.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryLiftingPractice {
    static int MX = (int) (2e5+5);
    static int MS = 18;
    static int[][] up;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        up = new int[MS][MX];

        String[] input = br.readLine().split(" ");
        for (int i = 2; i <= n; i++) {
            up[0][i] = Integer.parseInt(input[i-2]);
        }

        createBinaryLifting(n);
        String[] query = br.readLine().split(" ");
        System.out.println(jump(Integer.parseInt(query[0]), Integer.parseInt(query[1])));
    }

    private static void createBinaryLifting(int n) {
        for (int i = 1; i < MS; i++) {
            for (int j = 1; j <= n; j++) {
                up[i][j] = up[i-1][up[i-1][j]];
            }
        }
    }

    private static int jump(int x, int d) {
        for (int i = 0; i < MS; i++) {
            if (((d>>i) & 1) == 1) x = up[i][x];
        }

        return x == 0 ? -1: x;
    }
}
