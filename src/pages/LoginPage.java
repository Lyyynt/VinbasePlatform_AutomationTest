package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	@FindBy(how = How.CSS, using = ".v-text-field__slot > input[placeholder='Enter your email address...']")
	public WebElement txt_Email;
	
	@FindBy(how = How.CSS, using = ".v-text-field__slot > input[placeholder='Enter password']")
	public WebElement txt_Passwd;
	
	
	@FindBy(how = How.CSS, using = ".text-capitalize[type='submit']")
	public WebElement btn_ContinueWithEmail;
	


	public void Login(String email, String password) {
		wait.until(ExpectedConditions.elementToBeClickable(txt_Email)).sendKeys(email);
		wait.until(ExpectedConditions.elementToBeClickable(btn_ContinueWithEmail)).click();
		wait.until(ExpectedConditions.elementToBeClickable(txt_Passwd)).sendKeys(password);
		wait.until(ExpectedConditions.elementToBeClickable(btn_ContinueWithEmail)).click();
	}
}
