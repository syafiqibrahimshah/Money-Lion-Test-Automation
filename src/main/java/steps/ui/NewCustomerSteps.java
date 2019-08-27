package steps.ui;

import net.thucydides.core.annotations.Step;
import pages.HomePage;
import pages.MoneyLionPlusMembershipPage;
import pages.MoneyLionProductInvestingPage;
import pages.MoneyLionProductRewardsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class NewCustomerSteps {

	HomePage homePage;
	MoneyLionPlusMembershipPage moneyLionPlusMembershipPage;
	MoneyLionProductInvestingPage moneyLionProductInvestingPage;
	MoneyLionProductRewardsPage moneyLionProductRewardsPage;

	@Step
	public void opensHomePage() {
		homePage.open();
	}

	@Step
	public void opensMoneyLionPlusMembershipPage() {
		homePage.hoverAndClickMembershipMenuPlusLink();
	}

	@Step
	public void shouldSeeRobertsTestimony(String robertsTestimony) {
		assertThat(moneyLionPlusMembershipPage.getRobertsTestimony()).containsIgnoringCase(robertsTestimony);
	}

	@Step
	public void opensMoneyLionProductInvestingPage() {
		homePage.hoverAndClickProductInvestingLink();
	}

	@Step
	public void scrollToProjectionSlider() {
		moneyLionProductInvestingPage.scrollToProjectionSlider();
	}

	@Step
	public void setDepositAmount(int depositAmount) {
		moneyLionProductInvestingPage.setDepositAmount(depositAmount);
	}

	@Step
	public void setYear(int year) {
		moneyLionProductInvestingPage.setYearOnChart(year);
	}

	@Step
	public void shouldSeeProjectedValueAndDepositedAmount(int projectedValue, int depositedValue) {

		assertThat(moneyLionProductInvestingPage.getProjectedValue().equals(Integer.toString(projectedValue)));

		System.out.println("QA shouldSeeProjectedValueAndDepositedAmount = "
				+ moneyLionProductInvestingPage.getProjectedValue() + " == " + projectedValue);

		assertThat(moneyLionProductInvestingPage.getDepositedValue().equals(Integer.toString(depositedValue)));

		System.out.println("QA shouldSeeProjectedValueAndDepositedAmount = "
				+ moneyLionProductInvestingPage.getDepositedValue() + " == " + depositedValue);

	}

	@Step
	public void opensMoneyLionProductRewardsPage() {
		homePage.hoverAndClickProductRewardsLink();
	}

	@Step
	public void scrollToEarnRewardsBy() {
		moneyLionProductRewardsPage.scrollToEarnRewardsBy();
	}

	@Step
	public void shouldSeeAllFourWaysToEarnRewards(String way_1, String way_2, String way_3, String way_4) {
		assertThat(moneyLionProductRewardsPage.shouldSeeSigningUpForFreeCreditMonitoring(way_1).compareTo(true));
		assertThat(moneyLionProductRewardsPage.shouldSeePayingABillOnTime(way_2).compareTo(true));
		assertThat(moneyLionProductRewardsPage.shouldSeeTrackingYourSavings(way_3).compareTo(true));
		assertThat(moneyLionProductRewardsPage.shouldSeeSavingMoreWithMoneyLionPlus(way_4).compareTo(true));
	}

}
