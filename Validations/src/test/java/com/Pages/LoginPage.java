package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By uName = By.name("loginfmt");
	By next = By.id("idSIButton9");
	By pwd = By.name("passwd");

	public void set_UName(String userName) {
		driver.findElement(uName).sendKeys(userName);
	}

	public void click_Next() throws InterruptedException {
		driver.findElement(next).click();
		Thread.sleep(6000);

	}

	public void set_Password(String password) {
		driver.findElement(pwd).clear();
		driver.findElement(pwd).sendKeys(password);
	}

	public void submit() throws InterruptedException {
		driver.findElement(pwd).submit();
		Thread.sleep(6000);
	}

	public boolean verify_Title(String title) {
		String curTitle = driver.getTitle();
		if(curTitle.contains(title)) {
			return true;
		}
		else {
			return false;	
		}
	}


}
