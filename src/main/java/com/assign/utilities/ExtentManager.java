package com.assign.utilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	
	public static ExtentReports getInstance(){
		
		if(extent==null){
			
			
			extent = new ExtentReports(System.getProperty("user.dir")+"/target/surefire-reports/html/extent.html",true,DisplayOrder.OLDEST_FIRST);
			extent.loadConfig(new File(System.getProperty("user.dir")+"/src/test/resources/extentconfig/ReportsConfig.xml"));
			extent.addSystemInfo("Browser Name", "Chrome");
	        extent.addSystemInfo("Browser version", "v78.0");
	        extent.addSystemInfo("Selenium version", "v3.6.0");

			
		}
		
		return extent;
		
	}

}
