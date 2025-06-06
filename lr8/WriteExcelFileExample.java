package lr8;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class WriteExcelFileExample {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet("Товары");

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Товар");
        headerRow.createCell(1).setCellValue("Характеристики");
        headerRow.createCell(2).setCellValue("Стоимость");

        Row dataRow1 = sheet.createRow(1);
        headerRow.createCell(0).setCellValue("Книга");
        headerRow.createCell(1).setCellValue("Жанр: Фантастика, Автор: Иванов И.И.");
        headerRow.createCell(2).setCellValue(500.0);

        Row dataRow2 = sheet.createRow(2);
        headerRow.createCell(0).setCellValue("Компьютер");
        headerRow.createCell(1).setCellValue("Процессор: Intel Core i5, Оперативная память: имеется");
        headerRow.createCell(2).setCellValue(25000.0);

        String filePath = "java_ex/r8/example3.xlsx";
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        System.out.println("Данные записаны в файл: " + filePath);
    }
}
