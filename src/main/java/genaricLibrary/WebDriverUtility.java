package genaricLibrary;

import java.io.File;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains reusable methods of WebDriver
 * 
 * @author cw
 *
 */

public class WebDriverUtility {

	private WebDriver driver;

	/**
	 * This method is used to navigate to an application using user desired browser
	 * 
	 * @param browser
	 * @param url
	 * @param time
	 * @return
	 */

	public WebDriver openApplication(String browser, String url, long time) {

		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid browser data");
		}

		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		return driver;
	}

	/**
	 * This method is used to wait until the visibility
	 * 
	 * @param element
	 * @param time
	 * @return
	 */

	public WebElement explicitWait(WebElement element, long time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method is used to perform mouse over on an element
	 * 
	 * @param element
	 */

	public void mouseover(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}

	/**
	 * This method is used to perform doubleClick on an element
	 * 
	 * @param element
	 */

	public void doubleClickOnElement(WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}

	/**
	 * This method is used to perform drag and drop on an element
	 * 
	 * @param source
	 * @param target
	 */

	public void dragAndDrop(WebElement source, WebElement target) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}

	/**
	 * This method is used to perform droupdown on an element
	 * 
	 * @param source
	 * @param target
	 */

	public void droupDown(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	public void droupDown(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	/**
	 * This method is used to scrollToElement
	 * 
	 * @param element
	 */

	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments(0).scrollIntoView(true", element);
	}

	/**
	 * This method is used to takeScreenshot
	 */

	public void takeScreenshot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/screenshot.png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to handle alert pop up
	 */

	public void handleAlert() {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method is used to switch to child browser
	 */

	public void switchToChildBrowser() {
		Set<String> set = driver.getWindowHandles();
		for (String windowID : set) {
			driver.switchTo().window(windowID);
		}
	}

	/**
	 * This method is used to switch to frame
	 */

	public void switchToFrame() {
		driver.switchTo().frame(0);
	}

	/**
	 * This method is used to switch back to frame
	 */

	public void switchBackFromFrame() {
		driver.switchTo().defaultContent();
	}

	public void qiutBrowser() {
		// TODO Auto-generated method stub
		driver.quit();
		
	}
	
}
