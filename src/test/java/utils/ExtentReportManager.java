package utils;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import runner.Base;

public class ExtentReportManager extends Base implements ITestListener {

	public WebDriver driver;
	public ExtentSparkReporter sparkreport;
	public ExtentReports report;
	public ExtentTest test;

	String repName;
	

	public void onStart(ITestContext context) {

		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		repName = "Report." + timestamp + ".html";

		// create report inside the project directory
		sparkreport = new ExtentSparkReporter(System.getProperty("user.dir") + "\\reports\\" + repName);

		sparkreport.config().setDocumentTitle("WorldArt Automation Report");
		sparkreport.config().setReportName("WorldArt Functional Test Report");
		sparkreport.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(sparkreport);
		report.setSystemInfo("Application", "WordlArt");
		report.setSystemInfo("Module", "User");
		report.setSystemInfo("Os", "Windows");
		report.setSystemInfo("User Name", "Manoj Kumar Devaraj");
		report.setSystemInfo("Environemnt", "QA");

	}

	public void onTestSuccess(ITestResult result) {
		test = report.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups()); // to display groups in report
		test.log(Status.PASS, result.getName() + " got successfully executed");
	}

	public void onTestFailure(ITestResult result) {
		test = report.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName() + " got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());

		String Screenshotpath = ScreenShot.AttachScreenShot();
		try {
			test.addScreenCaptureFromPath(Screenshotpath);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		test = report.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName() + " got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}

	public void onFinish(ITestContext context) {

		report.flush();
		
		String pathOfExtentReport = System.getProperty("user.dir") + "\\reports\\" + repName;
		File extentReport = new File(pathOfExtentReport);

		try {
		    Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		try {
			String reportpath = System.getProperty("user.dir") + "\\reports\\" + repName;
			SecureEmailSender.sendEmailWithReport(reportpath, "mjd246official@gmail.com");
		} catch (Exception e) {
			
		}


	}

}
