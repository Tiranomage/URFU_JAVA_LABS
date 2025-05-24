package lr7;

import java.io.File;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя файла: ");
        String filename = scanner.nextLine();
        File file = new File(filename);

        if (file.exists()) {
            System.out.println("Размер файла: " + file.length() + " байт");
        } else {
            System.out.println("Файл не существует");
        }
    }
}
