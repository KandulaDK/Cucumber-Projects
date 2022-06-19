package org.projectsHyr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class calendars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		
		driver.findElement(By.id("first_date_picker")).click();
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar'] //a[text()='14']")).click();
		
		driver.findElement(By.id("second_date_picker")).click();
		WebElement cal = driver.findElement(By.id("ui-datepicker-div"));
		
		cal.findElement(By.xpath("//table[@class='ui-datepicker-calendar'] //td[@class=' '] //a[text()='30']")).click();
		
	}

}
