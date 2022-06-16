package org.flipkart.stepdefintion;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Realme {
	
	static WebDriver driver;
	@BeforeClass
	public static void launch() {
		System.out.println("browser launch ");
		WebDriverManager.edgedriver().setup();  
		
	 driver= new EdgeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@AfterClass
	public static void quit() {
		System.out.println("browser quit");
		driver.quit();
	}
	long starttime;
	@Before
	public void beforemethod() {
		System.out.println("beforemethod");
		long starttime = System.currentTimeMillis();
		
	}
	@After
	public  void aftermethod() {
		System.out.println("aftermethod");
		long endtime = System.currentTimeMillis();
		System.out.println("timetaken:"+(endtime-starttime));
	}
	
	@Test
	public void method1() {
		System.out.println("login");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
	}
	@Test
	public void method2() {
		System.out.println("mobilesearch");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("realme mobiles");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@Test
	public void method3() throws Throwable {
		System.out.println("windowshandling");
		driver.findElement(By.xpath("(//div[@class='_4rR01T'])[4]")).click();
		Set<String> child = driver.getWindowHandles();
		List<String> l= new ArrayList<String>(child);
		driver.switchTo().window(l.get(1));
		Thread.sleep(5000);
		String text2 = driver.findElement(By.xpath("//span[@class='B_NuCI']")).getText();
		//System.out.println(text2);
	}
	@Ignore
	@Test
	public void method4() throws IOException {
		System.out.println("add to cart");
		JavascriptExecutor js =(JavascriptExecutor)	driver;
		WebElement add = driver.findElement(By.xpath("//button[@class='_2KpZ6l _1t_O3S _2ti6Tf _3AWRsL']"));
		js.executeScript("arguments[0].scrollIntoView(true)", add);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\DURGA\\eclipse-workspace\\Junit\\src\\test\\resources\\mobiles");
		FileUtils.copyFile(src, dest);
		
	}
}
