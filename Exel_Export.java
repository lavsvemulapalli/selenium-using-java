package klm;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Exel_Export {
	@Test
	public void data() throws Exception {
		DateFormat det=new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date dt=new Date();
		
		FileOutputStream fos=new FileOutputStream("F:\\results\\" +det.format(dt)+".xls");
		WritableWorkbook wwb=Workbook.createWorkbook(fos);
		WritableSheet ws1=wwb.createSheet("lavanya", 0);
		WritableSheet ws2=wwb.createSheet("bharth", 1);
		Label l1=new Label(0,0,"java");
		ws1.addCell(l1);
		Label l2=new Label(0,1,"lovesbharath");
		ws1.addCell(l2);
		Label l3=new Label(0,0,"naya");
		ws2.addCell(l3);
		Label l4=new Label(0,1,"vanya");
		ws2.addCell(l4);
		wwb.write();
		wwb.close();
	
		
		
		
	}

}
