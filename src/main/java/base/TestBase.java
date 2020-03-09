package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Creating Base class
 *
 */
public class TestBase 
{
	public static Properties prop;
	public static WebDriver driver;
	public static WebDriverWait wait;
	
    public TestBase() {
    	try {
    		prop=new Properties();
    		FileInputStream ip=new FileInputStream(new File(System.getProperty("user.dir")+"\\Config.txt"));
    		prop.load(ip);
    	}catch(FileNotFoundException e) {
    		e.printStackTrace();
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    @BeforeSuite
    public void initialization() throws InterruptedException {
    	String browserName=prop.getProperty("browser");
    	System.out.println(browserName);
    	if(browserName.equalsIgnoreCase("chrome")) {
    		System.setProperty("webdriver.chrome.driver","C:\\prashant\\BookingTickets"
    				+ "\\MakeMyTrip\\chromedriver.exe");
    		ChromeOptions options=new ChromeOptions();
    		options.addArguments("Incognito");
    		options.addArguments("--ignore-certificate-errors");
    		
    		driver=new ChromeDriver(options);
    	}
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	driver.get(prop.getProperty("url"));   
    	System.out.println("Initialization");
    }
    @AfterSuite
    public void Teardown() {
    	driver.quit();
    }
	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
	public void HandleCalender(String mmyy, String day) {		
		while(true) {
			String text = driver.findElement(By.xpath("//*[@class='DayPicker-Caption']")).getText();
			if(text.equals(mmyy)) {
				System.out.println("oyyyyyyyy: "+text);
				break;
			}
			else {
				wait=new WebDriverWait(driver,20);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='DayPicker-NavBar']")));
				
				driver.findElement(By.xpath("//*[@class='DayPicker-NavBar']")).click();
				System.out.println("im here 2 ");
				
			}
		}
		String text1=driver.findElement(By.xpath("//*[@class='calDate']")).getText();
		System.out.println("heyyyyyyy "+text1);
	}
	public void clickElement(WebElement ele) {
		
	}
    
}