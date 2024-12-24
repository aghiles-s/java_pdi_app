package Cons;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Activité.ActiviteTir_a_larc;
import Projet.Accueil;
import Projet.Ami;
import Projet.AmisW;
import Projet.Autho;
import Projet.CompareGrapheAmis;
import Projet.DBConnection;
import Projet.Graphes;
import Projet.IMCCalculator;
import Projet.ModifierActive;
import Projet.Profil;
import Projet.Select;
import Projet.Sports;
import Sports.Sport;
import Sports.Tir_a_larc;
import Sports.User;

import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;




public class ConsTir_a_larc extends JFrame {
	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_duree;
	private JTextField textField_repetition;
	private JTextField textField_etatEsprit;

	private JTextField textField_Score;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		String pseudoUtilisateur = null;
	    if (args != null && args.length > 0) {
	        pseudoUtilisateur = args[0];
	    }
	    ConsTir_a_larc frame = new ConsTir_a_larc(pseudoUtilisateur);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); 
	}

	/**
	 * Create the frame.
	 */
	private String pseudoUtilisateur;
	public ConsTir_a_larc(String pseudoUtilisateur) {
		this.pseudoUtilisateur = pseudoUtilisateur;
		
	    initialize();
	  }
	private void initialize() {
		frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel navigationBar = new JPanel();
		navigationBar.setBackground(new Color(96, 150, 180));
		//34,109,104
		navigationBar.setBounds(0, 0, 174, 610);
		contentPane.add(navigationBar);
		navigationBar.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setText(lblNewLabel_1.getText() + pseudoUtilisateur);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(32, 49, 121, 29);
		navigationBar.add(lblNewLabel_1);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/accueil.png"));
		JButton btnAccueil = new JButton("Accueil", icon);
		btnAccueil.setHorizontalTextPosition(JButton.RIGHT);
		btnAccueil.setForeground(Color.BLACK);
		btnAccueil.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAccueil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = lblNewLabel_1.getText();
				Accueil.main(new String[] {pseudoUtilisateur});
				frame.setVisible(false);
				dispose();
			}
		});
		btnAccueil.setBounds(10, 103, 93, 36);
		btnAccueil.setBorder(null);
		btnAccueil.setBackground(Color.WHITE);
		navigationBar.add(btnAccueil);
		
		
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/images/sports.png"));
		JButton btnSports = new JButton("Tous les sports",icon1);
		btnAccueil.setHorizontalTextPosition(JButton.RIGHT);
		btnSports.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = lblNewLabel_1.getText();
				Sports.main(new String[] {pseudoUtilisateur});
				frame.setVisible(false);
				dispose();
			}
		
		});
		btnSports.setForeground(new Color(255, 255, 255));
		btnSports.setBounds(4, 183, 148, 36);
		btnSports.setBorder(null);
		btnSports.setBackground(new Color(96, 150, 180));
		navigationBar.add(btnSports);
		
		ImageIcon icon2 = new ImageIcon(getClass().getResource("/images/charts.png"));
		JButton btnDiagrammes = new JButton("Graphes",icon2);
		btnDiagrammes.setHorizontalTextPosition(JButton.RIGHT);
		btnDiagrammes.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnDiagrammes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = lblNewLabel_1.getText();
				Graphes.main(new String[] {pseudoUtilisateur});
				frame.setVisible(false);
				dispose();
			}
		});
		btnDiagrammes.setForeground(new Color(255, 255, 255));
		btnDiagrammes.setBounds(-3, 229, 121, 36);
		btnDiagrammes.setBorder(null);
		btnDiagrammes.setBackground(new Color(96, 150, 180));
		navigationBar.add(btnDiagrammes);
		
		ImageIcon icon5 = new ImageIcon(getClass().getResource("/images/bmi.png"));
		JButton btnIMC = new JButton("Calcule IMC",icon5);
		btnIMC.setHorizontalTextPosition(JButton.RIGHT);
		btnIMC.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnIMC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = lblNewLabel_1.getText();
				IMCCalculator.main(new String[] {pseudoUtilisateur});
				frame.setVisible(false);
				dispose();
				}
		});
		btnIMC.setForeground(new Color(255, 255, 255));
		btnIMC.setBounds(-1, 313, 148, 36);
		btnIMC.setBorder(null);
		btnIMC.setBackground(new Color(96, 150, 180));
		navigationBar.add(btnIMC);
		
		
		ImageIcon icon3 = new ImageIcon(getClass().getResource("/images/profil.png"));
		JButton btnProfil = new JButton("Profil",icon3);
		btnProfil.setHorizontalTextPosition(JButton.RIGHT);
		btnProfil.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = lblNewLabel_1.getText();
				Profil.main(new String[] {pseudoUtilisateur});
				frame.setVisible(false);
				dispose();
			}
		});
		btnProfil.setForeground(Color.WHITE);
		btnProfil.setBounds(-30, 150, 154, 36);
		btnProfil.setBorder(null);
		btnProfil.setBackground(new Color(96, 150, 180));
		navigationBar.add(btnProfil);
		
		ImageIcon icon6 =new ImageIcon(getClass().getResource("/images/deconnexion.png"));
		JButton btnSeDeconnecter = new JButton("Se déconnecter",icon6);
		btnProfil.setHorizontalTextPosition(JButton.RIGHT);
		btnSeDeconnecter.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnSeDeconnecter.setForeground(new Color(255, 255, 255));
		btnSeDeconnecter.setBounds(-3, 526, 174, 36);
		btnSeDeconnecter.setBorder(null);
		btnSeDeconnecter.setBackground(new Color(96, 150, 180));
		navigationBar.add(btnSeDeconnecter);
		btnSeDeconnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Autho.main(null);
				frame.setVisible(false);
				dispose();
			}
		});
		ImageIcon icon4 = new ImageIcon(getClass().getResource("/images/amis.png"));
		JButton btnAmis = new JButton("Amis",icon4);
		btnProfil.setHorizontalTextPosition(JButton.RIGHT);
		btnAmis.setForeground(Color.WHITE);
		btnAmis.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAmis.setBorder(null);
		btnAmis.setBackground(new Color(96, 150, 180));
		btnAmis.setBounds(-26, 267, 147, 36);
		navigationBar.add(btnAmis);
		
		ImageIcon icon61 = new ImageIcon(getClass().getResource("/images/rapport-32.png"));
		JButton btnMjrActivits1 = new JButton("Activités",icon61);
		btnProfil.setHorizontalTextPosition(JButton.RIGHT);btnMjrActivits1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = lblNewLabel_1.getText();
				ModifierActive.main(new String[] {pseudoUtilisateur});
				frame.setVisible(false);
				dispose();
			}
		});
		btnMjrActivits1.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnMjrActivits1.setForeground(Color.WHITE);
		btnMjrActivits1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnMjrActivits1.setBorder(null);
		btnMjrActivits1.setBackground(new Color(96, 150, 180));
		btnMjrActivits1.setBounds(-12, 379, 148, 36);
		navigationBar.add(btnMjrActivits1);
		
		ImageIcon icon7 = new ImageIcon(getClass().getResource("/images/compare.png"));
		btnProfil.setHorizontalTextPosition(JButton.RIGHT);
		JButton btnCompamis = new JButton("Compare Amis",icon7);
		btnCompamis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = lblNewLabel_1.getText();
				CompareGrapheAmis.main(new String[] {pseudoUtilisateur});
				frame.setVisible(false);
				dispose();
			} 
		});
		btnCompamis.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCompamis.setForeground(Color.WHITE);
		btnCompamis.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnCompamis.setBorder(null);
		btnCompamis.setBackground(new Color(96, 150, 180));
		btnCompamis.setBounds(10, 428, 135, 36);
		navigationBar.add(btnCompamis);
		btnAmis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = lblNewLabel_1.getText();
				AmisW.main(new String[] {pseudoUtilisateur});
				frame.setVisible(false);
				dispose();
			}
		});
		
		
		
		JPanel boutonChoisi = new JPanel();
		boutonChoisi.setBackground(new Color(147, 191, 207));
		boutonChoisi.setBounds(173, 0, 732, 632);
		contentPane.add(boutonChoisi);
		boutonChoisi.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(51, 23, 397, 21);
		textField.setBorder(new LineBorder(new Color(0, 0, 0)));
		boutonChoisi.add(textField);
		textField.setColumns(10);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.setBackground(new Color(255, 255, 255));
		btnRechercher.setBounds(464, 22, 85, 21);
		btnRechercher.setBorder(null);
		boutonChoisi.add(btnRechercher);
		
		textField_duree = new JTextField();
		textField_duree.setBorder(BorderFactory.createLineBorder(new Color(34,109,104)));
		textField_duree.setBounds(60, 110, 268, 21);
		//textField_duree.setBorder(null);
		boutonChoisi.add(textField_duree);
		textField_duree.setColumns(10);
		
		textField_repetition = new JTextField();
		textField_repetition.setColumns(10);
		textField_repetition.setBorder(BorderFactory.createLineBorder(new Color(34,109,104)));
		textField_repetition.setBounds(60, 179, 268, 21);
		boutonChoisi.add(textField_repetition);
		
		textField_etatEsprit = new JTextField();
		textField_etatEsprit.setColumns(10);
		textField_etatEsprit.setBorder(BorderFactory.createLineBorder(new Color(34,109,104)));
		textField_etatEsprit.setBounds(60, 250, 268, 21);
		boutonChoisi.add(textField_etatEsprit);
		
		JLabel lblNewLabel = new JLabel("Durée *H");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(62, 89, 96, 21);
		boutonChoisi.add(lblNewLabel);
		
		JLabel lblRpetition = new JLabel("Distance *m");
		lblRpetition.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRpetition.setBounds(60, 156, 98, 21);
		boutonChoisi.add(lblRpetition);
		
		JLabel lblEtatDesprit = new JLabel("Nombre de Fleche");
		lblEtatDesprit.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEtatDesprit.setBounds(60, 228, 136, 21);
		boutonChoisi.add(lblEtatDesprit);
		
		Session session = DBConnection.getSession();
		Transaction readTransaction = session.beginTransaction();
		User user = (User) session.get(User.class, Select.findUser1(pseudoUtilisateur).getIdUser());
		Query query = session.createQuery("FROM ActiviteTir_a_larc WHERE user = :user ORDER BY id DESC").setMaxResults(3);
        query.setParameter("user", user);
        // Recuperer la liste des resultats de la requete
        List<ActiviteTir_a_larc> sessions = query.list();
		
		JLabel lblActiv = new JLabel(" Vos dernières activités");
		lblActiv.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblActiv.setBounds(60, 353, 347, 21);
		boutonChoisi.add(lblActiv);
		int a=60;
		for (ActiviteTir_a_larc p : sessions) {
			JPanel dern_activ = new JPanel();
			dern_activ.setBackground(new Color(144, 200, 172));
			dern_activ.setBounds(a,384,159,150);
			boutonChoisi.add(dern_activ);
			dern_activ.setLayout(null);
			a+=189;
			
			JLabel lblDuree = new JLabel("Durée");
			lblDuree.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDuree.setBounds(10, 21, 55, 13);
			dern_activ.add(lblDuree);
			
			JLabel lblDistance = new JLabel("NbFleches");
			lblDistance.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDistance.setBounds(10, 56, 74, 18);
			dern_activ.add(lblDistance);
			
			
			JLabel distance = new JLabel("distance");
			distance.setFont(new Font("Tahoma", Font.BOLD, 14));
			distance.setBounds(10, 90, 63, 18);
			dern_activ.add(distance);
			
			
			JLabel Score = new JLabel("Score");
			Score.setFont(new Font("Tahoma", Font.BOLD, 14));
			Score.setBounds(10, 120, 63, 18);
			dern_activ.add(Score);
			
			
			JLabel lblDureeR_rempl = new JLabel(Integer.toString(p.getTir_a_larc().getDuree()));
			lblDureeR_rempl.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDureeR_rempl.setBounds(94, 21, 55, 13);
			dern_activ.add(lblDureeR_rempl);
			
			JLabel lblDistanceR__rempl = new JLabel(Integer.toString(p.getTir_a_larc().getNbFleches()));
			lblDistanceR__rempl.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDistanceR__rempl.setBounds(94, 56, 55, 18);
			dern_activ.add(lblDistanceR__rempl);
			
			JLabel lblVitesseR_rempl = new JLabel(Double.toString(p.getTir_a_larc().getDistance()));
			lblVitesseR_rempl.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblVitesseR_rempl.setBounds(94, 90, 55, 18);
			dern_activ.add(lblVitesseR_rempl);
		    //System.out.println(p);
			
			JLabel lblVitesseR_rempl1 = new JLabel(Integer.toString(p.getTir_a_larc().getScore()));
			lblVitesseR_rempl1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblVitesseR_rempl1.setBounds(94, 120, 55, 18);
			dern_activ.add(lblVitesseR_rempl1);
		}
		session.close();
		
			
		JPanel equitationIMG = new JPanel();
		equitationIMG.setBounds(404, 110, 170, 159);
		equitationIMG.setLayout(null);
		JLabel imageEquitation = new JLabel("");
		imageEquitation.setBounds(0, 0, 170, 159); 
		equitationIMG.add(imageEquitation);
		ImageIcon iconEquit = new ImageIcon(new ImageIcon(getClass().getResource("/images/tira2.jpg")).getImage().getScaledInstance(170, 170, 30));
		imageEquitation.setIcon(iconEquit);
		boutonChoisi.add(equitationIMG);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.setBounds(402, 336, 85, 21);
		btnAjouter.setBackground(new Color(20, 108, 148));
		btnAjouter.setBorder(null);
		boutonChoisi.add(btnAjouter);
		
		textField_Score = new JTextField();
		textField_Score.setColumns(10);
		textField_Score.setBorder(BorderFactory.createLineBorder(new Color(34,109,104)));
		textField_Score.setBounds(60, 309, 268, 21);
		boutonChoisi.add(textField_Score);
		
		JLabel lblEtatDesprit_1 = new JLabel("Score ");
		lblEtatDesprit_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEtatDesprit_1.setBounds(60, 279, 136, 21);
		boutonChoisi.add(lblEtatDesprit_1);
		
		JLabel lblNewLabel_2 = new JLabel("*Tous les champs sont obligatoires.");
		lblNewLabel_2.setBounds(60, 340, 220, 13);
		boutonChoisi.add(lblNewLabel_2);
		btnAjouter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Session session = DBConnection.getSession();
				Transaction persistTransaction1 = session.beginTransaction();
				User user = (User) session.get(User.class, Select.findUser1(pseudoUtilisateur).getIdUser());
				Sport sport = (Sport) session.get(Sport.class, 2);
				Tir_a_larc eq = new Tir_a_larc(
						Integer.parseInt(textField_duree.getText()), 
						Integer.parseInt(textField_repetition.getText()), 
						Double.parseDouble(textField_etatEsprit.getText()), 
						Integer.parseInt(textField_Score.getText()),sport);
				//Very useful, the save method can return an auto-generated Id.
				session.save(eq);
				ActiviteTir_a_larc actTir = new ActiviteTir_a_larc(user, eq);
				session.persist(actTir);
				
				persistTransaction1.commit();
				session.close();
			}
			
		});
	}
}
