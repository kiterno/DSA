import java.util.*;
public class Discount {
      public static void main(String[] args) {
            Scanner ob=new Scanner(System.in);
            int x;
            System.out.println("Enter the quantity");
            x = ob.nextInt();

            if(100*x>1000){
                  System.out.println("Total discount = " + (100*x*0.1) +
                   " Total amount = " + (100*x - 100*x*0.1));
            }
            else{
                  System.out.println("Total amount = " + (100*x));
            }
      }
}
