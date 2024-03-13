package runner;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.j2objc.annotations.Property;

import pages.UserRegistrationpage;
import utils.DataProviderMethod;
import utils.ExcelReader;

public class Test_RegistrationCheck extends Base {

	ExcelReader exl;

	@Test(dataProvider = "exceldata", dataProviderClass = DataProviderMethod.class)

	public void testScenario1_Ts1_ResistrationCheck(String firstname, String midname, String lastname, String email,
			String phn, String pwd) {

		logger.info("testScenario1_Ts1_ResistrationCheck--------STARTS");

		try {

			UserRegistrationpage usP = new UserRegistrationpage(driver);

			usP.clickUserLogin();

			logger.info("Clicked UserLogin");

			usP.clickRegisterSignUp();

			logger.info("Clicked Sign up inside Sign in page");

			usP.enterFirstName(firstname);

			logger.info("Entered the Firstname:  " + firstname);

			usP.enterMidName(midname);

			logger.info("Entered the Middlename:  " + midname);

			usP.enterLastName(lastname);

			logger.info("Entered the LastName:  " + lastname);

			usP.enterEmail(email + "@gmail.com");

			logger.info("Entered the Email:  " + email);

			usP.enterMobNumber(phn);

			logger.info("Entered the PhoneNumber:  " + phn);

			usP.enterPwd(pwd);

			logger.info("Entered the Password:  " + pwd);

			String confirmpwd = pwd;

			usP.enterConfirmPwd(confirmpwd);

			logger.info("Entered the Confirm Password:  " + confirmpwd);

			usP.clickTermsCondi();

			logger.info("Clicked The Terms and Condition");

			usP.clickFinalSignUp();

			logger.info("Clicked on Final Sign Up button");

			boolean locate = usP.locateYourOrder();

			if (locate == true)

			{
				Assert.assertEquals(locate, true);
				logger.info("Founded the OrdersPage");
				usP.clickLogout();
			}

			else {
				Assert.fail();
				logger.error("Not entered the OrdersPage");
			}

		} catch (Exception e) {
			Assert.fail();
			logger.error("testScenario1_Ts1_ResistrationCheck-FAILED");
		}

		logger.info("testScenario1_Ts1_ResistrationCheck--------ENDS");

	}

}
