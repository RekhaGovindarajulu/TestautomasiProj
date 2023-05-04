package Utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import Base.DriverManager;

public class Util extends DriverManager {

	static FileReader reader;
	static Properties p;
	
	public static byte[] takeScreenShot() {
		return ((TakesScreenshot) webDriver.get()).getScreenshotAs(OutputType.BYTES);
	}

	public static String properties(String fileName, String value) {
		String propValue = null;
		try {
			reader = new FileReader("AppConfig" + "//" + fileName + ".properties");
			p = new Properties();
			p.load(reader);
			propValue = p.getProperty(value);
		} catch (FileNotFoundException e) {
			new RuntimeException("File is not found : " + fileName);
		} catch (IOException e) {
			e.printStackTrace();
			new RuntimeException("IO exception occured");
		}
		return propValue;
	}

	public static void sendText(WebElement element, String value) {
		element.click();
		element.sendKeys(value);
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static String getURL() {
		return webDriver.get().getCurrentUrl();
	}
	
	public static String getTITLE() {
		return webDriver.get().getTitle();
	}
	
	public static void sleep(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}