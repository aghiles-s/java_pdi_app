package GrapheYogaCompAmis;

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

import Activité.ActiviteEquitation;
import Activité.ActiviteYoga;
import GrapheEquitaCompAmis.CamembertEqui;
import GrapheJogging.CamembertFrequenceJogging;
import Sports.User;
import Sports.Yoga;
import Projet.CompareAmis;
import Projet.DBConnection;
import Projet.Select;

public class CamembertRepetitionYoga extends JFrame {

	private static final long serialVersionUID = 1L;
	private String pseudoUtilisateur;
	private static String FriendPseudonyme;
	
	public CamembertRepetitionYoga(String pseudoUtilisateur,String FriendPseudonyme) {
		CamembertRepetitionYoga.FriendPseudonyme = FriendPseudonyme;
	}

	public static void main(String[] args) {
		String pseudoUtilisateur = null;
		if (args != null && args.length > 0) {
	        pseudoUtilisateur = args[0];
	    }
		CamembertRepetitionYoga demo = new CamembertRepetitionYoga(pseudoUtilisateur,FriendPseudonyme);
		
		DefaultPieDataset dataset = new DefaultPieDataset();
        
		
		// Configuration de Hibernate
        Session session = DBConnection.getSession();
        Session session1= DBConnection.getSession();
        
        User user = (User) ( session.get(User.class,Select.findUser1(CompareAmis.FriendPseudonyme).getIdUser()));
        User user1 = (User) ( session.get(User.class,Select.findUser1(CompareAmis.user.getPseudo()).getIdUser()));
        
        Query query = session.createQuery("FROM ActiviteYoga WHERE user = :user");
        query.setParameter("user", user);
        // Recuperer la liste des resultats de la requete
        List<ActiviteYoga> sessions = query.list();
        

        for (int i = 0; i < sessions.size(); i++) {
            dataset.setValue(user.getPseudo() + " - Repetition" + (i + 1), sessions.get(i).getYoga().getRepetition());
        }
		
		 Query query2 = session.createQuery("FROM ActiviteYoga WHERE user = :user1").setMaxResults(3);
	        query2.setParameter("user1", user1);

        List<ActiviteYoga> sessions1 = query2.list();
        for (int i = 0; i < sessions1.size(); i++) {
            dataset.setValue(user1.getPseudo() + " - Repetition" + (i + 1),sessions1.get(i).getYoga().getRepetition());
        }
        JFreeChart chart = ChartFactory.createPieChart(" Comparaison de Répétition du Yoga en Camembert de  "   +user.getPseudo()+ " et " +user1.getPseudo(), dataset, true, true, false);
        
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
        frame.setResizable(false);	
	
	}
	 public void setVisible(boolean visible) { // ajout de cette méthode pour être appelée depuis la fenêtre principale
	        super.setVisible(visible);
	    }
	
}