package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class DataIn {
  @DataProvider
  public static Object [] []  getData(Method m) throws IOException {
	  System.out.println(m.getName());
	  File filePath=new File("C://Users//HP PC//Sele_Automa//src//test//java//Data//TestData.xlsx");
	  FileInputStream fis=new FileInputStream(filePath);
	  
	  XSSFWorkbook  wb=new XSSFWorkbook (fis);
	  XSSFSheet ws=wb.getSheet("TestCasesFlag");
	 
	  
	  int maxRow=ws.getLastRowNum();
	  int maxCol=ws.getRow(0).getLastCellNum();
	
	  Map<Object, Object> datamap = new HashMap<>();
	  Object[][] obj = new Object[maxRow][1];
	    for (int i = 0; i < maxRow; i++) {
	        for (int j = 0; j < maxCol; j++) {
	        	//datamap.put(ws.getRow(0).getCell(j).toString(), ws.getRow(i+1).getCell(j).toString());
	        	if (ws.getRow(i+1).getCell(j).toString().equalsIgnoreCase(m.getName())) {
	        		if (ws.getRow(i+1).getCell(j+1).toString().equalsIgnoreCase("True")) {
	        			System.out.println("Reached");
	        			XSSFSheet wsSheet2=wb.getSheet("Data");
	        			   int maxRowSheet2=wsSheet2.getLastRowNum();
	        			   int maxColSheet2=wsSheet2.getRow(0).getLastCellNum();
	        			   Object[][] obj1= new Object[maxRowSheet2][1];
	        			  for (int x=0;x<maxRowSheet2;x++) {
	        				  
	        				  for (int y=0;y<maxColSheet2;y++) {
	        					  if (wsSheet2.getRow(x+1).getCell(y).toString().equalsIgnoreCase(m.getName())) {
	        						while (y<maxColSheet2) {
	        							  datamap.put(wsSheet2.getRow(0).getCell(y).toString(), wsSheet2.getRow(x+1).getCell(y).toString());  
	        							  y=y+1;
	        							}obj1[x][0] = datamap;
	        							obj=obj1;
	        					  }	
	        					  
	        				  }
	        				  
	        				  
	        				  
	        			  }
	        			  
	        			 
	        		}
	        	}	
	        	
	        	
	        }
	        

	      }
	      return  obj;
	    }
}
