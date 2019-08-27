package ui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import steps.ui.NewCustomerSteps;

@RunWith(SerenityRunner.class)
public class MoneyLionPlusMembershipPageUITest {

	@Managed
	WebDriver driver;

	@Steps
	NewCustomerSteps newCustomer;

	@Test
	@WithTags({ @WithTag(type = "priority", name = "high"), @WithTag(type = "component", name = "UI") })
	public void ableToAccessMoneyLionPlusMembershipPageSuccessfully() {
		newCustomer.opensHomePage();
		newCustomer.opensMoneyLionPlusMembershipPage();
		// There's no testimony from Robert. "CREDIT BUILDER PLUS" as a temporary
		// placeholder.
		newCustomer.shouldSeeRobertsTestimony("CREDIT BUILDER PLUS");
	}
}
