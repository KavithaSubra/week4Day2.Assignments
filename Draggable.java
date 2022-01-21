package week4Day2.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Draggable {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/draggable/");
		driver.manage().window().maximize();
		
		Actions builder = new Actions(driver);
		driver.switchTo().frame(0);
		WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
		
		builder.dragAndDropBy(drag, 50, 100).perform();
		
		driver.switchTo().defaultContent();
		driver.close();
		
		
	}

}
