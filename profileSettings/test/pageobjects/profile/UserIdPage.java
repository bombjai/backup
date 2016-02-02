package com.myfico.selenium.pageobjects.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import com.myfico.selenium.pageobjects.common.WireFrame;
import com.myfico.selenium.pageobjects.profile.UserIdPage;
import com.myfico.selenium.utils.PageObjectUtils;
import com.myfico.selenium.utils.Props;

public class UserIdPage extends WireFrame  {

	private final WebDriver driver;
	private final String pageTitle = Props.getProp("ps.userid.pagetitle");

	public UserIdPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

		// check we are on the profile page
		PageObjectUtils.checkPageTitle(driver, pageTitle);
	}
	
	By pageLoad = By.cssSelector(Props.getProp("ps.userid.pageload"));
	
	//get get fields
	By currentIdLocator = By.name(Props.getProp("ps.userid.input.currentId"));
	By newUserIdLocator = By.name(Props.getProp("ps.userid.input.newUserId"));
	By confirmUserIdLocator = By.name(Props.getProp("ps.userid.input.confirmUserId"));
	
	//submit button
	By submitLocator = By.xpath(Props.getProp("ps.userid.input.button"));
	
	public void typeCurrentId(String currentId) {
		WebElement element = driver.findElement(currentIdLocator);
		element.clear();
		element.sendKeys(currentId);
	}
	
	public void typeNewUserId(String newUserId) {
		WebElement element = driver.findElement(newUserIdLocator);
		element.clear();
		element.sendKeys(newUserId);
	}
	
	public void typeConfirmUserId(String confirmUserId) {
		WebElement element = driver.findElement(confirmUserIdLocator);
		element.clear();
		element.sendKeys(confirmUserId);
	}

	public UserIdPage filloutUserIdForm() {
	
		System.out.println("starting form");
		
		String newUser = Props.getProp("ps.userid.val.newUserId");
		typeNewUserId(newUser);
		System.out.println("New User ID: " + newUser);
		
		String confirm = Props.getProp("ps.userid.val.confirmUserId");
		typeConfirmUserId(confirm);
		System.out.println("Confirm User ID: " + confirm);

		String userid = Props.getProp("ps.userid.val.currentId");
		typeCurrentId(userid);
		System.out.println("User ID: " + userid);

		// focus input from blur
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("$('input').focus();");

		System.out.println("filled form");
		
		return this;

	}
	
	public UserIdPage submitUserIdForm() {
		PageObjectUtils.sleep();
		WebElement element = driver.findElement(submitLocator);
		element.click();
		
		PageObjectUtils.takeScreenShot(driver, false);
		System.out.println("submitting page...");
		
		WebDriverWait wait = new WebDriverWait(driver, Props.WAIT_NORMAL);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".success")));
		
		return new UserIdPage(driver);
	}

	public boolean verifyPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver, Props.WAIT_EXTRA);
		WebElement title = driver.findElement(By.xpath(Props.getProp("ps.userid.pageload")));
		wait.until(ExpectedConditions.visibilityOf(title));
		return true;
	}
	
	public void waitForPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver, Props.WAIT_EXTRA);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#mc_ps_usreid")));
	}
	
	
}
