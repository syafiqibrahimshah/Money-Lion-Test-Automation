package steps.api;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.util.Map;

import dataentities.Booking;
import dataentities.BookingDates;
import dataentities.CreateNewHotelBookingPostResponse;

public class CreateNewHotelBookingApiRequest {
	private String baseEndPointURL = "https://restful-booker.herokuapp.com/booking/";
	private Response response;
	private static Booking booking;
	private static BookingDates bookingDates;
	private static CreateNewHotelBookingPostResponse createNewHotelBookingPostResponse;

	@Step
	public void createNewHotelBooking(Map<String, Object> requestBody) {
		response = SerenityRest.rest().contentType(ContentType.JSON).body(requestBody).when().post(baseEndPointURL)
				.then().extract().response();

		createNewHotelBookingResponseToJavaObject();
	}

	@Step
	public void createNewHotelBookingResponseToJavaObject() {
		String json = response.getBody().asString();
		JsonPath jsonPath = new JsonPath(json);

		// POJO BookingDates
		bookingDates = new BookingDates();
		bookingDates.setCheckin(jsonPath.getString("booking.bookingdates.checkin"));
		bookingDates.setCheckout(jsonPath.getString("booking.bookingdates.checkout"));

		// POJO Booking
		booking = new Booking();
		booking.setFirstName(jsonPath.getString("booking.firstname"));
		booking.setLastName(jsonPath.getString("booking.lastname"));
		booking.setTotalPrice(Integer.parseInt(jsonPath.getString("booking.totalprice")));
		booking.setDepositPaid(Boolean.parseBoolean(jsonPath.getString("booking.depositpaid")));
		booking.setBookingDates(bookingDates);
		booking.setAdditionalNeeds(jsonPath.getString("booking.additionalneeds"));

		// POJO CreateNewHotelBookingPostResponse
		createNewHotelBookingPostResponse = new CreateNewHotelBookingPostResponse();
		createNewHotelBookingPostResponse.setBookingId(jsonPath.getString("bookingid"));
		createNewHotelBookingPostResponse.setBooking(booking);
	}

	@Step
	public void bookingAddedSuccesfully() {
		response.then().statusCode(200);
	}

	@Step
	public void iShouldFindBookingIdNotNull() {
		response.then().body("bookingid", notNullValue());
	}

	@Step
	public void iShouldFindBookingDatesCheckout(String checkoutDate) {
		response.then().body("booking.bookingdates.checkout", is(checkoutDate));
	}

	@Step
	public void iShouldFindBookingDatesCheckin(String checkinDate) {
		response.then().body("booking.bookingdates.checkin", is(checkinDate));
	}

	@Step
	public void iShouldFindBookingTotalPrice(int totalPrice) {
		response.then().body("booking.totalprice", is(totalPrice));
	}

	@Step
	public void iShouldFindBookingDepositPaid(boolean depositPaid) {
		response.then().body("booking.depositpaid", is(depositPaid));
	}

	public String getBookingId() {
		return createNewHotelBookingPostResponse.getBookingId();
	}

}
