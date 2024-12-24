package GrapheEquitaCompAmis;

import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
import org.jfree.ui.RefineryUtilities;

import Activité.ActiviteEquitation;
import Projet.CompareAmis;
import Projet.DBConnection;
import Projet.Select;
import Sports.User;



public class CourbeEqui extends JFrame {
 
	private static final long serialVersionUID = 1L;
	private String pseudoUtilisateur;
	private JPanel contentPane;
	
	public static void main(String[] args) {
		String pseudoUtilisateur = null;
		if (args != null && args.length > 0) {
	        pseudoUtilisateur = args[0];
	    }
		CourbeEqui demo = new CourbeEqui();
		 
	 
		// Configuration de Hibernate
		
	      
		 Session session = DBConnection.getSession();
		 User user1 = (User) session.get(User.class, Select.findUser1(CompareAmis.user.getPseudo()).getIdUser());
	        Query query1 = session.createQuery("FROM ActiviteEquitation WHERE user = :user1");
	        query1.setParameter("user1", user1);
	        List<ActiviteEquitation> sessions1 = query1.list();

	        // Extraire les sessions d'équitation de user2
	        User user2 = (User) session.get(User.class, Select.findUser1(CompareAmis.FriendPseudonyme).getIdUser());
	        Query query2 = session.createQuery("FROM ActiviteEquitation WHERE user = :user2");
	        query2.setParameter("user2", user2);
	        List<ActiviteEquitation> sessions2 = query2.list();

	        // Fermer la session Hibernate
	        session.close();

	        // Créer la série de données pour user1
	        XYSeries series1 = new XYSeries(CompareAmis.user.getPseudo());
	        for (int i = 0; i < sessions1.size(); i++) {
	            series1.add(i + 1, sessions1.get(i).getEquitation().getDistance());
	        }

	        // Créer la série de données pour user2
	        XYSeries series2 = new XYSeries(CompareAmis.FriendPseudonyme);
	        for (int i = 0; i < sessions2.size(); i++) {
	            series2.add(i + 1, sessions2.get(i).getEquitation().getDistance());
	        }

	        // Ajouter les séries de données à la collection de données
	        XYSeriesCollection dataset = new XYSeriesCollection();
	        dataset.addSeries(series1);
	        dataset.addSeries(series2);

	        // Créer le graphique en courbes
	        JFreeChart chart = ChartFactory.createXYLineChart(
	                "Comparaison de Distance d'Equitation entre " +CompareAmis.user.getPseudo()+ " et " +CompareAmis.FriendPseudonyme, // titre du graphique
	                "Activité", // nom de l'axe X
	                "Distance (m)", // nom de l'axe Y
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
