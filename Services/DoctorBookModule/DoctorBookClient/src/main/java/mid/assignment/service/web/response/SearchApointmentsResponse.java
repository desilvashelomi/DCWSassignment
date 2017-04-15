package mid.assignment.service.web.response;

import java.io.Serializable;
import java.util.Date;

public class SearchApointmentsResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1568493256821874780L;
	private Long docId;
	private Long apoId;
	private String docName;
	private String hospital;
	private Date apoDate;
	private double charge;

	public Long getDocId() {
		return docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

	public Long getApoId() {
		return apoId;
	}

	public void setApoId(Long apoId) {
		this.apoId = apoId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public Date getApoDate() {
		return apoDate;
	}

	public void setApoDate(Date apoDate) {
		this.apoDate = apoDate;
	}

	public double getCharge() {
		return charge;
	}

	public void setCharge(double charge) {
		this.charge = charge;
	}

}
