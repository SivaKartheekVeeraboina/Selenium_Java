package com.SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFrames {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		Thread.sleep(3000);
		driver.findElement(By.id("name")).sendKeys("Text1"); //Main Document
		Thread.sleep(3000);
		driver.switchTo().frame("frm1"); //Frame1
		
		Select CourseName_dd = new Select(driver.findElement(By.id("course")));
		CourseName_dd.selectByVisibleText("Java");  
		Thread.sleep(3000);
		driver.switchTo().defaultContent(); //Main Document
		
		driver.switchTo().frame("frm2"); //Frame2
		driver.findElement(By.id("firstName")).sendKeys("kartik");
		Thread.sleep(3000);
		driver.switchTo().defaultContent(); //Main Document
		driver.switchTo().frame("frm1"); //Frame1
		
		CourseName_dd.selectByVisibleText("Dot Net");
		
		driver.switchTo().defaultContent(); //Main Document
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("Text2");
		Thread.sleep(3000);

	}

}
