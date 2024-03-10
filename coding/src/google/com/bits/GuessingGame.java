package google.com.bits;
import java.util.Arrays;

public class GuessingGame {
    public static void main(String[] args) {
        int N = 6;
        int[] numbers = {5, 1, 2, 4, 3, 6};
        int[] result = countLessAfterGreater(N, numbers);

        for (int count : result) {
            System.out.println(count);
        }
    }

    public static int[] countLessAfterGreater(int N, int[] numbers) {
        int[] result = new int[N + 1];
        int[] countGreater = new int[N + 1];
        int[] countLesser = new int[N + 1];
        Arrays.fill(countGreater, 0);
        Arrays.fill(countLesser, 0);

        for (int i = 0; i < N; i++) {
            int number = numbers[i];
            countGreater[number]++;

            for (int j = 1; j < number; j++) {
                result[j]++;
            }

            for (int j = number + 1; j <= N; j++) {
                countLesser[j]++;
            }
        }

        for (int i = 1; i <= N; i++) {
            result[i] += countGreater[i] - countLesser[i];
        }

        return result;
    }
}
