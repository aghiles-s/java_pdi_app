package GrapheAmis;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import Activité.ActiviteEquitation;
import Activité.ActiviteYoga;
import GrapheEquitation.CamembertGraph;
import Projet.DBConnection;
import Projet.Select;
import Sports.User;

import javax.swing.JFrame;

import java.awt.Color;
import java.util.List;

public class GrapheYogaCam extends JFrame {


	public static void main(String[] args) {
    	
        String FriendPseudonyme = null;
        if (args != null && args.length > 0) {
        	FriendPseudonyme = args[0];
        }
        CamembertGraph demo = new CamembertGraph(FriendPseudonyme);

        // Création du dataset et du chart
        DefaultPieDataset dataset = new DefaultPieDataset();
        JFreeChart chart = ChartFactory.createPieChart("Duree Equitation en Camembert de  " +FriendPseudonyme, dataset, true, true, false);
        
        // Configuration de Hibernate
        Session session = DBConnection.getSession();
        Transaction persistTransaction1 = session.beginTransaction();
        User user = (User) session.get(User.class, Select.findUser1(FriendPseudonyme).getIdUser());
        //User user = (User) session.get(User.class, 2);
        // Récupération des données depuis la base de données
        
        Query query = session.createQuery("FROM ActiviteYoga WHERE user = :user").setMaxResults(3);
        query.setParameter("user", user);
        List<ActiviteYoga> sessions = query.list();
        session.close();

        
     // Ajout des données au dataset
        for (int i = 0; i < sessions.size(); i++) {
            dataset.setValue("Activité Yoga" + (i + 1) + " - Durée", sessions.get(i).getYoga().getDuree());
            dataset.setValue("Activité Yoga" + (i + 1) + " - Répétition", sessions.get(i).getYoga().getRepetition());
            dataset.setValue("Activité Yoga" + (i + 1) + " - État d'esprit", sessions.get(i).getYoga().getEtatEsprit());
        }


        // Personnalisation du graphique
        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.black);

        // Création du panel pour afficher le graphique
        ChartPanel chartPanel = new ChartPanel(chart);
        demo.setContentPane(chartPanel);
        
        JFrame frame = new JFrame(FriendPseudonyme);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(chartPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
		
    }
    
    
    private String FriendPseudonyme;

    public GrapheYogaCam(String FriendPseudonyme) {
        
        this.FriendPseudonyme = FriendPseudonyme;
        
    }

   
}




