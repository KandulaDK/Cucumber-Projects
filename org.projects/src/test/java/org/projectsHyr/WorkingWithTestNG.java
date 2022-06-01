package org.projectsHyr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithTestNG {
	@Test
	public void openingChrome() {
		WebDriverManager.chromedriver().setup();
		WebDriver dinnu = new ChromeDriver();
		
		dinnu.get("https://www.google.com");
	}
}
