package lr4;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите элементы массива через пробел: ");
        String input = scanner.nextLine();
        String[] parts = input.split(" ");
        int[] array = new int[parts.length];
        
        try {
            // Парсинг элементов массива
            for (int i = 0; i < parts.length; i++) {
                array[i] = Integer.parseInt(parts[i]); // Могут возникнуть NumberFormatException
            }
            
            // Вычисление среднего среди положительных элементов
            int sum = 0;
            int count = 0;
            for (int num : array) {
                if (num > 0) {
                    sum += num;
                    count++;
                }
            }
            
            if (count == 0) {
                throw new RuntimeException("Ошибка: В массиве нет положительных элементов");
            }
            
            double average = (double) sum / count;
            System.out.println("Среднее значение: " + average);
            
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Введены некорректные данные (не число)");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
