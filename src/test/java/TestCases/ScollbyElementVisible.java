package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScollbyElementVisible {
  @Test
  public void f() {

	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://demo.guru99.com/test/guru99home/");
	  JavascriptExecutor js =(JavascriptExecutor) driver;
	  
	  WebElement a=driver.findElement(By.linkText("Pinterest"));
	
	  js.executeScript("arguments[0].scrollIntoView();", a);
	  a.click();
	  
 }

}
