package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.BaseTest;

public class ChatbotFeedback extends BaseTest
{
	public WebDriver driver;
	//Class constructor
	public ChatbotFeedback() throws IOException 
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
	public void TS_117chatbotFeedbackModule() 
	{
		scrollDown(this.driver);
		this.ClickonElementsbyXpath("chatbot_feedback_module");
	}
	@Test(priority=1)
	public void TS_118viewchatbotFeedback() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("view_chatbot_feedback");
		Thread.sleep(2000);	
		this.ClickonElementsbyXpath("chatbot_feedback_breadcrumb");
	}
	@Test(priority=2)
	public void TS_119delchatbotFeedback() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("del_chatbot_feedback");
		Thread.sleep(3000);
		this.ClickonElementsbyXpath("close_del_chatbot_feedback_alert");
		Thread.sleep(2000);
	}
	@Test(priority=3)
	public void TS_120filterschatbotFeedback() throws InterruptedException
	{
		this.ClickOnFilter("chatbot_feedback_id_filter");
		this.ClickOnFilter("chatbot_feedback_email_filter");
		this.ClickOnFilter("chatbot_feedback_rating_filter");
		this.ClickOnFilter("chatbot_feedback_filter");
		this.ClickOnFilter("chatbot_feedback_createdAt_filter");
	}
	@Test(priority=4)
	public void TS_121searchchatbotFeedback() throws InterruptedException 
	{
		String searchchatbotFeedback = "test";
		this.driver.findElement(By.xpath(loc.getProperty("chatbot_feedback_search_box"))).sendKeys(searchchatbotFeedback);
		Thread.sleep(3000);
		//for clear text of the search field
		this.driver.findElement(By.xpath(loc.getProperty("chatbot_feedback_search_box"))).clear();
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
