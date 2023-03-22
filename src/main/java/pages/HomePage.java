package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver ;
	Actions act;
	@FindBy(xpath="//button[@id='onetrust-accept-btn-handler']")
	private WebElement okCookies ;
	@FindBy(xpath="(//span[text()='Bonds, Mutual Funds'])[2]")
	private WebElement invest ;
	@FindBy(xpath="(//span[text()='Mutual Funds'])[2]")
	private WebElement  mutualFunds;
	
	//initialization
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		act =   new Actions(driver);
	}
	
	//Use
	public void clickOnOkCookies() {
		okCookies.click();
	}
	
	public void clickOnInvestDroupDown() {
		act.moveToElement(invest).perform();
	}
	
	public void clickOnMutualFunds () {
		mutualFunds.click();
	}
	
	
	
	
}
