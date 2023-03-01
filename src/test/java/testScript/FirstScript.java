package testScript;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genaricLibrary.BaseClass;

public class FirstScript extends BaseClass{

	@Test
	public void firstTest() {
		SoftAssert soft=new SoftAssert();
		home.clickGears();
		home.clickSkillraryDemoApp();
		web.switchToChildBrowser();
		
		soft.assertEquals(demoApp.getPageHeader(),"Skillrary-ECommerce");
		demoApp.mouceHoverToCourse(web);
		demoApp.clickSeleniumTraining();
		
		soft.assertEquals(selenium.getPageHeader(),"Selenium Trainig");
		selenium.doubleClickPlusButton(web);
		selenium.clickAddToCart();
		web.handleAlert();
		
		soft.assertTrue(selenium.getItemAddedMessage().isDisplayed());
	}

}
