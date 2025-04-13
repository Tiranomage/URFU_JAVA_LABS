package lr4;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите элементы массива byte через пробел: ");
        String input = scanner.nextLine();
        String[] parts = input.split(" ");
        byte[] array = new byte[parts.length];
        
        try {
            // Парсинг элементов массива
            for (int i = 0; i < parts.length; i++) {
                array[i] = Byte.parseByte(parts[i]); // Могут возникнуть NumberFormatException
            }
            
            // Вычисление суммы с проверкой переполнения
            byte sum = 0;
            for (byte num : array) {
                sum += num;
                // Проверка переполнения (пример)
                if (num > 0 && sum < 0) { // Сумма переполнилась в положительную сторону
                    throw new ArithmeticException("Ошибка: Сумма превышает допустимый диапазон типа byte");
                }
                if (num < 0 && sum > 0) { // Сумма переполнилась в отрицательную сторону
                    throw new ArithmeticException("Ошибка: Сумма превышает допустимый диапазон типа byte");
                }
            }
            
            System.out.println("Сумма элементов: " + sum);
            
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Введены некорректные данные (не число) или число вне диапазона byte");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
