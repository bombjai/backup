
public class UserIdPage extends WireFrame  {
	
	private final WebDriver driver;
	private final String pageTitle = Props.getProp("user.pagetitle");

	public UserIdPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

		// check we are on the profile page
		PageObjectUtils.checkPageTitle(driver, pageTitle);
	}
	
	//get the fields
	By currentUserLocator = By.id(Props.getProp("user.input.currentuser"));
	By newUserLocator = By.id(Props.getProp("user.input.newuser"));
	By confirmUserLocator = By.id(Props.getProp("user.input.confirmuser"));
	By updateButtonLocator = By.id(Props.getProp("user.button.update"));
	
	public UserIdPage currentUser(String userId) {
		// Current User Id
		WebElement element = driver.findElement(currentUserLocator);
		element.clear();
		element.sendKeys(userId);
		return null;
	}
	
	public UserIdPage newUser(String userId) {
		// New User Id
		WebElement element = driver.findElement(newUserLocator);
		element.clear();
		element.sendKeys(userId);
		return null;
	}
	
	public UserIdPage confirmUser(String userId) {
		// Confirm User Id
		WebElement element = driver.findElement(confirmUserLocator);
		element.clear();
		element.sendKeys(userId);
		return null;
	}
	
	// The userid page allows the user to update userid
	public UserIdPage submitLogin() {
		// This is the only place that submits expects to be....
		driver.findElement(updateButtonLocator).click();

		// Return a new page object representing the destination.
		// Should the login page ever go somewhere else then changing the method
		// signature
		// for this method will mean that all tests that rely on this behavior
		// won't compile.
		return new UserIdPage(driver);
	}
		
	

}
