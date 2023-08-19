package saleforce_ui;

import java.security.Key;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SaleForce {
	
	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("shankarec24@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Testleaf@123");
		driver.findElement(By.id("Login")).click();
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.className("slds-icon-waffle")).click();
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
		driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("Marketing");
		driver.findElement(By.xpath("(//*[@class='slds-truncate'])[2]")).click();
		JavascriptExecutor j = (JavascriptExecutor) driver;
		
		
		WebElement leadElement = driver.findElement(By.xpath("//span[text()='Leads']"));
		j.executeScript("arguments[0].click();", leadElement);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("//button[@name='salutation']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("test");
		driver.findElement(By.xpath("//input[@name='Company']")).sendKeys("testleaf");
		
		
		driver.findElement(By.xpath("//button[text()='Save']")).sendKeys(Keys.ENTER);
		
		
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_icon-border-filled']")).click();
		
		driver.findElement(By.xpath("//*[text()='Convert']")).click();
		WebElement element = driver.findElement(By.xpath("(//input[@type='text'])[6]"));
		element.clear();
		element.sendKeys("Testleaf-Ganga");
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		driver.findElement(By.xpath("//*[text()='Go to Leads']")).click();
		
		driver.findElement(By.xpath("//*[@name='Lead-search-input']")).sendKeys("shankarec24@gmail.com");
		driver.findElement(By.xpath("//*[@name='Lead-search-input']")).sendKeys(Keys.ENTER);
//		WebElement noItemElement = driver.findElement(By.xpath("//span[text()='No items to display.']"));
//		if (noItemElement.isDisplayed()) {
//			System.out.println("success");
//		}else {
//			System.out.println("not sucess");
//		}
//		
		WebElement oppButton = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		j.executeScript("arguments[0].click();", oppButton);
		
		
		
	}

}
