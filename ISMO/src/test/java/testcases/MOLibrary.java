package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.BaseTest;

public class MOLibrary extends BaseTest
{
	public WebDriver driver;
	//Class Constructor
	public MOLibrary() throws IOException 
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
	public void TS_32jobsModule() 
	{
		this.ClickonElementsbyXpath("MO_Library_module_link");
	}
	@Test(priority=1)
	public void TS_33documentCategory() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("document_category_button");
		Thread.sleep(2000);
	}
	@Test(priority=2)
	public void TS_34addDocumentCategory() 
	{
		this.ClickonElementsbyXpath("add_category");
		String categoryName = "Category 14";
		this.driver.findElement(By.xpath(loc.getProperty("category_name"))).sendKeys(categoryName);
		WebElement categoryDropdown = driver.findElement(By.xpath(loc.getProperty("parent_category_dropdown")));
		Select category = new Select(categoryDropdown);
		category.selectByValue("12");
		this.ClickonElementsbyXpath("save_doc_category_button");
	}
	@Test(priority=3)
	public void TS_35editDocumentCategory() 
	{ 
		this.ClickonElementsbyXpath("edit_doc_category_button");
		this.ClickonElementsbyXpath("update_category_button");
	}
	@Test(priority=4)
	public void TS_36delDocumentCategory() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("del_category_button");
		Thread.sleep(2000);
		this.ClickonElementsbyXpath("close_del_category_alert");
		Thread.sleep(2000);
		this.ClickonElementsbyXpath("document_breadcrumbs");
	}
	@Test(priority=5)
	public void TS_37filtersDocCategory() throws InterruptedException
	{
		this.ClickOnFilter("doc_cat_id_filter");
		this.ClickOnFilter("doc_cat_name_filter");
		this.ClickOnFilter("doc_cat_pc_filter");
		this.ClickOnFilter("doc_cat_createdAt_filter");
	}
	@Test(priority=6)
	public void TS_38searchDocCategory() throws InterruptedException 
	{
		String searchDocCategory = "test";
		this.driver.findElement(By.xpath(loc.getProperty("doc_cat_search"))).sendKeys(searchDocCategory);
		Thread.sleep(3000);
		//for clear text of the search field
		this.driver.findElement(By.xpath(loc.getProperty("doc_cat_search"))).clear();
		Thread.sleep(2000);
	}
	@Test(priority=7)
	public void TS_39addNewDocument() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("add_new_document");
		String documentTitle = "Document 7";
		this.driver.findElement(By.xpath(loc.getProperty("document_title"))).sendKeys(documentTitle);
		WebElement docCategoryDropdown = this.driver.findElement(By.xpath(loc.getProperty("document_category_dropdown")));
		Select category = new Select(docCategoryDropdown);
		category.selectByValue("11");
		Thread.sleep(2000);
		//File Upload 
		this.driver.findElement(By.id(loc.getProperty("choose_doc_file"))).sendKeys("C:\\Users\\quratulain\\Downloads\\lecture10.pdf");
		//Image Upload
		this.driver.findElement(By.id(loc.getProperty("choose_doc_image"))).sendKeys("C:\\Users\\quratulain\\Downloads\\doc.jpg");
		//Publish Document
		this.ClickonElementsbyXpath("publish_doc_button");
	}
	@Test(priority=8)
	public void TS_40editDocument() 
	{ 
		this.ClickonElementsbyXpath("edit_doc");
		scrollDown(this.driver);
		this.ClickonElementsbyXpath("update_doc");
	}
	@Test(priority=9)
	public void TS_41delDocument() throws InterruptedException 
	{
		this.ClickonElementsbyXpath("del_doc_button");
		Thread.sleep(2000);
		this.ClickonElementsbyXpath("close_del_doc_alert");
	}
	@Test(priority=10)
	public void TS_42filtersDocument() throws InterruptedException
	{
		this.ClickOnFilter("doc_id_filter");
		this.ClickOnFilter("doc_title_filter");
		this.ClickOnFilter("doc_category_filter");
		this.ClickOnFilter("doc_keywords_filter");
		this.ClickOnFilter("doc_status_filter");
		this.ClickOnFilter("doc_createdAt_filter");
	}
	@Test(priority=11)
	public void TS_43searchDocument() throws InterruptedException 
	{
		String searchDoc = "test";
		this.driver.findElement(By.xpath(loc.getProperty("doc_search"))).sendKeys(searchDoc);
		Thread.sleep(3000);
		//for clear text of the search field
		this.driver.findElement(By.xpath(loc.getProperty("doc_search"))).clear();
		Thread.sleep(2000);
	}
	@AfterClass
	public void teardowntest() throws InterruptedException
	{
		tearDown(this.driver);
	}
	private void ClickonElementsbyXpath(String xpath) 
	{
		this.driver.findElement(By.xpath(loc.getProperty((xpath)))).click();
	}
	private void ClickOnFilter(String xpath) throws InterruptedException  
	{
		this.driver.findElement(By.xpath(loc.getProperty((xpath)))).click();
		Thread.sleep(2000);
		this.driver.findElement(By.xpath(loc.getProperty((xpath)))).click();
		Thread.sleep(2000);
	}
}
