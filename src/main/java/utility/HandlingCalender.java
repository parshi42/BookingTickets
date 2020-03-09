package utility;

import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.TestBase;

public class HandlingCalender extends TestBase{
	public static void selectDate(WebElement calendar, String year, String monthName, String day, WebDriver driver) throws ParseException{
		
		calendar.click();
		//retrieving currentYear
		String currentYear=driver.findElement(By.xpath("//div[@class='DayPicker"
				+ "-Caption']")).getText();
	}
}
