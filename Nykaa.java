package week4Day2.Assignments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {
	
public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();

		Actions builder = new Actions(driver);
		
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		builder.moveToElement(brands).pause(1000).perform();
		
		driver.findElement(By.xpath("//a[contains(text(),'Paris')]")).click();
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		
		driver.findElement(By.xpath("//div[@id='filter-sort']//button")).click();
		
		driver.findElement(By.xpath("//label[@for='radio_customer top rated_undefined']/div[2]")).click();
	    driver.findElement(By.xpath("//span[text()='Category']/following-sibling::div/div")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//span[text()='Hair']/following-sibling::span")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//span[text()='Hair Care']/following-sibling::span")).click();
	    driver.findElement(By.xpath("//input[contains(@id,'Shampoo')]/following-sibling::label/div[2]")).click();
	    
	    String filter2 = driver.findElement(By.xpath("//span[@class='filter-value']")).getText();
		System.out.println(filter2);
		
		 Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[text()='Concern']/following-sibling::div/div")).click();
		driver.findElement(By.xpath("//label[contains(@for,'Color Protection')]/div[2]")).click();
		
		List<WebElement> filters = driver.findElements(By.xpath("//span[@class='filter-value']"));
		System.out.println("Filter values are ");
		for(WebElement f: filters)
		{
			String filterValue=f.getText();
			System.out.println(filterValue);
		}
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(@href,'paris-color-protect')]//img[@alt = \"L'Oreal Paris Colour Protect Shampoo\"]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		String childWindow = windows.get(1);
		
		String title = driver.switchTo().window(childWindow).getTitle();
		System.out.println(title);
		
		WebElement dd1 = driver.findElement(By.xpath("//select[@title = 'SIZE']"));
		Select dropdown1 = new Select(dd1);
		dropdown1.selectByValue("1");
		
		String price = driver.findElement(By.xpath("//span[text()='MRP:']/following-sibling::span")).getText();
		System.out.println(price);
		
		driver.findElement(By.xpath("//h1[text()=\"L'Oreal Paris Colour Protect Shampoo\"]/following::span[19]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();
		
		WebElement shoppingBag = driver.findElement(By.xpath("//iframe[@src='/mobileCartIframe?ptype=customIframeCart']"));
		driver.switchTo().frame(shoppingBag);
		
		Thread.sleep(2000);
		
		String total = driver.findElement(By.xpath("//span[text()='Grand Total']/following-sibling::div[@class='value']")).getText();
		System.out.println("Grand Total: "+total);
		
		driver.findElement(By.xpath("//span[text()='PROCEED']")).click();
		
		List<String> windows1 = new ArrayList<String>(windowHandles);
		String childWindow1 = windows1.get(1);
		
		String title1 = driver.switchTo().window(childWindow1).getTitle();
		System.out.println(title1);
		
		driver.switchTo().window(childWindow1);
		
		driver.findElement(By.xpath("//button[@class='btn full big']")).click();
		
		String grandTotal = driver.findElement(By.xpath("//div[text()='Grand Total']/following-sibling::div/span")).getText();
		
		System.out.println("GrandTotal: "+grandTotal);
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./images/filter.png");
		FileUtils.copyFile(source, dest);
	}
}
