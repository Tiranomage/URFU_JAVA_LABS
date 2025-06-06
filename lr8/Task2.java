package lr8;

import org.json.simple.*;
import org.json.simple.parser.*;
import java.io.*;

public class Task2 {
    public static void main(String[] args) throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("tasks.json"));
        JSONArray tasks = (JSONArray) jsonObject.get("tasks");

        // Добавление новой задачи
        JSONObject newTask = new JSONObject();
        newTask.put("id", "3");
        newTask.put("title", "Документация");
        newTask.put("description", "Написать техническое описание");
        newTask.put("deadline", "2023-10-30");
        newTask.put("status", "Не начата");
        tasks.add(newTask);

        // Поиск задач по статусу
        tasks.stream()
             .filter(task -> ((JSONObject) task).get("status").equals("В процессе"))
             .forEach(System.out::println);

        // Удаление задачи по ID
        tasks.removeIf(task -> ((JSONObject) task).get("id").equals("2"));

        // Сохранение изменений
        try (FileWriter writer = new FileWriter("tasks.json")) {
            writer.write(jsonObject.toJSONString());
        }

        System.out.println("JSON-файл обновлен.");
    }
}
