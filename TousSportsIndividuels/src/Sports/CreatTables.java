package Sports;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Projet.DBConnection;
import Projet.DataInit;



public class CreatTables {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataInit.createTables();

		Session session = DBConnection.getSession();
		Transaction persistTransaction1 = session.beginTransaction();
		
		User user = new User("test1", "dass2", "das", 21, "f", 58.2, 1.62, "aaaaa", "0658", "758");
		session.persist(user);
		/*
		Yoga Yoga = new Yoga(15, 2, 1.2);
		session.save(Yoga);
		
		Tir = new Tir_a_larc(2,3,2.3,5);
		session.save(Tir);
		Tir = new Tir_a_larc(0,10,1.3,1);
		session.save(Tir);
		Tir = new Tir_a_larc(10,0,4.3,8);
		session.save(Tir);
		Tir = new Tir_a_larc(1,6,1.3,5);
		session.save(Tir);
		
		Musculation = new Musculation(0,0,0);
		session.save(Musculation);
		Musculation = new Musculation(2,30.4,4);
		session.save(Musculation);
		Musculation = new Musculation(9,4.2,1);
		session.save(Musculation);
		Musculation = new Musculation(2,10.4,4);
		session.save(Musculation);
		Musculation = new Musculation(9,4.2,1);
		session.save(Musculation);
		
		
		Jogging = new Jogging(0,0,0,0);
		session.save(Jogging);
		Jogging = new Jogging(2,7,1,2);
		session.save(Jogging);
		Jogging = new Jogging(3,1,2,1);
		session.save(Jogging);
		Jogging = new Jogging(1,6,0,6);
		session.save(Jogging);
		
		
		kayak = new Kayak(2,7,1,2);
		session.save(kayak);
		kayak = new Kayak(3,1,2,1);
		session.save(kayak);
		kayak = new Kayak(1,6,0,6);
		session.save(kayak);
		kayak = new Kayak(0,2,5,3);
		session.save(kayak);
		kayak = new Kayak(1,8,3,6);
		session.save(kayak);
		
		Equitation = new Equitation(2,30.4,4);
		session.save(Equitation);
		Equitation = new Equitation(9,4.2,1);
		session.save(Equitation);
		Equitation = new Equitation(2,10.4,4);
		session.save(Equitation);
		Equitation = new Equitation(9,4.2,1);
		session.save(Equitation);
		*/
		persistTransaction1.commit();

		session.close(); 

	}

}
