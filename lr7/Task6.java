package lr7;

import java.io.*;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя файла: ");
        String filename = scanner.nextLine();
        System.out.print("Введите слово для поиска: ");
        String keyword = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(keyword)) {
                    System.out.println(line);
                }
            }
        }
    }
}
