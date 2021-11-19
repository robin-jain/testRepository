package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import Libraries.BasicFunctions;
import Libraries.SetUp;
import ObjectRepository.Login_Objects;

public class TC_002 extends SetUp{


	
	@Test
  public void TC_001_loginandVerify() throws IOException {
		System.out.println("This is done");	
		startBrowser();
		BasicFunctions bs=new BasicFunctions(driver);
		Login_Objects ls=new Login_Objects(driver);
		bs.fn_get("https://www.google.com/");
		ls.fn_SearchonGooglePage("Robin Jain");
		
		fn_tearDown();
  }
}