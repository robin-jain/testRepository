package TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Screenshot {
  @Test
  public void f() throws IOException {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  File scresnshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyDirectory(scresnshot, new File(""));
	 // Iterator<String> itr=
  }
}
