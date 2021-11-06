package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScorllbyElementVisibleHorizantlly {
  @Test
  public void f() {
	  WebDriverManager.chromedriver().setup();
	  ChromeDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.navigate().to("http://demo.guru99.com/test/guru99home/scrolling.html");
	  JavascriptExecutor js=( JavascriptExecutor) driver;
	  WebElement a=driver.findElement(By.linkText("VBScript"));
	  js.executeScript("arguments[0].scrollIntoView()",a);
	  a.click();
  }
}
