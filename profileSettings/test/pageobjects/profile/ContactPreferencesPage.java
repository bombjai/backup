package com.myfico.selenium.pageobjects.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import com.myfico.selenium.pageobjects.common.WireFrame;
import com.myfico.selenium.pageobjects.profile.ContactPreferencesPage;
import com.myfico.selenium.utils.PageObjectUtils;
import com.myfico.selenium.utils.Props;

public class ContactPreferencesPage extends WireFrame  {

	private final WebDriver driver;
	private final String pageTitle = Props.getProp("ps.preferences.pagetitle");

	public ContactPreferencesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

		// check we are on the profile page
		PageObjectUtils.checkPageTitle(driver, pageTitle);
	}
	
	By pageLoad = By.cssSelector(Props.getProp("ps.preferences.pageload"));
	
	//get get fields
	By priEmailLocator = By.xpath(Props.getProp("ps.preferences.input.priEmail"));
	By recCheckLocator = By.xpath(Props.getProp("ps.preferences.input.recCheck"));
	By langLocator = By.name(Props.getProp("ps.preferences.input.lang"));
	
	//submit button
	By submitLocator = By.xpath(Props.getProp("ps.preferences.input.button"));
	
	public void selectPriCheckbox(Boolean priEmail) {
		//check value before checkbox
		WebElement selectedValue = driver.findElement(By.cssSelector("input#input_toggle_priEmail"));
		Boolean isChecked = selectedValue.isSelected();

		WebElement selectCheckbox = driver.findElement(priEmailLocator);
		if (priEmail && !isChecked){
			selectCheckbox.click();
		}
		else if (!priEmail && isChecked){
			selectCheckbox.click();
		}
	}
	
	public void selectRecCheckbox(Boolean recCheck) {
		
		//check value before checkbox
		WebElement selectedValue = driver.findElement(By.cssSelector("input#input_toggle_recCheck"));
		Boolean isChecked = selectedValue.isSelected();

		WebElement selectCheckbox = driver.findElement(recCheckLocator);
		if (recCheck && !isChecked){
			selectCheckbox.click();
		}
		else if (!recCheck && isChecked) {
			selectCheckbox.click();
		}
	}
	
	public void selectLang(String lang) {
		Select select = new Select(driver.findElement(langLocator));
		// select.deselectAll();
		select.selectByValue(lang);
	}

	public ContactPreferencesPage filloutContactPreferencesForm() {
	
		System.out.println("starting form");

		//String priEmail = Props.getProp("ps.preferences.val.priEmail");
		Boolean priEmail = false;
		if (Props.getProp("ps.preferences.val.priEmail").matches("true")){
			priEmail = true;
		}
		selectPriCheckbox(priEmail);
		System.out.println("Privileges Email: " + priEmail);
		
		Boolean recEmail = false;
		if (Props.getProp("ps.preferences.val.recCheck").matches("true")){
			recEmail = true;
		}
		selectRecCheckbox(recEmail);
		System.out.println("Recommends Email: " + recEmail);

		String lang = Props.getProp("ps.preferences.val.lang");
		selectLang(lang);
		System.out.println("Preferred Language: " + lang);

		System.out.println("filled form");
		
		return this;

	}
	
	public ContactPreferencesPage submitContactPreferencesForm() {
		PageObjectUtils.sleep();
		WebElement element = driver.findElement(submitLocator);
		element.click();
		
		PageObjectUtils.takeScreenShot(driver, false);
		System.out.println("submitting page...");
		
		WebDriverWait wait = new WebDriverWait(driver, Props.WAIT_NORMAL);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".success")));
		
		return new ContactPreferencesPage(driver);
	}

	public boolean verifyPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver, Props.WAIT_EXTRA);
		WebElement title = driver.findElement(By.xpath(Props.getProp("ps.preferences.pageload")));
		wait.until(ExpectedConditions.visibilityOf(title));
		return true;
	}
	
	public void waitForPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver, Props.WAIT_EXTRA);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#mc_ps_preferences")));
	}
	
	
}
