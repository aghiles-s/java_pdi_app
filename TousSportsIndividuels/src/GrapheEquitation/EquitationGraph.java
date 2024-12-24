package GrapheEquitation;

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
import Projet.DBConnection;
import Projet.Select;
import Sports.User;


public class EquitationGraph  extends JFrame{
	 private String pseudoUtilisateur;
	 
	    public EquitationGraph(String pseudoUtilisateur) {
			this.pseudoUtilisateur = pseudoUtilisateur;
	    } 
    public static void main(String[] args) {
    	
    	String pseudoUtilisateur = null;
		if (args != null && args.length > 0) {
	        pseudoUtilisateur = args[0];
	    }
		EquitationGraph demo = new EquitationGraph(pseudoUtilisateur);
		 
        // Configuration de Hibernate
        Session session = DBConnection.getSession();
        User user = (User) session.get(User.class, Select.findUser1(pseudoUtilisateur).getIdUser());
        //User user = (User) session.get(User.class, 2);
	     
        Query query = session.createQuery("FROM ActiviteEquitation WHERE user = :user");
        query.setParameter("user", user);
        // Extraire les données de la base de données
        List<ActiviteEquitation> sessions = query.list();
        // Fermer la session Hibernate
        session.close(); 
        
        // Créer le jeu de données pour l'histogramme
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for (int i = 0; i < sessions.size(); i++) {
            dataset.addValue(sessions.get(i).getEquitation().getVitesse(), "Vitesse", "Résultat " + (i+1));
        }
        
        // Créer le graphique en histogrammes
        JFreeChart chart = ChartFactory.createBarChart(
                "Vitesse Equitation Histogram de  "   +pseudoUtilisateur,
                "Session",
                "m/min",
                dataset,
                PlotOrientation.VERTICAL,
                true, // le graphique inclue une légende.
                true,// anti-crénelé pour améliorer la qualité de l'image.
                false // les outils de zoom.
        );
        
        // Personnaliser le graphique
        CategoryPlot plot = chart.getCategoryPlot();
       
        plot.setRangeGridlinePaint(Color.BLACK);
        
        CategoryAxis domainAxis = plot.getDomainAxis();
        /*domainAxis.setCategoryMargin(0.2);
        domainAxis.setUpperMargin(0.05);
        */
        domainAxis.setLowerMargin(0.05);
        
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        renderer.setMaximumBarWidth(0.1);
        renderer.setSeriesPaint(2, Color.GREEN);
        
        // Créer le panneau de graphique et l'ajouter à la fenêtre
        ChartPanel chartPanel = new ChartPanel(chart);
        JFrame frame = new JFrame(pseudoUtilisateur);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }
   
}
