package POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genaricLibrary.WebDriverUtility;

public class SkillraryDemoAppPage {

//	Deceleration 
	@FindBy(xpath = "//div[@class='navbar-header']")
	private WebElement pageHeader;

	@FindBy(id = "course")
	private WebElement courseTab;

	@FindBy(xpath = "//span[@class='wrappers']/a[text()='Selenium Training']")
	private WebElement seleniumTrainingLink;

	@FindBy(xpath = "//select[@name='addresstype']")
	private WebElement categoryDropdown;

	@FindBy(xpath = "//a[text()='Contect us']")
	private WebElement contectUsLink;

//	Initialization
	public SkillraryDemoAppPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//	/Utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}

	public void mouceHoverToCourse(WebDriverUtility web) {
		web.mouseover(courseTab);
	}

	public void clickSeleniumTraining() {
		seleniumTrainingLink.click();
	}

	public void selectCategory(WebDriverUtility web, int index) {
		web.droupDown(categoryDropdown, index);
	}

	public void clcikContactUs() {
		contectUsLink.click();
	}

}
