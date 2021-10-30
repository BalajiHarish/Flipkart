package com.qa.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.driver.DriverManager;
import com.qa.enums.WaitStrategy;

public final class ExplicitWaitUtils {
	
	private ExplicitWaitUtils() {
	
	}

	public static WebElement performExplicitWait(WaitStrategy waittype, By by) {

		WebElement element = null;
		
		if(waittype == WaitStrategy.CLICKABLE) {
			element = new WebDriverWait(DriverManager.getDriver(), 15)
			.until(ExpectedConditions.elementToBeClickable(by)); //old way

			//new WebDriverWait(DriverManager.getDriver(), 10).until(d -> d.findElement(by).isEnabled()); // java 8 way
			//Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS); //Used instead of thread sleep to avoid using try catch exceptions (used from apache commons lang maven jar)
	
		} else if(waittype == WaitStrategy.PRESENCE) {
			element = new WebDriverWait(DriverManager.getDriver(), 15)
			.until(ExpectedConditions.presenceOfElementLocated(by));
		} else if(waittype == WaitStrategy.VISIBLE) {
			element = new WebDriverWait(DriverManager.getDriver(), 15)
			.until(ExpectedConditions.visibilityOfElementLocated(by));
		} else if(waittype == WaitStrategy.NONE) {
			element = DriverManager.getDriver().findElement(by);
		}
		
		return element;
	}
}
