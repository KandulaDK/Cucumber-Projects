package org.projectsHyr;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import io.github.bonigarcia.wdm.WebDriverManager;

public class prac {
	static WebDriver driver;
	static String nextBtn = "//li //a[@aria-label='Next']";
	
	private static Logger log = LogManager.getLogger(prac.class.getClass());

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		log.info("opened greencart website");
		driver.findElement(By.linkText("Top Deals")).click();
		log.trace("clicked on Top Deals");
		driver.findElement(By.linkText("Flight Booking")).click();
		driver.findElement(By.cssSelector("a[class*='cart-header-navlink blinkingText']")).click();

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

		do {
			String page = it.next();
			String url = driver.switchTo().window(page).getCurrentUrl();
			System.out.println(url);
			if (findElement()) {
				driver.findElement(By.xpath("//li //a[@aria-label='Next']")).click();
//				File tss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//				try {
//					FileUtils.copyFile(tss, new File("C:\\Users\\DinnuBunny\\Music/image.png"));
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
				break;
			}
		} while (it.hasNext());
		driver.quit();
	
		
//			String actualUrl = "https://rahulshettyacademy.com/seleniumPractise/#/offers";

//			if(url.equals(actualUrl)) {
//				driver.findElement(By.xpath("//li //a[@aria-label='Next']")).click();
//			}

	}

	public static boolean findElement() {
		try {
			driver.findElement(By.xpath(nextBtn));
			return true;
		} catch (Exception err) {
//			System.out.println(err.getMessage());
//			e.printStackTrace();
			return false;
		}
	}

}
