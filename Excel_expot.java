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

public class Excel_expot {

	@Test
	public void ee() throws Exception
	{
		DateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date dt = new Date();
		FileOutputStream fos=new FileOutputStream("F:\\results\\" +dt1.format(dt) +".xls");
		WritableWorkbook wb1=Workbook.createWorkbook(fos);
		WritableSheet ws1=wb1.createSheet("lavanya", 0);
		WritableSheet ws2=wb1.createSheet("bharath", 1);
		Label l1=new Label(0,0,"");
		ws1.addCell(l1);
		Label l2=new Label(0,1,"java");
		ws1.addCell(l2);
		
		Label l3=new Label(0,0,"loves");
		ws2.addCell(l3);
		Label l4=new Label(0,1,"bharu");
		wb1.write();
		wb1.close();
		
	}
	
	
	
}
