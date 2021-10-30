package com.qa.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.qa.driver.DriverManager;
import com.qa.enums.WaitStrategy;

public class BrowserActions {

	protected void click(By by, WaitStrategy waittype) throws Exception {		
		WebElement element = ExplicitWaitUtils.performExplicitWait(waittype, by);
		element.click();
	}
	
	protected void clickJS(By by, WaitStrategy waittype) {
		
		WebElement element = ExplicitWaitUtils.performExplicitWait(waittype, by);
		JavascriptExecutor executor = (JavascriptExecutor)DriverManager.getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	protected void sendKeys(By by, String value, WaitStrategy waittype) throws Exception {
		WebElement element = ExplicitWaitUtils.performExplicitWait(waittype, by);
		element.sendKeys(value);
	}

	protected String getTitle() {
		return DriverManager.getDriver().getTitle();
	}
	
	protected String getAttributeValue(By by, String attributeName, WaitStrategy waittype) {
		
		WebElement element = ExplicitWaitUtils.performExplicitWait(waittype, by);
		return element.getAttribute(attributeName);
	}
	
	protected boolean verifyIsElementVisible(By by, WaitStrategy waittype) {
		
		WebElement element = ExplicitWaitUtils.performExplicitWait(waittype, by);
		return element.isDisplayed();
	}
	
	protected ArrayList<String> getElementsText(By by) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		List<WebElement> element = DriverManager.getDriver().findElements(by);
		
		for(int i = 0; i < element.size(); i++) {
			
			list.add(element.get(i).getText());
		}
		
		return list;
	}
	
	protected int getCountOfElements(By by) {
		
		List<WebElement> element = DriverManager.getDriver().findElements(by);
		return element.size();
	}
}
