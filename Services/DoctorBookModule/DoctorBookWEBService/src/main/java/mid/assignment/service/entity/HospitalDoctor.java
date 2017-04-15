package mid.assignment.service.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hospital_doctor")
public class HospitalDoctor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3353795985097458953L;

	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(name = "DOC_NAME", nullable = false)
	private String name;

	@Column(name = "DOC_SPECIALITY")
	private String speciality;

	@Column(name = "STATUS", nullable = false)
	private int status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
