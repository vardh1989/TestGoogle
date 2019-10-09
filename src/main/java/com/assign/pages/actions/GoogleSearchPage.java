package com.assign.pages.actions;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.apache.log4j.Logger;
import com.assign.base.Page;
import com.assign.pages.locators.GoogleSearchPageLocators;
import com.assign.utilities.Log;

public class GoogleSearchPage extends Page {
	
public GoogleSearchPageLocators gsp;
	
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public GoogleSearchPage(){
		
		//initializing page factory elements
		this.gsp=new GoogleSearchPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this.gsp);
		
	}
	/**
	 * Printing Search Results (Links and Text Section) to File .
	 * File Location to print details below = TestLinksAndSection.log
	 */
	public void printLinkTextAndSectionsToFile() {
		
		List<WebElement> links  = gsp.WEB_RESULTS_XPATH;
		List<WebElement> texts = gsp.TEXT_SECTION_RESULTS;
		for(int i=0;i<links.size();i++) {
			log.debug("Web Result Number---------> "+i);
			log.debug(links.get(i).getText());
			log.debug(texts.get(i).getText());
			log.debug("==========================================================");
			
		}
		
		
	}
	
	/**
	 * //Searching a keyword in Google.com
	 * @param keyword =text to search in google
	 */
	
	public void searchOnGoogle(String keyword) {
		
		gsp.TEXT_FIELD_TO_SEARCH.sendKeys(keyword);
		gsp.TEXT_FIELD_TO_SEARCH.sendKeys(Keys.ENTER);	
		
	}
	
	//Clicking Page number 2 
	public void clickOnPageNumber() {
		
		gsp.CLICK_ON_PAGE_NUMBER_2.click();
	}
	
	
	
	

}
