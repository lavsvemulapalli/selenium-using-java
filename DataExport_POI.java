package klm;

import static org.testng.Assert.assertThrows;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DataExport_POI {
	@Test
	public void dataExport() throws Exception
	{
		FileOutputStream fos=new FileOutputStream("F:\\results\\data123.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet s=wb.createSheet("lavanya");
		Row r1=s.createRow(0);
		r1.createCell(0).setCellValue("java");
		r1.createCell(1).setCellValue("webservices");
		Row r2=s.createRow(1);
		r2.createCell(0).setCellValue("appium");
		r2.createCell(1).setCellValue("bharath");
		Row r3=s.createRow(2);
		r3.createCell(0).setCellValue("abc");
		r3.createCell(1).setCellValue("raja");
		wb.write(fos);
		fos.close();
	
	}

}
