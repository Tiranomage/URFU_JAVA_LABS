package lr7;

import java.io.*;

public class Example1_4 {
    public static void main(String[] args) {
        String data = "Hello, buffered streams!";
        File file = new File("example_file.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(data);
            System.out.println("Данные записаны");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (file.delete()) System.out.println("Файл удален");
    }
}