package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SipCalculator {
	WebDriver driver;
	Actions act ;
	@FindBy(xpath="//div[@class='rangeslider__handle']")
	private WebElement percentageSlider ;
	
	@FindBy(xpath="(//input[contains (@class,'') and contains (@ng-keyup,'')])[6]")
	private WebElement expectedRateOfReturn ;
	
	@FindBy(xpath="//input[@class='form-control amt-invest ng-pristine ng-untouched ng-valid ng-not-empty']")
	private WebElement amountToInvest ;
	
	@FindBy(xpath="//input[@class='form-control ng-pristine ng-untouched ng-valid ng-empty ng-valid-maxlength']")
	private WebElement noOfINstallment ;
	
	@FindBy(xpath="//input[@name='frequency-0']")
	private WebElement frequencyMonthly ;
	
	@FindBy(xpath="//input[@id='frequency-1']")
	private WebElement frequencyQuaterly ;
	
	@FindBy(xpath="//a[@title='Calculate SIP Online']")
	private WebElement calculateButton ;
	
	@FindBy(xpath="//span[@class='emi-amt ng-binding']")
	private WebElement valueOfSIP;
	
	@FindBy(xpath="//span[@class='emi-text ng-binding']")
	private WebElement timeOfSIP;
	
	//initialization
		public SipCalculator(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
			act= new Actions(this.driver);
		}
		//Use
		public void MovePercentageSlider(int xAxis, int yAxis) {
			act.moveToElement(percentageSlider).clickAndHold(percentageSlider).moveByOffset(xAxis, yAxis).build().perform();
		}
//		public void clearExpectedRateOfReturn( ) {
//			
//		}
		public void sentKeyToExpectedRateOfReturn(CharSequence per) throws InterruptedException {
			act.doubleClick(expectedRateOfReturn).perform();
			Thread.sleep(3000);
			expectedRateOfReturn.clear();
			Thread.sleep(3000);
			expectedRateOfReturn.sendKeys(per);
			act.
		}
		
		public void sendAmountToInvest(CharSequence amount) {
			amountToInvest.sendKeys(amount);
		}
		public void sendNoOfINstallment(CharSequence noOfINstallment) {
			this.noOfINstallment.sendKeys(noOfINstallment);
		}
		public void ClickOnFrequency(String frequency) {
			if(frequency.equalsIgnoreCase("Monthly")) {
				frequencyMonthly.click();
			}
			else if (frequency.equalsIgnoreCase("Quarterly")) {
				frequencyQuaterly.click();
			}
		}
		public void ClickOnClaculateButton() {
			calculateButton.click();
		}
		
		public String GetValueOfSIP () {
			String amount =valueOfSIP.getText();
			return amount;
		}
		public String GetTimeOfSIP () {
			String amount =timeOfSIP.getText();
			return amount;
		}

}
