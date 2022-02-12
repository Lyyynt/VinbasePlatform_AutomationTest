package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoard extends BasePage {

	public DashBoard(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	} 
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	@FindBy(how = How.CSS, using = ".mt-auto[href='/vinbot'] > i")
	public WebElement btn_Manage_Service;
	
	public void ChooseVinBot() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_Manage_Service)).click();
	}
	
	

}
