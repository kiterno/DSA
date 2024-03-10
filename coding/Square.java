import java.util.*;

public class Square {
      public static void main(String[] args) {
            Scanner ob=new Scanner(System.in);
            System.out.println("Enter length and breath of rectangle");
            int length = ob.nextInt();
            int breath = ob.nextInt();


            if(length != breath){
                  System.out.println("No Its not a square");
            }
            else{
                  System.out.println("Yes Square");
            }
      }
}
