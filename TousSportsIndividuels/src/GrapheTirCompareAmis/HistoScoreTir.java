package GrapheTirCompareAmis;

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
import Activité.ActiviteTir_a_larc;
import GrapheEquitaCompAmis.CamembertEqui;
import GrapheEquitaCompAmis.GrapheUtiAmis;
import GrapheEquitation.EquitationGraph;
import Projet.CompareAmis;
import Projet.DBConnection;
import Projet.Select;
import Sports.Tir_a_larc;
import Sports.User;

public class HistoScoreTir extends JFrame{
	
	private static String pseudoUtilisateur;
	private static String FriendPseudonyme;
	
	public HistoScoreTir(String pseudoUtilisateur,String FriendPseudonyme) {
		HistoScoreTir.FriendPseudonyme = FriendPseudonyme;
		HistoScoreTir.pseudoUtilisateur = pseudoUtilisateur;
    	
        
    }  
    public static void main(String[] args) {
    	String pseudoUtilisateur = null;
		if (args != null && args.length > 0) { 
	        pseudoUtilisateur = args[0]; 
	    }
		HistoScoreTir demo = new HistoScoreTir( pseudoUtilisateur, FriendPseudonyme);
        // Configuration de Hibernate
		  // Configuration de Hibernate
		 Session session = DBConnection.getSession();
	        Session session1= DBConnection.getSession();
	        
	        User user = (User) ( session.get(User.class,Select.findUser1(CompareAmis.FriendPseudonyme).getIdUser()));
	        User user1 = (User) ( session.get(User.class,Select.findUser1(CompareAmis.user.getPseudo()).getIdUser()));
	        	
       
       //User user1 = (User) session.get(User.class, 2);
       // User user =(User) session.get(User.class,4 );
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

     // Extraire les sessions d'équitation de user1
        Query query1 = session.createQuery("FROM ActiviteTir_a_larc WHERE user = :user").setMaxResults(3);
        query1.setParameter("user", user);
        List<ActiviteTir_a_larc> sessions = query1.list();
        for (int i = 0; i < sessions.size(); i++) {
            dataset.addValue(sessions.get(i).getTir_a_larc().getScore(), user.getPseudo(), "Activité " + (i+1));
        }
        
        // Extraire les sessions d'équitation de user2
        Query query2 = session.createQuery("FROM ActiviteTir_a_larc WHERE user = :user1").setMaxResults(3);
        query2.setParameter("user1", user1);

        List<ActiviteTir_a_larc> sessions1 = query2.list();
        for (int i = 0; i < sessions1.size(); i++) {
            dataset.addValue(sessions1.get(i).getTir_a_larc().getScore(), user1.getPseudo(), "Activité " + (i+1));
        }
        
     // Créer le graphique en histogrammes
        JFreeChart chart = ChartFactory.createBarChart(
                "Comparaison de Score de Tir a l'arc en histogramme entre  "+ user.getPseudo()+" et " +user1.getPseudo() , // titre
                "Activité",// axe des abscisses
                "Score",
                dataset, // données
                PlotOrientation.VERTICAL, // orientation du graphique
                true, // afficher la légende
                true, // anti-crénelage
                false // pas de zoom
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
        JFrame frame = new JFrame("Histogramme des sessions de Tir a l'arc");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(chartPanel);
        frame.pack();
        frame.setVisible(true);
       }
       
   }
