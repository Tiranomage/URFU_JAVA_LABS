package lr7;

import java.io.*;

public class Task4 {
    public static void main(String[] args) throws IOException {
        File source = new File("source.txt");
        File dest = new File("dest.txt");

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("Файл скопирован");
        }
    }
}