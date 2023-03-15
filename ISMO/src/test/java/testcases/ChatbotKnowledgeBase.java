package testcases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.BaseTest;

public class ChatbotKnowledgeBase extends BaseTest
{
	public WebDriver driver;
	//Class constructor
	public ChatbotKnowledgeBase() throws IOException 
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
	public void TS_111chatbotKBModule() 
	{
		scrollDown(this.driver);
		this.ClickonElementsbyXpath("chatbot_KB_module_link");
	}
	@Test(priority=1)
	public void TS_112addQuestion() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("add_question_button");
		String question = "Question 2";
		this.driver.findElement(By.xpath(loc.getProperty("enter_question_KB"))).sendKeys(question);
		//CkEditor 
		String someText ="Test Answer Knowledge Base";
		JavascriptExecutor js = (JavascriptExecutor) this.driver;
		js.executeScript("CKEDITOR.instances['answer'].setData('"+someText+"')");
		String keywords = "BS Computer science";
		this.driver.findElement(By.xpath(loc.getProperty("keywords_Kb"))).sendKeys(keywords);
		this.ClickonElementsbyXpath("save_Kb_question");
	}
	@Test(priority=2)
	public void TS_113editQuestion() 
	{
		this.ClickonElementsbyXpath("edit_question_kb");
		this.ClickonElementsbyXpath("update_question_kb");
	}
	@Test(priority=3)
	public void TS_114delQuestion() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("del_question_kb");
		Thread.sleep(3000);
		this.ClickonElementsbyXpath("close_del_question_kb_alert");
		Thread.sleep(2000);
	}
	@Test(priority=4)
	public void TS_115filtersQuestion() throws InterruptedException
	{
		this.ClickOnFilter("question_kb_id_filter");
		this.ClickOnFilter("question_kb_question_filter");
		this.ClickOnFilter("question_kb_keyword_filter");
		this.ClickOnFilter("question_kb_createdAt_filter");
	}
	@Test(priority=5)
	public void TS_116searchQuestion() throws InterruptedException 
	{
		String searchQuestionKB = "test";
		this.driver.findElement(By.xpath(loc.getProperty("question_kb_search_box"))).sendKeys(searchQuestionKB);
		Thread.sleep(3000);
		//for clear text of the search field
		this.driver.findElement(By.xpath(loc.getProperty("question_kb_search_box"))).clear();
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
