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

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'/mens-footwear')]/span[text()=\"Sports Shoes\"]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		String childWindow = windows.get(0);
		
		String title = driver.switchTo().window(childWindow).getTitle();
		System.out.println(title);
		
		Thread.sleep(5000);
		
		String bread = driver.findElement(By.xpath("//span[@class='active-bread']")).getText();
		System.out.println(bread);
		
		String mensShoeCount = driver.findElement(By.xpath("//div[text()='Sports Shoes for Men']/following-sibling::div")).getText();
		System.out.println("Count of Men's Sports shoes: "+mensShoeCount);
		
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//i[contains(@class,'sort-arrow')]")).click();
		driver.findElement(By.xpath("//li[2][@data-index='1']")).click();
		
		WebElement fromValue = driver.findElement(By.xpath("//input[@name='fromVal']"));
		fromValue.clear();
		fromValue.sendKeys("900");
		
		WebElement toVal = driver.findElement(By.xpath("//input[@name='toVal']"));
		toVal.clear();
		toVal.sendKeys("1200");
		
		driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow')]")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[contains(@for,'Navy')]")).click();
		
		List<WebElement> filterValues = driver.findElements(By.xpath("//div[@class='filters-top-selected']//div[@class='navFiltersPill']"));
		System.out.println("Filter Values are ");
		for(WebElement value: filterValues)
		{
			String filterValue = value.getText();
			System.out.println(filterValue);
		}
		
		Thread.sleep(5000);
		WebElement prod = driver.findElement(By.xpath("//div[@class='product-desc-rating ']//p[1]"));
		
		System.out.println(prod.getText());
		Actions builder = new Actions(driver);
		
		builder.moveToElement(prod).perform();
		
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
		
		Thread.sleep(5000);
		
		String price = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		System.out.println("Price is "+price);
		
		String discount = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("Discount is " +discount);
		
		WebElement snap = driver.findElement(By.xpath("//img[@itemprop='image']"));
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./images/Snapdeal.png");
		FileUtils.copyFile(source, dest);
		
		driver.close();
		
	}

}
