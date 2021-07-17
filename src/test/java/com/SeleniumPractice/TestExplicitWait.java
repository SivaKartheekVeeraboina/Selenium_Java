package com.SeleniumPractice;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

//Video link//
//https://www.youtube.com/watch?v=_fEHxdMb6V4&list=PLacgMXFs7kl_7BbV1p_KqDYM65Zm4L_HU&index=20&ab_channel=HYRTutorials  //

public class TestExplicitWait {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().window().setSize(new Dimension(1000, 1000));
		 
		WebDriverWait wait = new WebDriverWait(driver, 10, 500);
//		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
//		wait.withTimeout(Duration.ofSeconds(10));
		
		driver.get("https://testproject.io/");
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.linkText("Login")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String windowHandle : windowHandles) {
			if(!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				Function<WebDriver, Boolean> f = new Function<WebDriver, Boolean>() {

					public Boolean apply(WebDriver webDriver) {
						return webDriver.findElement(By.id("username")).isDisplayed();
					}
				};
				wait.until(f);
				//wait.until(d->d.findElement(By.id("username")).isDisplayed());
				//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("username")));
				driver.findElement(By.id("username")).sendKeys("SK");
			}
		}
		
	}

}
