package saleforce_ui;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SaleForce2 {
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
		driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("Service");
		driver.findElement(By.xpath("(//div[@class='slds-app-launcher__tile-body slds-truncate'])[1]")).click();
		WebElement cases = driver.findElement(By.xpath("//span[text()='Cases']"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();", cases);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("(//input[@class='slds-combobox__input slds-input'])[1]")).click();
		driver.findElement(By.xpath("//*[text()='New Contact']")).click();
		driver.findElement(By.xpath("(//a[@class='select'])[1]")).click();
		driver.findElement(By.xpath("//*[text()='Mr.']")).click();
		driver.findElement(By.xpath("//input[contains(@class,'lastName compoundBLRadius')]")).sendKeys("Gangadaran");
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).click();
		driver.findElement(By.xpath("//*[text()='New Account']")).click();
		driver.findElement(By.xpath("(//input[@class=' input'])[1]")).sendKeys("Ganga");
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		driver.findElement(By.xpath("(//button[@data-value='--None--'])[1]")).click();
	}

}
