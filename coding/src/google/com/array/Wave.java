package google.com.array;

public class Wave {
    public static void convertToWave(int n, int[] a) {
        for(int i=0;i<n;i+=2){
            swapLeft(a, n, i);
            swapRight(a, n, i);
        }
    }

    private static void swapRight(int[] a, int n, int i) {
        if(i+1<n && a[i+1]>a[i]){
            int temp = a[i];
            a[i] = a[i+1];
            a[i+1] = temp;
        }
    }

    private static void swapLeft(int[] a, int n, int i) {
        if(i-1>=0 && a[i-1]>a[i]){
            int temp = a[i];
            a[i] = a[i-1];
            a[i-1] = temp;
        }
    }

}
