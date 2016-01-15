
public class SecretQuestionPage extends WireFrame  {

	private final WebDriver driver;
	private final String pageTitle = Props.getProp("secret.pagetitle");

	public SecretQuestionPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

		// check we are on the profile page
		PageObjectUtils.checkPageTitle(driver, pageTitle);
	}
	
	//get the fields
	By secretQuestion = By.id(Props.getProp("secret.input.secretquestion"));
	By answer = By.id(Props.getProp("secret.input.answer"));
	By confirmAnswer = By.id(Props.getProp("secret.input.confirmanswer"));
	By updateButtonLocator = By.id(Props.getProp("secret.button.update"));
	
	
	// how do I select drop down
	// public SecretQuestionPage selectDropdownState(String state) {
	// address
	// WebElement element = driver.findElement(stateLocator);
	// element.clear();
	// /dropdown.selectByValue("CA");
	// select.selectByValue("CA");
	// return null;
	// }

	public SecretQuestionPage newUser(String userId) {
		// Answer
		WebElement element = driver.findElement(answer);
		element.clear();
		element.sendKeys(userId);
		return null;
	}
	
	public SecretQuestionPage confirmUser(String userId) {
		// Confirm Answer
		WebElement element = driver.findElement(confirmAnswer);
		element.clear();
		element.sendKeys(userId);
		return null;
	}
	
	// The secret question page allows the user to update userid
	public SecretQuestionPage submitLogin() {
		// This is the only place that submits expects to be....
		driver.findElement(updateButtonLocator).click();

		// Return a new page object representing the destination.
		// Should the login page ever go somewhere else then changing the method
		// signature
		// for this method will mean that all tests that rely on this behavior
		// won't compile.
		return new SecretQuestionPage(driver);
	}
	
	
}
