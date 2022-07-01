package org.projectsHyr;


import org.apache.logging.log4j.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Logging4J {
	
	private static Logger log = LogManager.getLogger(Logging4J.class.getClass());
//	@Test
//	public void openingChrome() {
//		
//		log4J logging the logs in the console
	
//	}	
	public static void main(String[] args) {
		
		
		
		log.debug("I am debuging");
		if(true) 
			log.info("object is present");
		log.error("object is not present");
		
		log.fatal("this is fatal");
		
	}
}
