package lr8;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class Task1 {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("tasks.xml"));

        // Добавление новой задачи
        Element newTask = createTask(doc, "3", "Документация", "Написать техническое описание", "2023-10-30", "Не начата");
        doc.getDocumentElement().appendChild(newTask);

        // Сохранение изменений
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("tasks.xml"));
        transformer.transform(source, result);

        // Поиск задач по статусу
        NodeList tasks = doc.getElementsByTagName("task");
        List<Element> inProgressTasks = new ArrayList<>();
        for (int i = 0; i < tasks.getLength(); i++) {
            Element task = (Element) tasks.item(i);
            if (task.getElementsByTagName("status").item(0).getTextContent().equals("В процессе")) {
                inProgressTasks.add(task);
            }
        }

        // Удаление задачи по ID
        for (int i = 0; i < tasks.getLength(); i++) {
            Element task = (Element) tasks.item(i);
            if (task.getElementsByTagName("id").item(0).getTextContent().equals("2")) {
                task.getParentNode().removeChild(task);
            }
        }

        System.out.println("XML-файл обновлен.");
    }

    private static Element createTask(Document doc, String id, String title, String description, String deadline, String status) {
        Element task = doc.createElement("task");
        task.appendChild(createElement(doc, "id", id));
        task.appendChild(createElement(doc, "title", title));
        task.appendChild(createElement(doc, "description", description));
        task.appendChild(createElement(doc, "deadline", deadline));
        task.appendChild(createElement(doc, "status", status));
        return task;
    }

    private static Element createElement(Document doc, String tagName, String text) {
        Element element = doc.createElement(tagName);
        element.appendChild(doc.createTextNode(text));
        return element;
    }
}
