package api;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import steps.api.CreateNewHotelBookingApiRequest;
import net.serenitybdd.junit.runners.SerenityRunner;

@RunWith(SerenityRunner.class)
public class CreateNewHotelBookingTests {

	@Steps
	CreateNewHotelBookingApiRequest createNewHotelBookingApiRequest;

	@Test
	@WithTags({ @WithTag(type = "priority", name = "high"), @WithTag(type = "component", name = "API") })
	public void createNewBookingFromApril27thToApril30thWithTotalPriceOf2389WithoutPayingDeposit() {

		Map<String, String> bookingdatesRequestBodyAsMap = new HashMap<String, String>();
		bookingdatesRequestBodyAsMap.put("checkin", new String("2019-04-27"));
		bookingdatesRequestBodyAsMap.put("checkout", new String("2019-04-30"));

		Map<String, Object> requestBodyAsMap = new HashMap<String, Object>();
		requestBodyAsMap.put("firstname", new String("Suleiman"));
		requestBodyAsMap.put("lastname", new String("Syafiq"));
		requestBodyAsMap.put("totalprice", new Integer(2389));
		requestBodyAsMap.put("depositpaid", new Boolean(false));
		requestBodyAsMap.put("bookingdates", bookingdatesRequestBodyAsMap);
		requestBodyAsMap.put("additionalneeds", new String("Non Smoking Room"));

		createNewHotelBookingApiRequest.createNewHotelBooking(requestBodyAsMap);
		createNewHotelBookingApiRequest.bookingAddedSuccesfully();
		createNewHotelBookingApiRequest.iShouldFindBookingIdNotNull();
		createNewHotelBookingApiRequest.iShouldFindBookingDatesCheckin("2019-04-27");
		createNewHotelBookingApiRequest.iShouldFindBookingDatesCheckout("2019-04-30");
		createNewHotelBookingApiRequest.iShouldFindBookingTotalPrice(2389);
		createNewHotelBookingApiRequest.iShouldFindBookingDepositPaid(false);
		
	}

}