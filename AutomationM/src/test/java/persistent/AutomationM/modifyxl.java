package persistent.AutomationM;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class modifyxl {
	
	
  @Test
  public void f() throws BiffException, IOException, RowsExceededException, WriteException {
	  Workbook old = Workbook.getWorkbook(new File("./src/test/java/Book1.xls"));
	  
	  WritableWorkbook newb = Workbook.createWorkbook(new File("./src/test/java/Book3.xls"), old);
	  WritableSheet s1 = newb.getSheet("master");
	 
	  Label l1 = new Label(2, 0, "Addr");
	  s1.addCell(l1);
	  
	  l1 = new Label(2, 1, "Pune");
	  s1.addCell(l1);
	
	  l1 = new Label(2, 2, "Solapur");
	  s1.addCell(l1);
	  
	  l1 = new Label(2, 3, "Nashik");
	  s1.addCell(l1);
	  
	  newb.write();
	  newb.close();
	  old.close();
	  
  }  
	  
   
  
}
