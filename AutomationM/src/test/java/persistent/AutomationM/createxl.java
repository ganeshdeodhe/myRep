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

public class createxl {
	
	
  @Test
  public void f() throws BiffException, IOException, RowsExceededException, WriteException {
	  
	  WritableWorkbook book = Workbook.createWorkbook(new File("./src/test/java/posts.xls"));
	  WritableSheet s1 = book.createSheet("Mysheet", 0);
	 
	  Label l1 = new Label(1, 0, "This is Ganesh's fist Post");
	  s1.addCell(l1);
	  l1 = new Label(1, 1, "This is Ganesh's Second Cell");
	  s1.addCell(l1);
	  book.write();
	  book.close();
	  
  }  
	  
   
  
}
