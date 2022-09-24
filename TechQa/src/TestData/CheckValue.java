package TestData;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckValue {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\SHUBHAM\\Downloads\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	    driver.get("https://webdesignerwall.com/wdw-snippet/table-with-add-and-delete-and-edit-actions");
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,350)", "Page Scrool");
	    driver.switchTo().frame(1);
	    driver.findElement(By.className("material-icons")).click();

	}

}
