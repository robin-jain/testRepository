package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_001_VerifyLogin {
  @Test
  public void f() {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver =new ChromeDriver();
	  driver.get("https://www.google.com/");
	  System.out.println(driver.findElement(By.id("L2AGLb")).isDisplayed());
	  System.out.println(driver.findElement(By.id("L2AGLb")).isEnabled());
	  Assert.assertTrue(driver.findElement(By.id("L2AGLb")).isEnabled());
	  driver.findElement(By.id("L2AGLb")).click();
	  
  }
}
