package lr7;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Example1_5 {
    public static void main(String[] args) throws IOException {
        String inputPath = "input.txt";
        String outputPath = "output.txt";

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(inputPath), StandardCharsets.UTF_8));
             BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(outputPath), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toUpperCase());
                writer.newLine();
            }
            System.out.println("Данные преобразованы и записаны");
        }
    }
}
