package mobileteamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class AllActivityPage extends AbstractPageObject{

	By m_subMenuItm = By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");
	
	public AllActivityPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public SubMenuPage clickOnSubMenuItmAndGoToSubMenuPage(){
		driver.findElement(m_subMenuItm).click();
		return new SubMenuPage(driver);
	}	
}