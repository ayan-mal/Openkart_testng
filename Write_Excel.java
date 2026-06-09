package Testing_practice;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write_Excel {

    public static void main(String[] args) throws Exception {

        // Create Workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        // Create Sheet
        XSSFSheet sheet = workbook.createSheet("Sheet1");

        // Create Row 0 (Header)
        XSSFRow row0 = sheet.createRow(0);

        row0.createCell(0).setCellValue("Username");
        row0.createCell(1).setCellValue("Password");

        // Create Row 1
        XSSFRow row1 = sheet.createRow(1);

        row1.createCell(0).setCellValue("Ayan");
        row1.createCell(1).setCellValue("ayan123");

        // Create Row 2
        XSSFRow row2 = sheet.createRow(2);

        row2.createCell(0).setCellValue("Rahul");
        row2.createCell(1).setCellValue("rahul123");

        // File Path
        FileOutputStream file = new FileOutputStream(
        		"D:\\Wipro Java Selenium\\TestNG_selenium\\TestData\\WriteData.xlsx");

        // Write data into Excel
        workbook.write(file);

        // Close workbook and file
        workbook.close();
        file.close();

        System.out.println("Data Written Successfully");
    }
}