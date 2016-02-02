package com.myfico.selenium.pageobjects.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.myfico.selenium.pageobjects.common.WireFrame;
import com.myfico.selenium.pageobjects.profile.PersonalInfoPage;
import com.myfico.selenium.utils.PageObjectUtils;
import com.myfico.selenium.utils.Props;

public class PersonalInfoPage extends WireFrame  {

	private final WebDriver driver;
	private final String pageTitle = Props.getProp("ps.personalInfo.pagetitle");

	public PersonalInfoPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

		// check we are on the profile page
		PageObjectUtils.checkPageTitle(driver, pageTitle);
	}
	
	By pageLoad = By.cssSelector(Props.getProp("ps.personalInfo.pageload"));
	//By successSubmit = By.cssSelector(Props.getProp("ps.personalInfo.successful"));
	
	//get get fields
	//By firstnameLocator = By.id(Props.getProp("pi.input.firstname"));
	By middleInitialLocator = By.name(Props.getProp("ps.personalInfo.input.middleInit"));
	By lastnameLocator = By.name(Props.getProp("ps.personalInfo.input.lastname"));
	By suffixLocator = By.name(Props.getProp("ps.personalInfo.input.suffix"));
	By emailLocator = By.name(Props.getProp("ps.personalInfo.input.email"));
	//By ssnLocator = By.id(Props.getProp("pi.input.ssn"));
	//By dobLocator = By.id(Props.getProp("pi.input.dob"));
	//By genderLocator = By.id(Props.getProp("pi.input.gender"));
	By phoneLocator = By.name(Props.getProp("ps.personalInfo.input.phone"));
	By driverNumberLocator = By.name(Props.getProp("ps.personalInfo.input.drivernumber"));
	By driverStateLocator = By.name(Props.getProp("ps.personalInfo.input.driverstate"));
	//current address
	By addressLocator = By.name(Props.getProp("ps.personalInfo.input.address"));
	By addressLocator2 = By.name(Props.getProp("ps.personalInfo.input.address2"));
	By cityLocator = By.name(Props.getProp("ps.personalInfo.input.city"));
	By stateLocator = By.name(Props.getProp("ps.personalInfo.input.state"));
	By zipLocator = By.name(Props.getProp("ps.personalInfo.input.zip"));
	//previous address
	By prevAddressLocator = By.name(Props.getProp("ps.personalInfo.input.prevaddress"));
	By prevCityLocator = By.name(Props.getProp("ps.personalInfo.input.prevcity"));
	By prevStateLocator = By.name(Props.getProp("ps.personalInfo.input.prevstate"));
	By prevZipLocator = By.name(Props.getProp("ps.personalInfo.input.prevzip"));
	
	//submit button
	By submitLocator = By.xpath(Props.getProp("ps.personalInfo.input.button"));
	
	// added return = null to get rid of error
