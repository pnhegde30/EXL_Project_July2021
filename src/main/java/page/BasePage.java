package page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public void waitForElement(WebDriver driver, int waitTimeInSeconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public int randomGenerator(int boundaryNumber) { 
		Random rnd = new Random();
		int randomNo = rnd.nextInt(boundaryNumber);
		return randomNo;
	}

	public void selectFromDropdown(WebElement element, String visibleText) {
		Select sel1 = new Select(element);
		sel1.selectByVisibleText(visibleText);
		
	}

}
