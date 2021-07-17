package com.SeleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.microsoft.edge.seleniumtools.EdgeDriver;
import com.microsoft.edge.seleniumtools.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

//Video Link
//https://www.youtube.com/watch?v=h1Mj-V_onP8&list=PLacgMXFs7kl_7BbV1p_KqDYM65Zm4L_HU&index=20&ab_channel=HYRTutorials

public class TestBrowserMaximization {

	public static void main(String[] args) throws Exception{
		//Way 1 - Chrome
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.google.com/");
		
		//Way - 1 firefox
//		WebDriverManager.firefoxdriver().setup();
//		WebDriver driver = new FirefoxDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.google.com/");
		
		//Way - 1 Edge
//		WebDriverManager.edgedriver().setup();
//		WebDriver driver = new EdgeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.google.com/");
		
		//Way 2 - Chrome
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("start -maximized");
//		WebDriver driver = new ChromeDriver(options);
//		Thread.sleep(3000);
//		driver.get("https://www.google.com/");
		
		//Way 2 - Edge
		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
		options.addArguments("start -maximized");
		WebDriver driver = new EdgeDriver(options);
		Thread.sleep(3000);
		driver.get("https://www.google.com/");
		
		 
	}

}
