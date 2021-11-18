package TestCases;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import Data.DataIn;
import Libraries.BasicFunctions;
import Libraries.SetUp;
import ObjectRepository.Login_Objects;

public class TC_001 extends SetUp{


	
	@Test(dataProvider ="getData",dataProviderClass=DataIn.class)
  public void TC_001_loginandVerify(Map <Object, Object>map) throws IOException {
		System.out.println("This is done");	
		startBrowser();
		BasicFunctions bs=new BasicFunctions(driver);
		Login_Objects ls=new Login_Objects(driver);
		bs.fn_get("https://www.google.com/");
		ls.fn_TestgetUR("This is");
		 System.out.println("Welcome ->"+map.get("TestCaseName")+" Your search key is->"+map.get("userid"));
		
		fn_tearDown();
  }
}