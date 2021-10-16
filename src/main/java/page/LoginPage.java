package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	WebDriver driverPage;
	//Element Library
	
	public LoginPage(WebDriver driverTest) {
		this.driverPage = driverTest;
	}
	@FindBy(how = How.XPATH, using = "//*[@id=\"username\"]") WebElement USERNAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]") WebElement PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using = "/html/body/div/div/div/form/div[3]/button") WebElement SIGNIN_ELEMENT;
	
	//Intractable Methods
	public void insertUserName(String userName) {
		USERNAME_ELEMENT.sendKeys(userName);
	}
	
	public void insertPassword(String password) {
		PASSWORD_ELEMENT.sendKeys(password);
	}
	
	public void clickSigninButton() {
		SIGNIN_ELEMENT.click();
	}

}
