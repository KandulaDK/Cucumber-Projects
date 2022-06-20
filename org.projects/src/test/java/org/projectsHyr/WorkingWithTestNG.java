package org.projectsHyr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithTestNG {
	@Test
	public void openingChrome() {
		
		int a = 10;
		int b =++a;
		System.out.println(b);
		System.out.println(a++);
		System.out.println(a);
	}
}
