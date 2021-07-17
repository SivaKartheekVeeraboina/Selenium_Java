package com.SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XPathPractice {
	private static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		chapter9();

	}
	
	public static void highlight(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", element);
	}
	
	//Types of Xpath
	public static void chapter2() {
		driver.get("https://www.w3schools.com/");
		
		//Absolute Xpath
		//highlight(driver.findElement(By.xpath("/html/body/div[3]/a[4]")));
		
		//Relative Xpath
		highlight(driver.findElement(By.xpath("//a[@title='Exercises']")));
	}
	
	//Xpath using Attributes
	public static void chapter3() {
		driver.get("https://www.w3schools.com/");
		//Relative Xpath
		//driver.findElement(By.xpath("//a[@id='w3loginbtn']")).click();
		driver.findElement(By.xpath("//a[@title=\"Search W3Schools\"]")).click();
	}
	
	//Xpath Operators
	public static void chapter4() {
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
//		driver.findElement(By.xpath("//input[@maxlength=10]")).sendKeys("Test");
//		driver.findElement(By.xpath("//input[@maxlength!=10]")).sendKeys("Test2");
		
		List<WebElement> elements = driver.findElements(By.xpath("//input[@maxlength<=15]"));
		for (WebElement element : elements) {
			highlight(element);
		}
		
	}
	
	//Xpath Conditions
	public static void chapter5() {
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
//		List<WebElement> elements = driver.findElements(By.xpath("//input[@maxlength<= 1 and  @name = 'ne' or @type= 'tt']"));
//		System.out.println("Invalid:" + elements.size());
//		List<WebElement> elementss = driver.findElements(By.xpath("//input[@maxlength<= 15 or  @name = 'namgge' or @type= 'texggt']"));
//		System.out.println("Valid:" +elementss.size());
		List<WebElement> elementsss = driver.findElements(By.xpath("//input[not(@maxlength= 10)]"));
		System.out.println("Valid:" +elementsss.size()); 
		
	}
	
	//Xpath with Index
	
	public static void chapter6() {
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		highlight(driver.findElement(By.xpath("//table[@id= 'contactList']/tbody/tr[2]")));
		highlight(driver.findElement(By.xpath("(//table[@id= 'contactList']/tbody/tr/td)[23]")));
	}
	
	//Xpath Functions
	
	public static void chapter7() {
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		//Text
		highlight(driver.findElement(By.xpath("//a[text()='Sign in']")));
		highlight(driver.findElement(By.xpath("//h1[text()='Register']")));
		
		//Contains
		highlight(driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")));
		
		//with attribute
		highlight(driver.findElement(By.xpath("//div[contains(@class,'signin')]")));
		 
		//starts with
		highlight(driver.findElement(By.xpath("//a[starts-with(text(),'Sign in into')]")));
		
		//Normalize space		
		highlight(driver.findElement(By.xpath("//label[normalize-space(text())= 'First Name']")));

		//Last
		highlight(driver.findElement(By.xpath("(//table[@id = 'contactList']/tbody/tr)[last()]")));

		//position
		System.out.println(driver.findElements(By.xpath("(//table[@id = 'contactList']/tbody/tr)[position()>2]")).size());	
		
	}
	
	//Xpath Axes
	
	public static void chapter8() { 
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		
		//following-sibling
		highlight(driver.findElement(By.xpath("//label[text()='Email']/following-sibling::input[@type = 'text']")));
		
		//preceeding-sibling
		highlight(driver.findElement(By.xpath("//label[text()='Email']/following-sibling::input[@type = 'text']")));
		
		//child
		driver.findElement(By.xpath("//td[text()='Maria Anders']/preceding-sibling::td/child::input")).click();
		
		//parent
		highlight(driver.findElement(By.xpath("//td[text() = 'Helen Bennett']/parent::tr")));
		
		//Ancestor
		List<WebElement> elements = driver.findElements(By.xpath("//td[text() = 'Helen Bennett']/ancestor:: div"));
		System.out.println("Ancestor:" +elements.size());
		
		//Ancestor self
		List<WebElement> elementss = driver.findElements(By.xpath("//td[text() = 'Helen Bennett']/ancestor-or-self::*"));
		System.out.println("Ancestor seld:" +elementss.size());
		
		//Descendant  
		List<WebElement> elementsss = driver.findElements(By.xpath("//table[@id = 'contactList']/descendant::tr"));
		System.out.println("Descendant:" +elementsss.size());
		
		//Desecdant or self
		List<WebElement> elementssss = driver.findElements(By.xpath("//table[@id = 'contactList']/descendant-or-self::*"));
		System.out.println("Descendant self:" +elementssss.size());
		
		//following
		//highlight(driver.findElement(By.xpath("//label[text()='Password']/parent::div/following-sibling::div[1]/child::input")));
		
		//following shortform
		highlight(driver.findElement(By.xpath("//label[text()='Password']/following::input")));
		
		//Preceding shortform
		highlight(driver.findElement(
		By.xpath("//label[text()='Password']/preceding::input[1]")));
		 
	}
	
	//Xpath Shortcuts
	//a[contains(text(), 'account')] == //a[contains(., 'account')]
	
	public static void chapter9() {
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		
		//text "." can be used instead of text
		//highlight(driver.findElement(By.xpath("//h1[.='Register']")));
		
		//contains
		//highlight(driver.findElement(By.xpath("//a[contains(., 'account')]")));
		
		//starts-with  
		//highlight(driver.findElement(By.xpath("//td[starts-with(., 'Maria')]")));
		
		//Normalize-space
		//highlight(driver.findElement(By.xpath("//label[normalize-space(text())='First Name']")));
		
		//div[@class = 'container']/child::h1 == //div[@class = 'container']/h1
		
		//child short form -> /
		//highlight(driver.findElement(By.xpath("//div[@class = 'container']/h1")));
		
		//Parent ->/..
//		highlight(driver.findElement(By.xpath("//h1[.='Register']/..")));
		
		//descendant -> //f
		//table[@id='contactList']/descendant::td == //table[@id='contactList']//td
		List<WebElement> elements = driver.findElements(By.xpath("//table[@id='contactList']/descendant::td"));
		for (WebElement element : elements) {
			highlight(element);
		}
		
		
	}
	
	
	 

}
