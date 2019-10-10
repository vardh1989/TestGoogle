package com.assign.testcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.assign.base.Page;
import com.assign.errorcollectors.ErrorCollector;
import com.assign.pages.actions.GoogleSearchPage;
import com.assign.utilities.Log;
import com.assign.utilities.Utilities;
import org.apache.log4j.Logger;

public class GoogleSearchTest {
	
	public static Logger log = Logger.getLogger("devpinoyLogger");
	//intializing the driver and Page Factory Objects
	@BeforeSuite
	public void setUp(){
		
		Page.initConfiguration();
	}
	
	/**
	 *  Test Case
	 * @throws InterruptedException
	 * Test Steps : 1. Open https://www.google.com/
	 * 2. Search for “programming”
	 * 3. Parse result page and print title 
	 * and sections (sections are various result hits from different web sites which are listed by google on the results page 
	 * and the titles are titles of those section please skip the google ads and maps part if there is such a result on the result page).
	 * 4. Go to next page and do the same
	 */
	@Test
	public void printTitleAndSections() throws InterruptedException {
		
		log.debug("Starting test case printTitleAndSections");
		String keywordToSearch ="Programming";
		String page2StatsId="resultStats";
		GoogleSearchPage gp= new GoogleSearchPage();
		gp.searchOnGoogle(keywordToSearch);
		gp.printLinkTextAndSectionsToFile();
		gp.clickOnPageNumber();
		gp.wait(page2StatsId);
		gp.printLinkTextAndSectionsToFile(); 
		log.debug("Test case printTitleAndSections completed successfully" );
		
		
	}
	
	@AfterSuite(alwaysRun=true)
	public static void quitBrowser(){
		
		Page.tearDown();
		
	}
	
	
	

}
