package testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.BaseTest;

public class Jobs extends BaseTest
{
	public WebDriver driver;
	//Class Constructor
	public Jobs() throws IOException 
	{
		//call base class constructor
		super();
	}
	@BeforeClass
	public void setupCall()  throws IOException
	{
		this.driver= setupDriver();
		this.driver = login(this.driver,prop.getProperty("username"),prop.getProperty("password"));
	}
	@Test(priority=0)
	public void TS_25jobsModule() 
	{
		this.ClickonElementsbyXpath("job_module_link");
	}
	@Test(priority=1)
	public void TS_26addJob() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("add_job_button");
		String jobTitle = "SQA6";
		this.driver.findElement(By.xpath(loc.getProperty("job_title"))).sendKeys(jobTitle);
		String shortDescription = "testJobsSQA12343";
		this.driver.findElement(By.xpath(loc.getProperty("short_description"))).sendKeys(shortDescription);
		//CkEditor 
		String someText ="textJobs";
		JavascriptExecutor js = (JavascriptExecutor) this.driver;
		js.executeScript("CKEDITOR.instances['description'].setData('"+someText+"')");
		String qualification = "BS Computer science";
		this.driver.findElement(By.xpath(loc.getProperty("qualification"))).sendKeys(qualification);
		String experience = "2";
		this.driver.findElement(By.xpath(loc.getProperty("experience"))).sendKeys(experience);
		String location = "DHA Lahore";
		this.driver.findElement(By.xpath(loc.getProperty("location"))).sendKeys(location);
		String totalPositions = "2";
		this.driver.findElement(By.xpath(loc.getProperty("total_positions"))).sendKeys(totalPositions);
		Thread.sleep(2000);
		String specialization = "Computer Science";
		this.driver.findElement(By.xpath(loc.getProperty("specialization"))).sendKeys(specialization);
		String salary = "100000";
		this.driver.findElement(By.xpath(loc.getProperty("salary"))).sendKeys(salary);
		//Image Upload
		this.driver.findElement(By.id(loc.getProperty("choose_Image_job"))).sendKeys("C:\\Users\\quratulain\\Downloads\\jobs.jpg");
		//File Upload 
		this.driver.findElement(By.id(loc.getProperty("jobs_attachement"))).sendKeys("C:\\Users\\quratulain\\Downloads\\lecture10.pdf");
		Thread.sleep(3000);
		scrollUp(this.driver);
		this.ClickonElementsbyXpath("publish_job_button");
		String jobTableName = driver.findElement(By.xpath(loc.getProperty("job_table_name"))).getText();

		if(jobTableName.contains(jobTitle))
		{
			System.out.print("Job Added successfully...!");
		}
		else
		{
			System.out.println("Job is not added....!");
		}
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test(priority=2)
	public void TS_27editJob() 
	{
		this.ClickonElementsbyXpath("edit_job");
		this.ClickonElementsbyXpath("update_job");
	}
	@Test(priority=3)
	public void TS_28delJob() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("del_job_button");
		Thread.sleep(3000);
		this.ClickonElementsbyXpath("close_del_job_alert");
		Thread.sleep(2000);
	}
	@Test(priority=4)
	public void TS_29filtersJob() throws InterruptedException
	{
		this.ClickOnFilter("job_id_filter");
		this.ClickOnFilter("job_title_filter");
		this.ClickOnFilter("job_location_filter");
		this.ClickOnFilter("job_position_filter");
		this.ClickOnFilter("job_application_filter");
		this.ClickOnFilter("job_status_filter");
		this.ClickOnFilter("job_createdAt_filter");
	}
	@Test(priority=5)
	public void TS_30searchJob() throws InterruptedException 
	{
		String searchJob = "test";
		this.driver.findElement(By.xpath(loc.getProperty("job_search"))).sendKeys(searchJob);
		Thread.sleep(3000);
		//for clear text of the search field
		this.driver.findElement(By.xpath(loc.getProperty("job_search"))).clear();
		Thread.sleep(2000);
	}

	@Test(priority=4)
	public void TS_31viewJobApplication() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("view_job_application");
		Thread.sleep(3000);
		this.ClickonElementsbyXpath("export_job_application");
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
