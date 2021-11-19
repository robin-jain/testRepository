package ObjectRepository;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Libraries.BasicFunctions;

public class Login_Objects {

	WebDriver driver;
	BasicFunctions bs; 
	public  Login_Objects(WebDriver driver) {
		this.driver=driver;
		bs=new BasicFunctions(driver);
	}
	
	By type=By.name("q");
	By username1=By.xpath("");
	By gbutton=By.linkText("norsk");
	By btn=By.xpath("//*[@id=\"L2AGLb\"]/div");
	
	
	public void fn_SearchonGooglePage(String str) throws IOException {
		bs.fn_click(btn, "Click on Next button");
		bs.fn_sendKeys(type, str);
		//driver.findElement(type).sendKeys(str);	
		bs.fn_click(gbutton, "Click on Google Search button ");
	}




}
