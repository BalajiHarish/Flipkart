package com.qa.driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Driver initialization are done in this class
 * <p> It is responsible for launching browser and initializing driver <p>
 * @author Balaji
 * @see DriverManager
 * @see com.qa.testcases.BaseTest
 *
 */

public final class DriverClass {

	private DriverClass() {

	}

	public static void initializeDriver(String browserName, String url) throws Exception {

		//We check whether the driver is null first, bcz to avoid launching browser multiple times, if any one calls initialize driver method in test case without knowing hook class is already exist
		//How it works - since we assign something to driver in before method itself, when it comes to @test it wont be null for that particular test case till it is quit
		if(Objects.isNull(DriverManager.getDriver())) {
			if(browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				DriverManager.setDriver(new ChromeDriver());
			} else if(browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				DriverManager.setDriver(new FirefoxDriver());
			} else if(browserName.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				DriverManager.setDriver(new EdgeDriver());
			}
			
			DriverManager.getDriver().get(url);
			DriverManager.getDriver().manage().window().maximize();
		}
	}

	public static void quitDriver() {

		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
