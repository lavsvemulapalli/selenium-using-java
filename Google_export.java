package klm;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Google_export {

	@Test
	public void ge() throws Exception
	{
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date dt = new Date();
		FileOutputStream fos=new FileOutputStream("F:\\results\\" +dateFormat.format(dt) +".xls");
		WritableWorkbook wwb=Workbook.createWorkbook(fos);
		WritableSheet ws1=wwb.createSheet("Result1",0);
		WritableSheet ws2=wwb.createSheet("Result2",1);
		Label l1=new Label(0,0,"Selenium");
		ws1.addCell(l1);
		Label l2=new Label(0,1,"Appium");
		ws2.addCell(l2);
		wwb.write();
		wwb.close();
	}
	
}
