package mobileteamwork;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class ActiveTaskListsPage extends AbstractPageObject{
	
	public ActiveTaskListsPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public AddTaskListPage clickOnAddTaskListBtnAndGoToAddTaskListPage(){
		driver.scrollTo("Add Task List").click();
		return new AddTaskListPage(driver);
	}
	
	public TaskListPage clickOnDesiredTaskListAndGoToTaskListPage(String nameOfDesiredTaskList){
		driver.scrollTo(nameOfDesiredTaskList).click();
		return new TaskListPage(driver);
	}	
}