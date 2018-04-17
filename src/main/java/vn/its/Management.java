package vn.its;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import vn.its.model.Course;
import vn.its.model.Syllabus;

public class Management {

	public static void main(String[] args) {
		Syllabus syllabus = new Syllabus("Hibernate content", 30);
		 Course course = new Course("@Id Hibernate", new Date(), syllabus);

		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			 session.save(course);
			 session.getTransaction().commit();
//			Course hibernate = (Course) session.get(Course.class, 2);
//			System.out.println(hibernate);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		ConnectionUtil.getSessionFactory().close();

	}

}
