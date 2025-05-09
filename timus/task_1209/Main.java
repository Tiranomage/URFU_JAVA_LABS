package timus.task_1209;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            long Ki = scanner.nextLong();
            char digit = getDigit(Ki);
            if (i > 0) {
                result.append(" ");
            }
            result.append(digit);
        }
        System.out.println(result.toString());
    }

    private static char getDigit(long Ki) {
        long low = 1;
        long high = estimateHigh(Ki);

        while (low < high) {
            long mid = (low + high) / 2;
            long sumMid = mid * (mid + 1) / 2;
            if (sumMid < Ki) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        long L = low;
        long sumPrev = (L - 1) * L / 2;
        long posInBlock = Ki - sumPrev;

        return (posInBlock == 1) ? '1' : '0';
    }

    private static long estimateHigh(long Ki) {
        if (Ki <= 1) return 1;
        long sqrtVal = (long) Math.sqrt(2 * Ki) + 2;
        return sqrtVal;
    }
}
