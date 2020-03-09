package testCases;


import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.homePage;
import base.TestBase;

public class homePageTest extends TestBase{

	public static homePage homepage;
	
	@BeforeMethod
	public void setUp(){
		homepage = new homePage();
	}

	@Test
	public void verifyFlights() {	
		
			homepage.searchFlights();

	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
