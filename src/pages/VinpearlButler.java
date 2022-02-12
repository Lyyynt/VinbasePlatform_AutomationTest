package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Constants;

public class VinpearlButler extends BasePage {

	public VinpearlButler(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(how = How.CSS, using = ".v-btn > span > div >img")
	public WebElement btn_chat;
	
	@FindBy(how = How.CSS, using = ".v-text-field__slot > input[placeholder='Send a message']")
	public WebElement txt_SendMess;
	
	@FindBy(how = How.CSS, using =".chat-window-input >div:last-child")
	public WebElement btn_send;
	/*@FindBy(how = How.CSS, using = "msg_" + Constants.css_locator)
	public WebElement content_Response;*/
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	
	
	public void OpenChat() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_chat)).click();
	}
	public void SendMessage(String message) {
		wait.until(ExpectedConditions.elementToBeClickable(txt_SendMess)).sendKeys(message);
		btn_send.click();
		Constants.IdMessage++;//3
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#msg_"+ String.valueOf(Constants.IdMessage))));
	}
	
	
	

	
	
	public String getResponse(int i) {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#msg_"+ String.valueOf(i))));
		
		String comd1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#msg_"+ String.valueOf(i)))).getText();
		Constants.IdMessage++;//4
		String response;
		try {
			String comd2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#msg_"+ String.valueOf(i)))).getText();
			response = comd1 + ", "+ comd2;
			Constants.IdMessage++;
			
		}catch (Exception e){
			response = comd1;
		}
		return response;
	}
}
