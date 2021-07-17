package com.SeleniumPractice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCalendars {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
//		
//		int day = 30;
		
		//First Calendar
//		driver.findElement(By.id("first_date_picker")).click();
//		driver.findElement(By.xpath("//table[@class ='ui-datepicker-calendar']//a[text()="+day+"]")).click();
		
		//Second Calendar
//		driver.findElement(By.id("second_date_picker")).click();
//		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td[not(contains(@class,'ui-datepicker-other-month'))]//a[text()="+day+"]")).click();
		
		
		driver.findElement(By.id("first_date_picker")).click();
		selectDate(driver, "25/June/2015");
		
		driver.findElement(By.id("second_date_picker")).click();
		selectDate(driver, "25/June/2025");
	}
	
	public static void selectDate(WebDriver driver, String date) throws Exception {
		Calendar calendar = Calendar.getInstance();
		try {
			SimpleDateFormat targetDateFormat = new SimpleDateFormat("dd/MMM/yyyy");
			targetDateFormat.setLenient(false);
			Date formattedTargetDate = targetDateFormat.parse(date);
			calendar.setTime(formattedTargetDate);
		} catch (Exception e) {
			throw new Exception("Invalid Date is Provided, Please check the input date");
		}
			int targetMonth = calendar.get(Calendar.MONTH);
			int targetYear = calendar.get(Calendar.YEAR);
			int targetday = calendar.get(Calendar.DAY_OF_MONTH);
			
			
			
			//Format June 2021
			String currentDate = driver.findElement(By.className("ui-datepicker-title")).getText();
			SimpleDateFormat currentDateFormat = new SimpleDateFormat("MMM yyyy");
			Date currentTargetDate = currentDateFormat.parse(currentDate);
			calendar.setTime(currentTargetDate);
			int currentMonth = calendar.get(Calendar.MONTH);
			int currentYear = calendar.get(Calendar.YEAR);
			
			
			//Future Date
			while(currentMonth < targetMonth || currentYear < targetYear) {
				driver.findElement(By.className("ui-datepicker-next")).click();
				currentDate = driver.findElement(By.className("ui-datepicker-title")).getText();
				currentDateFormat = new SimpleDateFormat("MMM yyyy");
				currentTargetDate = currentDateFormat.parse(currentDate);
				calendar.setTime(currentTargetDate);
				currentMonth = calendar.get(Calendar.MONTH);
				currentYear = calendar.get(Calendar.YEAR);
			}
			
			//Past Date
			while(currentMonth > targetMonth || currentYear > targetYear) {
				driver.findElement(By.className("ui-datepicker-prev")).click();
				currentDate = driver.findElement(By.className("ui-datepicker-title")).getText();
				currentDateFormat = new SimpleDateFormat("MMM yyyy");
				currentTargetDate = currentDateFormat.parse(currentDate);
				calendar.setTime(currentTargetDate);
				currentMonth = calendar.get(Calendar.MONTH);
				currentYear = calendar.get(Calendar.YEAR);
			}
			
			if(currentMonth == targetMonth && currentYear == targetYear)
				driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td[not(contains(@class,'ui-datepicker-other-month'))]//a[text()="+targetday+"]")).click();
			else
				throw new Exception("unable to select the dates beacause of missing target & current dates");		
		
		
	} 

}
