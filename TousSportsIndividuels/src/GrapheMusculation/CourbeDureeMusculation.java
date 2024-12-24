package GrapheMusculation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import Activité.ActiviteMusculation;
import GrapheJogging.CourbeDureeJogging;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


import Projet.DBConnection;
import Projet.Select;
import Sports.Musculation;
import Sports.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;

public class CourbeDureeMusculation extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	
	
	
	private String pseudoUtilisateur;
	public static void main(String[] args) {
		String pseudoUtilisateur = null;
		if (args != null && args.length > 0) {
	        pseudoUtilisateur = args[0];
	    }
		CourbeDureeMusculation demo = new CourbeDureeMusculation();
		
				
		// Configuration de Hibernate
        Session session = DBConnection.getSession();
        User user = (User) session.get(User.class, Select.findUser1(pseudoUtilisateur).getIdUser());
        
        Query query = session.createQuery("FROM ActiviteMusculation WHERE user = :user");
        query.setParameter("user", user);
        // Recuperer la liste des resultats de la requete
        List<ActiviteMusculation> sessions = query.list();
        // Fermer la session Hibernate
        session.close();
        
		XYSeries series1 = new XYSeries("Durée");
		
		for (int i = 0; i < sessions.size(); i++) {
			series1.add(i+1, sessions.get(i).getMusculation().getDuree());
		}

		 // Ajouter les séries de données à la collection de données
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        // Créer le graphique en courbes
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Durée Musculation de  " +pseudoUtilisateur, // titre du graphique
                "Activité ", // nom de l'axe X
                "H" , // nom de l'axe Y
                dataset, // données pour le graphique
                PlotOrientation.VERTICAL, // orientation du graphique
                true, // inclure une légende
                true, // utiliser des tooltips
                false // ne pas utiliser de URLs
        );
        
        // Personnaliser le graphique
        XYPlot plot = chart.getXYPlot();
        
        // Couleur des séries de données
        plot.getRenderer().setSeriesPaint(0, Color.RED); // Durée
        
        
        
        // Créer le panneau de graphique et l'ajouter à la fenêtre
        ChartPanel chartPanel = new ChartPanel(chart);
        JFrame frame = new JFrame(pseudoUtilisateur);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(chartPanel);
        frame.pack();
        frame.setVisible(true);

	
		
		
	}

}