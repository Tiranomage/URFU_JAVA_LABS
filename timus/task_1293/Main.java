package timus.task_1293;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        System.out.println(n * m * k * 2);

        in.close();

    }
}
