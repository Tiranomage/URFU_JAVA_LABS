package timus.task_1068;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int count = Math.abs(N - 1) + 1;
        long sum = ((long) (1 + N) * count) / 2;
        System.out.println(sum);
    }
}