package google.com.maths;

public class NthDigit {
    public static void main(String[] args) {
        System.out.println(new NthDigit().findNthDigit(100));
    }
    public int findNthDigit(int n) {
        int x = 9;
        int digits = 1;
        int sum = 0;

        while ((n-x*digits)>=x) {
            n = n-x*digits++;
            sum += x;
            x = x*10;
        }

        int reminder = n%digits;
        int quo = n/digits;

        quo = sum+quo;
        System.out.println(sum+" "+quo+" "+reminder);
        if (reminder == 0) {
            return quo%10;
        } else {
            String s = (quo+1) + "";
            System.out.println(s);
            return Integer.parseInt(s.substring(reminder-1, reminder));
        }
    }
}
