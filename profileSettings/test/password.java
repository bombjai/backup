
public class PasswordPage extends WireFrame  {

	private final WebDriver driver;
	private final String pageTitle = Props.getProp("pass.pagetitle");

	public PasswordPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

		// check we are on the profile page
		PageObjectUtils.checkPageTitle(driver, pageTitle);
	}
	
	//get the fields
	By currentPassLocator = By.id(Props.getProp("pass.input.currentpass"));
	By newPassLocator = By.id(Props.getProp("pass.input.newpass"));
	By confirmPassLocator = By.id(Props.getProp("pass.input.confirmpass"));
	By updateButtonLocator = By.id(Props.getProp("pass.button.update"));
	
	public PasswordPage currentPassword(String password) {
		// current password
		WebElement element = driver.findElement(currentPassLocator);
		element.clear();
		element.sendKeys(password);
		return null;
	}
	
	public PasswordPage newPassword(String password) {
		// new password
		WebElement element = driver.findElement(newPassLocator);
		element.clear();
		element.sendKeys(password);
		return null;
	}
	
	public PasswordPage confirmPassword(String password) {
		// confirm password
		WebElement element = driver.findElement(confirmPassLocator);
		element.clear();
		element.sendKeys(password);
		return null;
	}
	
	// The password page allows the user to update password
	public PasswordPage submitLogin() {
		// This is the only place that submits expects to be....
		driver.findElement(updateButtonLocator).click();

		// Return a new page object representing the destination.
		// Should the login page ever go somewhere else then changing the method
		// signature
		// for this method will mean that all tests that rely on this behavior
		// won't compile.
		return new PasswordPage(driver);
	}
	
}
