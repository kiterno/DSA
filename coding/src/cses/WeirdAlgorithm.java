package cses;

import java.util.Scanner;

public class WeirdAlgorithm {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=scanner.nextInt();

        while(n!=1){
            System.out.print(n+" ");
            if(n%2==0){
                n = n/2;
            }else{
                n = n*3+1;
            }
        }
        System.out.print(n+" ");
    }
}
