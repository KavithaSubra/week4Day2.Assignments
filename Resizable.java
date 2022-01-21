package week4Day2.Assignments;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {
	
	public static void main(String[] args) throws IOException {
		
	
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://jqueryui.com/resizable");
	driver.manage().window().maximize();

	driver.switchTo().frame(0);
	
	WebElement resize = driver.findElement(By.xpath("//div[contains(@class,'ui-resizable-handle')]"));
	
	Actions builder = new Actions(driver);
	
	builder.dragAndDropBy(resize, 150, 100).perform();
	
	File source = driver.getScreenshotAs(OutputType.FILE);
	File dest = new File("./images/Resizable.png");
	FileUtils.copyFile(source, dest);
	
	driver.switchTo().defaultContent();
	driver.close();
	
	
	
	
	
}
	
}
