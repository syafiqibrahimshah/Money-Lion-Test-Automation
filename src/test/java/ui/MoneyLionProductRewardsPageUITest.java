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
public class MoneyLionProductRewardsPageUITest {
	@Managed
	WebDriver driver;

	@Steps
	NewCustomerSteps newCustomer;

	@Test
	@WithTags({ @WithTag(type = "priority", name = "high"), @WithTag(type = "component", name = "UI") })
	public void ableToSeeWaysToEarnRewards() {
		newCustomer.opensHomePage();
		newCustomer.opensMoneyLionProductRewardsPage();
		newCustomer.scrollToEarnRewardsBy();

		String way1 = "signing up for free credit monitoring";
		String way2 = "paying a bill on time";
		String way3 = "tracking your savings";
		String way4 = "saving more with MoneyLion Plus";
		newCustomer.shouldSeeAllFourWaysToEarnRewards(way1, way2, way3, way4);
	}
}
