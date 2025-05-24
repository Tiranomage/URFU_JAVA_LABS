package timus.task_1225;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        if (N == 1) {
            System.out.println(2);
            return;
        }
        if (N == 2) {
            System.out.println(2);
            return;
        }
        long prev = 2, curr = 2;
        for (int i = 3; i <= N; i++) {
            long next = prev + curr;
            prev = curr;
            curr = next;
        }
        System.out.println(curr);
    }
}
