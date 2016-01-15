
public class PersonalInfoPage extends WireFrame  {

	private final WebDriver driver;
	private final String pageTitle = Props.getProp("pi.pagetitle");

	public PersonalInfoPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

		// check we are on the profile page
		PageObjectUtils.checkPageTitle(driver, pageTitle);
	}
	
	//get get fields
	//By firstnameLocator = By.id(Props.getProp("pi.input.firstname"));
	By lastnameLocator = By.id(Props.getProp("pi.input.lastname"));
	By middleInitialLocator = By.id(Props.getProp("pi.input.lastname"));
	By suffixLocator = By.id(Props.getProp("pi.input.suffix"));
	By emailLocator = By.id(Props.getProp("pi.input.email"));
	//By ssnLocator = By.id(Props.getProp("pi.input.ssn"));
	//By dobLocator = By.id(Props.getProp("pi.input.dob"));
	//By genderLocator = By.id(Props.getProp("pi.input.gender"));
	By phone1Locator = By.id(Props.getProp("pi.input.phone1"));
	By phone2Locator = By.id(Props.getProp("pi.input.phone2"));
	By phone3Locator = By.id(Props.getProp("pi.input.phone3"));
	By driverNumberLocator = By.id(Props.getProp("pi.input.drivernumber"));
	By driverStateLocator = By.id(Props.getProp("pi.input.driverstate"));
	//current address
	By addressLocator = By.id(Props.getProp("pi.input.address"));
	By cityLocator = By.id(Props.getProp("pi.input.city"));
	By stateLocator = By.id(Props.getProp("pi.input.state"));
	By zipLocator = By.id(Props.getProp("pi.input.zip"));
	//previous address
	By prevAddressLocator = By.id(Props.getProp("pi.input.prevaddress"));
	By prevCityLocator = By.id(Props.getProp("pi.input.prevcity"));
	By prevStateLocator = By.id(Props.getProp("pi.input.prevstate"));
	By prevZipLocator = By.id(Props.getProp("pi.input.prevzip"));
	
	// added return = null to get rid of error
//	public PersonalInfo typeFirstname(String firstname) {
//		// First name
//		WebElement element = driver.findElement(firstnameLocator);
//		element.clear();
//		element.sendKeys(firstname);
//		return null;
//	}
	
	public PersonalInfoPage typeLastname(String lastname) {
		// last name
		WebElement element = driver.findElement(lastnameLocator);
		element.clear();
		element.sendKeys(lastname);
		return null;
	}
	
	public PersonalInfoPage typeMiddleInitial(String middleint) {
		// middle initial
		WebElement element = driver.findElement(middleInitialLocator);
		element.clear();
		element.sendKeys(middleint);
		return null;
	}
	
	public PersonalInfoPage typeSuffix(String suffix) {
		// suffix
		WebElement element = driver.findElement(suffixLocator);
		element.clear();
		element.sendKeys(suffix);
		return null;
	}
	
	public PersonalInfoPage typeEmail(String email) {
		// email
		WebElement element = driver.findElement(emailLocator);
		element.clear();
		element.sendKeys(email);
		return null;
	}
	
	public PersonalInfoPage typePhone1(String phone) {
		//phone - first 3
		WebElement element = driver.findElement(phone1Locator);
		element.clear();
		element.sendKeys(phone);
		return null;
	}
	
	public PersonalInfoPage typePhone2(String phone) {
		//phone - second 3
		WebElement element = driver.findElement(phone2Locator);
		element.clear();
		element.sendKeys(phone);
		return null;
	}
	
	public PersonalInfoPage typePhone3(String phone) {
		//phone - last 4
		WebElement element = driver.findElement(phone3Locator);
		element.clear();
		element.sendKeys(phone);
		return null;
	}
	
	
	// How do I select radio button
//	public PersonalInfo clickGender(String gender) {
//		// address
//		WebElement element = driver.findElement(genderLocator);
//		element.click();
//		return null;
//	}
//	
	public PersonalInfoPage typeDriverNumber(String drivernum) {
		// driver number
		WebElement element = driver.findElement(driverNumberLocator);
		element.clear();
		element.sendKeys(drivernum);
		return null;
	}
	
	//current
	public PersonalInfoPage typeAddress(String address) {
		// address
		WebElement element = driver.findElement(addressLocator);
		element.clear();
		element.sendKeys(address);
		return null;
	}

	public PersonalInfoPage typeCity(String city) {
		// address
		WebElement element = driver.findElement(cityLocator);
		element.clear();
		element.sendKeys(city);
		return null;
	}
	
	// how do I select drop down
	// public PersonalInfo selectDropdownState(String state) {
	// address
	// WebElement element = driver.findElement(stateLocator);
	// element.clear();
	// /dropdown.selectByValue("CA");
	// select.selectByValue("CA");
	// return null;
	// }

	public PersonalInfoPage typeZip(String zip) {
		// address
		WebElement element = driver.findElement(zipLocator);
		element.clear();
		element.sendKeys(zip);
		return null;
	}
	
	//previous
	public PersonalInfoPage typePrevAddress(String address) {
		// address
		WebElement element = driver.findElement(prevAddressLocator);
		element.clear();
		element.sendKeys(address);
		return null;
	}

	public PersonalInfoPage typePrevCity(String city) {
		// address
		WebElement element = driver.findElement(prevCityLocator);
		element.clear();
		element.sendKeys(city);
		return null;
	}
	
	// how do I select drop down
	// public PersonalInfo selectPrevDropdownState(String state) {
	// address
	// WebElement element = driver.findElement(prevStateLocator);
	// element.clear();
	// /dropdown.selectByValue("CA");
	// select.selectByValue("CA");
	// return null;
	// }

	public PersonalInfoPage typePrevZip(String zip) {
		// address
		WebElement element = driver.findElement(prevZipLocator);
		element.clear();
		element.sendKeys(zip);
		return null;
	}	
	
}
