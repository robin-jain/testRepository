import java.sql.Driver;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_001_Setup {

	public static void main(String args []) {
		//ChromeOptions chromeOptions = new ChromeOptions();
			//WebDriverManager.chromedriver().setup();
			//WebDriver driver = new ChromeDriver();
			//driver.get("https://www.facebook.com/");
			//driver.findElement(By.className("")).click();
			//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//driver.quit();
		LocalDateTime strtime=java.time.LocalDateTime.now();
		
		String str1= "Reports/Automation_Report"+strtime+".html";
		System.out.println(str1);  
	}	
}

