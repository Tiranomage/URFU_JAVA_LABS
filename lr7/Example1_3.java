package lr7;

import java.io.*;

public class Example1_3 {
    public static void main(String[] args) {
        String data = "Hello, character streams!";
        File file = new File("example_file.txt");

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(data);
            System.out.println("Данные записаны");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader reader = new FileReader(file)) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (file.delete()) System.out.println("Файл удален");
    }
}
