package lr7;

import java.io.*;

public class Task3 {
    public static void main(String[] args) {
        File file = new File("example_file.txt");
        int lineCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.readLine() != null) {
                lineCount++;
            }
            System.out.println("Количество строк: " + lineCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
