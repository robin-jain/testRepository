package TestCases;


import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChildWindow {
  @Test
  public void f() {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver =new ChromeDriver();
	  driver.get("http://demo.guru99.com/test/guru99home/");
	  
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  WebElement e=driver.findElement(By.linkText("Pinterest"));
	  js.executeScript("arguments[0].scrollIntoView()", e);
	
	  e.click();
	  Set <String> windows=driver.getWindowHandles();
	  for (String s: windows) {
		  driver.switchTo().window(s);
		System.out.println(  driver.getTitle());
	  }
	  
	  
  }
}
