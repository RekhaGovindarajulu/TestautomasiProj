package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.DriverManager;

public class SearchPage extends DriverManager {

	// page locators
	private By courseSearchTextbox = By.xpath("//input[@placeholder = 'Search courses...']");
	private By courseSearchBtn = By.xpath("//button[@type='submit']");
	private By courseSearchResult = By.xpath("//h3[@class = 'course-title']");
	private By courseReadmore = By.xpath("//div[@class = 'course-readmore']");
	private By courseBuybtn = By.xpath("//button[contains(text(),'Buy Now')]");
	private By checkoutText = By.xpath("//*[@id='learn-press-checkout']/h2");

	// constructor
	public SearchPage() {
		PageFactory.initElements(webDriver.get(), this);
	}

	// methods
	public void searchCourse(String course) throws InterruptedException {
		webDriver.get().findElement(courseSearchTextbox).sendKeys(course);
		WebElement searchBtn = new WebDriverWait(webDriver.get(), Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(courseSearchBtn));
		JavascriptExecutor executor = (JavascriptExecutor) webDriver.get();
		executor.executeScript("arguments[0].click();", searchBtn);
	}

	public String courseTitle() {
		String title = webDriver.get().findElement(courseSearchResult).getText();
		return title;
	}

	public void viewmore() {
		webDriver.get().navigate().refresh();
		WebElement view = new WebDriverWait(webDriver.get(), Duration.ofSeconds(15))
				.until(ExpectedConditions.elementToBeClickable(courseReadmore));
		view.click();
	}

	public void buyCourse() {
		WebElement buy = new WebDriverWait(webDriver.get(), Duration.ofSeconds(15))
				.until(ExpectedConditions.elementToBeClickable(courseBuybtn));
		buy.click();

	}

	public String verifyCheckout() {
		return webDriver.get().findElement(checkoutText).getText();
	}

}