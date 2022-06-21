package org.projectsHyr;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithTestNG {
	
	private static Logger log = LogManager.getLogger(WorkingWithTestNG.class.getName());
//	@Test
//	public void openingChrome() {
//		
//		
//	}	
	public static void main(String[] args) {
		log.debug("I am debuging");
		if(true) 
			log.info("object is present");
		log.error("object is not present");
		
		log.fatal("this is fatal");
		
	}
}
