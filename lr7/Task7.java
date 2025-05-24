package lr7;

import java.io.*;
import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя файла: ");
        String filename = scanner.nextLine();
        System.out.print("Введите текст для записи: ");
        String text = scanner.nextLine();

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(text);
            System.out.println("Записано символов: " + text.length());
        }
    }
}
