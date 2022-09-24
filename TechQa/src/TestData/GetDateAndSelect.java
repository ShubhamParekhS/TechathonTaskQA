package TestData;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetDateAndSelect {
	
	private static String url="https://jqueryui.com/datepicker/#date-range";
	private static String selectFromDate ="//input[@id='from']";
	private static String selectToDate="//input[@id='to']";

	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SHUBHAM\\Downloads\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		driver.switchTo().frame(0);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		driver.findElement(By.xpath(selectFromDate)).sendKeys("25092022");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(selectToDate)).sendKeys("30092022");
		System.out.println("Test Run successfully");

	}

}
