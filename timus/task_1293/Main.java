package timus.task_1293;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        String line = in.nextLine();

        String[] parts = line.split(" ");

        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int k = Integer.parseInt(parts[2]);

        System.out.println(n * m * k * 2);
        
        in.close();
        
    }
}
