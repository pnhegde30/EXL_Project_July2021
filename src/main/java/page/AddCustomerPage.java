package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {
	
	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Element Library
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]") WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id='cid']") WebElement COMPANY_DROP_DOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]") WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]") WebElement PHONE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]") WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]") WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]") WebElement STATE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]") WebElement ZIP_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id='country']") WebElement COUNTRY_DROP_DOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]") WebElement SAVE_BUTTON_ADD_CUSTOMER_ELEMENT;

	String enteredName;
	
	public void enterFullName(String fullname ) {
		int randomNumber = randomGenerator(999);
		enteredName = fullname + randomNumber;
		FULL_NAME_ELEMENT.sendKeys(enteredName);
	}
	
	public void selectCompanyDropDown(String company) {
		selectFromDropdown(COMPANY_DROP_DOWN_ELEMENT, company);
	}
	
	public void enterEmail(String email) {
		int randomNumber = randomGenerator(9999);
		EMAIL_ELEMENT.sendKeys(randomNumber + email);
	}
	
	public void enterPhone(String phone) {
		PHONE_ELEMENT.sendKeys(phone + randomGenerator(999));
	}
	
	public void enterAddress(String address) {
		ADDRESS_ELEMENT.sendKeys(address);
	}
	
	public void enterCity(String city) {
		CITY_ELEMENT.sendKeys(city);
	}
	
	public void enterState(String state) {
		STATE_ELEMENT.sendKeys(state);
	}
	
	public void enterZip(String zip) {
		ZIP_ELEMENT.sendKeys(zip);
	}
	
	public void selectCountryDropDown(String country) {
		selectFromDropdown(COUNTRY_DROP_DOWN_ELEMENT, country);
	}
	
	public void clickSaveButton() {
		SAVE_BUTTON_ADD_CUSTOMER_ELEMENT.click();
	}
	
	//tbody/tr[1]/td[3]
	//tbody/tr[2]/td[3]
	//tbody/tr[3]/td[3]
	//Delete button:
	//tbody/tr[1]/td[7]/a[2]
	
	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[3]";
	String after_xpath_delete = "]/td[7]/a[2]";
	
	public void verifyEnteredNameAndDelete() {
		for(int i = 1; i <=10; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);
			//Assert.assertEquals(name, enteredName, "Entered Name doesn't exist");
			//creating a custom assertion 
			if(name.contains(enteredName)) {
				System.out.println("Entered name exist");
				driver.findElement(By.xpath(before_xpath + i + after_xpath_delete)).click();
			}
			
			break;
		}
	}
	
	
}
