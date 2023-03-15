package baseclass;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	public  Properties prop = new Properties();
	public  Properties loc = new Properties();	
	//Call Class Constructor
	public BaseTest() throws IOException 
	{
		prop.load((new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties")));
		loc.load((new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties")));
	}
	public  WebDriver setupDriver() 
	{
		WebDriver driver = null;
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(prop.getProperty("testurl"));
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("testurl"));
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		return driver;

	}
	public WebDriver login(WebDriver driver,String username,String password) 
	{
		driver.findElement(By.xpath(loc.getProperty("email_field"))).sendKeys(username);
		driver.findElement(By.xpath(loc.getProperty("password_field"))).sendKeys(password);
		driver.findElement(By.xpath(loc.getProperty("login_button"))).click();
		return driver;

	}
	public void scrollDown(WebDriver driver) 
	{
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0, 2000)", "");
	}
	public void scrollUp(WebDriver driver) 
	{
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0, -2000)", "");
	}
	public void tearDown(WebDriver driver) throws InterruptedException 
	{
		Thread.sleep(2000);
		driver.quit();
		System.out.println("\nTest Completed Successfully");

	}
}
