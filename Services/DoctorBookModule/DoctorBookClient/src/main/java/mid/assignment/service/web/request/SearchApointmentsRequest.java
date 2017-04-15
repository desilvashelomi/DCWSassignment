package mid.assignment.service.web.request;

import java.io.Serializable;

public class SearchApointmentsRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1568493256821874780L;
	private Long docId;
	private String docName;

	public Long getDocId() {
		return docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

}
