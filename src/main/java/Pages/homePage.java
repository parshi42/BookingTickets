package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class homePage extends TestBase{
	
	public WebDriverWait wait=null;
	
	
	
	@FindBy(id="gosuggest_inputSrc")
	WebElement fromCity;
	@FindBy(id="gosuggest_inputDest")
	WebElement toCity;
	@FindBy(xpath="//*[@id='departureCalendar']")
	WebElement departure;
	
	public homePage() {
		PageFactory.initElements(driver, this);
		
	}

	
	public void searchFlights(){
	//	PageFactory.initElements(driver, this);
		System.out.println("hello1");
		System.out.println(driver.getTitle());
		try {
			wait=new WebDriverWait(driver,20);
			//Thread.sleep(100000);
			System.out.println("Please agave");
			wait.until(ExpectedConditions.visibilityOf(fromCity));
			//fromCity.getText();
		}catch(Exception e) {
			System.out.println("erooooor");
		}
		
		//wait.until(ExpectedConditions.visibilityOf(fromCity));
		if(fromCity.isDisplayed() && fromCity.isEnabled()) {
			System.out.println("hello2");
			
			fromCity.click();			
			System.out.println("hello3");
		//	JavascriptExecutor js = (JavascriptExecutor)driver;
			 
		/*	js.executeScript("document.getElementById('fromCity').value='Hyderabad';");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			fromCity.sendKeys("Hyderabad");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fromCity.sendKeys(Keys.ARROW_DOWN);
			fromCity.sendKeys(Keys.ENTER);			
			toCity.click();
			toCity.sendKeys("Banglore");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			toCity.sendKeys(Keys.DOWN);
			toCity.sendKeys(Keys.ENTER);
			System.out.println("oyyyyyyyy111: ");
			departure.click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("oyyyyyyyy112: ");
			HandleCalender("April 2020","15");
			System.out.println("oyyyyyyyy113: ");
		}
	}
	
}
