package lr8;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.*;

public class Task3 {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://example.com/tasks").get(); 
            Elements taskLinks = doc.select("a.task-link");

            // Сохранение ссылок в файл
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("task_links.txt"))) {
                for (org.jsoup.nodes.Element link : taskLinks) {
                    writer.write(link.attr("href") + "\n");
                }
            }

            System.out.println("Ссылки сохранены в task_links.txt.");
        } catch (IOException e) {
            System.err.println("Ошибка подключения: " + e.getMessage());
        }
    }
}
