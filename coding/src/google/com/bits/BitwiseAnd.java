package google.com.bits;

public class BitwiseAnd {
    public static int findX(int n) {
        while ((n & (n - 1)) != 0) {
            n = n & (n - 1);
        }
        return (n - 1);
    }

    public static void main(String[] args) {
        int n = 17;
        int x = findX(n);
        System.out.println("For n = " + n + ", x = " + x);
    }



}

