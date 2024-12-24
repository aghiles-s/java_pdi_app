package MJAActivite;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Activité.ActiviteEquitation;
import Activité.ActiviteJogging;
import Activité.ActiviteKayak;
import Activité.ActiviteMusculation;
import Activité.ActiviteTir_a_larc;
import Activité.ActiviteYoga;
import Projet.DBConnection;
import Projet.Select;
import Sports.User;

public class ActJogging extends JFrame {
	private JFrame frame;
    private JTable table;
    private DefaultTableModel model;

    private Map<String, Object[]> activitesData = new HashMap<String, Object[]>();
    private String pseudoUtilisateur;
    public ActJogging(String pseudoUtilisateur) {
		this.pseudoUtilisateur = pseudoUtilisateur;
	       
    	
        //super("Tableau des activités"); 
        
        model = new DefaultTableModel(); 
        table = new JTable(model);
       
        // Ajouter la JTable à un JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        
        // Initialisation des données
        Session session = DBConnection.getSession();
        try { 
            // Récupération des activités de la table Equitation
            //User user = (User) session.get(User.class, 2);
        	User user = (User) session.get(User.class, Select.findUser1(pseudoUtilisateur).getIdUser());
			
        	Query query = session.createQuery("FROM ActiviteJogging WHERE user = :user ORDER BY id DESC").setMaxResults(7);
            query.setParameter("user", user);
            // Recuperer la liste des resultats de la requete
            List<ActiviteJogging> sessions = query.list();
            model.addColumn("Activité");
            model.addColumn("Duree");
            model.addColumn("Distance");
            model.addColumn("Vitesse");
            model.addColumn("Frequence");
            
           
           
            for (ActiviteJogging e : sessions)  {
                
                model.addRow(new Object[]{"Jogging", e.getJogging().getDuree(), e.getJogging().getDistance(),e.getJogging().getVitesse(),e.getJogging().getFrequence()});
            }
       
       
           
            
            // Fermeture de la session Hibernate
            session.close();
            

        } catch (Exception e) {
            e.printStackTrace();
        }
       
        

        //DefaultTableModel model = new DefaultTableModel(session, columnNames);
        //JTable table = new JTable(model);
       
        JButton editButton = new JButton("Modifier");
        JPanel panel1 = new JPanel(new BorderLayout());

        JScrollPane scrollPane1 = new JScrollPane(table);

        panel1.add(scrollPane1, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
       
        buttonPanel.add(editButton);
        panel1.add(buttonPanel, BorderLayout.SOUTH);

       

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    // Récupérer les valeurs de la ligne sélectionnée
                    Object Duree = model.getValueAt(selectedRow, 1);
                    Object Distance = model.getValueAt(selectedRow, 2);
                    Object Vitesse = model.getValueAt(selectedRow, 3);
                    Object Frequence = model.getValueAt(selectedRow, 4);
                    // Afficher une boîte de dialogue pour modifier les valeurs
                    String newDistance = JOptionPane.showInputDialog(panel1, "Distance", Distance);
                    String newDuree = JOptionPane.showInputDialog(panel1, "Duree :", Duree);
                    String newVitesse = JOptionPane.showInputDialog(panel1, "Vitesse :", Vitesse);
                    String newFrequence = JOptionPane.showInputDialog(panel1, "Frequence :", Frequence);

                    // Mettre à jour les valeurs dans le modèle
                    model.setValueAt(newDuree, selectedRow, 1);
                    model.setValueAt(newDistance, selectedRow, 2);
                    model.setValueAt(newVitesse, selectedRow, 3);
                    model.setValueAt(newFrequence, selectedRow, 4);
                    // Mettre à jour la base de données avec les nouvelles valeurs
                    Session session = DBConnection.getSession();
                    try {
                        // Récupération de l'objet User
                        //User user = (User) session.get(User.class, 2);
                    	User user = (User) session.get(User.class, Select.findUser1(pseudoUtilisateur).getIdUser());
        				
                    	Query query = session.createQuery("FROM ActiviteJogging WHERE user = :user ORDER BY id DESC").setMaxResults(7);
                        query.setParameter("user", user);
                        List<ActiviteJogging> sessions = query.list();

                        // Récupération de l'objet ActiviteEquitation correspondant à la ligne modifiée
                        ActiviteJogging session1 = sessions.get(selectedRow);

                        // Mise à jour des valeurs de l'objet ActiviteEquitation avec les nouvelles valeurs
                        session1.getJogging().setDuree(Integer.parseInt(newDuree));
                        Integer newDistance1 = (int) Double.parseDouble(newDistance.toString());
                        session1.getJogging().setDistance(newDistance1);
                        int newSpeed = (int) Double.parseDouble(newVitesse.toString());
                        session1.getJogging().setVitesse(newSpeed);
                        int newSpeed1 = (int) Double.parseDouble(newVitesse.toString());
                        session1.getJogging().setFrequence(newSpeed1);
                       
                        // Sauvegarde des modifications dans la base de données
                        session.beginTransaction();
                        session.update(session1);
                        session.getTransaction().commit();

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    } finally {
                        session.close();
                    }
                }
            }
        });
     





        JFrame frame = new JFrame("Activité Jogging de " +pseudoUtilisateur);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(panel1);
        frame.pack();
        frame.setVisible(true);
    }
    

    public static void main(String[] args) {
    	String pseudoUtilisateur = null;
	    if (args != null && args.length > 0) {
	        pseudoUtilisateur = args[0];
	    }
	    ActJogging window = new ActJogging(pseudoUtilisateur);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
        
    }
