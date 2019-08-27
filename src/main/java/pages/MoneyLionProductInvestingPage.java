package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MoneyLionProductInvestingPage extends PageObject {

	@FindBy(xpath = "//span[contains(.,'Use the sliders to see projections about how much your money could grow over time.')]")
	public WebElementFacade projectionSliderInstruction;

	@FindBy(xpath = "//div[contains(@class,'rc-slider-handle')][contains(@aria-valuemin,'25')]")
	public WebElement depositSlider;

	@FindBy(xpath = "//div[contains(@class,'depositNumberText-0-336')]")
	public WebElementFacade depositText;

	@FindBy(xpath = "//*[local-name()='svg']//*[local-name()='g' and @class='ct-labels']//*[local-name()='foreignObject']//span[@class='ct-label ct-horizontal ct-end']")
	public WebElementFacade yearlyChartValue;

	@FindBy(xpath = "//*[local-name()='svg']//*[local-name()='g']//*[local-name()='g']//*[local-name()='g']//*[local-name()='foreignObject']//div[text()='Projected value']/following-sibling::div[contains(text(), '$')]")
	public WebElementFacade ProjectedValueOnChart;

	@FindBy(xpath = "//*[local-name()='svg']//*[local-name()='g']//*[local-name()='g']//*[local-name()='g']//*[local-name()='foreignObject']//div[text()='Deposited']/following-sibling::div[contains(text(), '$')]")
	public WebElementFacade DepositedValueOnChart;

	public MoneyLionProductInvestingPage(WebDriver driver) {
		super(driver);
	}

	public void scrollToProjectionSlider() {
		evaluateJavascript("arguments[0].scrollIntoView(true);", projectionSliderInstruction);
		projectionSliderInstruction.waitUntilVisible();
	}

	public void setDepositAmount(int toBeDepositedAmount) {

		int currentDepositShown = Integer.parseInt(depositText.getText().replaceAll("[^0-9.,]+", ""));
		String toBeDepositedAmountStr = Integer.toString(toBeDepositedAmount);
		toBeDepositedAmountStr = "$" + toBeDepositedAmountStr;
		System.out.println("toBeDepositedAmountStr = " + toBeDepositedAmountStr);

		// move slider to the left
		if (currentDepositShown > toBeDepositedAmount) {
			while (!depositText.getText().equals(toBeDepositedAmountStr)) {
				depositText.waitUntilVisible();
				withAction().clickAndHold(depositSlider).moveByOffset(-20, 0).release().build().perform();
				System.out.println("depositText" + depositText.getText());

			}
		}

		// move slider to the right
		if (currentDepositShown < toBeDepositedAmount) {
			while (!depositText.getText().equals(toBeDepositedAmountStr)) {
				depositText.waitUntilVisible();
				withAction().clickAndHold(depositSlider).moveByOffset(20, 0).release().build().perform();
				System.out.println("depositText" + depositText.getText());
			}
		}
	}

	public void setYearOnChart(int yearToSet) {

		yearlyChartValue.waitUntilVisible();
		List<WebElement> yearValue = getDriver().findElements(By.xpath(
				"//*[local-name()='svg']//*[local-name()='g' and @class='ct-labels']//*[local-name()='foreignObject']//span[@class='ct-label ct-horizontal ct-end']"));

		for (int i=0; i < yearToSet; i++) {
			withAction().dragAndDropBy(yearValue.get(i), 15, 0).perform();
		}
	}

	public String getProjectedValue() {
		System.out.println("ProjectedValueOnChart = " + ProjectedValueOnChart.getAttribute("textContent"));

		return ProjectedValueOnChart.getAttribute("textContent");

	}

	public String getDepositedValue() {
		System.out.println("ProjectedValueOnChart = " + DepositedValueOnChart.getAttribute("textContent"));

		return DepositedValueOnChart.getAttribute("textContent");
	}
}
