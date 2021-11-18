package Libraries;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class BasicFunctions {

	public WebDriver driver;
	
	
	public BasicFunctions(WebDriver driver) {
		this.driver=driver;
	}



	/**
	 * Used to Navigate to URL
	 * @param URL=Application URL
	 * @throws IOException 
	 */
	
	
	public void fn_get(String URL) throws IOException {
		
		try{
			driver.get(URL);
			SetUp.func_printlogPass("Navigated to URL"+ URL);
			
		} catch(Exception e) {
			SetUp.func_printlogFail("Not able to Navigate to URL"+ URL);
			SetUp.childTest.fail("Not able to click to Element",
					MediaEntityBuilder.createScreenCaptureFromBase64String(Screenshot()).build());
		}
		
	}



	/**
	 * Used to Click WebElement
	 * @param Locator=Application and Element name 
	 * @throws IOException 
	 */
	public void fn_click(By Locator, String elem) throws IOException {
		
		try{
			driver.findElement(Locator).click();
			SetUp.func_printlogPass("Successfully clicked on "+elem );;
		} catch(Exception e) {
			SetUp.func_printlogFail("Not able to Click to Elemenent"+ elem);
			SetUp.childTest.fail("Not able to click to Element",
					MediaEntityBuilder.createScreenCaptureFromBase64String(Screenshot()).build());
		}
		
	}

	public String Screenshot() {
		return ((TakesScreenshot )driver).getScreenshotAs(OutputType.BASE64);
	}

}	
