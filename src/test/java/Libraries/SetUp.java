package Libraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetUp {

	public  WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;
	ExtentHtmlReporter htmlReport;
	//String method;

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
	
	@BeforeTest
	public void startReprt() {
		htmlReport=new ExtentHtmlReporter("Reports/Automation_Report.html");
		extent=new ExtentReports();
		extent.attachReporter(htmlReport);
		htmlReport.config().setReportName("Regression Reprot");
	}
	
	@BeforeMethod
	public void method(Method method) {
		parentTest=extent.createTest(method.getName());
		
		
	}

	public static void func_printlogPass(String str) {
		childTest=parentTest.createNode(str);
		childTest.log(Status.PASS, MarkupHelper.createLabel(str, ExtentColor.BLUE));
		
	}
	public static void func_printlogFail(String str) {
		childTest=parentTest.createNode(str);
		childTest.log(Status.FAIL, MarkupHelper.createLabel(str, ExtentColor.BLUE));
		
	}
	public void fn_tearDown() {
		driver.close();
		
	}
	@AfterSuite
	public void fn_Suit() {
	extent.flush();
	}
	
	@BeforeMethod
	public void f1() {
	System.out.println();	
	}

}
