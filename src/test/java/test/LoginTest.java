package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	
	WebDriver driverTest;
	
	ExcelReader exlRead = new ExcelReader("src\\main\\java\\testData\\Techfios_TestData.xlsx");
	String userName = exlRead.getCellData("LoginInfo", "UserName", 2);
	String password = exlRead.getCellData("LoginInfo", "Password", 2);
	
	@Test
	public void validUserShouldBeAbleToLogin() throws InterruptedException {
		
		driverTest = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driverTest, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();
		
		DashboardPage dashboard = PageFactory.initElements(driverTest, DashboardPage.class);
		dashboard.verifyDashboardElement();
		
		BrowserFactory.tearDown();
		
	}

}
