package lr7;

import java.io.*;

public class Example1_1 {
    public static void main(String[] args) {
        File folder = new File("src/lr8/example1/example_folder");
        File file = new File(folder, "example_file.txt");

        try {
            if (!folder.exists() && folder.mkdirs()) {
                System.out.println("Папка создана");
            }

            if (!file.exists() && file.createNewFile()) {
                System.out.println("Файл создан");
            }

            if (file.delete()) {
                System.out.println("Файл удален");
            }

            if (folder.delete()) {
                System.out.println("Папка удалена");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
