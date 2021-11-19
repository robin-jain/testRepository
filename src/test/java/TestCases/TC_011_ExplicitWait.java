package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_011_ExplicitWait {
	
	@Test
	public void fn() {
		
	
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  WebDriverWait wait=new WebDriverWait(driver, 20);
	  WebElement a=wait.until(ExpectedConditions.visibilityOfElementLocated( (By) driver.findElement(By.className(""))));
	  a.click();
	}  

}
