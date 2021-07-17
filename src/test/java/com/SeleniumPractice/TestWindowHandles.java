package com.SeleniumPractice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWindowHandles {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		Thread.sleep(3000);
		
		//Single Window
//		String ParentWindowHandle =driver.getWindowHandle();
//		System.out.println("Parent window Handle -" + ParentWindowHandle + "Title -" + driver.getTitle());
//		Thread.sleep(3000);
//		driver.findElement(By.id("newWindowBtn")).click();
//		Thread.sleep(3000);
//		Set<String> WindowHandles = driver.getWindowHandles();
//		for (String WindowHandle : WindowHandles) {
//			if(!WindowHandle.equals(ParentWindowHandle)) {
//				driver.switchTo().window(WindowHandle);
//				driver.manage().window().maximize();
//				driver.findElement(By.id("firstName")).sendKeys("SK");
//				Thread.sleep(3000);
//				driver.close();
//			}
//			//System.out.println(WindowHandle + driver.getTitle());
//		}
//		driver.switchTo().window(ParentWindowHandle);
//		driver.findElement(By.id("name")).sendKeys("Shiv");
		
		
		//Single Tab
		String ParentWindowHandle =driver.getWindowHandle();
		System.out.println("Parent window Handle -" + ParentWindowHandle + "Title -" + driver.getTitle());
		Thread.sleep(3000);
		driver.findElement(By.id("newTabBtn")).click();
		Thread.sleep(3000);
		Set<String> WindowHandles = driver.getWindowHandles();
		for (String WindowHandle : WindowHandles) {
			if(!WindowHandle.equals(ParentWindowHandle)) {
				driver.switchTo().window(WindowHandle);
				System.out.println(driver.findElement(By.id("output")).getText());
				driver.findElement(By.id("alertBox")).click();
				System.out.println(driver.switchTo().alert().getText());
				Thread.sleep(3000);
				driver.switchTo().alert().accept();
				System.out.println(driver.findElement(By.id("output")).getText());
				Thread.sleep(3000);
				driver.close();
			}
		}
		driver.switchTo().window(ParentWindowHandle);
		driver.findElement(By.id("name")).sendKeys("Shiv");

		
		
		Thread.sleep(3000);
		driver.quit();
		

	}

}
