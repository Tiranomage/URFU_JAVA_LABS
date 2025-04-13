package lr4;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        int[][] matrix = { // Пример матрицы 3x3
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер столбца (0-" + (matrix[0].length - 1) + "): ");
        
        try {
            int column = Integer.parseInt(scanner.nextLine()); // Могут возникнуть NumberFormatException
            
            if (column < 0 || column >= matrix[0].length) {
                throw new IllegalArgumentException("Ошибка: Столбца с таким номером не существует");
            }
            
            System.out.println("Элементы столбца " + column + ":");
            for (int i = 0; i < matrix.length; i++) {
                System.out.println(matrix[i][column]);
            }
            
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Введены некорректные данные (не число)");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
