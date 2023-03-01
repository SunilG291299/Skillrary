package genaricLibrary;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import POMpages.ContactUsPage;
import POMpages.CoreJavaForSeleniumPage;
import POMpages.CoreJavaVideoPage;
import POMpages.HomePage;
import POMpages.SeleniumTraningPage;
import POMpages.SkillraryDemoAppPage;
import POMpages.TestingPage;

public class BaseClass {

	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected WebDriverUtility web;
	protected WebDriver driver;
	protected HomePage home;
	protected SkillraryDemoAppPage demoApp;
	protected SeleniumTraningPage selenium;
	protected TestingPage testing;
	protected CoreJavaForSeleniumPage corejava;
	protected CoreJavaVideoPage javaVideo;
	protected ContactUsPage contact;

	// @BeforeSuite
	// @BeforeTest

	@BeforeClass
	public void classConfiguration() {
		property = new PropertiesUtility();
		excel = new ExcelUtility();
		web = new WebDriverUtility();

		property.propertiesInitialization(IConstantPath.PROPERTIES_FILE_PATH);
		excel.excelInitialization(IConstantPath.EXCEL_FILE_PATH);
	}

	@BeforeMethod
	public void methodConfiguration() {
		long time = Long.parseLong(property.fetchProperty("timeouts"));
		driver = web.openApplication(property.fetchProperty("browser"), property.fetchProperty("url"), time);

		home = new HomePage(driver);
		Assert.assertTrue(home.getLogo().isDisplayed());
		
		demoApp = new SkillraryDemoAppPage(driver);
		selenium = new SeleniumTraningPage(driver);
		corejava = new CoreJavaForSeleniumPage(driver);
		javaVideo = new CoreJavaVideoPage(driver);
		testing = new TestingPage(driver);
		contact = new ContactUsPage(driver);
	}

	@AfterMethod
	public void methodTearDown() {
		web.qiutBrowser();
	}

	@AfterClass
	public void classTearDown() {
		excel.closeExcel();
	}

	
	// @AfterTest
	//  @AfterSuite

}

