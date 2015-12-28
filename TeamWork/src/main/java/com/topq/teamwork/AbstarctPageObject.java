package com.topq.teamwork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstarctPageObject {

	protected final WebDriver driver;

	public AbstarctPageObject(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		assertInPage();
	}
	
	 protected abstract void assertInPage();	
}
