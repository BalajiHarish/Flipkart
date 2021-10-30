package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.FlightsPage;
import com.qa.pages.HomePage;
import com.qa.pages.TravelPage;

public class SearchFlights extends BaseTest {

	protected SearchFlights() {
		
	}
	
	@Test
	public void getFlightPrices() throws Exception {
		
		HomePage homepage = new HomePage();
		TravelPage travelpage = new TravelPage();
		FlightsPage flightpage = new FlightsPage();
		
		homepage.clickCloseLoginDialogBoxButton();
		homepage.clickOnSubMenuItem("Travel");
		Thread.sleep(1500); //Sometime page load not proper - just used incase to avoid failures
		
		Assert.assertTrue(travelpage.isOneWaySelectedByDefault(), "One Way Category is not selected by default");
		travelpage.clickOnRoundTripCategory();
		travelpage.selectFromCity("Kolkata");
		travelpage.selectToCity("Chennai");
		travelpage.selectDepartureDate_CalenderDate("November", 1);
		travelpage.selectReturnDate_CalenderDate("November", 30);
		travelpage.addAdultTraveller(2);
		travelpage.addChildTraveller(1);
		Assert.assertTrue(travelpage.verifyIsEconomySelectByDefault(), "Economy Cabin Class is not selected by default");
		travelpage.clickSearchFlightsButton();
		
		Assert.assertTrue(flightpage.verifyIsNonStopPreferenceNotSelected(), "Non-Stop Preference selected by default");
		flightpage.clickNonStopPreference_Button();
		Thread.sleep(3000);  //Unable to use wait because the flights list getting changed without DOM elements load after clicking on Non-Stop preference
		System.out.println("Departure Flights Prices: " + flightpage.getDepartureFlightsPrice());
		flightpage.selectLastDepartureFlight();
		Thread.sleep(3000);
		System.out.println("Return Flights Prices: " + flightpage.getReturnFlightsPrice());
		flightpage.selectLastReturnFlight();
		flightpage.clickBookFlightsButton();
		
		Thread.sleep(3000);
		System.out.println(flightpage.getReviewFlightsPageTitle());
		Assert.assertEquals(flightpage.getReviewFlightsPageTitle(), "Review Store Online - Buy Review Online at Best Price in India | Flipkart.com", "Page not redirected to review flights page");
		
		Thread.sleep(3000);
	}
}
