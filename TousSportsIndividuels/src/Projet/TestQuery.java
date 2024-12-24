package Projet;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Sports.User;
public class TestQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = DBConnection.getSession();
		//testUpdate(session, "met", "dass");
		testWhereClause(session, 1);
		session.close(); 
			
	}
	
	private static void testUpdate(Session session, String newFirstName, String lastname) {
		Transaction updateTransaction = session.beginTransaction();
		Query updateQuery = session.createQuery("update User p set p.nom = :nom where p.prenom=:prenom");
		updateQuery.setString("nom", newFirstName);
		updateQuery.setString("prenom", lastname);
		updateQuery.executeUpdate();
		updateTransaction.commit();
	
		
	}
	
	private static void testWhereClause(Session session, int id) {
		Transaction readTransaction = session.beginTransaction();
		Query readQuery = session.createQuery("from User p where p.id=:id");
		readQuery.setInteger("id", id);
		List result = readQuery.list();
		Iterator iterator = result.iterator();
		while (iterator.hasNext()) {
			User user = (User) iterator.next();
//			String sp1 = user.getSport1();
//			String sp2 = user.getSport2();
//			String sp3 = user.getSport3();
//			String sp4 = user.getSport4();
			//System.out.println("["+sp1+ "]" + sp2 + "[" + sp3 + "]"+ sp4);
		}
		readTransaction.commit();
	}


}
