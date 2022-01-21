package week4Day2.Assignments;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();

		driver.switchTo().frame(0);
		
		WebElement item1 = driver.findElement(By.xpath("//li[contains(text(),'Item 1')]"));
		System.out.println(item1.getText());
		WebElement item2 = driver.findElement(By.xpath("//li[contains(text(),'Item 2')]"));
		WebElement item3 = driver.findElement(By.xpath("//li[contains(text(),'Item 3')]"));
		WebElement item4 = driver.findElement(By.xpath("//li[contains(text(),'Item 4')]"));
		WebElement item5 = driver.findElement(By.xpath("//li[contains(text(),'Item 5')]"));
		WebElement item6 = driver.findElement(By.xpath("//li[contains(text(),'Item 6')]"));
		WebElement item7 = driver.findElement(By.xpath("//li[contains(text(),'Item 7')]"));
		
		
		Actions builder = new Actions(driver);
		
		builder.dragAndDrop(item3, item1).perform();

		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./images/Sortable.png");
		FileUtils.copyFile(source, dest);
		
		//driver.close();
}
}
