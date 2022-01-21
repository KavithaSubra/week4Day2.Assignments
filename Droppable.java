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

public class Droppable {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable");
		driver.manage().window().maximize();
		
		Actions builder = new Actions(driver);
		driver.switchTo().frame(0);
		WebElement drag = driver.findElement(By.xpath("//div[@id = 'draggable']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id = 'droppable']"));
		
		builder.dragAndDrop(drag, drop).perform();
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./images/Droppable.png");
		FileUtils.copyFile(source, dest);
		
		driver.switchTo().defaultContent();
		driver.close();
		
	}

}
