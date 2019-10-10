package com.assign.utilities;

import java.io.File;

import com.assign.base.Constants;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getInstance() {

		if (extent == null) {

			extent = new ExtentReports(System.getProperty("user.dir") + "/target/surefire-reports/html/extent.html",
					true, DisplayOrder.OLDEST_FIRST);
			extent.loadConfig(
					new File(System.getProperty("user.dir") + "/src/test/resources/extentconfig/ReportsConfig.xml"));
			if(Constants.browser.equals("chrome")) {
				extent.addSystemInfo("Browser Name", "Chrome");
				extent.addSystemInfo("Browser version", "v78.0");
				extent.addSystemInfo("Selenium version", "v3.6.0");
			}
			else {
				extent.addSystemInfo("Browser Name", "Firefox");
				extent.addSystemInfo("Browser version", "v69.0.2");
				extent.addSystemInfo("Selenium version", "v3.6.0");
				
			}
			

		}

		return extent;

	}

}
