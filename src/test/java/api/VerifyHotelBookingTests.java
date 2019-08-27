package api;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import steps.api.CreateNewHotelBookingApiRequest;
import steps.api.VerifyHotelBookingApiRequest;

@RunWith(SerenityRunner.class)
public class VerifyHotelBookingTests {

	@Steps
	VerifyHotelBookingApiRequest verifyHotelBookingApiRequest;

	@Steps
	CreateNewHotelBookingApiRequest createNewHotelBookingApiRequest;

	@Test
	@WithTags({ @WithTag(type = "priority", name = "high"), @WithTag(type = "component", name = "API") })
	public void verifyBookingFromApril27thToApril30thWithTotalPriceOf2389WithoutPayingDeposit() {

		String bookingId = createNewHotelBookingApiRequest.getBookingId();

		verifyHotelBookingApiRequest.getHotelBooking(bookingId);
		verifyHotelBookingApiRequest.foundHotelBooking();
		verifyHotelBookingApiRequest.iShouldFindBookingFirstName("Suleiman");
		verifyHotelBookingApiRequest.iShouldFindBookingLastName("Syafiq");
		verifyHotelBookingApiRequest.iShouldFindBookingDatesCheckin("2019-04-27");
		verifyHotelBookingApiRequest.iShouldFindBookingDatesCheckout("2019-04-30");
		verifyHotelBookingApiRequest.iShouldFindBookingTotalPrice(2389);
		verifyHotelBookingApiRequest.iShouldFindBookingDepositPaid(false);
	}
}
