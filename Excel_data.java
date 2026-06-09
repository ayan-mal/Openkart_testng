package Testing_practice;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

// access file(read file)
//sheet
//row
//column

public class Excel_data {

// DataProvider Method

@DataProvider(name = "loginData")

public Object[][] getData() throws Exception {
FileInputStream file =new FileInputStream("D:\\Wipro Java Selenium\\TestNG_selenium\\TestData\\LoginData.xlsx");
XSSFWorkbook workbook =new XSSFWorkbook(file);

XSSFSheet sheet =workbook.getSheet("Sheet1");

 int rows = sheet.getPhysicalNumberOfRows();// total rpws count=4
 int cols = sheet.getRow(0).getLastCellNum();// 0....4
Object[][] data = new Object[rows - 1][cols];

for (int i = 1; i < rows; i++) {
 for (int j = 0; j < cols; j++) {

data[i - 1][j] =
sheet.getRow(i).getCell(j).toString();

 }
 }
 workbook.close();
return data;

}
// Test Method

@Test(dataProvider = "loginData")

public void loginTest(String user1,
 String pass1) {

System.out.println("Username : " + user1);
System.out.println("Password : " + pass1);
 System.out.println("Login Successful");
}
}