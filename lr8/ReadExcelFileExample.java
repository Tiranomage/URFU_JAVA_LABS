package lr8;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelFileExample {
    public static void main(String[] args) throws IOException {
        String filePath = "example.xlsx";
        FileInputStream inputStream = new FileInputStream(filePath);

        XSSFWorkobook workbook = new XSSFWorkobook(inputStream);

        XSSFSheet sheet = workbook.getSheet("Товары");

        for (Row row : sheet) {
            for (Cell cell : row) {
                System.out.print(cell.toString() + "\t");
            }
            System.err.println();
        }

        workbook.close();
        inputStream.close();
    }
}
