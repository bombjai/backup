package com.myfico.selenium.testcases.profile;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.myfico.selenium.pageobjects.dashboard.DashboardPage;
import com.myfico.selenium.pageobjects.login.LoginPage;
import com.myfico.selenium.pageobjects.profile.PasswordPage;
import com.myfico.selenium.pageobjects.login.LogoutPage;
import com.myfico.selenium.testcases.BaseTestCase;
import com.myfico.selenium.utils.PageObjectUtils;
import com.myfico.selenium.utils.Props;
import com.myfico.selenium.utils.TestData;

public class TestPasswordPage extends BaseTestCase {

	// Declare all PageObjects to be used in this test
	LoginPage loginPage;
	DashboardPage dashBoardPage;
	PasswordPage passwordPage;
	LogoutPage logoutPage;


	@BeforeSuite(alwaysRun = true)
	public void setUpBeforeSuite(ITestContext context) {
		// setup(context);
		driver = new FirefoxDriver();
	}

	@AfterTest
	public void afterTest() {
		PageObjectUtils.takeScreenShot(driver, false);
	}

	@Test(description = "Navigate to Login Page")
	public void nav2LoginPage() {
		//String urlLoginPage = Props.HTTPS + Props.DOMAIN_CURRENT + Props.getProp("url.page.login");
		String urlLoginPage = Props.HTTPS + "local.secure.myfico.com" + Props.getProp("url.page.login");
		System.out.println("urlLoginPage is " + urlLoginPage);
		
		driver.get(urlLoginPage);
		loginPage = new LoginPage(driver);
	}
	
	@Test(description = "Enter Valid Login cerdentials")
	public void loginAsAdmin() {
		String urlLogin = Props.HTTPS + Props.DOMAIN_CURRENT + Props.getProp("url.page.login");
		driver.get(urlLogin);

		loginPage = new LoginPage(driver);
		dashBoardPage = loginPage.loginAs(Props.getProp("ps.val.username"), Props.getProp("ps.val.passsword"));
		dashBoardPage.waitForPageLoad();
	}

	@Test(description = "Navigates to Password page")
	public void navigatePasswordPage() {
		//String urlPage = Props.HTTP + Props.DOMAIN_SECURE + Props.getProp("url.page.ps.password");
		String urlPage = Props.HTTP + "local.secure.myfico.com" + Props.getProp("url.page.ps.password");
		System.out.println("Password URL is " + urlPage);
		driver.get(urlPage);
		
		PasswordPage passwordPage = new PasswordPage(driver);
		
		passwordPage.verifyPageLoad();
		System.out.println("page verified!");
	}
	
	@Test(description = "Update Form")
	public void fillForm() {
		PasswordPage passwordPage = new PasswordPage(driver);
		passwordPage.filloutPasswordForm();
	}
	
	@Test(description = "Submit Form")
	public void submitForm() {
		PasswordPage passwordPage = new PasswordPage(driver);
		passwordPage.submitPasswordForm();
		
		System.out.println("submit form complete");
	}

	@Test(description = "Navigates to Logout page")
	public void navigateLogoutPage() {
		String urlLogoutPage = Props.HTTPS + Props.DOMAIN_CURRENT + Props.getProp("url.page.logout");
		System.out.println("urlLogoutPage is " + urlLogoutPage);
		driver.get(urlLogoutPage);

		PageObjectUtils.sleep();

		logoutPage = new LogoutPage(driver);
		PageObjectUtils.takeScreenShot(driver, isRunningRemote);
	}
	
	@AfterSuite(alwaysRun = true)
	public void setUpAfterSuite() {
		// quitDriver();
	}

}
