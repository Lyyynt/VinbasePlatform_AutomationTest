package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageAgent extends BasePage {

	public ManageAgent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	@FindBy(how = How.CSS, using = ".v-card:nth-child(2)> div")
	public WebElement btn_VinPearl_butler;
	
	@FindBy(how = How.CSS, using = ".active-menu")
	public WebElement btn_Intents;
	
	public void ChooseButler() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_VinPearl_butler)).click();
		wait.until(ExpectedConditions.elementToBeClickable(btn_Intents)).click();
	}

}
