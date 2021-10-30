package com.qa.pages;

import org.openqa.selenium.By;

import com.qa.enums.WaitStrategy;
import com.qa.utils.BrowserActions;
import com.qa.utils.DynamicXpathUtils;

public class HomePage extends BrowserActions {

	private final By closeLoginDialogBox_Button = By.xpath("//div[@class='_2QfC02']/button");

	public void clickCloseLoginDialogBoxButton() throws Exception {

		click(closeLoginDialogBox_Button, WaitStrategy.CLICKABLE);
	}
	
	private String chooseCategory_Button = "//img[@alt='%s']";

	public void clickOnSubMenuItem(String category) throws Exception {

		String newxpath = DynamicXpathUtils.getNewXpath(chooseCategory_Button, category);
		click(By.xpath(newxpath), WaitStrategy.CLICKABLE);
	}
}
