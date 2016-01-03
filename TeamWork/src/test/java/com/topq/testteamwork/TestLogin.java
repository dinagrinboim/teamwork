package com.topq.testteamwork;

import org.openqa.selenium.WebDriver;
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
import com.topq.testteamwork.BrowserDriver.Browsers;

public class TestLogin {

	private WebDriver driver = BrowserDriver.getDriver(Browsers.FIREFOX); 
	
	/*SingletonFileConfiguration properties = new SingletonFileConfiguration();
	private String url = properties.getUrl();
	private String username = properties.getUserName();
    private String password = properties.getUserPassword();*/
    
	/*private String username = "fake09@fake.com";
    private String password = "fake";*/
    
	private String  url = SingletonFileConfiguration.getInstance().getMyProperties("url");
	private String  username = SingletonFileConfiguration.getInstance().getMyProperties("username");
	private String  password = SingletonFileConfiguration.getInstance().getMyProperties("password");
    
	@BeforeMethod
	public void setup(){
		/*driver.get("http://topq.teamwork.com");*/			
		driver.get(url);
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