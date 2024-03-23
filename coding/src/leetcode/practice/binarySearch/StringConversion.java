package leetcode.practice.binarySearch;

public class StringConversion {
    int stringConversion(String X, String Y) {
        return check(X, Y, 0, 0);
    }

    private int check(String x, String y, int i, int j) {
        if(i>=x.length() && j>=y.length()) return 1;

        if (j>=y.length() && remainingLower(x, i)) {
            return 1;
        }

        if (j>=y.length()) return 0;

        int match = check(x, y, i+1, j+1);

        int notMatch = x.charAt(i) >= 'a' ? check(x, y, i+1, j) : 1;

        return  match == notMatch ? 1: 0;
    }

    private boolean remainingLower(String x, int i) {
        while (i<x.length() ) {
            if (x.charAt(i) < 'a')
                return false;
            i++;
        }

        return true;
    }
}
