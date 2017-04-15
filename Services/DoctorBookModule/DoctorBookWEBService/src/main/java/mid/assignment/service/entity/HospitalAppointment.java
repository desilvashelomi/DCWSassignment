package mid.assignment.service.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hospital_apointments")
public class HospitalAppointment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8953518413566198050L;

	@Id
	@GeneratedValue
	@Column(name = "APOINTMENT_ID", nullable = false)
	private Long apoId;

	@JoinColumn(name = "DOC_ID")
	@ManyToOne(fetch = FetchType.EAGER)
	private HospitalDoctor doctor;

	@Column(name = "CHARGE", nullable = false)
	private double charge;

	@Column(name = "HOSPITAL", nullable = false)
	private String hospital;

	@Column(name = "DATE_TIME", nullable = false)
	private Date dateTime;

	@Column(name = "STATUS", nullable = false)
	private int status;

	public Long getApoId() {
		return apoId;
	}

	public void setApoId(Long apoId) {
		this.apoId = apoId;
	}

	public HospitalDoctor getDoctor() {
		return doctor;
	}

	public void setDoctor(HospitalDoctor doctor) {
		this.doctor = doctor;
	}

	public double getCharge() {
		return charge;
	}

	public void setCharge(double charge) {
		this.charge = charge;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

}
