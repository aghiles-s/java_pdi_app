package GrapheMusculationCompareAmis;

import java.awt.Color;
import java.util.List;
import javax.swing.JFrame;

import org.hibernate.Query;
import org.hibernate.Session;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import Activité.ActiviteEquitation;
import Activité.ActiviteMusculation;
import GrapheEquitaCompAmis.GrapheUtiAmis;
import GrapheJogging.CamembertFrequenceJogging;
import Projet.CompareAmis;
import Projet.DBConnection;
import Projet.Select;
import Sports.Musculation;
import Sports.User;


public class HistoRepetitionMusc extends JFrame{
	private static String pseudoUtilisateur;
	private static String FriendPseudonyme;
	//private static String pseudoUtilisateur;
	
	    public HistoRepetitionMusc(String pseudoUtilisateur,String FriendPseudonyme) {
	    	HistoRepetitionMusc.pseudoUtilisateur = pseudoUtilisateur;
	    	 
	    	HistoRepetitionMusc.FriendPseudonyme = FriendPseudonyme;
	    } 
	
    public static void main(String[] args) {
    	String pseudoUtilisateur = null;
		if (args != null && args.length > 0) {
	        pseudoUtilisateur = args[0];
	    }
		HistoRepetitionMusc demo = new HistoRepetitionMusc(pseudoUtilisateur,FriendPseudonyme);
		
		
        // Configuration de Hibernate
		Session session = DBConnection.getSession();
        Session session1= DBConnection.getSession();
        
        User user = (User) ( session.get(User.class,Select.findUser1(CompareAmis.FriendPseudonyme).getIdUser()));
        User user1 = (User) ( session.get(User.class,Select.findUser1(CompareAmis.user.getPseudo()).getIdUser()));
        
        	
        
        Query query1 = session.createQuery("FROM ActiviteMusculation WHERE user = :user").setMaxResults(3);
        query1.setParameter("user", user);
        List<ActiviteMusculation> sessions = query1.list();
      

        Query query2 = session.createQuery("FROM ActiviteMusculation WHERE user = :user1").setMaxResults(3);
        query2.setParameter("user1", user1);

        List<ActiviteMusculation> sessions1 = query2.list();
       
        
        // Créer le jeu de données pour l'histogramme
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for (int i = 0; i < sessions.size(); i++) {
            dataset.addValue(sessions.get(i).getMusculation().getRepetition(), user.getPseudo(), "Activité " + (i+1));
        }
        for (int i = 0; i < sessions1.size(); i++) {
            dataset.addValue(sessions1.get(i).getMusculation().getRepetition(), user1.getPseudo(), "Activité " + (i+1));
        }
        
        // Créer le graphique en histogrammes
        JFreeChart chart = ChartFactory.createBarChart(
                "Comparaison de Repetition de Musculation Histogram entre "+ user.getPseudo()+" et " +user1.getPseudo(),
                "Session",
                "Repetition",
                dataset,
                PlotOrientation.VERTICAL,
                true, // le graphique inclue une légende.
                true,// anti-crénelé pour améliorer la qualité de l'image.
                false // les outils de zoom.
        );
        
        // Personnaliser le graphique
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);

        // Définir les couleurs des séries de données
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, Color.RED); // user1 en rouge
        renderer.setSeriesPaint(1, Color.BLUE); // user2 en bleu

        // Afficher le graphique dans une fenêtre
        ChartPanel chartPanel = new ChartPanel(chart);
        JFrame frame = new JFrame("Histogramme des sessions d'équitation");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(chartPanel);
        frame.pack();
        frame.setVisible(true);
       }
       
   }
