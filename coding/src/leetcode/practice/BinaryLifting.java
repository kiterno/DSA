package leetcode.practice;

public class BinaryLifting {
    static int MS = 18;
    static int MX = (int) (2e5+5);

    static int[][] up = new int[MS][MX];

    public void createLift(int n) {
        for (int i = 1; i < MS; i++) {
            for (int j = 1; j <= n; j++) {
                up[i][j] = up[i-1][up[i-1][j]];
            }
        }
    }

    public int jump(int x, int d) {
        for (int i = 0; i < MS; i++) {
            if (((d>>i) & 1) == 1) x = up[i][x];
        }

        return x == 0 ? -1: x;
    }

    public static void main(String[] args) {
        int[] a = {0, 0, 6, 10, 3, 1, 1, 5, 4, 2, 7};

        BinaryLifting binaryLifting = new BinaryLifting();

        for (int i = 0; i < a.length; i++) {
            up[0][i] = a[i];
        }
        binaryLifting.createLift(a.length-1);

        printlift(a.length);

        System.out.println(binaryLifting.jump(9, 3));
        System.out.println(binaryLifting.jump(8, 3));
        System.out.println(binaryLifting.jump(8, 5));
    }

    private static void printlift(int n) {
        for (int i = 0; i < MS; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(up[i][j]+" ");
            }
            System.out.println();
        }
    }
}
