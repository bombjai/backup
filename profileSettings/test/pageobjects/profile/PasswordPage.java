package com.myfico.selenium.pageobjects.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import com.myfico.selenium.pageobjects.common.WireFrame;
import com.myfico.selenium.pageobjects.profile.PasswordPage;
import com.myfico.selenium.utils.PageObjectUtils;
import com.myfico.selenium.utils.Props;

public class PasswordPage extends WireFrame  {

	private final WebDriver driver;
	private final String pageTitle = Props.getProp("ps.password.pagetitle");

	public PasswordPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

		// check we are on the profile page
		PageObjectUtils.checkPageTitle(driver, pageTitle);
	}
	
	By pageLoad = By.cssSelector(Props.getProp("ps.password.pageload"));
	
	//get get fields
	By currentPassLocator = By.name(Props.getProp("ps.password.input.currentPass"));
	By newPassLocator = By.name(Props.getProp("ps.password.input.newPass"));
	By confirmPassLocator = By.name(Props.getProp("ps.password.input.confirmPass"));
	
	//submit button
	By submitLocator = By.xpath(Props.getProp("ps.password.input.button"));
	
	public void typeCurrentPassword(String currPass) {
		WebElement element = driver.findElement(currentPassLocator);
		element.clear();
		element.sendKeys(currPass);
	}
	
	public void typeNewPassword(String newPass) {
		WebElement element = driver.findElement(newPassLocator);
		element.clear();
		element.sendKeys(newPass);
	}
	
	public void typeConfirmPassword(String confirmPass) {
		WebElement element = driver.findElement(confirmPassLocator);
		element.clear();
		element.sendKeys(confirmPass);
	}

	public PasswordPage filloutPasswordForm() {
	
		System.out.println("starting form");

		String pass = Props.getProp("ps.password.val.currentPass");
		typeCurrentPassword(pass);
		System.out.println("Password: " + pass);
		
		String current = Props.getProp("ps.password.val.newPass");
		typeNewPassword(current);
		System.out.println("New Password: " + current);
		
		String confirm = Props.getProp("ps.password.val.confirmPass");
		typeConfirmPassword(confirm);
		System.out.println("Confirm Password: " + confirm);

		// focus input from blur
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("$('input').focus();");

		System.out.println("filled form");
		
		return this;

	}
	
	public PasswordPage submitPasswordForm() {
		PageObjectUtils.sleep();
		WebElement element = driver.findElement(submitLocator);
		element.click();
		
		PageObjectUtils.takeScreenShot(driver, false);
		System.out.println("submitting page...");
		
		WebDriverWait wait = new WebDriverWait(driver, Props.WAIT_NORMAL);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".success")));
		
		return new PasswordPage(driver);
	}

	public boolean verifyPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver, Props.WAIT_EXTRA);
		WebElement title = driver.findElement(By.xpath(Props.getProp("ps.password.pageload")));
		wait.until(ExpectedConditions.visibilityOf(title));
		return true;
	}
	
	public void waitForPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver, Props.WAIT_EXTRA);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#mc_ps_password")));
	}
	
	
}
