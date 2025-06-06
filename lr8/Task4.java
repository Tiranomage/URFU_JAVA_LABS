package lr8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Задачи");

            // Заголовки
            Row headerRow = sheet.createRow(0);
            String[] headers = {"ID", "Название", "Описание", "Дедлайн", "Статус"};
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }

            // Данные
            Object[][] data = {
                {1, "Создать проект", "Разработать MVP", "2023-10-20", "В процессе"},
                {2, "Тестирование", "Проверка модулей", "2023-10-25", "Не начата"}
            };

            int rowNum = 1;
            for (Object[] rowData : data) {
                Row row = sheet.createRow(rowNum++);
                int colNum = 0;
                for (Object field : rowData) {
                    Cell cell = row.createCell(colNum++);
                    if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    } else {
                        cell.setCellValue((String) field);
                    }
                }
            }

            try (FileOutputStream fos = new FileOutputStream("tasks.xlsx")) {
                workbook.write(fos);
            }

            System.out.println("Excel-файл создан.");
        } catch (IOException e) {
            System.err.println("Ошибка работы с Excel: " + e.getMessage());
        }
    }
}
