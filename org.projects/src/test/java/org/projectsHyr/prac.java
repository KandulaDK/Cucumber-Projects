package org.projectsHyr;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class prac {
	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.findElement(By.linkText("Top Deals")).click();
		driver.findElement(By.linkText("Flight Booking")).click();
		
		Set<String> acWin = driver.getWindowHandles();
		Iterator<String> it = acWin.iterator();
//		String firstPage = it.next();
//		System.out.println(it.hasNext());
//		
//		String sPage = it.next();
//		
//		System.out.println(it.hasNext());
//		String TPage = it.next();
//		
//		driver.switchTo().window(TPage);
	
		while(it.hasNext()){
			String page = it.next();
			String url = driver.switchTo().window(page).getCurrentUrl();
			System.out.println(url);
			if(findElement()) {
				driver.findElement(By.xpath("//li //a[@aria-label='Next']")).click();
				break;
			}
			
			
//			String actualUrl = "https://rahulshettyacademy.com/seleniumPractise/#/offers";
			
			
			
//			if(url.equals(actualUrl)) {
//				driver.findElement(By.xpath("//li //a[@aria-label='Next']")).click();
//			}
	
		
		}
		
		

	}
	
	public static boolean findElement() {
		try {
			driver.findElement(By.xpath("//li //a[@aria-label='Next']"));
			return true;
		}catch(NoSuchElementException e) {
			return false;
		}
	}

}
