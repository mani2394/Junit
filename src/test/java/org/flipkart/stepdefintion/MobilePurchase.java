package org.flipkart.stepdefintion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class MobilePurchase {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.edge.driver","C:\\Users\\DURGA\\eclipse-workspace\\Junit\\src\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.flipkart.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("realme mobiles");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		File f=new File("C:\\Users\\DURGA\\eclipse-workspace\\Junit\\src\\test\\resources\\Book1.xlsx");
		
		FileOutputStream f1 = new FileOutputStream(f);
		HSSFWorkbook w= new HSSFWorkbook();
		HSSFSheet Sheet = w.createSheet("mani1");
		Thread.sleep(2000);
		List<WebElement> a = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		for (int i = 0; i < a.size(); i++) {
			WebElement realme = a.get(i);
			String text = realme.getText();
				HSSFRow row = Sheet.createRow(i);
				HSSFCell cell = row.createCell(0);
				cell.setCellValue(text);
				w.write(f);
				w.close();
				
			
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='_4rR01T'])[4]")).click();
		Set<String> child = driver.getWindowHandles();
		List<String> l= new ArrayList<String>(child);
		driver.switchTo().window(l.get(1));
		Thread.sleep(5000);
		String text2 = driver.findElement(By.xpath("//span[@class='B_NuCI']")).getText();
		//System.out.println(text2);
		
	     Sheet = w.createSheet("mani2");
	       
	     HSSFRow row = Sheet.createRow(0);
	     HSSFCell cell = row.createCell(0);
	     cell.setCellValue(text2);
			w.write(f);
			w.close();
			Thread.sleep(5000);  
		JavascriptExecutor js =(JavascriptExecutor)	driver;
		WebElement add = driver.findElement(By.xpath("//button[@class='_2KpZ6l _1t_O3S _2ti6Tf _3AWRsL']"));
		js.executeScript("arguments[0].scrollIntoView(true)", add);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\DURGA\\eclipse-workspace\\Junit\\src\\test\\resources\\mobiles");
		FileUtils.copyFile(src, dest);
		
		FileInputStream f2 =new  FileInputStream(f);
		HSSFWorkbook w2= new HSSFWorkbook(f2);
		HSSFSheet sheet2 = w.getSheet("mani1");
		HSSFRow row2 = sheet2.getRow(3);
		HSSFCell cell2 = row2.getCell(0);
		 
		String name1 = cell2.getStringCellValue();
		System.out.println(name1);
		
		sheet2=w.getSheet("mani2");
		HSSFRow row3 = sheet2.getRow(0);
		HSSFCell cell3 = row2.getCell(0);
		 
		String name2 = cell2.getStringCellValue();
		System.out.println(name2);
		
		if(name1.equals(name2)) {
			System.out.println("matched");
		}
		else {
			System.out.println("notmatched");
		}
		
	}

}
