package mac;

public class CompareVersionNumbers {
    public static void main(String[] args) {
        String version1 = "0.1";
        String version2 = "1.1";


        System.out.println(new CompareVersionNumbers().compareVersion(version1, version2));
    }
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int i=0, j=0;

        while(i<v1.length && j<v2.length) {
            int x = Integer.parseInt(v1[i]);
            int y = Integer.parseInt(v2[i]);
            System.out.println(x+" "+y);
            if(x > y) {
                return 1;
            } else if(x < y) {
                return -1;
            } else {
                i++;
                j++;
            }
        }

        while(i<v1.length) {
            int x = Integer.parseInt(v1[i]);

            if(x > 0) {
                return 1;
            } else {
                i++;
            }
        }

        while(j<v2.length) {
            int y = Integer.parseInt(v2[j]);

            if(y>0) {
                return -1;
            } else {
                j++;
            }
        }

        return 0;
    }
}
