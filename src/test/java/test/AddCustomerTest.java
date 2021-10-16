package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {

	WebDriver driver;
	
	ExcelReader exlRead = new ExcelReader("src\\main\\java\\testData\\Techfios_TestData.xlsx");
	String userName = exlRead.getCellData("LoginInfo", "UserName", 2);
	String password = exlRead.getCellData("LoginInfo", "Password", 2);
	String fullName = exlRead.getCellData("AddContactInfo", "FullName", 2);
	String companyName = exlRead.getCellData("AddContactInfo", "CompanyName", 2);
	String email = exlRead.getCellData("AddContactInfo", "Email", 2);
	String phone = exlRead.getCellData("AddContactInfo", "Phone", 2);
	String address = exlRead.getCellData("AddContactInfo", "Address", 2);
	String cityName = exlRead.getCellData("AddContactInfo", "City", 2);
	String countryName = exlRead.getCellData("AddContactInfo", "Country", 2);
	String stateName = exlRead.getCellData("AddContactInfo", "State", 2);
	String zip = exlRead.getCellData("AddContactInfo", "Zip", 2);
	
	
	@Test
	public void validUserShouldBeAbleToAddCustomer() {
		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();

		DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
		dashboard.verifyDashboardElement();
		dashboard.clickCustomerButton();
		dashboard.clickAddCustomerButton();

		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.enterFullName(fullName);
		addCustomerPage.selectCompanyDropDown(companyName);
		addCustomerPage.enterEmail(email);
		addCustomerPage.enterPhone(phone);
		addCustomerPage.enterAddress(address);
		addCustomerPage.enterCity(cityName);
		addCustomerPage.enterState(stateName);
		addCustomerPage.enterZip(zip);
		addCustomerPage.selectCountryDropDown(countryName);
		addCustomerPage.clickSaveButton();
		
		dashboard.verifyProfilePage();
		dashboard.clickListCustomerButton();
		
		addCustomerPage.verifyEnteredNameAndDelete();
	}

}
