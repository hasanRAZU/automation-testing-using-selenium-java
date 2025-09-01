package pagesBestBuy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseBestBuy.BaseClassBB;

public class LocationPageBB extends BaseClassBB {
	
	@FindBy(className="us-link")
	WebElement countryUSA;

	public LocationPageBB() {
		PageFactory.initElements(driver, this);
	}
	
	public void deliveryAtUSA() {
		clickOn(countryUSA);
	}

	public String bestBuyPageTitle() throws Exception {

		return getPageTitle();

	}
	
	public int urlResponseCode() throws Exception {

		return getResponseCode(readProperty("url"));

	}
}
