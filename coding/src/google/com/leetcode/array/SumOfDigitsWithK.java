package google.com.leetcode.array;

public class SumOfDigitsWithK {
    public int minimumNumbers(int num, int k)
    {
        if(num == 0)
            return 0;
        for(int i = 1; i*k <= num && i <= 10; i++) // Start with set size 1 and look for set having unit's digit equal to that of num
            if(num % 10 == ((i*k)%10)) // Look for equal unit's digit
                return i;

        return -1;
    }

    public static void main(String[] args) {
        int num = 58, k=6;
        System.out.println(new SumOfDigitsWithK().minimumNumbers(num, k));
    }
}
