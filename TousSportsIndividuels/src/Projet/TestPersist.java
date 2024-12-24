package Projet;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Activité.ActiviteEquitation;
import Activité.ActiviteJogging;
import Activité.ActiviteKayak;
import Activité.ActiviteMusculation;
import Activité.ActiviteTir_a_larc;
import Activité.ActiviteYoga;
import Sports.Amis;
import Sports.Choix;
import Sports.Equitation;
import Sports.Jogging;
import Sports.Kayak;
import Sports.Musculation;
import Sports.Sport;
import Sports.Tir_a_larc;
import Sports.User;
import Sports.Yoga;




public class TestPersist {

	public static void main(String[] args) {
		DataInit.createTables();
		 
		//Kayak kayak;
		User User,User1,User2,User3,User4,User5;
		

		Session session = DBConnection.getSession();
		Transaction Transaction = session.beginTransaction();
		
		User1 = new User("SAGHIR", "Aghiles", "Ghiles", 21, "h", 77.5, 1.75, "saghiraghiles@gmail.com", "0658584330", "758");
		session.persist(User1);
		
		User4 = new User("Jean", "Dupont","JD",20,"H",80.7,1.88,"Jean@gmail.com","0762315463","12345");

		session.persist(User4);
		
		User3 = new User("Dassine", "Mettouchi","Das",21,"F",54.,1.62,"mettouchidassien98@gmail.com","0652297858","Pv=nrtemc2001");
        session.persist(User3);
	
		User = new User("yasmine", "abbas","yasmineabbas",21,"F",48.9,1.57,"yasmineabbas012@gmail.com","0762315441","Pv=nrtemc2001");
		session.persist(User);
		
		User2 = new User("RIHGAS", "Mikah", "Hak", 23, "h", 77.5, 1.85, "mikamika@gmail.com", "0658584330", "758");
		session.persist(User);
		
		User5 = new User("RIHGAS", "Enicay", "Yac", 29, "h", 77.5, 1.80, "yacyac.com", "0658584330", "758");
		session.persist(User5);
		session.save(User5);
		session.save(User2);
		
		
		Amis amiRelation = new Amis(User1, User2);
		session.persist(amiRelation);
		
		Amis amiRelation2 = new Amis(User1, User);
		session.persist(amiRelation2);
		
		Amis amiRelation3 = new Amis(User1, User3);
		session.persist(amiRelation3);
		
		Amis amiRelation4 = new Amis(User1, User4);
		session.persist(amiRelation4);
		
		///
		User user = new User("test1", "dass2", "das", 21, "f", 58.2, 1.62, "aaaaa", "0658", "758");
		session.persist(user); // Création de l'entité 
		
		Sport sport1 = new Sport("Yoga"); // Création de l'entité
		session.persist(sport1);
		//session.save(sport);
		
		Sport sport2 = new Sport("Tir A LArc"); // Création de l'entité
		session.persist(sport2);
		
		Sport sport3 = new Sport("Musculation"); // Création de l'entité
		session.persist(sport3);
		
		Sport sport4 = new Sport("Jogging"); // Création de l'entité
		session.persist(sport4);
		
		Sport sport5 = new Sport("Equitation"); // Création de l'entité
		session.persist(sport5);
		
		Sport sport6 = new Sport("Kayak"); // Création de l'entité
		session.persist(sport6);
		
		
		//User user = (User) session.get(User.class, 1);
		Choix choix = new Choix(User4, sport1);
		session.persist(choix);
		session.save(choix);
		Choix choix1 = new Choix(User4, sport5);
		session.persist(choix1);
		session.save(choix1);
		Choix choix11 = new Choix(User4, sport3);
		session.persist(choix11);
		session.save(choix11);
		
		Choix choix2 = new Choix(User, sport1);
		session.persist(choix2);
		session.save(choix2);
		Choix choix22 = new Choix(User, sport5);
		session.persist(choix22);
		session.save(choix22);
		
		Choix choix3 = new Choix(User1, sport2);
		session.persist(choix3);
		session.save(choix3);
		Choix choix31 = new Choix(User1, sport5);
		session.persist(choix31);
		session.save(choix31);
		
		Choix choix4 = new Choix(User2, sport4);
		session.persist(choix4);
		session.save(choix4);
		Choix choix41 = new Choix(User2, sport6);
		session.persist(choix41);
		session.save(choix41);
		
		Choix choix5 = new Choix(User3, sport4);
		session.persist(choix5);
		session.save(choix5);
		Choix choix51 = new Choix(User3, sport3);
		session.persist(choix51);
		session.save(choix51);
		
		Choix choix6 = new Choix(User5, sport4);
		session.persist(choix6);
		session.save(choix6);
		Choix choix61 = new Choix(User5, sport3);
		session.persist(choix61);
		session.save(choix61);
		
		Choix choix7 = new Choix(user, sport4);
		session.persist(choix7);
		session.save(choix7);
		Choix choix71 = new Choix(user, sport3);
		session.persist(choix71);
		session.save(choix71);
		
		
		String nomSport = "Equitation";
		Query query = (Query) session.createQuery("FROM Sport WHERE nomSport = :nomSport");
		query.setParameter("nomSport", nomSport);
		Sport sport = (Sport) query.uniqueResult();
		
		Equitation eq = new Equitation(20, 3.5, 1, sport5);
		session.persist(eq);
		Equitation eq1 = new Equitation(10, 3, 2,sport5);
		session.persist(eq1);
		Equitation eq2 = new Equitation(30, 2, 5,sport5);
		session.persist(eq2);
		
		String nomSport1 = "Jogging";
		Query query1 = (Query) session.createQuery("FROM Sport WHERE nomSport = :nomSport");
		query1.setParameter("nomSport", nomSport);
		Sport sport11 = (Sport) query1.uniqueResult();
		Jogging eq3 = new Jogging(30, 50, 5,20,sport4);
		session.persist(eq3);
		Jogging eq31 = new Jogging(10, 0, 0,10,sport4);
		session.persist(eq31);
		Jogging eq32 = new Jogging(30, 50, 5,20,sport4);
		session.persist(eq32);
		
		String nomSport2 = "Kayak";
		Query query2 = (Query) session.createQuery("FROM Sport WHERE nomSport = :nomSport");
		query2.setParameter("nomSport", nomSport);
		Sport sport21 = (Sport) query2.uniqueResult();
		Kayak eq5 = new Kayak(30, 50, 5,20,sport6);
		session.persist(eq5);
		Kayak eq51 = new Kayak(10, 0, 0,10,sport6);
		session.persist(eq51);
		Kayak eq52 = new Kayak(30, 50, 5,20,sport6);
		session.persist(eq52);
		
		String nomSport3 = "Musculation";
		Query query3 = (Query) session.createQuery("FROM Sport WHERE nomSport = :nomSport");
		query3.setParameter("nomSport", nomSport);
		Sport sport31 = (Sport) query3.uniqueResult();
		Musculation eq4 = new Musculation(30, 5, 5,sport3);
		session.persist(eq4);
		Musculation eq41 = new Musculation(10, 0, 0,sport3);
		session.persist(eq41);
		Musculation eq42 = new Musculation(30, 5, 5,sport3);
		session.persist(eq42);
		
		String nomSport4 = "Tir_a_larc";
		Query query4 = (Query) session.createQuery("FROM Sport WHERE nomSport = :nomSport");
		query4.setParameter("nomSport", nomSport);
		Sport sport41 = (Sport) query4.uniqueResult();
		Tir_a_larc eq6 = new Tir_a_larc(30, 50, 5,20,sport2);
		session.persist(eq6);
		Tir_a_larc eq61 = new Tir_a_larc(20, 5, 20,3,sport2);
		session.persist(eq61);
		Tir_a_larc eq62 = new Tir_a_larc(30, 50, 0,20,sport2);
		session.persist(eq62);
		
		String nomSport5 = "Yoga";
		Query query5 = (Query) session.createQuery("FROM Sport WHERE nomSport = :nomSport");
		query5.setParameter("nomSport", nomSport);
		Sport sport51 = (Sport) query5.uniqueResult();
		Yoga eq7 = new Yoga(30, 50, 5,sport1);
		session.persist(eq7);
		Yoga eq71 = new Yoga(10, 10, 20,sport1);
		session.persist(eq71);
		Yoga eq72 = new Yoga(0, 15, 0,sport1);
		session.persist(eq72);
		
		ActiviteEquitation actEq = new ActiviteEquitation(User4, eq);
		session.persist(actEq);
		ActiviteEquitation actEq1 = new ActiviteEquitation(User4, eq1);
		session.persist(actEq1);
		ActiviteEquitation actEq2 = new ActiviteEquitation(User4, eq2);
		session.persist(actEq2);
		
		ActiviteJogging actJog = new ActiviteJogging(User4, eq3);
		session.persist(actJog);
		ActiviteJogging actJog1 = new ActiviteJogging(User4, eq31);
		session.persist(actJog1);
		ActiviteJogging actJog2 = new ActiviteJogging(User4, eq32);
		session.persist(actJog2);
		
		ActiviteMusculation actMus = new ActiviteMusculation(User4, eq4);
		session.persist(actMus);
		ActiviteMusculation actMus1 = new ActiviteMusculation(User4, eq41);
		session.persist(actMus1);
		ActiviteMusculation actMus2 = new ActiviteMusculation(User4, eq42);
		session.persist(actMus2);
		
		ActiviteKayak actEqKay = new ActiviteKayak(User4, eq5);
		session.persist(actEqKay);
		ActiviteKayak actEqKay1 = new ActiviteKayak(User4, eq51);
		session.persist(actEqKay1);
		ActiviteKayak actEqKay2 = new ActiviteKayak(User4, eq52);
		session.persist(actEqKay2);
		
		ActiviteTir_a_larc actTir = new ActiviteTir_a_larc(User4, eq6);
		session.persist(actTir);
		ActiviteTir_a_larc actTir1 = new ActiviteTir_a_larc(User4, eq61);
		session.persist(actTir1);
		ActiviteTir_a_larc actTir2 = new ActiviteTir_a_larc(User4, eq62);
		session.persist(actTir2);
		
		ActiviteYoga actYoga = new ActiviteYoga(User4, eq7);
		session.persist(actYoga);
		ActiviteYoga actYoga1 = new ActiviteYoga(User4, eq71);
		session.persist(actYoga1);
		ActiviteYoga actYoga2 = new ActiviteYoga(User4, eq72);
		session.persist(actYoga2);
		////////////////
		
		
		Transaction.commit();
		
 
		session.close();
	}
}
