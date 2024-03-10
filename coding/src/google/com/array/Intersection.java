package google.com.array;

import java.util.ArrayList;
import java.util.List;

public class Intersection {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();

        int i=0, j=0;

        while (i<firstList.length && j<secondList.length) {
            int max = Math.max(firstList[i][0], secondList[j][0]);
            int min = Math.min(firstList[i][1], secondList[j][1]);

            if (max <= min) {
                list.add(new int[]{max, min});
            }

            if(firstList[i][1] < secondList[j][1])
                i++;
            else
                j++;
        }

        return list.toArray(new int[list.size()][]);
    }
}
