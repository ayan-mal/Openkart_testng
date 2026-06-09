package Testing_practice;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

	public class WriteExcel_usingDataProviders {

	    // DataProvider
	    @DataProvider(name = "data")
	    public Object[][] dp1() {

	        return new Object[][] {

	                {"username", "password"},
	                {"invalid", "password"},
	                {"username", "2345678"},
	                {"invalid", "invalid"}

	        };
	    }

	    // Test Method
	    @Test(dataProvider = "data")
	    public void writeData(String username1, String password1) throws Exception {

	        // Create Workbook
	        XSSFWorkbook workbook = new XSSFWorkbook();

	        // Create Sheet
	        XSSFSheet sheet = workbook.createSheet("LoginData");

	        // Header Row
	        XSSFRow header = sheet.createRow(0);

	        header.createCell(0).setCellValue("Username");
	        header.createCell(1).setCellValue("Password");

	        // Calling DataProvider Method
	        Object[][] data = dp1();

	        // Writing Data into Excel
	        for (int i = 0; i < data.length; i++) {

	            XSSFRow row = sheet.createRow(i + 1);

	            row.createCell(0).setCellValue(data[i][0].toString());
	            row.createCell(1).setCellValue(data[i][1].toString());
	        }

	        // File Path
	        FileOutputStream file = new FileOutputStream
	        		("D:\\Wipro Java Selenium\\TestNG_selenium\\TestData\\WriteData.xlsx");

	        // Write Data
	        workbook.write(file);

	        // Close
	        workbook.close();
	        file.close();

	        System.out.println("Data Written Successfully");
	        System.out.println("Username : " + username1);
	        System.out.println("Password : " + password1);
	    }
	}