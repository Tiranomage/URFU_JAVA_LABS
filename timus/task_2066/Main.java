package timus.task_2066;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        
        List<int[]> permutations = new ArrayList<>();
        permutations.add(new int[]{a, b, c});
        permutations.add(new int[]{a, c, b});
        permutations.add(new int[]{b, a, c});
        permutations.add(new int[]{b, c, a});
        permutations.add(new int[]{c, a, b});
        permutations.add(new int[]{c, b, a});
        
        int min = Integer.MAX_VALUE;
        for (int[] arr : permutations) {
            int x = arr[0], y = arr[1], z = arr[2];
            for (char op1 : new char[]{'+', '-', '*'}) {
                for (char op2 : new char[]{'+', '-', '*'}) {
                    int result = evaluate(x, y, z, op1, op2);
                    if (result < min) {
                        min = result;
                    }
                }
            }
        }
        System.out.println(min);
    }

    private static int evaluate(int x, int y, int z, char op1, char op2) {
        int result;
        if (op1 == '*') {
            int temp = x * y;
            if (op2 == '*') {
                result = temp * z;
            } else if (op2 == '+') {
                result = temp + z;
            } else {
                result = temp - z;
            }
        } else if (op2 == '*') {
            int temp = y * z;
            if (op1 == '+') {
                result = x + temp;
            } else {
                result = x - temp;
            }
        } else {
            int first = x;
            if (op1 == '+') {
                first += y;
            } else if (op1 == '-') {
                first -= y;
            }
            if (op2 == '+') {
                result = first + z;
            } else {
                result = first - z;
            }
        }
        return result;
    }
}
