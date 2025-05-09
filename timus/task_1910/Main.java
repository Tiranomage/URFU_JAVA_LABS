package timus.task_1910;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int maxSum = a[0] + a[1] + a[2];
        int position = 1;

        for (int i = 1; i <= n - 3; i++) {
            int currentSum = a[i] + a[i + 1] + a[i + 2];
            if (currentSum > maxSum) {
                maxSum = currentSum;
                position = i + 1;
            }
        }

        System.out.println(maxSum + " " + (position + 1));
    }
}
