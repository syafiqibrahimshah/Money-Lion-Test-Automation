package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://www.moneylion.com")
public class HomePage extends PageObject {

	@FindBy(xpath = "(//span[contains(.,'Memberships')])[1]")
	public WebElement membershipMenuLinks;

	@FindBy(xpath = "(//span[contains(.,'Plus')])[1]")
	public WebElementFacade membershipMenuPlusLink;

	@FindBy(xpath = "(//span[contains(.,'Products')])[1]")
	public WebElement productsLink;

	@FindBy(xpath = "(//span[contains(.,'Investing')])[1]")
	public WebElementFacade productsInvestingLink;
	
	@FindBy(xpath = "(//span[contains(.,'Rewards')])[1]")
	public WebElementFacade productsRewardsLink;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void hoverAndClickMembershipMenuPlusLink() {
		withAction().moveToElement(membershipMenuLinks).perform();
		membershipMenuPlusLink.waitUntilVisible();
		membershipMenuPlusLink.click();
	}

	public void hoverAndClickProductInvestingLink() {
		withAction().moveToElement(productsLink).perform();
		productsInvestingLink.waitUntilVisible();
		productsInvestingLink.click();
	}
	
	public void hoverAndClickProductRewardsLink() {
		withAction().moveToElement(productsLink).perform();
		productsRewardsLink.waitUntilVisible();
		productsRewardsLink.click();
	}

}
