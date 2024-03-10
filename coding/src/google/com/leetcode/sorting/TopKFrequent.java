package google.com.leetcode.sorting;

import java.util.*;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<>();

        for(int i:nums){
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else{
                map.put(i, 1);
            }
        }

        Sort arr[] = new Sort[map.size()];
        int i=0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            arr[i] = new Sort();
            arr[i].number = entry.getKey();
            arr[i++].freq = entry.getValue();
        }

        Arrays.sort(arr);
        int size = arr.length-1;
        int res[]=new int[k];
        i=0;
        while (k-->0){
            res[i++] = arr[size--].number;
        }
        return res;
    }

    class Sort implements Comparable<Sort>{
        int number, freq;
        @Override
        public int compareTo(Sort temp) {
            return this.freq - temp.freq;
        }
    }

    public static void main(String[] args) {
        int a[] = {1, 1,1,2,2,3};
        int k=2;
        TopKFrequent topKFrequent = new TopKFrequent();
        System.out.println(topKFrequent.topKFrequent(a, k));
    }
}
