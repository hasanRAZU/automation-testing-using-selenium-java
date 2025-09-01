package pagesBestBuy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseBestBuy.BaseClassBB;

public class HomePageBB extends BaseClassBB {

	@FindBy(xpath = "//span[text()='Account']")
	WebElement account;

	@FindBy(xpath = "//a[text()='Sign In']")
	WebElement signIn;

	@FindBy(xpath = "//a[text()='Create Account']")
	WebElement createAccount;

	public HomePageBB() {
		PageFactory.initElements(driver, this);
	}

	public void goToCreatAccount() {
		clickOn(account);
		clickOn(createAccount);
	}

	public void goToSignIn() {
		clickOn(account);
		clickOn(signIn);
	}
}
