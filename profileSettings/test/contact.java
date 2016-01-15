

public class ContactPage extends WireFrame  {
	private final WebDriver driver;
	private final String pageTitle = Props.getProp("secret.pagetitle");

	public ContactPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

		// check we are on the profile page
		PageObjectUtils.checkPageTitle(driver, pageTitle);
	}
	
	//get the fields
	By privEmailLocator = By.id(Props.getProp("user.input.privilege"));
	By recEmailLocator = By.id(Props.getProp("user.input.recommend"));
	By LangLocator = By.id(Props.getProp("user.input.language"));
	By fqm1EmailLocator = By.id(Props.getProp("user.input.fqm1"));
	By fqm2EmailLocator = By.id(Props.getProp("user.input.fqm2"));
	By fqm3EmailLocator = By.id(Props.getProp("user.input.fqm3"));
	By updateButtonLocator = By.id(Props.getProp("user.button.update"));
	
	
	
}
