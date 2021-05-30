package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;


	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By emails = By.xpath("//*[@class='BVgxayg_IGpXi5g7S77GK']/div");
	By subject = By.xpath("//span[@class='ITWTqi_23IoOPmK3O6ErT']");
	By body = By.xpath("//div[@class='PlainText']");
	By userProfile = By.xpath("//*[@class='W3SxI5cuS3WM1UXD8WZsU']");
	By signOut = By.xpath("//a[contains(text(),'Sign out')]");
	By focused = By.xpath("//button[@name = 'Focused']");
	
	

	public void openLatestMail() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(10000);
		driver.findElement(focused).click();
		List<WebElement> we = driver.findElements(emails);
		if(we.size()>0) {
			Thread.sleep(6000);
			we.get(0).click();
			Thread.sleep(10000);
		}
		else {
			System.out.println("You don't have any email.");
		}
	}

	public String subjectOfEmail() throws InterruptedException {
		
		return driver.findElement(subject).getText();
	}

	public String bodyOfEmail() {
		return driver.findElement(body).getText();
	}

	public void userProfile() throws InterruptedException {
		
		driver.findElement(userProfile).click();
		Thread.sleep(2000);

	}

	public void signOut() throws InterruptedException {
		
		driver.findElement(signOut).click();
	
	}






}
