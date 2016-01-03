package com.topq.teamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TasksListPage extends AbstractTeamWorkPage{

	By m_addFirstTask = By.xpath("//button[@class='btn btn-success js-add-task btn-lg']");
	By m_FirstTaskTextBox = By.xpath("//form[@id='newTaskForm']//following::span/input[@placeholder]");
	By m_saveMyChangesBtn = By.xpath("//input[@value='Save my changes']");
	By m_goToMilestones = By.xpath("//li[@id='tab_messages']");
	
	public TasksListPage(WebDriver driver_) {
		super(driver_);
	}

	public void clickOnAddTheFirstTaskBtn(){
		driver.findElement(m_addFirstTask).click();
	}
	public void sendKeyToTaskTextBox(String strTask){
		driver.findElement(m_FirstTaskTextBox).sendKeys(strTask);
	}
	public void saveTask(){
		driver.findElement(m_saveMyChangesBtn).click();
	}
	
	public void addTasksToTheList(String strTask) throws InterruptedException{
		Thread.sleep(1500);
		sendKeyToTaskTextBox(strTask);
		saveTask();
		Thread.sleep(1500);
	}	

	public MilestonesPage goToMilstonesPage() {
		driver.findElement(m_goToMilestones).click();
		return new MilestonesPage(driver);
	}
		
	@Override
	protected void assertInPage() {		
	}
}
