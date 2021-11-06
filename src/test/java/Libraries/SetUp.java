package Libraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetUp {

	public  WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;
	ExtentSparkReporter spartReport;

	public   Properties fn_loadpro() throws IOException {
		  File f=new File("C:\\Users\\HP PC\\Sele_Automa\\src\\test\\resources\\config\\globalConfig.properties");
		  FileInputStream FileInput =new FileInputStream(f);
		  Properties prop=new Properties();
		  prop.load(FileInput);
		  System.out.println(prop.getProperty("URL"));
		  return prop;
	  }

	
	//@BeforeMethod
	public  void startBrowser() throws IOException {
		Properties configProp =fn_loadpro();
		String browser=configProp.getProperty("browser");
		if(browser.equals("Chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			//driver.get("https://www.toolsqa.com/testng/testng-dataproviders/");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}else if(browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}else {
			System.out.println("Brower is not provided hence launching Chrome");
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			}
		}
	
	
	public void startReprt() {
		spartReport=new ExtentSparkReporter("Reports/Automation_Report.html");
		extent=new ExtentReports();
		extent.attachReporter(spartReport);
	}
	
	//@BeforeMethod
	public void method(Method method) {
		parentTest=extent.createTest(method.getName());
	}


	public void fn_tearDown() {
		driver.quit();
		//extent.flush();
	}
	
	@BeforeMethod
	public void f1() {
	System.out.println();	
	}

}
