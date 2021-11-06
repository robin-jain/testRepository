package Libraries;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.MediaEntityBuilder;

public class BasicFunctions {

	public WebDriver driver;
	

	public BasicFunctions(WebDriver driver) {
		this.driver=driver;
	}



	/**
	 * Used to Navigate to URL
	 * @param URL=Application URL
	 */
	
	
	public void fn_get(String URL) {
		
		try{
			driver.get(URL);
			//SetUp.childTest.pass("Navigated to URL"+ URL);
		} catch(Exception e) {
			//SetUp.childTest.fail("Not able to  navigate to URL"+ URL);
		}
		
	}



	/**
	 * Used to Click WebElement
	 * @param Locator=Application and Element name 
	 */
	public void fn_click(By Locator, String elem) {
		
		try{
			driver.findElement(Locator).click();
			//SetUp.childTest.pass("Successfully cliced to Element "+ elem);
		} catch(Exception e) {
			//SetUp.childTest.fail("Not able to click to Element"+ elem,
					//MediaEntityBuilder.createScreenCaptureFromBase64String(Screenshot()).build());
			//SetUp.childTest.info(e);
		}
		
	}

	public String Screenshot() {
		return ((TakesScreenshot )driver).getScreenshotAs(OutputType.BASE64);
	}

}	
