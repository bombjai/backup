package com.myfico.selenium.testcases.profile;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.myfico.selenium.pageobjects.dashboard.DashboardPage;
import com.myfico.selenium.pageobjects.login.LoginPage;
import com.myfico.selenium.pageobjects.marketing.Product1BMPage;
import com.myfico.selenium.pageobjects.monitored_data.MonitoredDataPage;
import com.myfico.selenium.testcases.BaseTestCase;
import com.myfico.selenium.utils.PageObjectUtils;
import com.myfico.selenium.utils.Props;
import com.myfico.selenium.utils.TestData;

public class TestMonitoredDataPage extends BaseTestCase {

	// Declare all PageObjects to be used in this test
	LoginPage loginPage;
	DashboardPage dashBoardPage;
	MonitoredDataPage monitoredDataPage;


	@BeforeSuite(alwaysRun = true)
	public void setUpBeforeSuite(ITestContext context) {
		// setup(context);
		driver = new FirefoxDriver();
	}

	@AfterTest
	public void afterTest() {
		PageObjectUtils.takeScreenShot(driver, false);
	}

	@Test(description = "Enter Valid Login cerdentials")
	public void loginAsAdmin() {
		String urlLogin = Props.HTTPS + Props.DOMAIN_CURRENT + Props.getProp("url.page.login");
		driver.get(urlLogin);

		loginPage = new LoginPage(driver);
		// PageObjectUtils.takeScreenShot(driver);

		dashBoardPage = loginPage.loginAs(TestData.getValidUserName(), TestData.getValidPassword());
		dashBoardPage.waitForPageLoad();

		// Assert.assertTrue(dashBoardPage.verifyPageLoad());
		// this is causing an error for invalid .mc_navheader
	}

	@Test(description = "Navigates to Monitored Data page")
	public void navigateMonitoredDataPage() {
		String urlPage = Props.HTTP + Props.DOMAIN_SECURE + Props.getProp("url.page.monitoreddata");
		System.out.println("Monitored Data URL is " + urlPage);
		driver.get(urlPage);

		monitoredDataPage = new MonitoredDataPage(driver);
		PageObjectUtils.takeScreenShot(driver, false);
		monitoredDataPage.waitForPageLoad();
	}
	
	@Test(description = "Click Add Driver License Number Link")
	public void clickAddLicense() {
		PageObjectUtils.sleep();
		monitoredDataPage = new MonitoredDataPage(driver);
		monitoredDataPage.clickAddDriverLicenseNumberLink();
	}
	
	@Test(description = "Click Add Passport Number Link")
	public void clickAddPassport() {
		PageObjectUtils.sleep();
		monitoredDataPage = new MonitoredDataPage(driver);
		monitoredDataPage.clickAddPassportNumberLink();
	}
	
	@Test(description = "Click Add Email Address Link")
	public void clickEmailLink() {
		PageObjectUtils.sleep();
		monitoredDataPage = new MonitoredDataPage(driver);
		monitoredDataPage.clickAddEmailAddressLink();
	}
	
	@Test(description = "Click Add Phone Numbers Link")
	public void clickPhoneLink() {
		PageObjectUtils.sleep();
		monitoredDataPage = new MonitoredDataPage(driver);
		monitoredDataPage.clickAddPhoneNumberLink();
	}
	
	@Test(description = "Click Add Credit / Debit Card Link")
	public void clickCardLink() {
		PageObjectUtils.sleep();
		monitoredDataPage = new MonitoredDataPage(driver);
		monitoredDataPage.clickAddCardLink();
	}
	
	@Test(description = "Click Add Bank Accounts Link")
	public void clickBankLink() {
		PageObjectUtils.sleep();
		monitoredDataPage = new MonitoredDataPage(driver);
		monitoredDataPage.clickAddBankAccountNumberLink();
	}
	
	@Test(description = "Click Add Medical ID Link")
	public void clickMedicalIdLink() {
		PageObjectUtils.sleep();
		monitoredDataPage = new MonitoredDataPage(driver);
		monitoredDataPage.clickAddMedicalIdLink();
	}

	@Test(description = "Input Driver's License Number")
	public void enterLicenseNumber() {
		monitoredDataPage = new MonitoredDataPage(driver);
		monitoredDataPage.typeLicenseNumber("T8031985");
		monitoredDataPage.selectLicenseState("TX");
		PageObjectUtils.sleep();
		
		By submitData = By.cssSelector(Props.getProp("monitoreddata.css.input.license.submit"));
		WebElement submitInfo = driver.findElement(submitData);
		submitInfo.click();
	}

	@Test(description = "Input Passport Number")
	public void enterPassportNumber() {
		monitoredDataPage = new MonitoredDataPage(driver);
		monitoredDataPage.typePassportNumber("TX123TX123");
		PageObjectUtils.sleep();
	
		By submitData = By.cssSelector(Props.getProp("monitoreddata.css.input.passport.submit"));
		WebElement submitInfo = driver.findElement(submitData);
		submitInfo.click();
	}
	
	
	@AfterSuite(alwaysRun = true)
	public void setUpAfterSuite() {
		// quitDriver();
	}

}
