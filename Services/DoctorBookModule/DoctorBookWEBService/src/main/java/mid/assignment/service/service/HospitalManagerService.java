/**
 * 
 */
package mid.assignment.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mid.assignment.service.dao.HotelApointmentDAO;
import mid.assignment.service.entity.BookAppointment;
import mid.assignment.service.entity.HospitalAppointment;

@Service
public class HospitalManagerService {

	@Autowired
	private HotelApointmentDAO hotelApointmentDAO;

	@Transactional
	public List<HospitalAppointment> getApointmentByDocId(Long docId) {

		return hotelApointmentDAO.getApointmentByDocId(docId);
	}

	@Transactional
	public BookAppointment saveApointment(BookAppointment bookAppointment) {
		return hotelApointmentDAO.saveApointment(bookAppointment);
	}

	@Transactional
	public BookAppointment updateApointment(BookAppointment bookAppointment) {
		return hotelApointmentDAO.updateApointment(bookAppointment);
	}

}
