package mid.assignment.service.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "hospital_book_apointments")
public class BookAppointment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3339014094113814720L;

	@Id
	@GeneratedValue
	@Column(name = "BOOK_ID")
	private Long bookId;

	@Column(name = "CREATED_DATE", nullable = false)
	private Date createdDate;

	@JoinColumn(name = "APOINTMENT_ID", nullable = false)
	private String apointmentId;

	@Column(name = "CHARGE", nullable = false)
	private double charge;

	@Column(name = "USER", nullable = false)
	private String user;

	@Column(name = "PAYMENT_METH", nullable = false)
	private String paymentMethods;

	@Column(name = "STATUS", nullable = false)
	private int status;

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public double getCharge() {
		return charge;
	}

	public void setCharge(double charge) {
		this.charge = charge;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPaymentMethods() {
		return paymentMethods;
	}

	public void setPaymentMethods(String paymentMethods) {
		this.paymentMethods = paymentMethods;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getApointmentId() {
		return apointmentId;
	}

	public void setApointmentId(String apointmentId) {
		this.apointmentId = apointmentId;
	}

}
