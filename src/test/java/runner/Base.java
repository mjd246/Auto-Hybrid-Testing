package runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Base {

	public static WebDriver driver;

	public static Properties prop;
	public static FileInputStream file;
	public static Logger logger;

	// @BeforeClass

	@BeforeMethod
	@Parameters({ "browser" })

	public void setUp(String brow) throws IOException {

		logger = LogManager.getLogger(this.getClass());

		// Properties file setup
		try {
			String filepath = System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\common.properties";
			file = new FileInputStream(filepath);
			prop = new Properties();
			prop.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// browser setup
		switch (brow) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Browser Not Found");
			break;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("siteUrl"));
		logger.info("Browser opened and Url Loaded");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));

	}

	@AfterMethod
	// @AfterClass

	public void tearDown() {

		driver.quit();
	}

	// @AfterClass

//	public void tearDown() {
//		
//		driver.quit();
//}
}
