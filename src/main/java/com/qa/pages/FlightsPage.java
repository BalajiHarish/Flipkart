package com.qa.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;

import com.qa.enums.WaitStrategy;
import com.qa.utils.BrowserActions;
import com.qa.utils.DynamicXpathUtils;

public class FlightsPage extends BrowserActions {

	private By nonStopPreference = By.xpath("(//div[text()='Preference']//following::div[@class='non-stop']//span/span)[1]");
	
	public boolean verifyIsNonStopPreferenceNotSelected() {
		
		String attributeValue = getAttributeValue(nonStopPreference, "class", WaitStrategy.CLICKABLE);
		return attributeValue.equalsIgnoreCase("c-switch switch-off");
	}
	
	public void clickNonStopPreference_Button() throws Exception {
		
		click(nonStopPreference, WaitStrategy.CLICKABLE);
	}
	
	private By departureFlightsPrice_text = By.xpath("(//div[@class='result-wrpr']//div[@class='result-col-inner'])[1]//div[@class='price']//span[2]");
	
	public ArrayList<String> getDepartureFlightsPrice() {
		
		return getElementsText(departureFlightsPrice_text);
	}
	
	private By returnFlightsPrice_text = By.xpath("(//div[@class='result-wrpr']//div[@class='result-col-inner'])[2]//div[@class='price']//span[2]");
	
	public ArrayList<String> getReturnFlightsPrice() {
		
		return getElementsText(returnFlightsPrice_text);
	}
	
	private String lastDepartureFlight_layout = "((//div[@class='result-wrpr']//div[@class='result-col-inner'])[1]//div[@class='radio-list-item'])[%s]";
	
	public void selectLastDepartureFlight() throws Exception {
		
		int noOfFlights = getCountOfElements(departureFlightsPrice_text);
		String newxpath = DynamicXpathUtils.getNewXpath(lastDepartureFlight_layout, Integer.toString(noOfFlights));
		clickJS(By.xpath(newxpath), WaitStrategy.CLICKABLE);
	}
	
	private String lastReturnFlight_layout = "((//div[@class='result-wrpr']//div[@class='result-col-inner'])[2]/div)[%s]";
	
	public void selectLastReturnFlight() throws Exception {
		
		int noOfFlights = getCountOfElements(returnFlightsPrice_text);
		String newxpath = DynamicXpathUtils.getNewXpath(lastReturnFlight_layout, Integer.toString(noOfFlights));
		clickJS(By.xpath(newxpath), WaitStrategy.CLICKABLE);
	}
	
	private By bookFlights_button = By.xpath("//button[text()='Book']");
	
	public void clickBookFlightsButton() throws Exception {
		
		click(bookFlights_button, WaitStrategy.CLICKABLE);
	}
	
	public String getReviewFlightsPageTitle() {
		
		return getTitle();
	}
}
