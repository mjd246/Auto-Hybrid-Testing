package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utils.HelperMethod;

public class UserRegistrationpage extends BasePage {

	public UserRegistrationpage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//div[@class='top-links']//ul[1]//li[1]")
	@CacheLookup
	private WebElement userLogin;

	@FindBy(xpath = "//a[normalize-space()='Sign Up!']")
	@CacheLookup
	private WebElement registerSignUp;

	@FindBy(xpath = "//input[@id='userFirstName']")
	@CacheLookup
	private WebElement firstName;

	@FindBy(xpath = "//input[@id='userMiddleName']")
	@CacheLookup
	private WebElement middleName;

	@FindBy(xpath = "//input[@id='userLastName']")
	@CacheLookup
	private WebElement lastName;

	@FindBy(xpath = "//input[@id='userEmail']")
	@CacheLookup
	private WebElement emaiL;

	@FindBy(xpath = "//input[@placeholder='*MOBILE NUMBER']")
	@CacheLookup
	private WebElement mobileNumber;

	@FindBy(xpath = "//input[@id='password']")
	@CacheLookup
	private WebElement passWord;

	@FindBy(xpath = "//input[@id='confirmPassword']")
	@CacheLookup
	private WebElement confirmPwd;

	@FindBy(xpath = "//label[@for='termsAndConditionCheckBox']")
	@CacheLookup
	private WebElement theTermsandCondi;

	@FindBy(xpath = "//button[@id='signUpBtn']")
	@CacheLookup
	private WebElement signUp;

	@FindBy(xpath = "//h4[normalize-space()='YOUR ORDERS']")
	@CacheLookup
	private WebElement yOURORDERS;

	@FindBy(xpath = "//span[@class='filter-option pull-left'][normalize-space()='MY ACCOUNT']")
	@CacheLookup
	private WebElement mYACCOUNT;

	@FindBy(xpath = "//span[normalize-space()='LOGOUT']")
	@CacheLookup
	private WebElement lOGOUT;

	public void clickUserLogin()

	{
		HelperMethod help = new HelperMethod(driver);
		help.waitforVisibility(userLogin, 10);
		help.ClickOn(userLogin);
	}

	public void clickRegisterSignUp()

	{
		HelperMethod help = new HelperMethod(driver);
		help.waitforVisibility(registerSignUp, 15);
		help.jsClick(registerSignUp);
	}

	public void enterFirstName(String value)

	{
		HelperMethod help = new HelperMethod(driver);
		help.waitforVisibility(firstName, 10);
		help.enterValue(firstName, value);
	}

	public void enterMidName(String value)

	{
		HelperMethod help = new HelperMethod(driver);
		help.enterValue(middleName, value);
	}

	public void enterLastName(String value)

	{
		HelperMethod help = new HelperMethod(driver);
		help.enterValue(lastName, value);
	}

	public void enterEmail(String value)

	{
		HelperMethod help = new HelperMethod(driver);
		help.enterValue(emaiL, value);
	}

	public void enterPwd(String value)

	{
		HelperMethod help = new HelperMethod(driver);
		help.enterValue(passWord, value);
	}

	public void enterMobNumber(String value)

	{
		HelperMethod help = new HelperMethod(driver);
		help.enterValue(mobileNumber, value);
	}

	public void enterConfirmPwd(String value)

	{
		HelperMethod help = new HelperMethod(driver);
		help.enterValue(confirmPwd, value);
	}

	public void clickTermsCondi()

	{
		HelperMethod help = new HelperMethod(driver);
		help.ClickOn(theTermsandCondi);

	}

	public void clickFinalSignUp()

	{
		HelperMethod help = new HelperMethod(driver);
		help.ClickOn(signUp);

	}

	public boolean locateYourOrder()

	{
		HelperMethod help = new HelperMethod(driver);
		help.waitforVisibility(yOURORDERS, 10);

		return yOURORDERS.isDisplayed();

	}

	public void clickLogout()

	{
		HelperMethod help = new HelperMethod(driver);	
		help.ClickOn(mYACCOUNT);
		help.waitforVisibility(lOGOUT, 5);
		help.ClickOn(lOGOUT);
	}

}
