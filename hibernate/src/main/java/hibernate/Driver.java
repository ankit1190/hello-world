package hibernate;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.models.User;

public class Driver {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		SessionFactory factory  = new Configuration().configure()
										.addAnnotatedClass(User.class)
										.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
//			CriteriaBuilder cb = session.getCriteriaBuilder();
//			CriteriaQuery<User> u = cb.createQuery(User.class);
//			Root<User> rootEntry = u.from(User.class);
//			CriteriaQuery<User> all = u.select(rootEntry);
//			
//			TypedQuery<User> allquery = session.createQuery(all);
//			List<User> users = allquery.getResultList();
			
			List<User> users = session.createQuery("from User u where u.role = 'ADMIN'").getResultList();
			
			for(User items: users) {
				System.out.println(items);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}

	}

}
