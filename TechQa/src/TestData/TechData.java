package TestData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TechData {
	
	private static String url="https://www.globalsqa.com/samplepagetest/";
	private static String nameField ="g2599-name";
	private static String emailField="g2599-email";
	private static String websiteField="g2599-website";
	private static String selectExpertise="g2599-expertise[]";
	private static String selectEducation="g2599-education";
	private static String clickAlertPopUp="//button[contains(text(),'Alert Box : Click Here')]";
	private static String clickSubmit="//button[contains(text(),'Submit')]";
	
	
	

		
	public static void main(String args[]) throws FileNotFoundException
{
		String name=null;
		String email=null;
		String webSite=null;

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\SHUBHAM\\Downloads\\driver\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
		    driver.get(url);
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		    FileInputStream file = new FileInputStream("C:\\Users\\SHUBHAM\\EclipseWorkspace\\TechQa\\src\\DataSheet\\Data.xlsx");
		    try {
				XSSFWorkbook workBookData = new XSSFWorkbook(file);
				XSSFSheet sheet = workBookData.getSheetAt(0);
				XSSFRow row = sheet.getRow(1);
	            XSSFCell cell1 = row.getCell(0);
	            System.out.println(cell1);
	            XSSFCell cell2 = row.getCell(1);
	            System.out.println(cell2);
	            XSSFCell cell3 = row.getCell(2);
	            System.out.println(cell3);

	            name = cell1.toString();
	            email = cell2.toString();
	            webSite = cell3.toString();

	            file.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		    WebElement element=driver.findElement(By.name("file-553"));
		    element.sendKeys("C:\\Users\\SHUBHAM\\EclipseWorkspace\\TechQa\\src\\UploadFiles\\download.png");
		    driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		    driver.findElement(By.name(nameField)).sendKeys(name);
		    driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		    driver.findElement(By.name(emailField)).sendKeys(email);
		    driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		    driver.findElement(By.name(websiteField)).sendKeys(webSite);
		    driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		    Select experiance=new Select(driver.findElement(By.name("g2599-experienceinyears")));
		    experiance.selectByValue("3-5");
		    JavascriptExecutor js = (JavascriptExecutor)driver;
		    js.executeScript("window.scrollBy(0,380)");
		    driver.findElement(By.name(selectExpertise)).click();
		    driver.findElement(By.name(selectEducation)).click();
		    driver.findElement(By.xpath(clickAlertPopUp)).click();
		    Alert alert = driver.switchTo().alert();
		    alert.accept();
		    alert.accept();
		    driver.findElement(By.xpath("//textarea[@id='contact-form-comment-g2599-comment']\r\n"
		    		+ "")).sendKeys("Good to submit");
		    driver.findElement(By.xpath(clickSubmit)).click();
		    driver.close();
		    System.out.println("Test Run successfully");
			}
	
	

}
