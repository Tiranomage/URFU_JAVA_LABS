package lr3;

import java.util.Scanner;

public class Task2 {
    public static void printBinary(int n) {
        if (n > 0) {
            printBinary(n / 2);
            System.out.print(n % 2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        printBinary(num);
    }
}
