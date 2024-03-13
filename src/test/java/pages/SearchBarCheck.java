package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import jdk.internal.org.jline.utils.Log;
import utils.HelperMethod;

public class SearchBarCheck extends BasePage {

	public SearchBarCheck(WebDriver driver) {
		super(driver);
		
	}


	@FindBy(xpath = "//a/i[@class='fa fa-search']")
	WebElement searchBar;

	@FindBy(xpath = "//div/input[@id='searchFieldVal']")
	WebElement searchBox;
	
	@FindBy(xpath = "(//div[@class='over-item cursor-pointer'])[1]")
	WebElement hoverProduct;
	
	@FindBy(xpath = "(//a[text()='VIEW DETAIL'])[1]")
	WebElement viewDetail;
	

	public void hoverSearchBar()

	{
		/*
		Actions act = new Actions(driver);
		act.moveToElement(searchBar).perform();
		*/
		HelperMethod help = new HelperMethod(driver);
		help.hoverOver(searchBar);	
		
	}

	public void searchProduct() throws InterruptedException

	{
		HelperMethod help = new HelperMethod(driver); //passing the driver with the help of constructor
		
		help.enterValue(searchBox, "watches");
	
		help.enterValue(searchBox, Keys.ENTER);
		
		
	
	}
	
	public void hoverProduct1()
	
	{
		HelperMethod help = new HelperMethod(driver); 
		help.hoverOver(hoverProduct);
	}
	
	public void viewDetailClick()
	
	{
		HelperMethod help = new HelperMethod(driver);
		
		help.waitforVisibility(viewDetail, 10); //implemented Explicit wait
		help.ClickOn(viewDetail);
	}
	
	

}
