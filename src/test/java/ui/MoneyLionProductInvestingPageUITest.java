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
public class MoneyLionProductInvestingPageUITest {

	@Managed
	WebDriver driver;

	@Steps
	NewCustomerSteps newCustomer;

	@Test
	@WithTags({ @WithTag(type = "priority", name = "high"), @WithTag(type = "component", name = "UI") })
	public void ableToVerifyTotalDepositedAmountOverAPeriodOfTime() {

		newCustomer.opensHomePage();
		newCustomer.opensMoneyLionProductInvestingPage();
		newCustomer.scrollToProjectionSlider();
		newCustomer.setDepositAmount(125);
		newCustomer.setYear(21);
		newCustomer.shouldSeeProjectedValueAndDepositedAmount(89820, 31500);

		newCustomer.setDepositAmount(350);
		newCustomer.setYear(20);
		newCustomer.shouldSeeProjectedValueAndDepositedAmount(227863, 84000);

		newCustomer.setDepositAmount(450);
		newCustomer.setYear(1);
		newCustomer.shouldSeeProjectedValueAndDepositedAmount(5676, 5400);
	}

}
