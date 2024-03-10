package cses.dp;

import java.util.Scanner;

public class BookShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        Book[] books = new Book[n+1];
        books[0] = new Book();
        for (int i = 1; i <= n; i++) {
            books[i] = new Book();
            books[i].price = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            books[i].pages = sc.nextInt();
        }

        int[][] dp = new int[n+1][x+1];

        for (int i = 0; i <= n; i++) {
            for(int money = 0; money<=x;money++) {
                if (i==0 || money==0)
                    dp[i][money] = 0;
                else {
                    int c1 = (i == 1) ? 0 : dp[i - 1][money];
                    int c2 = (money < books[i].price) ? 0 : books[i].pages + dp[i - 1][money - books[i].price];

                    dp[i][money] = Math.max(c1, c2);
                }
            }
        }


        System.out.println(dp[n][x]);
    }


    static class Book {
        int price, pages;

        public Book() {
        }

        public Book(int price, int pages) {
            this.price = price;
            this.pages = pages;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "price=" + price +
                    ", pages=" + pages +
                    '}';
        }
    }
}
