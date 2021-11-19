package TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_010_PropertyExample {
  @Test
  public void f() throws IOException {
	  File f=new File("C:\\Users\\HP PC\\Sele_Automa\\src\\test\\resources\\config\\globalConfig.properties");
	  FileInputStream FileInput =new FileInputStream(f);
	  Properties prop=new Properties();
	  prop.load(FileInput);
	  String browser=prop.getProperty("URL");
	  
	  if(browser.equals("Chrome")){
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.toolsqa.com/testng/testng-dataproviders/");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}else if(browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}else {
			System.out.println("Brower is not provided hence launching Chrome");
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			}
  }
}