//	public PersonalInfo typeFirstname(String firstname) {
//		// First name
//		WebElement element = driver.findElement(firstnameLocator);
//		element.clear();
//		element.sendKeys(firstname);
//		return null;
//	}
	
	public void typeMiddleInitial(String middleint) {
		// middle initial
		WebElement element = driver.findElement(middleInitialLocator);
		element.clear();
		element.sendKeys(middleint);
	}
	
	public PersonalInfoPage typeLastname(String lastname) {
		// last name
		WebElement element = driver.findElement(lastnameLocator);
		element.clear();
		element.sendKeys(lastname);
		return this;
	}
	
	public void typeSuffix(String suffix) {
		// suffix
		Select select = new Select(driver.findElement(suffixLocator));
		// select.deselectAll();
		select.selectByVisibleText(suffix);
	}
	
	public PersonalInfoPage typeEmail(String email) {
		// email
		WebElement element = driver.findElement(emailLocator);
		element.clear();
		element.sendKeys(email);
		return null;
	}
	
	public void typePhone(String phone) {
		//phone - last 4
		WebElement element = driver.findElement(phoneLocator);
		element.clear();
		element.sendKeys(phone);
	}
	
	public void typeDriverNumber(String drivernum) {
		// driver number
		WebElement element = driver.findElement(driverNumberLocator);
		element.clear();
		element.sendKeys(drivernum);
	}
	
	public void typeDriverState(String state) {
		// suffix
		Select select = new Select(driver.findElement(driverStateLocator));
		// select.deselectAll();
		select.selectByVisibleText(state);
	}
	
	//current
	public void typeAddress(String address) {
		// address
		WebElement element = driver.findElement(addressLocator);
		element.clear();
		element.sendKeys(address);
	}
	
	public void typeAddress2(String address) {
		// address 2
		WebElement element = driver.findElement(addressLocator2);
		element.clear();
		element.sendKeys(address);
	}

	public void typeCity(String city) {
		// address
		WebElement element = driver.findElement(cityLocator);
		element.clear();
		element.sendKeys(city);
	}
	
	public void selectState(String state) {
		// select state
		Select select = new Select(driver.findElement(stateLocator));
		// select.deselectAll();
		select.selectByVisibleText(state);
	}

	public void typeZip(String zip) {
		// address
		WebElement element = driver.findElement(zipLocator);
		element.clear();
		element.sendKeys(zip);
	}
	
	//previous
	public void typePrevAddress(String address) {
		// address
		WebElement element = driver.findElement(prevAddressLocator);
		element.clear();
		element.sendKeys(address);
	}
	
	public void prevSelectState(String state) {
		// select state
		Select select = new Select(driver.findElement(prevStateLocator));
		// select.deselectAll();
		select.selectByVisibleText(state);
	}


	public void typePrevCity(String city) {
		// address
		WebElement element = driver.findElement(prevCityLocator);
		element.clear();
		element.sendKeys(city);
	}
	
	public PersonalInfoPage typePrevZip(String zip) {
		// address
		WebElement element = driver.findElement(prevZipLocator);
		element.clear();
		element.sendKeys(zip);
		return this;
	}
	
	public PersonalInfoPage filloutPersonalInfoForm() {
	
		System.out.println("starting form");
		
		String middleinit = Props.getProp("ps.personalInfo.val.middleinit");
		typeMiddleInitial(middleinit);
		System.out.println("Middle Initial: " + middleinit);
		
		String lastname = Props.getProp("ps.personalInfo.val.lastname");
		typeLastname(lastname);
		System.out.println("Last Name: " + lastname);
		
		String suffix = Props.getProp("ps.personalInfo.val.suffix");
		typeSuffix(suffix);
		System.out.println("Suffix: " + suffix);

		String email = Props.getProp("ps.personalInfo.val.email");
		typeEmail(email);
		System.out.println("Email: " + email);
		
		String drivernumber = Props.getProp("ps.personalInfo.val.drivernumber");
		typeDriverNumber(drivernumber);
		System.out.println("Driver Number: " + drivernumber);
		
		String driverstate = Props.getProp("ps.personalInfo.val.driverstate");
		typeDriverState(driverstate);
		System.out.println("Driver State: " + driverstate);
		
		String address = Props.getProp("ps.personalInfo.val.address");
		typeAddress(address);
		System.out.println("Address: " + address);
		
		String address2 = Props.getProp("ps.personalInfo.val.address2");
		typeAddress2(address2);
		System.out.println("Address2: " + address2);
		
		String city = Props.getProp("ps.personalInfo.val.city");
		typeCity(city);
		System.out.println("City: " + city);
		
		String state = Props.getProp("ps.personalInfo.val.state");
		selectState(state);
		System.out.println("State: " + state);
		
		String zip = Props.getProp("ps.personalInfo.val.zip");
		typeZip(zip);
		System.out.println("Zip: " + zip);
		
		String prevaddress = Props.getProp("ps.personalInfo.val.prevaddress");
		typePrevAddress(prevaddress);
		System.out.println("Prev Address: " + prevaddress);
				
		String prevcity = Props.getProp("ps.personalInfo.val.prevcity");
		typePrevCity(prevcity);
		System.out.println("Prev City: " + prevcity);
		
		String prevstate = Props.getProp("ps.personalInfo.val.prevstate");
		prevSelectState(prevstate);
		System.out.println("Prev State: " + prevstate);
		
		String prevzip = Props.getProp("ps.personalInfo.val.prevcity");
		typePrevZip(prevzip);
		System.out.println("Prev Zip: " + prevzip);
		
		System.out.println("form filled");
		return this;

	}
	
	public PersonalInfoPage submitPersonalInfoForm() {
		WebElement element = driver.findElement(submitLocator);
		element.click();
		
		PageObjectUtils.takeScreenShot(driver, false);
		System.out.println("submitting page...");
		
		PersonalInfoPage personalInfoPage = new PersonalInfoPage(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, Props.WAIT_NORMAL);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".success")));
		
		return personalInfoPage;
	}
	
	public boolean verifyPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver, Props.WAIT_EXTRA);
		WebElement personalTitle = driver.findElement(By.xpath(Props.getProp("ps.personalInfo.pageload")));
		wait.until(ExpectedConditions.visibilityOf(personalTitle));
		return true;
	}
	
	public void waitForPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver, Props.WAIT_EXTRA);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#mc_ps_personal")));
	}
	
	
}
