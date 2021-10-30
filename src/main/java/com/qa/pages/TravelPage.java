package com.qa.pages;

import org.openqa.selenium.By;

import com.qa.enums.WaitStrategy;
import com.qa.utils.BrowserActions;
import com.qa.utils.DynamicXpathUtils;

public class TravelPage extends BrowserActions {

	private By oneWayRadio_Button = By.xpath("//input[@id='ONE_WAY']//following-sibling::div//div");

	public boolean isOneWaySelectedByDefault() {

		String attributeValue = getAttributeValue(oneWayRadio_Button, "data-checked", WaitStrategy.CLICKABLE);
		return attributeValue.equalsIgnoreCase("true");
	}

	private By roundTrip_Button = By.xpath("//input[@type='radio' and @id='ROUND_TRIP']//following::div");

	public void clickOnRoundTripCategory() throws Exception {

		click(roundTrip_Button, WaitStrategy.CLICKABLE);
	}

	private By fromCity_inputField = By.xpath("//div//label[text()='From']//preceding-sibling::input");
	private String fromCity_dropdownValue = "//input[@name='0-departcity']//parent::div/following-sibling::div//span[contains(text(),'%s')]";

	public void selectFromCity(String fromCityName) throws Exception {

		sendKeys(fromCity_inputField, fromCityName, WaitStrategy.CLICKABLE);
		String newxpath = DynamicXpathUtils.getNewXpath(fromCity_dropdownValue, fromCityName);
		click(By.xpath(newxpath), WaitStrategy.CLICKABLE);
	}

	private By toCity_inputField = By.xpath("//div//label[text()='To']//preceding-sibling::input");
	private String toCity_dropdownValue = "//input[@name='0-arrivalcity']//parent::div/following-sibling::div//span[contains(text(),'%s')]";

	public void selectToCity(String toCityName) throws Exception {

		sendKeys(toCity_inputField, toCityName, WaitStrategy.CLICKABLE);
		String newxpath = DynamicXpathUtils.getNewXpath(toCity_dropdownValue, toCityName);
		click(By.xpath(newxpath), WaitStrategy.CLICKABLE);
	}

	private By departureDate_inputField = By.xpath("//input[@name='0-datefrom']");
	private String departureDate_Button = "//table//thead//div[contains(text(),'%s')]//ancestor::thead//following::tbody//button[text()='%s']";

	public void selectDepartureDate_CalenderDate(String departureMonth, int departureDate) throws Exception {

		click(departureDate_inputField, WaitStrategy.CLICKABLE);
		String newxpath = DynamicXpathUtils.getNewXpath(departureDate_Button, departureMonth, departureDate);
		click(By.xpath(newxpath), WaitStrategy.CLICKABLE);
	}

	private By returnDate_inputField = By.xpath("//input[@name='0-dateto']");
	private String returnDate_Button = "//table//thead//div[contains(text(),'%s')]//ancestor::thead//following::tbody//button[text()='%s']";

	public void selectReturnDate_CalenderDate(String returnMonth, int returnDate) throws Exception {

		click(returnDate_inputField, WaitStrategy.CLICKABLE);
		String newxpath = DynamicXpathUtils.getNewXpath(returnDate_Button, returnMonth, returnDate);
		click(By.xpath(newxpath), WaitStrategy.CLICKABLE);
	}
	
	private By travellerDetails_inputField = By.xpath("//input[@name='0-travellerclasscount']");
	private By addAdultTraveller_Button = By.xpath("(//div//label[text()='Travellers']//following::div//div[text()='Adults']//parent::div//following-sibling::div//button)[2]");
	
	public void addAdultTraveller(int noOfAdultTravellers) throws Exception {
		
		click(travellerDetails_inputField, WaitStrategy.CLICKABLE);
		if(noOfAdultTravellers > 1) {
			
			for(int i=1; i<=noOfAdultTravellers-1; i++) {
				
				click(addAdultTraveller_Button, WaitStrategy.CLICKABLE);
			}
		}
	}
	
	private By addChildTraveller_Button = By.xpath("(//div//label[text()='Travellers']//following::div//div[text()='Children']//parent::div//following-sibling::div//button)[2]");
	
	public void addChildTraveller(int noOfChildTravellers) throws Exception {
		
		if(verifyIsElementVisible(addChildTraveller_Button, WaitStrategy.CLICKABLE) == false) {
			
			click(travellerDetails_inputField, WaitStrategy.CLICKABLE);
		}
		
		for(int i=1; i<=noOfChildTravellers; i++) {
			
			click(addChildTraveller_Button, WaitStrategy.CLICKABLE);
		}
	}
	
	private By economyCabinClass_RadioButton = By.xpath("//div//label[text()='Cabin Class']//following::div//div[text()='Economy']");
	
	public boolean verifyIsEconomySelectByDefault() {
		
		String attributeValue = getAttributeValue(economyCabinClass_RadioButton, "data-checked", WaitStrategy.CLICKABLE);
		return attributeValue.equalsIgnoreCase("true");
	}
	
	private By searchFlights_Button = By.xpath("//button//*[text()='SEARCH']");
	
	public void clickSearchFlightsButton() throws Exception {
		
		click(searchFlights_Button, WaitStrategy.CLICKABLE);
	}
}
