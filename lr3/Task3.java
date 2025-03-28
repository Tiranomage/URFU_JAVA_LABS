package lr3;

import java.util.Scanner;

public class Task3 {
    public static void printArray(int[] arr, int index) {
        if (index == arr.length) return;
        System.out.print(arr[index] + " ");
        printArray(arr, index + 1);
    }

    public static void inputArray(int[] arr, int index) {
        if (index == arr.length) return;
        Scanner scanner = new Scanner(System.in);
        arr[index] = scanner.nextInt();
        inputArray(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        inputArray(arr, 0);
        printArray(arr, 0);
    }
}
