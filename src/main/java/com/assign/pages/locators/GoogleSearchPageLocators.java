package com.assign.pages.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class GoogleSearchPageLocators {
	
	//Storing locators of Google search page  using PageFactory Finder approach.
	
	@FindAll({
		@FindBy(xpath="//div[@class='srg']//h3")
		})public List<WebElement>WEB_RESULTS_XPATH; 
	
	@FindAll({
		@FindBy(xpath="//div[@class='srg']//div[@class='s']")
		})public List<WebElement>TEXT_SECTION_RESULTS;
	
	
	@FindBy(xpath = "//a[@aria-label= 'Page 2']")
	public WebElement CLICK_ON_PAGE_NUMBER_2;
	
	@FindBy(xpath = "//input[@name='q']")
	public WebElement TEXT_FIELD_TO_SEARCH;
	
	@FindBy(id="resultStats")
	public WebElement pageNumberDetail;
	

}
