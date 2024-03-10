import java.util.Arrays;
import java.util.Scanner;

public class Apartments {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int[] desired_ap = new int[n];
        int[] size_ap = new int[m];

        getInputs(n, desired_ap, scanner);

        getInputs(m, size_ap, scanner);

        Arrays.sort(desired_ap);
        Arrays.sort(size_ap);

        int pos = 0;
        int count = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            while (pos<m && k+desired_ap[i] > size_ap[pos] && desired_ap[i]-k > size_ap[pos]) {
                pos++;
            }

            if (pos<m && ((desired_ap[i]<=size_ap[pos] && desired_ap[i]+k>=size_ap[pos]) || (desired_ap[i]>=size_ap[pos] && desired_ap[i]-k<=size_ap[pos]))) {
                count++;
                pos++;
            }
        }
        ans.append(count);
        System.out.println(ans.toString());
    }

    private static void getInputs(int n, int[] desired_ap, Scanner scanner) {
        for (int i = 0; i < n; i++) {
            desired_ap[i] = scanner.nextInt();
        }
    }
}
