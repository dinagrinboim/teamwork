package mobileteamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class TaskListPage extends AbstractPageObject{

	By m_createTheFirstTaskBtn = By.xpath("//android.widget.Button[@text='Create the first task']");
	By m_AddTaskBtn = By.xpath("//android.widget.TextView[@text='Add Task']");
	By m_menuMoreOptionsBtn = By.xpath("//android.widget.ImageView[@content-desc='More options']");
	
	public TaskListPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public AddTaskPage clickOnCreateTheFirstTaskBtnAndGoToAddTaskPage(){
		driver.findElement(m_createTheFirstTaskBtn).click();
		return new AddTaskPage(driver);
	}
	
	public AddTaskPage clickOnAddTaskBtnAndGoToAddTaskPage(){
		driver.findElement(m_AddTaskBtn).click();
		return new AddTaskPage(driver);
	}

	public MenuMoreOptionsPage clickOnMenuMoreOptionsBtnAndGoToMenuMoreOptionsPage(){
		driver.findElement(m_menuMoreOptionsBtn).click();
		return new MenuMoreOptionsPage(driver);
	}	
}