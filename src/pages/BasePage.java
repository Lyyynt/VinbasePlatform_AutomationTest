package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
	
	
	public BasePage(WebDriver driver)	{
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,5), this);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		}
}
