package com.SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestJavascriptExecutor {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
//		driver.get("https://www.hyrtutorials.com/");
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		
		//id
//		WebElement element = (WebElement) jsExecutor.executeScript("return document.getElementById('email');");
//		element.sendKeys("id");
		
		//name
//		WebElement element = (WebElement) jsExecutor.executeScript("return document.getElementsByName('email')[0]");
//		element.sendKeys("name");
		
		//css
//		WebElement element = (WebElement) jsExecutor.executeScript("return document.querySelector('#email')");
//		element.sendKeys("css");
		 
		//xpath
//		WebElement element = (WebElement) jsExecutor.executeScript("return document.evaluate(\"//input[@id='email']\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue");
//		element.sendKeys("xpath");
		
		
//		jsExecutor.executeScript("document.getElementById('email').value='Id';");
//		Thread.sleep(3000);
//		jsExecutor.executeScript("document.getElementsByName('email')[0].value='Name';");
//		Thread.sleep(3000);
//		jsExecutor.executeScript("document.getElementsByClassName('inputtext')[0].value='ClassName';");
//		Thread.sleep(3000);
//		jsExecutor.executeScript("document.getElementsByTagName('input')[2].value='TagName';");
//		Thread.sleep(3000);
//		jsExecutor.executeScript("document.querySelector('#email').value='Css';");
//		Thread.sleep(3000);
//		jsExecutor.executeScript("document.evaluate(\"//input[@id='email']\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.value='xpath';");

		//Click Operation
//		jsExecutor.executeScript("document.getElementsByName('login')[0].click()");
//		jsExecutor.executeScript("document.getElementById('email').style.border='5px red solid';");
//		jsExecutor.executeScript("document.getElementById('email').style.background='yellow';");
//		jsExecutor.executeScript("document.getElementById('email').setAttribute('style','border:5px red solid;background:yellow')");
		
//		jsExecutor.executeScript("window.scrollTo(0,500)");
//		Thread.sleep(3000);
//		jsExecutor.executeScript("window.scrollBy(0,500)");
//		Thread.sleep(3000);
//		jsExecutor.executeScript("document.getElementById('ty_footer').scrollIntoView();");
		
		WebElement username = driver.findElement(By.id("email"));
		jsExecutor.executeScript("arguments[0].setAttribute('style','border:5px red solid;background:yellow');", username);
		
	
	}

}



























