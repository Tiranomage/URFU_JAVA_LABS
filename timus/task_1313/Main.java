package timus.task_1313;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] matrix = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        for (int s = 0; s < 2 * N - 1; s++) {
            int startI = Math.min(s, N - 1);
            int endI = Math.max(0, s - (N - 1));
            
            for (int i = startI; i >= endI; i--) {
                int j = s - i;
                result.add(matrix[i][j]);
            }
        }
        
        System.out.println(result.stream().map(String::valueOf).collect(java.util.stream.Collectors.joining(" ")));
    }
}
