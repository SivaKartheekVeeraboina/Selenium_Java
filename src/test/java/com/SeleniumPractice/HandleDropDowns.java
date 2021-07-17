package com.SeleniumPractice;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDowns {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		Thread.sleep(3000);
		//SingleSelectionDropDown
//		WebElement courseElement =  driver.findElement(By.id("course"));
//		Select courseNameDropDown = new Select(courseElement);
//		List<WebElement> courseNameDropDownOptions = courseNameDropDown.getOptions();
//		for (WebElement option : courseNameDropDownOptions) {
//			System.out.println(option.getText());
//		}
//		courseNameDropDown.selectByIndex(1); //java
//		Thread.sleep(3000);
//		courseNameDropDown.selectByValue("net"); //dotnet
//		Thread.sleep(3000);
//		courseNameDropDown.selectByVisibleText("Python");  //python
//		Thread.sleep(3000);
//		String SelectedText = courseNameDropDown.getFirstSelectedOption().getText();
//		System.out.println("Selected visible Text - "+ SelectedText);
		
		//MultiSelectionDropDown
		WebElement ideElement =  driver.findElement(By.id("ide"));
		Select ideDropDown = new Select(ideElement);
		List<WebElement> ideDropDownOptions = ideDropDown.getOptions();
		for (WebElement option : ideDropDownOptions) {
			System.out.println(option.getText());
		}
		ideDropDown.selectByIndex(0); //Eclipse
		Thread.sleep(3000);
		ideDropDown.selectByValue("ij"); //IntelliJ Idea
		Thread.sleep(3000);
		ideDropDown.selectByVisibleText("NetBeans");  //NetBeans
		Thread.sleep(3000);
		
		ideDropDown.deselectByVisibleText("IntelliJ IDEA");
		
		List<WebElement>  SelectedOptions = ideDropDown.getAllSelectedOptions();
		for (WebElement selectedOption: SelectedOptions) {
			System.out.println("Selected visible Text - "+ selectedOption.getText());
		}
	}

}
