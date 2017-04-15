package mid.assignment.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import mid.assignment.response.PaymentGatewayResponse;
import mid.assignment.service.entity.BookAppointment;
import mid.assignment.service.entity.HospitalAppointment;
import mid.assignment.service.request.PaymentGatewayRequest;
import mid.assignment.service.service.HospitalManagerService;
import mid.assignment.service.web.request.ReservationRequest;
import mid.assignment.service.web.request.SearchApointmentsRequest;
import mid.assignment.service.web.response.ReservationResponse;
import mid.assignment.service.web.response.SearchApointmentsResponse;

@RestController
public class DoctorBookRESTService {
	@Autowired
	private HospitalManagerService hospitalManagerService;

	@RequestMapping(value = "/restapi/searchApointments", method = RequestMethod.POST)
	public @ResponseBody List<SearchApointmentsResponse> searchApointments(
			@RequestBody SearchApointmentsRequest searchApointmentsRequest) {

		List<SearchApointmentsResponse> apointmentsResponses = new ArrayList<SearchApointmentsResponse>();
		List<HospitalAppointment> appointments = hospitalManagerService
				.getApointmentByDocId(searchApointmentsRequest.getDocId());

		for (HospitalAppointment appointment : appointments) {
			SearchApointmentsResponse response = new SearchApointmentsResponse();
			response.setDocName(appointment.getDoctor().getName());
			response.setApoDate(appointment.getDateTime());
			response.setHospital(appointment.getHospital());
			apointmentsResponses.add(response);

		}
		return apointmentsResponses;
	}

	@RequestMapping(value = "/restapi/bookApointment", method = RequestMethod.POST)
	public @ResponseBody ReservationResponse bookApointment(@RequestBody ReservationRequest reservationRequest)
			throws RestClientException, URISyntaxException {

		ReservationResponse reservationResponses = new ReservationResponse();
		BookAppointment bookAppointment = new BookAppointment();

		bookAppointment.setCharge(reservationRequest.getCharge());
		bookAppointment.setCreatedDate(new Date());
		bookAppointment.setPaymentMethods(reservationRequest.getChargeType());
		bookAppointment.setUser(reservationRequest.getUser());
		bookAppointment.setApointmentId(reservationRequest.getApointmentId());
		bookAppointment.setStatus(0);
		BookAppointment appointment = hospitalManagerService.saveApointment(bookAppointment);

		if (null != appointment) {

			RestTemplate restTemplate = new RestTemplate();
			PaymentGatewayRequest paymentGatewayRequest = new PaymentGatewayRequest();

			paymentGatewayRequest.setCcNo(reservationRequest.getCcNo());
			paymentGatewayRequest.setCvcNo(reservationRequest.getCvcNo());
			paymentGatewayRequest.setCardHolder(reservationRequest.getCardHolder());
			paymentGatewayRequest.setCharge(reservationRequest.getCharge());

			@SuppressWarnings("unchecked")
			PaymentGatewayResponse paymentGatewayResponse = (PaymentGatewayResponse) restTemplate.postForObject(
					new URI("http://localhost:9763/DoctorBookRESTService/restapi/testPaymentGateway"),
					paymentGatewayRequest, PaymentGatewayResponse.class);

			if (null != paymentGatewayResponse) {
				bookAppointment.setStatus(1);
				hospitalManagerService.updateApointment(bookAppointment);
			}

		}

		return reservationResponses;
	}

}
