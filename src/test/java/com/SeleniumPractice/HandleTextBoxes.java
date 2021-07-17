package com.SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleTextBoxes {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.github.com/login");
		Thread.sleep(3000);
		WebElement usernameTxt = driver.findElement(By.id("login_field"));
		if(usernameTxt.isDisplayed()) {
			if(usernameTxt.isEnabled()) {
				usernameTxt.sendKeys("SK");
				String  enteredTxt = usernameTxt.getAttribute("value");
				System.out.println(enteredTxt);
				Thread.sleep(3000);
				usernameTxt.clear();
			}
			else 
				System.err.println("username textbox is not enabled");
		}
		else 
			System.err.println("username textbox is not displayed");
	}

}
