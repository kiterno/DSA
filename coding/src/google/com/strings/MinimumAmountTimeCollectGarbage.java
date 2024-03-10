package google.com.strings;

import java.util.ArrayList;
import java.util.List;

public class MinimumAmountTimeCollectGarbage {
    public static void main(String[] args) {
        MinimumAmountTimeCollectGarbage m = new MinimumAmountTimeCollectGarbage();
        String[] garbage = {"G","P","GP","GG"};
        int[] travel = {2,4,3};
        int res = m.garbageCollection(garbage, travel);
        System.out.println(res);

        garbage =new String[]{"MMM","PGM","GP"};
        travel = new int[] {3, 10};
        System.out.println(m.garbageCollection(garbage, travel));
    }

    public int garbageCollection(String[] garbage, int[] travel) {

        List<List<Integer>> garbageList = new ArrayList<>();
        for (int i=0;i<garbage.length;i++) {
            int m=0, p=0, g=0;
            for(int j=0;j<garbage[i].length();j++) {
                char ch = garbage[i].charAt(j);
                if (ch == 'M')
                    m++;
                else if (ch == 'P')
                    p++;
                else if (ch == 'G')
                    g++;
            }
            List<Integer> list = new ArrayList<>();
            list.add(m); list.add(p); list.add(g);
            garbageList.add(list);
        }
        int sum = 0;
        for (int i=2;i>=0;i--) {
            boolean flag = false;
            for(int j=garbageList.size()-1;j>=0;j--) {
                List<Integer> list = garbageList.get(j);

                if(list.get(i) > 0){
                    sum += list.get(i);
                    flag = true;
                }
                if (flag && j!=0)
                    sum += travel[j-1];
            }
        }

//        System.out.println(garbageList);

        return sum;
    }
}
