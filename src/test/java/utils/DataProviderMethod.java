package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import pages.BasePage;
import runner.Base;

public class DataProviderMethod {

	ExcelReader exl;

	@DataProvider(name = "exceldata")

	public Object[][] readdata() throws IOException

	{
		String path = System.getProperty("user.dir") + "\\testdata\\ecommerce.xlsx";
		System.out.println(path);
		exl = new ExcelReader();
		return exl.getAllData(path, "Sheet2");

	}

}
