package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	static WebDriver driverFactory;
	static String browser;
	static String url;

	public static void readConfig() {

		Properties prop = new Properties();

		try {
			InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
			prop.load(input);
			browser = prop.getProperty("browser");
			System.out.println("Browser used: " + browser);
			url = prop.getProperty("url");
		} catch (IOException e) {
			e.getStackTrace();

		}
	}

	public static WebDriver init() {
		readConfig();
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driverFactory = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
			driverFactory = new FirefoxDriver();
		}
		driverFactory.manage().window().maximize();
		driverFactory.manage().deleteAllCookies();
		driverFactory.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driverFactory.get(url);
		return driverFactory;
	}

	public static void tearDown() throws InterruptedException {
		Thread.sleep(10000);
		driverFactory.close();
		driverFactory.quit();
	}

}
