package google.com.leetcode.array;

public class IncTripletSeq {
    public boolean increasingTriplet(int[] nums) {

        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;

        for(int i: nums){
            if(i<first){
                first = i;
            }
            else if(i<second)
                second = i;
            if(i>first && i>second)
                return true;
        }
        return false;
    }
}
