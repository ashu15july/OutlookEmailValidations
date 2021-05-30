package com.EmailValidations.Testcases;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.Pages.HomePage;
import com.Pages.LoginPage;

import utilities.ConfigFileReader;
import utilities.ExcelReader;


public class TC001_Login_With_MultipleUsers {
	String title = "- Outlook";
	String excelPath = "\\Resources\\Testdata.xlsx";
	String SheetName = "Credentials";
	LoginPage logP;
	HomePage homP;
	WebDriver driver;
	WebDriverWait wait;
	ConfigFileReader conf;


	@BeforeMethod
	public void setUp() throws InterruptedException {

		conf = new ConfigFileReader();
		System.setProperty("webdriver.chrome.driver",conf.getDriverPath());
		driver  = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(conf.getApplicationUrl());
		driver.manage().window().maximize();
		
		
		
	}

	@Test()
	public void login_to_email_account() throws Exception {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		int rows = ExcelReader.return_total_rows_fromExcel("."+excelPath, SheetName);
		logP = new LoginPage(driver);	
		homP = new HomePage(driver);
		conf = new ConfigFileReader();

		if(rows>0) {
			for(int i=1;i<=rows;i++) {
				String userName = ExcelReader.getCellData(i, 0);
				String passWord = ExcelReader.getCellData(i, 1);
				logP.set_UName(userName);
				logP.click_Next();
				logP.set_Password(passWord);
				logP.submit();
				if(logP.verify_Title(title)==true) {
					homP.openLatestMail();
					String currentSubject = homP.subjectOfEmail();
					Assert.assertEquals(currentSubject, conf.getSubject());					
					String currentBody = homP.bodyOfEmail();					
					Assert.assertEquals(currentBody, conf.getBody());
					homP.userProfile();
					Thread.sleep(10000);
					homP.signOut();
					Thread.sleep(6000);
					System.out.println(userName+ " logged out successfully.");
					driver.navigate().to(conf.getApplicationUrl());
					Thread.sleep(2000);
				}
				else {
					System.out.println(userName+" could not login successfully with provided credentials.");
				}

			}
		}

	}

	@AfterTest
	public void tear_Down() {
		driver.close();
	}






}


