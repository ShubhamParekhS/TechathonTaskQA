package TestData;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class iFrameTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SHUBHAM\\Downloads\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	    driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    driver.findElement(By.id("iFrame")).click();    
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("window.scrollBy(0,350)", "Page Scrool");
	       driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	       driver.switchTo().frame(0);
	       driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	       js.executeScript("window.scrollBy(0,350)", "Page Scrool");
	       driver.findElement(By.xpath("//*[@id=\"portfolio_items\"]/div[1]/a/div/div/div[1]/img")).click();
	     WebElement header1 = driver.findElement(By.tagName("h1"));
	    System.out.println(header1.getText());

	}

}
