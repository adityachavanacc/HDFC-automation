package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MutualFunds {
	WebDriver driver;
	@FindBy(xpath="(//a[@value='Overlay Not Required'])[3]")
	private WebElement sipCalculator ;

	//initialization
	public MutualFunds(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//use
	public void ClickOnSipCalculator() {
		sipCalculator.click();
	}
	
	
	
}
