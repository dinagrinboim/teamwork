package mobileteamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class AllProjectPage extends AbstractPageObject{

	By m_webDriverTrainingItm = By.xpath("//android.widget.TextView[@text='WebDriver Training']");
	
	public AllProjectPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}
	
	public ProjectHomePage clickOnwebDriverItmAndGoToProjectHomePage(String nameOfWebDriver){
		TouchAction action = new TouchAction(driver);
		action.longPress(driver.findElement(By.xpath("//android.widget.TextView[@text='"+nameOfWebDriver+"']"))).release().perform();		
		return new ProjectHomePage(driver);
	}
}