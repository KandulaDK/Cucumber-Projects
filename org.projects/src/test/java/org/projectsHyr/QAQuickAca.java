package org.projectsHyr;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import io.github.bonigarcia.wdm.WebDriverManager;

public class QAQuickAca {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 String[]items = {"Tomato","Beans","Carrot","Walnuts","Water"};
		 
		 HashMap<String,Integer> vegList = new  HashMap<String,Integer>();
		 vegList.put("Tomato", 3);
		 
		List<String> vegItems = Arrays.asList(items);
		
		 
		 
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//// div[@class='price']/preceding-sibling::a

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		List<WebElement> lists = driver.findElements(By.xpath("//div[@class='product']"));

		for (WebElement list : lists) {
			String veg = list.findElement(By.tagName("h4")).getText();
//			String price = pri.getText();
			veg = veg.split(" ")[0];
			if (vegItems.contains(veg)) {	
				list.findElement(By.tagName("button")).click();
//				WebElement des = driver.findElement(By.xpath("//li[@class='col-sm-3 col-xs-6']["+i+"]//h3/a"));
////						driver.findElement(RelativeLocator.with(By.xpath("div[@class='item']//h3/a")).above(pri));
////				WebElement des = pri.findElement(By.xpath("/parent::div/parent::div//h3/a"));
//				System.out.println(des.getText());
//				des.click();
			}

		}
//		driver.quit();
	}

}
