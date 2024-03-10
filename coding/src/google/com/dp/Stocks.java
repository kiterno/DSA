package google.com.dp;

import java.util.Scanner;

public class Stocks {
    public void stockBuySell(int[] price, int n) {

        int j = 0, i;
        StringBuilder sb = new StringBuilder();

        for (i=1;i<n;i++) {
            if(price[i] < price[i-1]) {
                if(i-1!=j)
                    sb.append("("+j+" "+(i-1)+") ");
                j = i;
            }
        }
        if(i-1!=j)
            sb.append("("+j+" "+(i-1)+") ");

        if(sb.toString().isEmpty())
            System.out.println("No Profit");
        else
            System.out.println(sb);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] price = new int[n];
        for (int i=0;i<n;i++)
            price[i] = scanner.nextInt();

        Stocks stocks = new Stocks();
        stocks.stockBuySell(price, n);
    }
}
