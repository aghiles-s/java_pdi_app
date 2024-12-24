package Projet;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

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

import org.hibernate.Session;

public class DBConnection {
	
	private static SessionFactory sessionFactory;
	private static AnnotationConfiguration config;

	public static AnnotationConfiguration getConfig() {
		if (config == null) {
			config = new AnnotationConfiguration();
			config.addAnnotatedClass(User.class);
			config.addAnnotatedClass(Amis.class);  
			config.addAnnotatedClass(Kayak.class);
			config.addAnnotatedClass(Tir_a_larc.class);
			config.addAnnotatedClass(Equitation.class); 
			config.addAnnotatedClass(Yoga.class);
			config.addAnnotatedClass(Musculation.class);
			config.addAnnotatedClass(Jogging.class);
			config.addAnnotatedClass(ActiviteYoga.class);
			config.addAnnotatedClass(ActiviteEquitation.class);
			config.addAnnotatedClass(ActiviteMusculation.class);
			config.addAnnotatedClass(ActiviteJogging.class);
			config.addAnnotatedClass(ActiviteTir_a_larc.class);
			config.addAnnotatedClass(ActiviteKayak.class);
			config.addAnnotatedClass(Sport.class);
			config.addAnnotatedClass(Choix.class);
			String packageName = DBConnection.class.getPackage().getName();
			config.configure(packageName + "/connection.cfg.xml");
		}
		return config;
	} 

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				AnnotationConfiguration config = getConfig();
				sessionFactory = config.buildSessionFactory();
			} catch (Throwable ex) {
				System.err.println("Initial SessionFactory creation failed." + ex);
				throw new ExceptionInInitializerError(ex);
			}
		}
		return sessionFactory;
	}

	public static Session getSession() {
		return getSessionFactory().openSession();
	}

	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

}
