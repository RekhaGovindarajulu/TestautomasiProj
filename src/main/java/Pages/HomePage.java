package Pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Base.DriverManager;
import Utility.Util;

public class HomePage extends DriverManager {
	
		private ArrayList<String> newtab;

		//page locators
		private By eLearningLink = By.xpath("//a[text()='E-Learning']");
		
		
		//constructor
		public HomePage() {
			PageFactory.initElements(webDriver.get(), this);
		}
		
			
		//page methods
		public String getPageUrl() {
			return Util.getURL();
		}
		
		public String verifyPageTitle() {
			return Util.getTITLE();
		}
		
		
		public SearchPage clickElearning() {
		//WebElement link = driver.findElement(eLearningLink);
			WebElement link = new WebDriverWait(webDriver.get(), Duration.ofSeconds(10))
				.until(ExpectedConditions.presenceOfElementLocated(eLearningLink));
			link.click();
			newtab = new ArrayList<String>(webDriver.get().getWindowHandles());
			webDriver.get().switchTo().window(newtab.get(1));
			
			return new SearchPage();
		}
	
}
