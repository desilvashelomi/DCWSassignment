package mid.assignment.jsf.beans;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import mid.assignment.jsf.dao.LoginDAO;
import mid.assignment.jsf.request.ReservationRequest;
import mid.assignment.jsf.request.SearchApointmentsRequest;
import mid.assignment.jsf.response.ReservationResponse;
import mid.assignment.jsf.response.SearchApointmentsResponse;
import mid.assignment.jsf.util.SessionUtils;

@ManagedBean
@SessionScoped
public class SearchController implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;

	private List<SearchApointments> searchApointmentsList;
	private SearchApointments searchApointments;

	private String doctorName;

	private String ccNumber;
	private String cvvNumber;
	private String cardHolder;

	public void searchApointments() throws RestClientException, URISyntaxException {
		SearchApointmentsRequest searchApointmentsRequest = new SearchApointmentsRequest();
		searchApointmentsRequest.setDocName(doctorName);
		RestTemplate restTemplate = new RestTemplate();
		@SuppressWarnings("unchecked")
		List<SearchApointmentsResponse> searchApointmentsResponses = (List<SearchApointmentsResponse>) restTemplate
				.postForObject(new URI("http://localhost:9763/DoctorBookRESTService/restapi/searchApointments"),
						searchApointmentsRequest, SearchApointmentsResponse.class);

		List<SearchApointments> apointments = new ArrayList<SearchApointments>();

		for (SearchApointmentsResponse reservationResponse1 : searchApointmentsResponses) {
			SearchApointments searchApointments = new SearchApointments();
			searchApointments.setDocName(reservationResponse1.getDocName());
			searchApointments.setHospital(reservationResponse1.getHospital());
			searchApointments.setCharge(reservationResponse1.getCharge());
			searchApointments.setApoDate(reservationResponse1.getApoDate());
			apointments.add(searchApointments);
		}
		searchApointmentsList = apointments;

	}

	public String loadPaymentPage() {
		HttpSession session = SessionUtils.getSession();
		session.setAttribute("charge", searchApointments.getCharge());
		session.setAttribute("apoId", searchApointments.getApoId());
		return "payment";

	}

	public ReservationResponse callPaymentGateway() throws RestClientException, URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();
		ReservationRequest reservationRequest = new ReservationRequest();
		reservationRequest.setCcNo(ccNumber);
		reservationRequest.setCvcNo(cvvNumber);
		reservationRequest.setCardHolder(cardHolder);
		
		HttpSession session = SessionUtils.getSession();
		reservationRequest.setCharge(Double.parseDouble(session.getAttribute("charge").toString()));

		@SuppressWarnings("unchecked")
		ReservationResponse reservationResponse = (ReservationResponse) restTemplate.postForObject(
				new URI("http://localhost:9763/DoctorBookRESTService/restapi/bookApointment"), reservationRequest,
				ReservationResponse.class);
		return reservationResponse;

	}

	public List<SearchApointments> getSearchApointmentsList() {
		return searchApointmentsList;
	}

	public void setSearchApointmentsList(List<SearchApointments> searchApointmentsList) {
		this.searchApointmentsList = searchApointmentsList;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public SearchApointments getSearchApointments() {
		return searchApointments;
	}

	public void setSearchApointments(SearchApointments searchApointments) {
		this.searchApointments = searchApointments;
	}

}
