package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MoneyLionPlusMembershipPage extends PageObject {

	@FindBy(xpath = "//span[contains(.,'CREDIT BUILDER PLUS')]")
	public WebElement robertsTestimonyDisplay;

	public MoneyLionPlusMembershipPage(WebDriver driver) {
		super(driver);
	}

	public String getRobertsTestimony() {
		return robertsTestimonyDisplay.getText();
	}

}
