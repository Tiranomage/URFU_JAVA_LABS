package lr7;

import java.io.*;

public class Example1_6 {
    public static void main(String[] args) {
        File file = new File("example_file.txt");

        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            writer.println("Hello, PrintWriter!");
            writer.print("Java is fun");
            System.out.println("Данные записаны");
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (file.delete()) System.out.println("Файл удален");
    }
}
