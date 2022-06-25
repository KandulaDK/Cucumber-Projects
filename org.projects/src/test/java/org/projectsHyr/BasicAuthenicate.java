package org.projectsHyr;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicAuthenicate {
	static WebDriver driver;
	private static Logger log = LogManager.getLogger(BasicAuthenicate.class.getName());
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		log.info("Driver was created and browser is opening");
		
//		driver.get("http://admin:admin@the-internet.herokuapp.com/");
//		
//		driver.findElement(By.linkText("Basic Auth")).click();
//				
//		String msg = driver.findElement(By.tagName("p")).getText();
//		System.out.println(msg);
//		
//		if (msg.equals("Congratulations! You must have the proper credentials.")) {
//			log.info("Login Sucess Congratualtions msg was displayed");
//		}else {
//			log.error("login failed.");
//		}
		
		uploadFile();

	}
	
	public static void uploadFile() throws InterruptedException, IOException {
//		Actions a = new Actions(driver);
//		driver.switchTo().newWindow(WindowType.TAB);
//		Set<String> windows = driver.getWindowHandles();
//		Iterator<String> i =	windows.iterator();
//		i.next();
//		driver.switchTo().window(i.next());
		driver.navigate().to("https://jpg2pdf.com/");
		log.info("opening Jpg to pdf page..");
		driver.findElement(By.cssSelector("label[aria-label='Upload Files']")).click();
		log.info("clicked on Upload File button");
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\DinnuBunny\\Downloads\\New folder\\fileupload.exe");
		log.info("choosing the file to upload");
		
		//span[class='file-button__text file-button__text_title'] ---download button
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class*='file-button__text']")));
		driver.findElement(By.cssSelector("span[class*='file-button__text']")).click();
		log.info("Clicked on Download Button");
		Thread.sleep(3000);
		driver.quit();
		log.info("Browser Closed...");
		
	}
}
