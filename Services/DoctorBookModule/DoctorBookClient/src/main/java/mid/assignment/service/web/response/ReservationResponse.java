package mid.assignment.service.web.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReservationResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty(required = true)
	private String reservationId;
	@JsonProperty(required = true)
	private String reservationStatus;

	public String getReservationId() {
		return reservationId;
	}

	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}

	public String getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

}
