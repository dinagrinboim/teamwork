package com.topq.testteamwork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.topq.teamwork.HomePage;
import com.topq.teamwork.LoginPage;
import com.topq.teamwork.MilestonesPage;
import com.topq.teamwork.TasksListPage;
import com.topq.teamwork.TasksPage;

public class TestLogin {

	private WebDriver driver;
    private String username = "fake09@fake.com";
    private String password = "fake";
	
	@BeforeMethod
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "/home/developer/driver/chromedriver");
		driver = new FirefoxDriver();		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://topq.teamwork.com");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	@Test
	public void testCreatNewTaskList() throws InterruptedException{
		
		Reporter.log("User is Logged in with name and password");		
		LoginPage loginPage = new LoginPage(driver);		
		HomePage homePage = loginPage.doLoginAndgotToOverviewPage(username, password);
		
		Reporter.log("Add new task list");
		TasksPage tasksPage = homePage.clickOnTasksMenuItmAndGoToTasksPage();
		
		//TODO: Implement a new class that represents the add new task list page
		tasksPage.clickOnAddTaskBtn();
		tasksPage.setNameOfNewTaskList("din");
		tasksPage.btnCreateTaskList();

		Reporter.log("Add two tasks to the list");
		TasksListPage tasksList = tasksPage.clickOnTaskListNameOnLeftPage("din");
		tasksList.clickOnAddTheFirstTaskBtn();
		tasksList.addTasksToTheList("do something");
		tasksList.addTasksToTheList("do something else");
		
		Reporter.log("Click on mileStones item on the menu and then click again on the task item");
		MilestonesPage mileStones = tasksList.goToMilstonesPage();
		mileStones.clickOnTasksMenuItm();
		
		Reporter.log("Verify task list exits");
		Assert.assertTrue(tasksPage.verifyTaskListExits("din"),"The task is not exit");
		Reporter.log("The task is exit");
		
		Reporter.log("Delete task");
		tasksPage.deleteTaskList("din");
	}		
}		