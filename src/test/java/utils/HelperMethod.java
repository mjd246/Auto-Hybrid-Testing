package utils;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class HelperMethod extends BasePage

{

	JavascriptExecutor js;

	public HelperMethod(WebDriver driver) {
		super(driver);

	}

	
	public void hoverOver(WebElement element) {
		try {

			Actions act = new Actions(driver);
			act.moveToElement(element).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void enterValue(WebElement element, String value)

	{
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterValue(WebElement element, Keys key)// method overloading

	{

		try {
			element.sendKeys(key);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void ClickOn(WebElement element)

	{

		try {
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void jsClick(WebElement element)

	{

		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void waitforVisibility(WebElement element, int sec)

	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));

		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
