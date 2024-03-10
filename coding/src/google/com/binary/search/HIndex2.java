package google.com.binary.search;

public class HIndex2 {

    public static void main(String[] args) {
        int[] a = {0,1,3,5,6};

        System.out.println(new HIndex2().hIndex(a));
    }
    public int hIndex(int[] citations) {
        int lo = 0, hi = citations.length;
        if (citations.length == 1) {
            return citations[0];
        }
        while (lo<=hi) {
            int mid = lo + (hi-lo)/2;
            int cit = getCitationCount(mid, citations);
//            System.out.println(mid+" "+cit);

            if (cit >= mid) {
                lo = mid+1;
            }
            else hi = mid-1;
        }

        return Math.min(lo, hi);
    }

    private int getCitationCount(int mid, int[] citations) {
        int count=0;
        for (int i: citations) {
            if (mid<=i)
                count++;
        }

        return count;
    }
}
