package mobileteamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class ConfirmationRequiredPage extends AbstractPageObject{

	By m_deleteBtn = By.xpath("android.widget.Button[@text='Delete']");
	
	public ConfirmationRequiredPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}
	
	public ActiveTaskListsPage clickOnDeleteBtnAndGoToActiveTaskListsPage(){
		driver.findElement(m_deleteBtn).click();
		return new ActiveTaskListsPage(driver);
	}
}