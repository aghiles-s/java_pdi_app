package GrapheKayak;

import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import Activité.ActiviteKayak;
import GrapheJogging.CamembertFrequenceJogging;
import Sports.Kayak;
import Sports.User;
import Projet.DBConnection;
import Projet.Select;

public class CamembertDistanceKayak extends JFrame {

	//private static final long serialVersionUID = 1L;
	 

	public static void main(String[] args) {
		String pseudoUtilisateur = null;
		if (args != null && args.length > 0) {
	        pseudoUtilisateur = args[0];
	    }
		CamembertDistanceKayak demo = new CamembertDistanceKayak(pseudoUtilisateur, pseudoUtilisateur);
		
		// Création du dataset et du chart
        DefaultPieDataset dataset = new DefaultPieDataset();
        JFreeChart chart = ChartFactory.createPieChart("Distance Kayak en Camembert de  " +pseudoUtilisateur, dataset, true, true, false);
       
		
		// Configuration de Hibernate
        Session session = DBConnection.getSession();
        // Extraire les données de la base de données
        // Recuperer la classe User de l'utilisateur connecte
        //User user = (User) session.get(User.class, 1);
        User user = (User) session.get(User.class, Select.findUser1(pseudoUtilisateur).getIdUser());
      //User user = (User) session.get(User.class, 2);
        
        Query query = session.createQuery("FROM ActiviteKayak WHERE user = :user");
        query.setParameter("user", user);
        // Recuperer la liste des resultats de la requete
        List<ActiviteKayak> sessions = query.list();
        // Fermer la session Hibernate
        session.close();
        
        // Ajout des données au dataset
		for (int i = 0; i < sessions.size(); i++) {
			dataset.setValue("Distance"+(i+1), sessions.get(i).getKayak().getDistance());
		}
		

		// Personnalisation du graphique
	    chart.setBackgroundPaint(Color.white);
	    chart.getTitle().setPaint(Color.black);
	
	    // Création du panel pour afficher le graphique
	    ChartPanel chartPanel = new ChartPanel(chart);
	    demo.setContentPane(chartPanel);
	    
	    JFrame frame = new JFrame(pseudoUtilisateur);
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.add(chartPanel);
	    frame.pack();
	    frame.setVisible(true);
	}
	private String pseudoUtilisateur;
	public CamembertDistanceKayak(String title,String pseudoUtilisateur) {
		super(pseudoUtilisateur);
		this.pseudoUtilisateur = pseudoUtilisateur;
	}
}
