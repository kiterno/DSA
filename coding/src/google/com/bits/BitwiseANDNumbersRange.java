package google.com.bits;

public class BitwiseANDNumbersRange {
    public int rangeBitwiseAnd(int left, int right) {
        int diffBits = 0;

        while (left!=right) {
            left = left>>1;
            right = right>>1;

            diffBits++;
        }

        return left<<diffBits;
    }
}
