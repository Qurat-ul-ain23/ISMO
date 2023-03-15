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

public class FAQ extends BaseTest
{
	public WebDriver driver;
	//Class Constructor
	public FAQ() throws IOException 
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
	public void TS_62faqModule()
	{
		this.ClickonElementsbyXpath("faq_module_link");
	}
	@Test(priority=1)
	public void TS_63addFaqCategory() 
	{
		this.ClickonElementsbyXpath("faq_category_button");
		this.ClickonElementsbyXpath("add_new_faq_category_button");
		String CategoryName = "Category7";
		driver.findElement(By.xpath(loc.getProperty("faq_category_name"))).sendKeys(CategoryName);
		this.ClickonElementsbyXpath("faq_category_save_button");	
	}
	@Test(priority=2)
	public void TS_64editfaqCategory() 
	{ 
		this.ClickonElementsbyXpath("edit_faq_category");
		this.ClickonElementsbyXpath("update_faq_category_button");
	}
	@Test(priority=3)
	public void TS_65delfaqCategory() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("del_faq_category_button");
		Thread.sleep(2000);
		this.ClickonElementsbyXpath("close_del_category_faq_alert");
	}
	@Test(priority=4)
	public void TS_66filtersFaqCategory() throws InterruptedException
	{
		this.ClickOnFilter("faq_category_id_filter");
		this.ClickOnFilter("faq_category_name_filter");
		this.ClickOnFilter("faq_category_CreatedAt_filter");
	}
	@Test(priority=5)
	public void TS_67searchFaqCategory() throws InterruptedException 
	{
		String searchFaqCategory = "test";
		this.driver.findElement(By.xpath(loc.getProperty("faq_category_search"))).sendKeys(searchFaqCategory);
		Thread.sleep(3000);
		//for clear text of the search field
		this.driver.findElement(By.xpath(loc.getProperty("faq_category_search"))).clear();
		Thread.sleep(2000);
		this.ClickonElementsbyXpath("faq_breadcrumbs_link");
		Thread.sleep(2000);		
	}
	@Test(priority=6)
	public void TS_68addFaq() throws InterruptedException
	{
		this.ClickonElementsbyXpath("add_faq_button");
		String QuestionName = "Question 4";	
		driver.findElement(By.xpath(loc.getProperty("enter_faq_question"))).sendKeys(QuestionName);
		WebElement FaqcategoryDropdown = this.driver.findElement(By.xpath(loc.getProperty("faq_categroy_dropdown")));
		Select category = new Select(FaqcategoryDropdown);
		category.selectByValue("21");
		Thread.sleep(2000);
		scrollDown(this.driver);
		//CK Editor
		String someText ="textPost";
		JavascriptExecutor js = (JavascriptExecutor) this.driver;
		js.executeScript("CKEDITOR.instances['answer'].setData('"+someText+"')");
		Thread.sleep(2000);
		this.ClickonElementsbyXpath("faq_publish_button");
	}
	@Test(priority=7)
	public void TS_69editfaq() 
	{ 
		this.ClickonElementsbyXpath("edit_faq");
		this.ClickonElementsbyXpath("update_faq_button");
	}
	@Test(priority=8)
	public void TS_70delfaq() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("del_faq_button");
		Thread.sleep(2000);
		this.ClickonElementsbyXpath("close_del_faq_alert");
	}
	@Test(priority=9)
	public void TS_71filtersFaq() throws InterruptedException
	{
		this.ClickOnFilter("faq_id_filter");
		this.ClickOnFilter("faq_question_filter");
		this.ClickOnFilter("faq_category_filter");
		this.ClickOnFilter("faq_status_filter");
		this.ClickOnFilter("faq_createdAt_filter");
	}
	@Test(priority=10)
	public void TS_72searchFaq() throws InterruptedException 
	{
		String searchFaq = "test";
		this.driver.findElement(By.xpath(loc.getProperty("faq_search"))).sendKeys(searchFaq);
		Thread.sleep(3000);
		//for clear text of the search field
		this.driver.findElement(By.xpath(loc.getProperty("faq_search"))).clear();
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
