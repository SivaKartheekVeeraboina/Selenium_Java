package com.SeleniumPractice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScreenShots {

	public static void main(String[] args) throws Exception {
//		WebDriverManager.chromedriver().setup();
//		ChromeDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		
//		driver.get("https://www.google.com/");
		
		//File
//		File sourceFile = driver.getScreenshotAs(OutputType.FILE);
//		File destFile = new File("./Screenshots/img1.jpg");
//		FileUtils.copyFile(sourceFile, destFile);
//		System.out.println("Screenshot saved successfully");
		
		//Bytes
//		byte[] byteArr = driver.getScreenshotAs(OutputType.BYTES);
//		File destFile = new  File("./Screenshots/img1.jpg");
//		FileOutputStream fos = new FileOutputStream(destFile);
//		fos.write(byteArr);
//		fos.close();
//		System.out.println("Screenshot saved successfully");
		
		//Base64
//		String base64code = driver.getScreenshotAs(OutputType.BASE64);
//		byte[] byteArr = Base64.getDecoder().decode(base64code);
//		File destFile = new File("./Screenshots/img1.jpg");
//		FileOutputStream fos = new FileOutputStream(destFile);
//		fos.write(byteArr);
//		fos.close();
//		System.out.println("Screenshot saved successfully");

		////////WedDriver//////////
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		
		//File
//		TakesScreenshot takesScreenShot = (TakesScreenshot) driver;
//		File sourceFile = takesScreenShot.getScreenshotAs(OutputType.FILE);
//		File destFile = new File("./Screenshots/img1.jpg");
//		FileUtils.copyFile(sourceFile, destFile);
//		System.out.println("Screenshot saved successfully");
		
		//Bytes
//		TakesScreenshot takesScreenShot = (TakesScreenshot) driver;
//		byte[] byteArr = takesScreenShot.getScreenshotAs(OutputType.BYTES);
//		File destFile = new  File("./Screenshots/img1.jpg");
//		FileOutputStream fos = new FileOutputStream(destFile);
//		fos.write(byteArr);
//		fos.close();
//		System.out.println("Screenshot saved successfully");
		
		//Base64
		TakesScreenshot takesScreenShot = (TakesScreenshot) driver;
		String base64code = takesScreenShot.getScreenshotAs(OutputType.BASE64);
		byte[] byteArr = Base64.getDecoder().decode(base64code);
		File destFile = new File("./Screenshots/img1.jpg");
		FileOutputStream fos = new FileOutputStream(destFile);
		fos.write(byteArr);
		fos.close();
		System.out.println("Screenshot saved successfully");

		
		
		
		driver.quit();
	}

}
