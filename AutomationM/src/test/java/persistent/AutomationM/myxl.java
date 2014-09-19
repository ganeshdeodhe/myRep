package persistent.AutomationM;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class myxl {
	
	
  @Test
  public void f() throws BiffException, IOException, InterruptedException {
	  
	  Workbook book = Workbook.getWorkbook(new File("./src/test/java/Book3.xls"));
	  Sheet s1 = book.getSheet("master");
	  System.out.println(s1.getColumns());
	  System.out.println(s1.getRows());
	  String data;
	  
	  System.out.println("======Prinitng .xls File Data=========");
	  
	  int i=0,j;
	  String title="",post="";
	  		  for(j=1;j<s1.getRows();j++){
			  System.out.println(" Loop: "+j);
			  title = s1.getCell(i, j).getContents();
			  post = s1.getCell(i+1, j).getContents();
			  System.out.print(title);
			  System.out.print(post);
			  System.out.println("");
			 
		  }
	  //}
	  book.close();
	  Thread.sleep(20000);
	    
  }
  
   
}
