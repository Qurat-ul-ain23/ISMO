package testcases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.BaseTest;

public class TrainingModule extends BaseTest
{
	public WebDriver driver;
	//Class constructor
	public TrainingModule() throws IOException 
	{
		//Call base class constructor
		super();
	}
	@BeforeClass
	public void setupCall()  throws IOException
	{
		this.driver= setupDriver();
		this.driver = login(this.driver,prop.getProperty("username"),prop.getProperty("password"));
	}
	@Test(priority=0)
	public void TS_99trainingModule() 
	{
		this.ClickonElementsbyXpath("training_module_link");
	}
	@Test(priority=1)
	public void TS_100addTraining() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("add_new_training_button");
		String trainingTitle = "SQA Training1";
		this.driver.findElement(By.xpath(loc.getProperty("training_title"))).sendKeys(trainingTitle);
		String trainingshortDescription = "Test Trainings short description";
		this.driver.findElement(By.xpath(loc.getProperty("training_short_description"))).sendKeys(trainingshortDescription);
		//CkEditor 
		String someText ="Test Training description";
		JavascriptExecutor js = (JavascriptExecutor) this.driver;
		js.executeScript("CKEDITOR.instances['description'].setData('"+someText+"')");
		//date and time selection
		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) this.driver;
		js1.executeScript("document.getElementById('start_datetime').value='01/02/2023 11:34'");
		js1.executeScript("document.getElementById('end_datetime').value='17/12/2023 11:45'");
		js1.executeScript("document.getElementById('start_date').value='2023-02-01 11:34:00'");
		js1.executeScript("document.getElementById('end_date').value='2023-12-17 11:45:00'");
		Thread.sleep(2000);	
		scrollDown(this.driver);
		String targetAudience = "BS Computer science";
		this.driver.findElement(By.xpath(loc.getProperty("target_audience"))).sendKeys(targetAudience);
		String topics = "Computer Science";
		this.driver.findElement(By.xpath(loc.getProperty("training_topics"))).sendKeys(topics);
		Thread.sleep(2000);
		String trainingLocation = "DHA Lahore";
		this.driver.findElement(By.xpath(loc.getProperty("training_location"))).sendKeys(trainingLocation);
		WebElement statusDropdown = this.driver.findElement(By.xpath(loc.getProperty("training_status_dropdown")));
		Select category = new Select(statusDropdown);
		category.selectByValue("1");
		this.ClickonElementsbyXpath("training_save_button");
	}
	@Test(priority=2)
	public void TS_101editTraining() 
	{
		this.ClickonElementsbyXpath("edit_training");
		this.ClickonElementsbyXpath("update_training_button");
	}
	@Test(priority=3)
	public void TS_102delTraining() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("del_training_button");
		Thread.sleep(3000);
		this.ClickonElementsbyXpath("close_del_training_alert");
		Thread.sleep(2000);
	}
	@Test(priority=4)
	public void TS_103filtersTraining() throws InterruptedException
	{
		this.ClickOnFilter("training_id_filter");
		this.ClickOnFilter("training_title_filter");
		this.ClickOnFilter("training_topics_filter");
		this.ClickOnFilter("training_location_filter");
		this.ClickOnFilter("training_status_filter");
		this.ClickOnFilter("training_createdAt_filter");
	}
	@Test(priority=5)
	public void TS_104searchTraining() throws InterruptedException 
	{
		String searchTraining = "test";
		this.driver.findElement(By.xpath(loc.getProperty("training_search_box"))).sendKeys(searchTraining);
		Thread.sleep(3000);
		//for clear text of the search field
		this.driver.findElement(By.xpath(loc.getProperty("training_search_box"))).clear();
		Thread.sleep(2000);
	}
	@AfterClass
	public void teardowntest() throws InterruptedException
	{
		tearDown(this.driver);
	}
	private void ClickOnFilter(String xpath) throws InterruptedException  
	{
		this.driver.findElement(By.xpath(loc.getProperty((xpath)))).click();
		Thread.sleep(2000);
		this.driver.findElement(By.xpath(loc.getProperty((xpath)))).click();
		Thread.sleep(2000);
	}
	private void ClickonElementsbyXpath(String xpath) 
	{
		this.driver.findElement(By.xpath(loc.getProperty((xpath)))).click();
	}
}
