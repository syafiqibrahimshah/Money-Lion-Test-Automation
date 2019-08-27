package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class MoneyLionProductRewardsPage extends PageObject {

	@FindBy(xpath = "//div[@class='container-0-312']"
			+ "[contains(.,'Earn rewards bysIt’s easy to earn rewards. And we’ll help you stay  on track along the way.SIGN UP FOR FREE')]")
	public WebElementFacade earnRewardsBySection;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[3]/div/div/div[1]/h1[2]")
	public WebElementFacade earnRewardsByText;

	public void scrollToEarnRewardsBy() {
		evaluateJavascript("arguments[0].scrollIntoView(true);", earnRewardsBySection);
	}

	public Boolean shouldSeeSigningUpForFreeCreditMonitoring(String way_1) {

		do {
		} while (!earnRewardsByText.getText().equals(way_1));
		System.out.print("way_1 = " + earnRewardsByText.getText());
		return true;
	}

	public Boolean shouldSeePayingABillOnTime(String way_2) {
		do {
		} while (!earnRewardsByText.getText().equals(way_2));
		System.out.print("way_2 = " + earnRewardsByText.getText());
		return true;
	}

	public Boolean shouldSeeTrackingYourSavings(String way_3) {
		do {
		} while (!earnRewardsByText.getText().equals(way_3));
		System.out.print("way_3 = " + earnRewardsByText.getText());
		return true;
	}

	public Boolean shouldSeeSavingMoreWithMoneyLionPlus(String way_4) {
		do {
		} while (!earnRewardsByText.getText().equals(way_4));
		System.out.print("way_4 = " + earnRewardsByText.getText());
		return true;
	}

}
