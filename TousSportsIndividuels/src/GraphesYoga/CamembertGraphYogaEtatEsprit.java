package GraphesYoga;

import java.awt.Color;
import java.util.List;
import org.hibernate.Query;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.hibernate.Session;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import Activité.ActiviteYoga;
import Sports.User;
import Sports.Yoga;
import Projet.DBConnection;
import Projet.Select;

public class CamembertGraphYogaEtatEsprit extends ApplicationFrame {
  
	public static void main(String[] args) {
		String pseudoUtilisateur = null;
		if (args != null && args.length > 0) {
	        pseudoUtilisateur = args[0];
	    }
		CamembertGraphYogaEtatEsprit demo = new CamembertGraphYogaEtatEsprit(pseudoUtilisateur);
		
		
		DefaultPieDataset dataset = new DefaultPieDataset();
        JFreeChart chart = ChartFactory.createPieChart("Etat d'ésprit Yoga en Camembert de  " +pseudoUtilisateur, dataset, true, true, false);
        
		// Configuration de Hibernate
        Session session = DBConnection.getSession();
        // Extraire les données de la base de données
        // Recuperer la classe User de l'utilisateur connecte
        //User user = (User) session.get(User.class, 1);
        User user = (User) session.get(User.class, Select.findUser1(pseudoUtilisateur).getIdUser());
        
        Query query = session.createQuery("FROM ActiviteYoga WHERE user = :user");
        query.setParameter("user", user);
        // Recuperer la liste des resultats de la requete
        List<ActiviteYoga> sessions = query.list();
        // Fermer la session Hibernate
        session.close();
        
		
		for (int i = 0; i < sessions.size(); i++) {
			dataset.setValue("Repetition"+(i+1), sessions.get(i).getYoga().getEtatEsprit());
		}
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
    }
	private static final long serialVersionUID = 1L;

	private String pseudoUtilisateur;
	public CamembertGraphYogaEtatEsprit(String pseudoUtilisateur) {
		super(pseudoUtilisateur);
		this.pseudoUtilisateur = pseudoUtilisateur;
	}
}
