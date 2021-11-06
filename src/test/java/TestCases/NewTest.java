package TestCases;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() throws IOException  {
	  FileReader reader=new FileReader("C:\\Users\\HP PC\\Sele_Automa\\src\\main\\resources\\config\\globalConfig.properties");
	  Properties p=new Properties();  
	    p.load(reader);  
	      
	    System.out.println(p.getProperty("URL"));
	    
	    
  }
}
