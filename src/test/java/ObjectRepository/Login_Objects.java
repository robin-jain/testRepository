package ObjectRepository;
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
	By gbutton=By.xpath("//input[@value='Google Search']");
	By btn=By.xpath("//*[@id=\"L2AGLb\"]/div");
	
	
	public void fn_TestgetUR(String str) {
		bs.fn_click(btn, "thisa");
		driver.findElement(type).sendKeys(str);	
		bs.fn_click(gbutton, "this is ");
	}




}
