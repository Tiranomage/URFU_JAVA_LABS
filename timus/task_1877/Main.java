package timus.task_1877;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lock1Str = scanner.nextLine().trim();
        String lock2Str = scanner.nextLine().trim();
        
        int lock1 = Integer.parseInt(lock1Str);
        int lock2 = Integer.parseInt(lock2Str);
        
        for (int code = 0; code <= 9999; code++) {
            int night = code + 1;
            if (night % 2 == 1) {
                if (code == lock1) {
                    System.out.println("yes");
                    return;
                }
            } else {
                if (code == lock2) {
                    System.out.println("yes");
                    return;
                }
            }
        }
        System.out.println("no");
    }
}
