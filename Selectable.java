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

public class Selectable {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable");
		driver.manage().window().maximize();

		driver.switchTo().frame(0);
		
		WebElement item1 = driver.findElement(By.xpath("//li[contains(text(),'Item 1')]"));
		WebElement item2 = driver.findElement(By.xpath("//li[contains(text(),'Item 2')]"));
		WebElement item5 = driver.findElement(By.xpath("//li[contains(text(),'Item 5')]"));
		
		Actions builder = new Actions(driver);
		
		builder.click(item1).keyDown(Keys.CONTROL).click(item5).click(item2).keyUp(Keys.CONTROL).perform();
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./images/Selectable.png");
		FileUtils.copyFile(source, dest);
		
		driver.close();
}
}
