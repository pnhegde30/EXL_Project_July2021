package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DashboardPage extends BasePage {
	
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Dashboard')]") WebElement DASHBOARD_TITLE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Customers')]") WebElement CUSTOMER_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Add Customer')]") WebElement ADD_CUSTOMER_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'List Customer')]") WebElement LIST_CUSTOMER_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"summary\"]") WebElement SUMMARY_PROFILE_PAGE_ELEMENT;

	public void verifyDashboardElement() {
		Assert.assertEquals(DASHBOARD_TITLE_ELEMENT.getText(), "Dashboard", "Dashboard Page not found!!");
	}
	
	public void clickCustomerButton() {
		waitForElement(driver, 8, CUSTOMER_BUTTON_ELEMENT);
		CUSTOMER_BUTTON_ELEMENT.click();
	}
	
	public void clickAddCustomerButton() {
		waitForElement(driver, 8, ADD_CUSTOMER_BUTTON_ELEMENT);
		ADD_CUSTOMER_BUTTON_ELEMENT.click();
	}
	
	public void clickListCustomerButton() {
		waitForElement(driver, 8, LIST_CUSTOMER_BUTTON_ELEMENT);
		LIST_CUSTOMER_BUTTON_ELEMENT.click();
	}
	
	public void verifyProfilePage() {
		Assert.assertEquals(SUMMARY_PROFILE_PAGE_ELEMENT.getText(),"Summary" , "Profile Page not found!!");
	}
	
}
