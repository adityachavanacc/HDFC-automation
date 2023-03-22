package testNgTrala;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.MutualFunds;
import pages.SipCalculator;

public class SipCalculatorFunctionality {
	WebDriver driver ;
	HomePage homePage;
	SipCalculator sipCalculator;
	MutualFunds mutualFunds;
	
	@BeforeClass
	public void beforeClass() {
		
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32 (2)\\chromedriver.exe");
		driver= new ChromeDriver();
	}
	
	@BeforeMethod
	public void goToSipCalculator() throws InterruptedException {
		
		driver.get("https://www.hdfcbank.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		homePage = new HomePage(driver);
		//homePage.clickOnOkCookies();
		homePage.clickOnInvestDroupDown();
		homePage.clickOnMutualFunds();
		mutualFunds = new MutualFunds(driver);
		Thread.sleep(1000);
		mutualFunds.ClickOnSipCalculator();
		sipCalculator=new SipCalculator(driver);
	 }
	
	@Test(priority=0)
	public void calculateSIPbyEnteringAllValidInput() throws InterruptedException {
	
		sipCalculator.sendAmountToInvest("20000");
		sipCalculator.ClickOnFrequency("Quterly");
		sipCalculator.sendNoOfINstallment("20");
		//sipCalculator.clearExpectedRateOfReturn();
		Thread.sleep(3000);
		sipCalculator.sentKeyToExpectedRateOfReturn("24");
		Thread.sleep(3000);
		sipCalculator.ClickOnClaculateButton();
		String value="? 5,02,498.08";
		String time = "1 years 8 months";
		if(value.equalsIgnoreCase(sipCalculator.GetValueOfSIP()) && time.equalsIgnoreCase(sipCalculator.GetTimeOfSIP())) {
			System.out.println("Test1 =>pass");
		}
		else {
			System.out.println("Test1 =>fail ");
		} 
	}
	
	@Test (priority = -1 , enabled = false)
	public void calculateSIPbyEnteringValidInputWithPercentageSlider() {
		System.out.println("AfterClass");
		sipCalculator.sendAmountToInvest("20000");
		sipCalculator.ClickOnFrequency("Quterly");
		sipCalculator.sendNoOfINstallment("20");
		//sipCalculator.clearExpectedRateOfReturn();
		sipCalculator.MovePercentageSlider(500,0);
		sipCalculator.ClickOnClaculateButton();
		String value="? 5,02,498.08";
		String time = "1 years 8 months";
	}
	
	@Test
	public void oneInvalidInput() {
		sipCalculator.sendNoOfINstallment(null);
	}
	@AfterMethod
	public void afterMethod() {
		
	}
	@AfterClass
	public void afterClass() {
		
	//	driver.close();
	}

}
