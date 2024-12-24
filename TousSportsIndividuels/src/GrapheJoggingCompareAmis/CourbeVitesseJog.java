package GrapheJoggingCompareAmis;

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
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import Activité.ActiviteEquitation;
import Activité.ActiviteJogging;
import Projet.CompareAmis;
import Projet.DBConnection;
import Projet.Select;
import Sports.Jogging;
import Sports.User;


public class CourbeVitesseJog extends JFrame {

	private static final long serialVersionUID = 1L;
	private String pseudoUtilisateur;
	public static void main(String[] args) {
		String pseudoUtilisateur = null;
		if (args != null && args.length > 0) {
	        pseudoUtilisateur = args[0];
	    }
		CourbeVitesseJog demo = new CourbeVitesseJog();
		
		// Configuration de Hibernate
		 Session session = DBConnection.getSession();
		 User user1 = (User) session.get(User.class, Select.findUser1(CompareAmis.user.getPseudo()).getIdUser());
	        Query query1 = session.createQuery("FROM ActiviteJogging WHERE user = :user1");
	        query1.setParameter("user1", user1);
	        List<ActiviteJogging> sessions1 = query1.list();


        // Extraire les sessions d'équitation de user2
        User user2 = (User) session.get(User.class, Select.findUser1(CompareAmis.FriendPseudonyme).getIdUser());
        Query query2 = session.createQuery("FROM ActiviteJogging WHERE user = :user2");
        query2.setParameter("user2", user2);
        List<ActiviteJogging> sessions2 = query2.list();

        
        // Créer la série de données pour user1
        XYSeries series1 = new XYSeries(CompareAmis.user.getPseudo());
        for (int i = 0; i < sessions1.size(); i++) {
            series1.add(i + 1, sessions1.get(i).getJogging().getVitesse());
        }

        // Créer la série de données pour user2
        XYSeries series2 = new XYSeries(CompareAmis.FriendPseudonyme);
        for (int i = 0; i < sessions2.size(); i++) {
            series2.add(i + 1, sessions2.get(i).getJogging().getVitesse());
        }
		  // Ajouter les séries de données à la collection de données
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        // Créer le graphique en courbes
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Comparaison de Vitesse de Jogging entre " +CompareAmis.user.getPseudo()+ " et " +CompareAmis.FriendPseudonyme, // titre du graphique
                "Activité ", // nom de l'axe X
                "m/min" , // nom de l'axe Y
                dataset, // données pour le graphique
                PlotOrientation.VERTICAL, // orientation du graphique
                true, // inclure une légende
                true, // utiliser des tooltips
                false // ne pas utiliser de URLs
        );
        
     // Personnaliser le graphique
        XYPlot plot = chart.getXYPlot();

        // Couleur des séries de données
        plot.getRenderer().setSeriesPaint(0, Color.RED); // User1
        plot.getRenderer().setSeriesPaint(1, Color.BLUE); // User2
    
    
    
    // Créer le panneau de graphique et l'ajouter à la fenêtre
    ChartPanel chartPanel = new ChartPanel(chart);
    JFrame frame = new JFrame(pseudoUtilisateur);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.add(chartPanel);
    frame.pack();
    frame.setVisible(true);
}



}
