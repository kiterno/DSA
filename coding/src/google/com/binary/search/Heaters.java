package google.com.binary.search;

public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        int n = houses.length;

        int low = houses[0], high = (int) 10e9;
        int ans = (int) 10e9;

        while (low<=high) {
            int mid = low + (high-low)/2;

            if (possible(houses, heaters, mid)) {
                high = mid-1;
                if (mid<ans)
                    ans = mid;
            }
            else {
                low = mid+1;
            }
        }

        return ans;
    }

    private boolean possible(int[] houses, int[] heaters, int mid) {
        int min = heaters[0] - mid, max = heaters[0]+mid;
        int pos = 0;
        int count = 0;

        for (int i=0; i<houses.length; i++) {
            if (houses[i]>=min && houses[i]<=max) {
                count++;
            } else if (pos+1<heaters.length){
                pos++;
                min = heaters[pos]-mid;
                max = heaters[pos]+mid;
                if (houses[i]>=min && houses[i]<=max) {
                    count++;
                } else {
                    i--;
                }
            }
        }

        return count>=houses.length;
    }

    public static void main(String[] args) {
        int[] a = {1,1,1,1,1,1,999,999,999,999,999};
        int[] heaters = {499,500,501};

        System.out.println(new Heaters().findRadius(a, heaters));

        a = new int[] {1,2,3};
        heaters = new int[] {2};

        System.out.println(new Heaters().findRadius(a, heaters));
    }
}
