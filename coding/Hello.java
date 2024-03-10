import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Stream;

class Hello{
      public static void main(String args[]){
            System.out.println("Hello World");

            int[][] a = {{1,2}, {2,-1}};

            Arrays.sort(a, new Comparator<int[]>() {
                  @Override
                  public int compare(int[] o1, int[] o2) {
                        return 0;
                  }
            });

            int[] arr = {9,-2,10,3,-5,34,-22,7};
            Sort[] ans = new Sort[arr.length];

            for (int i = 0; i < arr.length; i++) {
                  ans[i] = new Sort(arr[i]);
            }

            Arrays.sort(ans, new Comparator<Sort>() {
                  @Override
                  public int compare(Sort o1, Sort o2) {
                        if (Math.abs(o1.a) == Math.abs(o2.a)) {
                              return o1.a-o2.a;
                        }
                        return Math.abs(o1.a) - Math.abs(o2.a);
                  }
            });
            for(Sort i: ans)
                  System.out.print(i.a+" ");
            System.out.println();
      }

      static class Sort {
            int a;

            public Sort(int a) {
                  this.a = a;
            }
      }
}