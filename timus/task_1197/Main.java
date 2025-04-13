package timus.task_1197;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine()); 

        int[][] moves = {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
        };
        
        for (int i = 0; i < n; i++) {
            String position = scanner.nextLine();
            int x = position.charAt(0) - 'a'; 
            int y = Character.getNumericValue(position.charAt(1)) - 1;
            
            int count = 0;
            for (int[] move : moves) {
                int newX = x + move[0];
                int newY = y + move[1];
                if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}