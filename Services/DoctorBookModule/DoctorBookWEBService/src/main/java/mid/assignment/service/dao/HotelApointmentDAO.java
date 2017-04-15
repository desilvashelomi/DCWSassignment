package mid.assignment.service.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mid.assignment.service.entity.BookAppointment;
import mid.assignment.service.entity.HospitalAppointment;

@Repository
public class HotelApointmentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<HospitalAppointment> getApointmentByDocId(Long docId) {
		Session session = sessionFactory.getCurrentSession();

		@SuppressWarnings("unchecked")
		List<HospitalAppointment> hospitalAppointments = session
				.createQuery("from HospitalAppointment s where s.doctor.id=:docId").setParameter("docId", docId).list();

		return hospitalAppointments;
	}

	public BookAppointment saveApointment(BookAppointment bookAppointment) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(bookAppointment);
		return bookAppointment;
	}

	public BookAppointment updateApointment(BookAppointment bookAppointment) {
		Session session = sessionFactory.getCurrentSession();
		session.update(bookAppointment);
		return bookAppointment;
	}

}
