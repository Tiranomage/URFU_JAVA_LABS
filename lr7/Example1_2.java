package lr7;

import java.io.*;

public class Example1_2 {
    public static void main(String[] args) {
        String data = "Hello, byte streams!";
        File file = new File("example_file.txt");

        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(data.getBytes());
            System.out.println("Данные записаны");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, bytesRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (file.delete()) System.out.println("Файл удален");
    }
}
