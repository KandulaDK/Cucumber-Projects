package org.projectsHyr;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class JSExecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor ex = (JavascriptExecutor)driver;
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/basic-controls.html");
		
		ex.executeScript("window.scroll(0,500)");
		
		ex.executeScript("document.getElementById('firstName').setAttribute('style','border:2px grey solid;background:green;color:white;font-size:30px;text-align:center')");
		
		WebElement firstName =  driver.findElement(By.id("firstName"));
		WebElement lastName =  driver.findElement(By.id("lastName"));
		WebElement email =  driver.findElement(By.id("email"));
		WebElement radioFemale = driver.findElement(By.id("femalerb"));
		
		Object[] wb =  new Object[4];
		wb[0]=firstName;
		wb[1]=lastName;
		wb[2]=email;
		wb[3]=radioFemale;
		
		
		
		ex.executeScript("arguments[0].value='dinesh kumar';", wb);
		ex.executeScript("arguments[1].value='dinesh kumar';", wb);
		ex.executeScript("arguments[2].value='dinesh kumar';", wb);
		ex.executeScript("arguments[3].click();", wb);
		ex.executeScript("arguments[3].style.border;", wb);
		
		
		
		
	}

}
