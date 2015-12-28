package com.topq.teamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TasksPage extends AbstractTeamWorkPage{

	By m_addTask = By.xpath("//div/ul/li/button[@class='btn btn-success btn-hasIcon']");
	By m_newTaskListName = By.id("newTaskListName");
	By m_btnCreateTaskList = By.id("btnCreateTaskList");

	public TasksPage(WebDriver driver_) {
		super(driver_);
	}

	public void clickOnAddTaskBtn(){
		driver.findElement(m_addTask).click();
	}
	
	public void setNameOfNewTaskList(String strNewTaskListName){
		driver.findElement(m_newTaskListName).sendKeys(strNewTaskListName);
	}
	
	public void btnCreateTaskList(){
		driver.findElement(m_btnCreateTaskList).click();
	}
	
	public void doTasks(String strNewTaskListName) throws InterruptedException{
		Thread.sleep(3000);
		clickOnAddTaskBtn();
		setNameOfNewTaskList(strNewTaskListName);
		btnCreateTaskList();
	}
	
	public TasksListPage clickOnTaskListNameOnLeftPage(String listName){
		WebElement listTaskName = driver.findElement(By.xpath("//span[contains(.,'"+ listName +"')]"));
		listTaskName.click();
		return new TasksListPage(driver); 
	}
	
	public boolean verifyTaskListExits(String nameOfTaskList){
		//TODO: Replace this call with findElements and verify that we have more then one item in the list
		WebElement listTaskName = driver.findElement(By.xpath("//span[contains(.,'"+ nameOfTaskList +"')]"));
		/*list
		listTaskName.getSize()*/
		
			
			
		/*WebElement listTaskName = driver.findElement(By.xpath("//span[contains(.,'"+ nameOfTaskList +"')]"));
		if(listTaskName != null){
			return true;
		}
		return false;*/		
	}
	
	public void deleteTaskList(String nameOfTaskList){
		WebElement listTaskName = driver.findElement(By.xpath("//span[contains(.,'"+ nameOfTaskList +"')]"));
		listTaskName.click();
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-hasIcon tipped']")).click();
		driver.findElement(By.xpath("//a/i[@class='ico-trash icon-large']")).click();
	}
	
	@Override
	protected void assertInPage() {
		(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.id("pageTitle")));	
	}
}
