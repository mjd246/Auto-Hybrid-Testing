package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

import pages.BasePage;
import runner.Base;

public class ScreenShot extends Base {

	static TakesScreenshot ts;
	String fileName;

	public static void captureScreenShot() {

		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String filename = "Screenshot." + timestamp + ".png";
		ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "\\screenshots\\" + filename);
		try {
			Files.copy(file, target);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String AttachScreenShot() {

		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String filename = "Screenshot." + timestamp + ".png";
		ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		String screenshotpath = System.getProperty("user.dir") + "\\screenshots\\" + filename;
		File target = new File(System.getProperty("user.dir") + "\\screenshots\\" + filename);
		try {
			Files.copy(file, target);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshotpath;

	}

}
