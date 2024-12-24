package GrapheAmis;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.hibernate.Query;
import org.hibernate.Session;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import Activité.ActiviteKayak;
import GrapheEquitation.CourbeGraph;
import Projet.DBConnection;
import Projet.Select;
import Sports.User;

public class GrapheKayakCourbe extends JFrame {
    
	private static String FriendPseudonyme;

	 public GrapheKayakCourbe(String FriendPseudonyme) {
			this.FriendPseudonyme = FriendPseudonyme;
	    } 
    public static void main(String[] args) {
    	
    	String FriendPseudonyme = null;
		if (args != null && args.length > 0) {
			FriendPseudonyme = args[0];
	    }
		GrapheKayakCourbe demo = new GrapheKayakCourbe(FriendPseudonyme);
		
		
    	Session session = DBConnection.getSession();
        //User user = (User) session.get(User.class, 2);
    	User user = (User) session.get(User.class, Select.findUser1(FriendPseudonyme).getIdUser());
        
        // Récupération de toutes les activités de kayaka
        Query query = session.createQuery("FROM ActiviteKayak WHERE user = :user").setMaxResults(3);
        query.setParameter("user", user);
        List<ActiviteKayak> sessions = query.list();

        // Création des données pour le graphique
     // Création des données pour le graphique
        XYSeries seriesDuree = new XYSeries("Durée");
        XYSeries seriesDistance = new XYSeries("Distance");
        XYSeries seriesVitesse = new XYSeries("Vitesse");
        XYSeries seriesPoids = new XYSeries("Poids");
        for (int i = 0; i < sessions.size(); i++) {    
            seriesDuree.add(i+1, sessions.get(i).getKayak().getDuree());
            seriesDistance.add(i+1, sessions.get(i).getKayak().getDistance());
            seriesVitesse.add(i+1, sessions.get(i).getKayak().getVitesse());
            seriesPoids.add(i+1, sessions.get(i).getKayak().getPoidBat());
        }

        // Ajout des séries au dataset
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(seriesDuree);
        dataset.addSeries(seriesDistance);
        dataset.addSeries(seriesVitesse);
        dataset.addSeries(seriesPoids);

        // Création du graphique
        JFreeChart chart = ChartFactory.createXYLineChart(
            "Activité Kayak de  " +FriendPseudonyme, 
            "Numéro de l'Activité", 
            "Valeur", 
            dataset, 
            PlotOrientation.VERTICAL, 
            true, 
            true, 
            false
        );

        // Configuration des couleurs et des formes des courbes
        XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.BLACK);
        plot.setDomainGridlinePaint(Color.BLACK);

        LineAndShapeRenderer renderer = new LineAndShapeRenderer(true, false);
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesPaint(2, Color.GREEN);
        renderer.setSeriesPaint(3, Color.ORANGE);

        //plot.setRenderer(renderer);

        // Configuration de l'axe des ordonnées
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setAutoRange(true);
        rangeAxis.setAutoRangeIncludesZero(false);

        // Affichage du graphique
        ChartPanel chartPanel = new ChartPanel(chart);
        JFrame frame = new JFrame(FriendPseudonyme);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(chartPanel);
        frame.pack();
        frame.setVisible(true);


        // Fermer la session Hibernate
        
    }
}