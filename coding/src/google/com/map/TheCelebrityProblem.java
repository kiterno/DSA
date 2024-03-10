package google.com.map;

import java.util.*;

public class TheCelebrityProblem {
        int celebrity(int arr[][], int n)
        {
            Map<Integer, Integer> map = new HashMap<>();

            for (int i=0;i<n;i++) {
                for (int j=0;j<n;j++) {
                    if(i!=j && arr[i][j] == 1) {
                        map.put(j, map.getOrDefault(j, 0) + 1);
                    }
                }
            }

            List<Integer> res = new ArrayList<>();

            for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                if(entry.getValue() == n-1) {
                    res.add(entry.getKey());
                }
            }
            ArrayList<Integer> finalRes = new ArrayList<>();
            for (int i: res) {
                boolean knows = false;
                for(int j=0;j<n;j++) {
                    if(i!=j && arr[i][j] == 1) {
                        knows = true;
                        break;
                    }
                }

                if(!knows) {
                    finalRes.add(i);
                }
            }

            if(finalRes.size() == 1) {
                return res.get(0);
            } else return -1;
        }

    public static void main(String[] args) {
        int[][] arr = {{0, 1, 0},
                {0, 0, 0},
                {0, 1, 0}};

        TheCelebrityProblem t = new TheCelebrityProblem();
        System.out.println(t.celebrity(arr, arr.length));
        arr = new int[][]{{0, 1, 1, 0},
                {0, 0, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 0}};


        System.out.println(t.celebrity(arr, arr.length));
    }
}
