package runner;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import utils.ScreenShot;

public class TestCheck extends Base {

	ScreenShot sc = new ScreenShot();

	@Test

	public void check() {
		
		if(driver.findElement(By.xpath("(//img[@alt='World Art Community'])[3]")).isDisplayed())
			
		{
			System.out.println("Hello");
			ScreenShot.captureScreenShot();
		}
		

	}

}
