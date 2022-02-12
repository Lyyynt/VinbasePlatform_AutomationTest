package testcases;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.DashBoard;
import pages.ManageAgent;
import pages.VinpearlButler;

import utils.Constants;
import utils.ExcelUtils;

import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class SendMessage {
	
	WebDriver driver;
	LoginPage lp;
	DashBoard db;
	ManageAgent ma;
	VinpearlButler vb;
	
	//public static int IdMessage = 2;
	
	@DataProvider(name = "sendMessage")
	public static Object[][] credentials() throws Exception {
		ExcelUtils excel = new ExcelUtils(Constants.DataPath_Message, Constants.SheetName_Message);
		return excel.getTableArray(3);
	}

	
  @Test(dataProvider = "sendMessage")
  public void SendMessage(String testcaseID, String message, String dialog_output) throws Exception {
	  vb.SendMessage(message);
	  
	  
	  ExcelUtils excel = new ExcelUtils(Constants.DataPath_Message, Constants.SheetName_Message);
	  /*for (int testcaseID = 1; testcaseID <= excel.getRowUsed(); testcaseID++) {
		  excel.setCellData(vb.getResponse(Constants.IdMessage), excel.getRowContains(String.valueOf(i), Constants.Col_TestcaseID), Constants.Col_Actual_Results);
		  if (excel.getCellData(testcaseID, Constants.Col_Dialog_Output).equals(excel.getCellData(testcaseID, Constants.Col_Actual_Results))) {
			  excel.setCellData("PASS", excel.getRowContains(String.valueOf(testcaseID), Constants.Col_TestcaseID), Constants.Col_Results);
		  } else {
			  excel.setCellData("FAILED", excel.getRowContains(String.valueOf(testcaseID), Constants.Col_TestcaseID), Constants.Col_Results);
		  }
		  
	  }*/
	  excel.setCellData(vb.getResponse(Constants.IdMessage), excel.getRowContains(testcaseID, Constants.Col_TestcaseID), Constants.Col_Actual_Results);
	  
  }
 
  
 
  
  @BeforeClass
  public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\linhnt178\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Constants.URL);
		lp = new LoginPage(driver);	
		db = new DashBoard(driver);
		ma = new ManageAgent(driver);
		vb = new VinpearlButler(driver);
		lp.Login("thuylinhnguyen.hust@gmail.com", "xaqLIT94@#");
		db.ChooseVinBot();
		ma.ChooseButler();
		vb.OpenChat();
	}

  @AfterClass()
  public void tearDown() {
		//driver.quit();
		
	}

}
