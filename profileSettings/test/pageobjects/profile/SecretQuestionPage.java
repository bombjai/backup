package com.myfico.selenium.pageobjects.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import com.myfico.selenium.pageobjects.common.WireFrame;
import com.myfico.selenium.pageobjects.profile.SecretQuestionPage;
import com.myfico.selenium.utils.PageObjectUtils;
import com.myfico.selenium.utils.Props;

public class SecretQuestionPage extends WireFrame  {

	private final WebDriver driver;
	private final String pageTitle = Props.getProp("ps.secretquestion.pagetitle");

	public SecretQuestionPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

		// check we are on the profile page
		PageObjectUtils.checkPageTitle(driver, pageTitle);
	}
	
	By pageLoad = By.cssSelector(Props.getProp("ps.secretquestion.pageload"));
	
	//get get fields
	By secretQuestionLocator = By.name(Props.getProp("ps.secretquestion.input.secretQuestion"));
	By answerLocator = By.name(Props.getProp("ps.secretquestion.input.answer"));
	By confirmAnswerLocator = By.name(Props.getProp("ps.secretquestion.input.confirmAnswer"));
	
	//submit button
	By submitLocator = By.xpath(Props.getProp("ps.secretquestion.input.button"));
	
	public void typeCurrentQuestion(String secretQuestion) {
		Select select = new Select(driver.findElement(secretQuestionLocator));
		// select.deselectAll();
		//select.selectByVisibleText(secretQuestion);
		//select by value
		select.selectByValue(secretQuestion);
	}
	
	public void typeNewAnwer(String answer) {
		WebElement element = driver.findElement(answerLocator);
		element.clear();
		element.sendKeys(answer);
	}
	
	public void typeConfirmAnswer(String confirmAnswer) {
		WebElement element = driver.findElement(confirmAnswerLocator);
		element.clear();
		element.sendKeys(confirmAnswer);
	}

	public SecretQuestionPage filloutSecretQuestionForm() {
	
		System.out.println("starting form");

		String question = Props.getProp("ps.secretquestion.val.secretQuestion");
		typeCurrentQuestion(question);
		System.out.println("Secret Question: " + question);
		
		String current = Props.getProp("ps.secretquestion.val.answer");
		typeNewAnwer(current);
		System.out.println("Answer: " + current);
		
		String confirm = Props.getProp("ps.secretquestion.val.confirmAnswer");
		typeConfirmAnswer(confirm);
		System.out.println("Confirm Answer: " + confirm);

		// focus input from blur
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("$('input').focus();");

		System.out.println("filled form");
		
		return this;

	}
	
	public SecretQuestionPage submitSecretQuestionForm() {
		PageObjectUtils.sleep();
		WebElement element = driver.findElement(submitLocator);
		element.click();
		
		PageObjectUtils.takeScreenShot(driver, false);
		System.out.println("submitting page...");
		
		WebDriverWait wait = new WebDriverWait(driver, Props.WAIT_NORMAL);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".success")));
		
		return new SecretQuestionPage(driver);
	}

	public boolean verifyPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver, Props.WAIT_EXTRA);
		WebElement title = driver.findElement(By.xpath(Props.getProp("ps.secretquestion.pageload")));
		wait.until(ExpectedConditions.visibilityOf(title));
		return true;
	}
	
	public void waitForPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver, Props.WAIT_EXTRA);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#mc_ps_question")));
	}
	
	
}
