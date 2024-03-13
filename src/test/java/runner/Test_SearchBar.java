package runner;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

import pages.SearchBarCheck;

public class Test_SearchBar extends Base {

	@Test(priority = 1)
	public void testScenario2_Ts2_SearchFunctionality() throws InterruptedException

	{
		SearchBarCheck sbc = new SearchBarCheck(driver);

		sbc.hoverSearchBar();
		logger.info("Hover over searchbar");
		sbc.searchProduct();
		logger.info("Values Entered");

	}

	@Test(priority = 2, dependsOnMethods = { "testScenario2_Ts2_SearchFunctionality" })

	public void testScenario2_Ts2_HoverAndClick() throws InterruptedException {
		SearchBarCheck sbc = new SearchBarCheck(driver);

		sbc.hoverSearchBar();
		sbc.searchProduct();
		sbc.hoverProduct1();
		sbc.viewDetailClick();

	}
}
