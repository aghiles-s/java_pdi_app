package GrapheKayakCompareAmis;

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
import Activité.ActiviteKayak;
import GrapheEquitaCompAmis.CamembertEqui;
import GrapheJogging.CamembertFrequenceJogging;
import Sports.Kayak;
import Sports.User;
import Projet.CompareAmis;
import Projet.DBConnection;
import Projet.Select;

public class CamembertDistanceKayak extends JFrame {

	//private static final long serialVersionUID = 1L;
	private static String FriendPseudonyme;
	 private String pseudoUtilisateur;
   private JPanel contentPane;
   
   public CamembertDistanceKayak(String pseudoUtilisateur,String FriendPseudonyme) {
        
   	//CamembertEqui.pseudoUtilisateur = pseudoUtilisateur;
   	
	   CamembertDistanceKayak.FriendPseudonyme = FriendPseudonyme;
        
   }

	public static void main(String[] args) {
		String pseudoUtilisateur = null;
		if (args != null && args.length > 0) {
	        pseudoUtilisateur = args[0];
	    }
		CamembertDistanceKayak demo = new CamembertDistanceKayak(pseudoUtilisateur,FriendPseudonyme);

		// Création du dataset et du chart
        DefaultPieDataset dataset = new DefaultPieDataset();
        
		
		// Configuration de Hibernate
        Session session = DBConnection.getSession();
        Session session1= DBConnection.getSession();
        
        User user = (User) ( session.get(User.class,Select.findUser1(CompareAmis.FriendPseudonyme).getIdUser()));
        User user1 = (User) ( session.get(User.class,Select.findUser1(CompareAmis.user.getPseudo()).getIdUser()));
        
        Query query = session.createQuery("FROM ActiviteKayak WHERE user = :user");
        query.setParameter("user", user);
        List<ActiviteKayak> sessions = query.list();
        
        // Ajout des données au dataset
        for (int i = 0; i < sessions.size(); i++) {
            dataset.setValue(user.getPseudo() + " - Distance" + (i + 1), sessions.get(i).getKayak().getDistance());
        }
        
		 Query query2 = session.createQuery("FROM ActiviteKayak WHERE user = :user1").setMaxResults(3);
	        query2.setParameter("user1", user1);

	        List<ActiviteKayak> sessions1 = query2.list();
	        for (int i = 0; i < sessions1.size(); i++) {
	            dataset.setValue(user1.getPseudo() + " - Distance" + (i + 1),sessions1.get(i).getKayak().getDistance());
	        }
		JFreeChart chart = ChartFactory.createPieChart("Comparaison de Distance de Kayak en Camembert de "   +user.getPseudo()+ " et " +user1.getPseudo(), dataset, true, true, false);
	       
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
