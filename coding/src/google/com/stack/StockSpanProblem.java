package google.com.stack;

import java.util.Stack;

public class StockSpanProblem {
    public static int[] calculateSpan(int price[], int n)
    {
        Stack<Integer> stack = new Stack<>();
        int res[] = new int[n];

        for (int i=0;i<n;i++) {
            while (!stack.isEmpty() && price[i]>=price[stack.peek()]) {
                stack.pop();
            }

            int x = stack.isEmpty() ? 1+i : i-stack.peek();
            res[i] = x;
            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 7; int[] price={100, 80, 60, 70, 60, 75, 85};
        println(calculateSpan(price, n));

        n = 42;
        price =new int[] {68, 735, 101, 770, 525, 279 ,559, 563, 465, 106, 146, 82, 28, 362, 492, 596 ,743, 28 ,637 ,392 ,205, 703, 154, 293, 383, 622, 317, 519, 696, 648, 127, 372, 339, 270, 713, 68, 700, 236, 295, 704, 612, 123};
        println(calculateSpan(price, n));
    }

    public static void println(int[] ints) {
        for (int i:ints)
            System.out.printf(i+"\t");
        System.out.println();
    }
}
