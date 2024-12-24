package GrapheEquitation;

import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import Activité.ActiviteEquitation;
import Sports.User;
import Projet.DBConnection;
import Projet.Select;

public class CamembertGraph extends JFrame {
    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    public static void main(String[] args) {
    	 
        String pseudoUtilisateur = null;
        if (args != null && args.length > 0) {
            pseudoUtilisateur = args[0];
        }
        CamembertGraph demo = new CamembertGraph(pseudoUtilisateur);

        // Création du dataset et du chart
        DefaultPieDataset dataset = new DefaultPieDataset();
        JFreeChart chart = ChartFactory.createPieChart("Duree Equitation en Camembert de  "   +pseudoUtilisateur, dataset, true, true, false);
        
        // Configuration de Hibernate
        Session session = DBConnection.getSession();
        Transaction persistTransaction1 = session.beginTransaction();
        //User user = (User) session.get(User.class, Select.findUser1(pseudoUtilisateur).getIdUser());
        User user = (User) session.get(User.class, 2);
        // Récupération des données depuis la base de données
        
        Query query = session.createQuery("FROM ActiviteEquitation WHERE user = :user");
        query.setParameter("user", user);
        List<ActiviteEquitation> sessions = query.list();
        session.close();

        // Ajout des données au dataset
        for (int i = 0; i < sessions.size(); i++) {
            dataset.setValue("Duree" + (i + 1), sessions.get(i).getEquitation().getDuree());
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
        frame.setResizable(false);
		
    }
    public void setVisible(boolean visible) { // ajout de cette méthode pour être appelée depuis la fenêtre principale
        super.setVisible(visible);
    }
    private String pseudoUtilisateur;

    public CamembertGraph(String pseudoUtilisateur) {
        super(pseudoUtilisateur);
        this.pseudoUtilisateur = pseudoUtilisateur;
        
    }
}
