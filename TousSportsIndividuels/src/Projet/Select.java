package Projet;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Sports.Amis;
import Sports.Sport;
import Sports.User;





public class Select {

	public static void main(String[] args) {
	 
	}
	 public static User findUser1(String Pseudo) {
	        User user = null;
	        Session session = DBConnection.getSession();
			Transaction Transaction = session.beginTransaction();
	            user = (User) session
	                    .createQuery("FROM User WHERE Pseudo = :Pseudo ")
	                    .setParameter("Pseudo", Pseudo)
	                    .uniqueResult();
	            session.getTransaction().commit();
	       
	        return user;
	 }
	 public static User findUser2(String IdUser) {
	        User user = null;
	        Session session = DBConnection.getSession();
			Transaction Transaction = session.beginTransaction();
	            user = (User) session
	                    .createQuery("FROM User WHERE IdUser = :IdUser ")
	                    .setParameter("IdUser", IdUser)
	                    .uniqueResult();
	            session.getTransaction().commit();
	       
	        return user; 
	 }
	 

	 public static User findUser(String Pseudo, String Mdps) {
	        User user = null;
	        Session session = DBConnection.getSession();
			Transaction Transaction = session.beginTransaction();
	            user = (User) session
	                    .createQuery("FROM User WHERE Pseudo = :Pseudo AND Mdps = :Mdps")
	                    .setParameter("Pseudo", Pseudo)
	                    .setParameter("Mdps", Mdps)
	                    .uniqueResult();
	            session.getTransaction().commit();
	       
	        return user;
	 }
	 public static User findUser_withId(Integer idUser) {
	        User user = null;
	        Session session = DBConnection.getSession();
			Transaction Transaction = session.beginTransaction();
	            user = (User) session
	                    .createQuery("FROM User WHERE IdUser= :idUser")
	                    .setParameter("idUser", idUser)
	                    .uniqueResult();
	            session.getTransaction().commit();
	       
	        return user;
	    }
	 private static void testWhereClause(Session session, int id) {
			Transaction readTransaction = session.beginTransaction();
			Query readQuery = session.createQuery("from User p where p.id=:id");
			readQuery.setInteger("id", id);
			List result = readQuery.list();
			Iterator iterator = result.iterator();
			while (iterator.hasNext()) {
				User user = (User) iterator.next();
//				String sp1 = user.getSport1();
//				String sp2 = user.getSport2();
//				String sp3 = user.getSport3();
//				String sp4 = user.getSport4();
				//System.out.println("["+sp1+ "]" + sp2 + "[" + sp3 + "]"+ sp4);
			}
			readTransaction.commit();
		}
	 public static User findRandomUser(String Pseudo) {
			User user = null;
			Session session = DBConnection.getSession();
			Transaction Transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<User> users = session.createQuery("FROM User WHERE Pseudo != :Pseudo")
						.setParameter("Pseudo", Pseudo).list();
			if (!users.isEmpty()) {
				int randomIndex = new Random().nextInt(users.size());
				user = users.get(randomIndex);
			}
			Transaction.commit(); 
			session.close(); 

			return user;
		}
	 
	 public static List<User> ResearchUser(String nomContenant) {
		    List<User> users2 = new ArrayList<>();
		    Session session = DBConnection.getSession();
		    Transaction transaction = session.beginTransaction();
		    @SuppressWarnings("unchecked")
		    List<User> result = session.createQuery("FROM User WHERE Pseudo LIKE :nomContenant")
		                        .setParameter("nomContenant",nomContenant + "%")
		                        .list();
		    if (!result.isEmpty()) {
		        users2 = result;
		    }
		    transaction.commit();
		    session.close();
		    return users2;
		}
	
	 public static List<Integer> find_idFriends(int idUser) {
		 List<Integer> idFriends = new ArrayList<>();
		 Session session = DBConnection.getSession();
		 Transaction transaction = session.beginTransaction();
		 @SuppressWarnings("unchecked")
		List<Integer> result = session.createQuery("Select idAmi FROM Amis WHERE idUtilisateur = :idUser")
	             .setParameter("idUser", idUser)
	             .list();
		 if (!result.isEmpty()) {
		        idFriends = result;
		 }
		 transaction.commit();
		 session.close();
		 return idFriends; 
		 }
	 
	 public static void addFriend(User user, User Friend) {
			Session session = DBConnection.getSession();
			session.beginTransaction();
			 Amis amiRelation = new Amis (user,Friend);
			 session.persist(amiRelation);
		 }
	 
	 public static void deleteFriend(User user, User Friend) {
		 Session session = DBConnection.getSession();
		 Transaction Transaction = session.beginTransaction();
		 session.createQuery("Delete from Amis WHERE idUtilisateur = :idUser and idAmi = :idFriend")
		 		.setParameter("idUser", user.getIdUser())
		 		.setParameter("idFriend",Friend.getIdUser());
		 session.persist(Transaction);
         Transaction.commit();
	 }
	 public static void deleteChoix(User user) {
		 Session session = DBConnection.getSession();
		 Transaction Transaction = session.beginTransaction();
		 session.createQuery("Delete from Choix WHERE idUtilisateur = :idUser")
		 		.setParameter("idUser", user.getIdUser());
		 session.persist(Transaction);
         Transaction.commit();
	 }
	 
	 
	 public static void deleteAmisByUserAndAmi(User utilisateur, User ami) {
		 Session session = DBConnection.getSession();
		 Transaction Transaction = session.beginTransaction();
	     String hql = "delete from Amis where utilisateur = :utilisateur and ami = :ami";
	     Query query = session.createQuery(hql);
	     query.setParameter("utilisateur", utilisateur);
	     query.setParameter("ami", ami);
	     int deletedRows = query.executeUpdate();

	     Transaction.commit();
	     System.out.println(deletedRows + " lignes ont été supprimées !");
	}
	 
	 public static boolean amiExistePourUtilisateur(User utilisateur, User ami) {
			Session session = DBConnection.getSession();
			Transaction Transaction = session.beginTransaction();
			Query query = session.createQuery("FROM Amis WHERE utilisateur = :utilisateur AND ami = :ami");
		    query.setParameter("utilisateur", utilisateur);
		    query.setParameter("ami", ami);
		    Amis amis = (Amis) query.uniqueResult();
	        Transaction.commit();;
		    if (amis == null) {
		    		 return false;
		    } else {
		    	return true;
		    	}
		}
	 
	 
	
	 @SuppressWarnings("null")
	public static User updateUser(String nom, String prenom, String pseudo, int age, double taille, double poids, String sexe,String email, String tel, String mdps) {
		 	Session session = DBConnection.getSession();
			Transaction Transaction = null;
			User user = null;
			
			Transaction = session.beginTransaction();
			
			user.setPseudo(pseudo);
			user.setNomUser(nom);
			user.setPrenomUser(prenom);
			user.setEmail(email);
			user.setTel(tel);
			user.setAge(age);
			user.setSexe(sexe);
			user.setTaille(taille);
			user.setPoids(poids);
			user.setMdps(mdps);
			session.update(user);
         Transaction.commit();
         
	        if (Transaction != null) {
	                Transaction.rollback(); // Annuler les modifications en cas d'erreur
	            }
			session.close();  
			return user;
	    }
	
	 
	
	
	
}

