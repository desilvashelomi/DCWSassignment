package mid.assignment.service.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PaymentGatewayRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty(required = true)
	private String chargeType;
	@JsonProperty(required = false)
	private double charge;
	@JsonProperty(required = false)
	private String reservationId;
	@JsonProperty(required = false)
	private String user;
	@JsonProperty(required = false)
	private String cvcNo;
	@JsonProperty(required = false)
	private String ccNo;
	@JsonProperty(required = false)
	private String cardHolder;
	@JsonProperty(required = false)
	private String mobile;
	@JsonProperty(required = false)
	private String pin;
	@JsonProperty(required = false)
	private String apointmentId;

	public String getChargeType() {
		return chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	public double getCharge() {
		return charge;
	}

	public void setCharge(double charge) {
		this.charge = charge;
	}

	public String getReservationId() {
		return reservationId;
	}

	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getCvcNo() {
		return cvcNo;
	}

	public void setCvcNo(String cvcNo) {
		this.cvcNo = cvcNo;
	}

	public String getCcNo() {
		return ccNo;
	}

	public void setCcNo(String ccNo) {
		this.ccNo = ccNo;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getApointmentId() {
		return apointmentId;
	}

	public void setApointmentId(String apointmentId) {
		this.apointmentId = apointmentId;
	}

}
