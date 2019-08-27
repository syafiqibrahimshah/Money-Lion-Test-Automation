package steps.api;

import static org.hamcrest.Matchers.is;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class VerifyHotelBookingApiRequest {
	private String baseEndPointURL = "https://restful-booker.herokuapp.com/booking/";
	private Response response;

	@Step
	public void getHotelBooking(String bookingId) {
		response = SerenityRest.when().get(baseEndPointURL + bookingId);
	}

	@Step
	public void foundHotelBooking() {
		response.then().statusCode(200);
	}

	public void iShouldFindBookingDatesCheckin(String checkinDate) {
		response.then().body("bookingdates.checkin", is(checkinDate));
	}

	public void iShouldFindBookingDatesCheckout(String checkoutDate) {
		response.then().body("bookingdates.checkout", is(checkoutDate));
	}

	public void iShouldFindBookingTotalPrice(int totalPrice) {
		response.then().body("totalprice", is(totalPrice));
	}

	public void iShouldFindBookingDepositPaid(boolean depositPaid) {
		response.then().body("depositpaid", is(depositPaid));
	}

	public void iShouldFindBookingFirstName(String firstName) {
		response.then().body("firstname", is(firstName));

	}

	public void iShouldFindBookingLastName(String lastName) {
		response.then().body("lastname", is(lastName));

	}

}
