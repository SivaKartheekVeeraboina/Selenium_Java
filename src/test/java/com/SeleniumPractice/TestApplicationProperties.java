package com.SeleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//Video Link
//https://youtu.be/NJd5i4rw3Rg

public class TestApplicationProperties {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://www.seleniumhq.org");
		
		//URL
		String CurrentUrl = driver.getCurrentUrl();
		System.out.println("Current URL: " + CurrentUrl);
		
		
		//TITLE
		String title = driver.getTitle();
		System.out.println("Current TITLE: " + title);
		
		//HTML PAGE SOURCE
		String PageSource = driver.getPageSource();
		System.out.println("Current PageSource: " + PageSource);
		
		driver.quit();
	}

}
