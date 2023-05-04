package Base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	public static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
			
	@BeforeMethod
	public static void CreateDriver() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		webDriver.set(driver);
	}

	@AfterMethod
	public synchronized void afterSuite() {
		webDriver.get().close();
		webDriver.get().quit();
	}

}