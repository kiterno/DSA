package google.com.array;

import java.util.HashMap;
import java.util.Map;

public class MaxPointOnLine {

    public static void main(String[] args) {
//        int[][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
//        int[][] points = {{2,3},{3,3},{-5,3}};
//        int[][] points = {{4,5},{4,-1},{4,0}};
//        int[][] points = {{-6,-1},{3,1},{12,3}};
        int[][] points = {{7,3},{19,19},{-16,3},{13,17},{-18,1},{-18,-17},{13,-3},{3,7},{-11,12},{7,19},{19,-12},{20,-18},{-16,-15},{-10,-15},{-16,-18},{-14,-1},{18,10},{-13,8},{7,-5},{-4,-9},{-11,2},{-9,-9},{-5,-16},{10,14},{-3,4},{1,-20},{2,16},{0,14},{-14,5},{15,-11},{3,11},{11,-10},{-1,-7},{16,7},{1,-11},{-8,-3},{1,-6},{19,7},{3,6},{-1,-2},{7,-3},{-6,-8},{7,1},{-15,12},{-17,9},{19,-9},{1,0},{9,-10},{6,20},{-12,-4},{-16,-17},{14,3},{0,-1},{-18,9},{-15,15},{-3,-15},{-5,20},{15,-14},{9,-17},{10,-14},{-7,-11},{14,9},{1,-1},{15,12},{-5,-1},{-17,-5},{15,-2},{-12,11},{19,-18},{8,7},{-5,-3},{-17,-1},{-18,13},{15,-3},{4,18},{-14,-15},{15,8},{-18,-12},{-15,19},{-9,16},{-9,14},{-12,-14},{-2,-20},{-3,-13},{10,-7},{-2,-10},{9,10},{-1,7},{-17,-6},{-15,20},{5,-17},{6,-6},{-11,-8}};

        MaxPointOnLine obj = new MaxPointOnLine();
        System.out.println(obj.maxPoints(points));
    }

    public int maxPoints(int[][] points) {

        Map<String, Integer> map = new HashMap<>();

        int len = points.length;

        for (int i=0;i<len;i++) {
            for (int j = i+1; j < len; j++) {
                String mxc = getMAndCValues(points[i][0], points[i][1], points[j][0], points[j][1]);
                System.out.println(i+"X"+j+"\t"+mxc);
                if(map.containsKey(mxc)) {
                    map.put(mxc, map.get(mxc) +1);
                }
                else
                    map.put(mxc, 1);
            }
        }

        int max = 0;
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        return getFromSriDharacharya(max);
    }

    private int getFromSriDharacharya(int max) {
        double n = -3+Math.sqrt(9-8*(1-max));
        double ans = n/2;

        return (int)(ans+1);
    }

    private String getMAndCValues(int x1, int y1, int x2, int y2) {
        if(x2-x1 == 0) {
            return "X";
        }
        double m = (y2*1.0-y1*1.0) / (x2*1.0-x1*1.0);
        if(m == 0.0)
            m = Math.abs(m);
        double c = y1 * 1.0 - m * x1;

        return String.format("%.2f", m)+"X"+String.format("%.2f", c);
    }
}
