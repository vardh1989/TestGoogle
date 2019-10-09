/*
 * package com.assign.testcases;
 * 
 * import java.util.Hashtable;
 * 
 * import org.testng.SkipException; import org.testng.annotations.AfterMethod;
 * import org.testng.annotations.AfterSuite; import org.testng.annotations.Test;
 * 
 * import com.assign.base.Page; import com.assign.pages.actions.SigninPage;
 * import com.assign.utilities.Utilities;
 * 
 * public class SearchTest {
 * 
 * 
 * 
 * @Test(dataProviderClass=Utilities.class,dataProvider="dp") public void
 * signInTest(Hashtable<String,String> data) {
 * 
 * if(data.get("runmode").equalsIgnoreCase("N")){
 * 
 * throw new SkipException("Skipping the test as the Run mode is NO");
 * 
 * 
 * } Page.initConfiguration(); SigninPage signin = Page.topNav.gotoSignIn();
 * signin.doLogin(data.get("username"), data.get("password"));
 * 
 * 
 * }
 * 
 * 
 * @AfterSuite public void tearDown(){ if(Page.driver!=null){
 * Page.quitBrowser(); } } }
 */