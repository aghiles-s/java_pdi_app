package GrapheKayak;

import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;

import org.hibernate.Query;
import org.hibernate.Session;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import Activité.ActiviteKayak;
import Projet.DBConnection;
import Projet.Select;
import Sports.User;

public class CourbeVitesseKayak extends JFrame {

	private static final long serialVersionUID = 1L;
	private String pseudoUtilisateur;
	public static void main(String[] args) {
		String pseudoUtilisateur = null;
		if (args != null && args.length > 0) {
	        pseudoUtilisateur = args[0];
	    }
		CourbeVitesseKayak demo = new CourbeVitesseKayak();
		// Configuration de Hibernate
        Session session = DBConnection.getSession();
        // Extraire les données de la base de données
        // Recuperer la classe User de l'utilisateur connecte
        //User user = (User) session.get(User.class, 1);
        User user = (User) session.get(User.class, Select.findUser1(pseudoUtilisateur).getIdUser());
        
        Query query = session.createQuery("FROM ActiviteKayak WHERE user = :user");
        query.setParameter("user", user);
        // Recuperer la liste des resultats de la requete
        List<ActiviteKayak> sessions = query.list();
        // Fermer la session Hibernate
        session.close();
        
		XYSeries series1 = new XYSeries("Vitesse");
		for (int i = 0; i < sessions.size(); i++) {
			series1.add(i+1, sessions.get(i).getKayak().getVitesse());
		}

		// Ajouter les séries de données à la collection de données
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        // Créer le graphique en courbes
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Vitesse Kayak de  "   +pseudoUtilisateur, // titre du graphique
                "Activité ", // nom de l'axe X
                "Km/h" , // nom de l'axe Y
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
