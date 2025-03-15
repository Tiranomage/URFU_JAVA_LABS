package lr2;

public class Task2 {
    public static void main(String[] args) {
        int n = 4;
        int[][] matrix = new int[n][n];
        int count = 1;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = count++;
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    matrix[i][j] = count++;
                }
            }
        }

        for (int[] row : matrix) {
            for (int num : row) {
                System.out.printf("%4d", num);
            }
            System.out.println();
        }
    }
}
