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

import Activité.ActiviteKayak;
import Projet.Accueil;
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
import Sports.Kayak;
import Sports.Sport;
import Sports.User;

import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class ConsKayak extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_duree;
	private JTextField textField_Distance;
	private JTextField textField_Vitesse;
	private JTextField textField_PoidBat;

	
	public static void main(String[] args) {
		String pseudoUtilisateur = null;
	    if (args != null && args.length > 0) {
	        pseudoUtilisateur = args[0];
	    }
	    ConsKayak frame = new ConsKayak(pseudoUtilisateur);
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
	
	private String pseudoUtilisateur;
	public ConsKayak(String pseudoUtilisateur) {
		this.pseudoUtilisateur = pseudoUtilisateur;
		
	    initialize();
	  }
	private void initialize() {
		frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 733);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel navigationBar = new JPanel();
		navigationBar.setBackground(new Color(96, 150, 180));
		//34,109,104
		navigationBar.setBounds(0, 0, 174, 723);
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
		btnAccueil.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAccueil.setForeground(Color.BLACK);
		btnAccueil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = lblNewLabel_1.getText();
				Accueil.main(new String[] {pseudoUtilisateur});
				frame.setVisible(false);
				dispose();
			}
		});
		btnAccueil.setBorder(null);
		btnAccueil.setBackground(Color.WHITE);
		btnAccueil.setBounds(9, 140, 93, 36);
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
		btnSports.setForeground(Color.WHITE);
		btnSports.setBorder(null);
		btnSports.setBackground(new Color(96, 150, 180));
		btnSports.setBounds(2, 232, 154, 36);
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
		
		btnDiagrammes.setForeground(Color.WHITE);
		btnDiagrammes.setBorder(null);
		btnDiagrammes.setBackground(new Color(96, 150, 180));
		btnDiagrammes.setBounds(-3, 278, 131, 36);
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
		btnIMC.setBounds(-4, 381, 164, 36);
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
		btnProfil.setForeground(new Color(255, 255, 255));
		btnProfil.setBounds(-14, 186, 131, 36);
		btnProfil.setBorder(null);
		btnProfil.setBackground(new Color(96, 150, 180));
		navigationBar.add(btnProfil);
		
		ImageIcon icon6 = new ImageIcon(getClass().getResource("/images/deconnexion.png"));
		JButton btnSeDeconnecter = new JButton("Se déconnecter",icon6);
		btnProfil.setHorizontalTextPosition(JButton.RIGHT);
		btnSeDeconnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSeDeconnecter.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Autho.main(null);
						frame.setVisible(false);
						dispose();	
					}
				});
			}
		});
		
		btnSeDeconnecter.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnSeDeconnecter.setForeground(Color.WHITE);
		btnSeDeconnecter.setBorder(null);
		btnSeDeconnecter.setBackground(new Color(96, 150, 180));
		btnSeDeconnecter.setBounds(10, 616, 154, 36);
		navigationBar.add(btnSeDeconnecter);
		
		ImageIcon icon4 = new ImageIcon(getClass().getResource("/images/amis.png"));
		JButton btnAmis = new JButton("Amis",icon4);
		btnProfil.setHorizontalTextPosition(JButton.RIGHT);
		btnAmis.setForeground(Color.WHITE);
		btnAmis.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAmis.setBorder(null);
		btnAmis.setBackground(new Color(96, 150, 180));
		btnAmis.setBounds(-15, 324, 131, 36);
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
		btnMjrActivits1.setBounds(-4, 446, 139, 36);
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
		btnCompamis.setBounds(20, 492, 136, 36);
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
		boutonChoisi.setBounds(173, 0, 818, 775);
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
		textField_duree.setBounds(60, 110, 268, 19);
		//textField_duree.setBorder(null);
		boutonChoisi.add(textField_duree);
		textField_duree.setColumns(10);
		
		textField_Distance = new JTextField();
		textField_Distance.setColumns(10);
		textField_Distance.setBorder(BorderFactory.createLineBorder(new Color(34,109,104)));
		textField_Distance.setBounds(60, 179, 268, 19);
		boutonChoisi.add(textField_Distance);
		
		textField_Vitesse = new JTextField();
		textField_Vitesse.setColumns(10);
		textField_Vitesse.setBorder(BorderFactory.createLineBorder(new Color(34,109,104)));
		textField_Vitesse.setBounds(60, 250, 268, 19);
		boutonChoisi.add(textField_Vitesse);
		
		JLabel lblNewLabel = new JLabel("Durée *H");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(62, 89, 96, 21);
		boutonChoisi.add(lblNewLabel);
		
		JLabel lblRpetition = new JLabel("Distance *m");
		lblRpetition.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRpetition.setBounds(60, 156, 98, 21);
		boutonChoisi.add(lblRpetition);
		
		JLabel lblEtatDesprit = new JLabel("Vitesse Km/H");
		lblEtatDesprit.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEtatDesprit.setBounds(60, 228, 136, 21);
		boutonChoisi.add(lblEtatDesprit);
		
		Session session = DBConnection.getSession();
		@SuppressWarnings("unused")
		Transaction readTransaction = session.beginTransaction();
		User user = (User) session.get(User.class, Select.findUser1(pseudoUtilisateur).getIdUser());
		 Query query = session.createQuery("FROM ActiviteKayak WHERE user = :user ORDER BY id DESC").setMaxResults(3);
        query.setParameter("user", user);
        // Recuperer la liste des resultats de la requete
        @SuppressWarnings("unchecked")
		List<ActiviteKayak> sessions = query.list();
		
		JLabel lblActiv = new JLabel(" Vos dernières activités");
		lblActiv.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblActiv.setBounds(51, 435, 347, 21);
		boutonChoisi.add(lblActiv);
		int a=60;
		for (ActiviteKayak p : sessions) {
			JPanel dern_activ = new JPanel();
			dern_activ.setBackground(new Color(144, 200, 172));
			dern_activ.setBounds(a,484,159,175);
			boutonChoisi.add(dern_activ);
			dern_activ.setLayout(null);
			a+=189;
			
			JLabel lblDuree = new JLabel("Durée");
			lblDuree.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDuree.setBounds(10, 21, 55, 13);
			dern_activ.add(lblDuree);
			
			JLabel lblDistance = new JLabel("Distance");
			lblDistance.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDistance.setBounds(10, 56, 74, 18);
			dern_activ.add(lblDistance);
			
			JLabel lblVitesse = new JLabel("Vitesse");
			lblVitesse.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblVitesse.setBounds(10, 90, 63, 18);
			dern_activ.add(lblVitesse);
			
			JLabel PoidBat = new JLabel("PoidBat");
			PoidBat.setFont(new Font("Tahoma", Font.BOLD, 14));
			PoidBat.setBounds(10, 120, 63, 18);
			dern_activ.add(PoidBat);
			
			
			
			
			
			JLabel lblDureeR_rempl = new JLabel(Integer.toString(p.getKayak().getDuree()));
			lblDureeR_rempl.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDureeR_rempl.setBounds(94, 21, 55, 13);
			dern_activ.add(lblDureeR_rempl);
			
			JLabel lblDistanceR__rempl = new JLabel(Double.toString(p.getKayak().getDistance()));
			lblDistanceR__rempl.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDistanceR__rempl.setBounds(94, 56, 55, 18);
			dern_activ.add(lblDistanceR__rempl);
			
			JLabel lblVitesseR_rempl = new JLabel(Double.toString(p.getKayak().getVitesse()));
			lblVitesseR_rempl.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblVitesseR_rempl.setBounds(94, 90, 55, 18);
			dern_activ.add(lblVitesseR_rempl);
		    //System.out.println(p);
			
			JLabel lblVitesseR_rempl1 = new JLabel(Double.toString(p.getKayak().getPoidBat()));
			lblVitesseR_rempl1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblVitesseR_rempl1.setBounds(96, 120, 55, 18);
			dern_activ.add(lblVitesseR_rempl1);
			
		}
		session.close();
		
			
		JPanel equitationIMG = new JPanel();
		equitationIMG.setBounds(448, 110, 170, 159);
		equitationIMG.setLayout(null);
		ImageIcon iconEquit = new ImageIcon(new ImageIcon(getClass().getResource("/images/Kayak.jpg")).getImage().getScaledInstance(170, 170, 30));
		boutonChoisi.add(equitationIMG);
		JLabel imageEquitation = new JLabel("");
		imageEquitation.setBounds(0, 0, 170, 159);
		equitationIMG.add(imageEquitation);
		imageEquitation.setIcon(iconEquit);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.setBounds(410, 398, 85, 21);
		btnAjouter.setBackground(new Color(20, 108, 148));
		btnAjouter.setBorder(null);
		boutonChoisi.add(btnAjouter);
		
		textField_PoidBat = new JTextField();
		textField_PoidBat.setColumns(10);
		textField_PoidBat.setBorder(BorderFactory.createLineBorder(new Color(34,109,104)));
		textField_PoidBat.setBounds(60, 309, 268, 19);
		boutonChoisi.add(textField_PoidBat);
		
		JLabel lblEtatDesprit_1 = new JLabel("PoidBat *g");
		lblEtatDesprit_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEtatDesprit_1.setBounds(60, 279, 136, 21);
		boutonChoisi.add(lblEtatDesprit_1);
		
		JLabel lblNewLabel_2 = new JLabel("*Tous les champs sont obligatoires.");
		lblNewLabel_2.setBounds(60, 338, 210, 13);
		boutonChoisi.add(lblNewLabel_2);
		btnAjouter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Session session = DBConnection.getSession();
				Transaction persistTransaction1 = session.beginTransaction();
				User user = (User) session.get(User.class, Select.findUser1(pseudoUtilisateur).getIdUser());
				Sport sport = (Sport) session.get(Sport.class, 6);
				Kayak eq = new Kayak(
						Integer.parseInt(textField_duree.getText()), 
						Double.parseDouble(textField_Distance.getText()), 
						Double.parseDouble(textField_Vitesse.getText()), 
						Double.parseDouble(textField_PoidBat.getText()),sport);
						
				//Very useful, the save method can return an auto-generated Id.
				session.save(eq);
				ActiviteKayak actKay = new ActiviteKayak(user, eq);
				session.persist(actKay);
				persistTransaction1.commit();
				session.close();
			}
			
		});
	}
}
