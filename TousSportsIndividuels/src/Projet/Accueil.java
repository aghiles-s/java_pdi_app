package Projet;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Cons.ConEquitation;
import Cons.ConsJogging;
import Cons.ConsTir_a_larc;
import Cons.ConsYoga;
import Sports.Choix;
import Sports.User;
import Cons.ConsKayak;
import Cons.ConsMusculation;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;




public class Accueil extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel contentPane;
	private JTextField searchBar;
	

	/*
	 * Launch the application.
	 */
	public void setFrameVisible(boolean visible) {
        this.setVisible(visible);
    }
	
    
    
   
	public static void main(String[] args) {
		String pseudoUtilisateur = null;
	    if (args != null && args.length > 0) {
	        pseudoUtilisateur = args[0];
	    }
	    Accueil frame  = new Accueil(pseudoUtilisateur);
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
	 @SuppressWarnings("unused")
	private String pseudoUtilisateur;
	    @SuppressWarnings("unchecked")
		public Accueil(String pseudoUtilisateur) {
			this.pseudoUtilisateur = pseudoUtilisateur;
	        
		frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 577);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		JPanel navigationBar = new JPanel();
		navigationBar.setBorder(new LineBorder(new Color(0, 0, 0)));
		navigationBar.setBackground(new Color(96, 150, 180));
		//34,109,104
		navigationBar.setBounds(0, 0, 185, 544);
		contentPane.add(navigationBar);
		navigationBar.setLayout(null);
	
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setText(lblNewLabel.getText() + pseudoUtilisateur);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(32, 49, 121, 29);
		navigationBar.add(lblNewLabel);
		
		ImageIcon icon =new ImageIcon(getClass().getResource("/images/accueil.png"));
		JButton btnAccueil = new JButton("Accueil", icon);
		btnAccueil.setHorizontalTextPosition(JButton.RIGHT);
		btnAccueil.setForeground(Color.BLACK);
		btnAccueil.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAccueil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = lblNewLabel.getText();
				Accueil.main(new String[] {pseudoUtilisateur});
				frame.setVisible(false);
				dispose();		
			}
		});
		btnAccueil.setBounds(10, 104, 93, 36);
		btnAccueil.setBorder(null);
		btnAccueil.setBackground(Color.WHITE);
		navigationBar.add(btnAccueil);
		

		
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/images/sports.png"));
		JButton btnSports = new JButton("Tous les sports",icon1);
		btnAccueil.setHorizontalTextPosition(JButton.RIGHT);
		btnSports.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = lblNewLabel.getText();
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
		
		//ImageIcon icon2 = new ImageIcon("C:/Users/abbas/eclipse-workspace/Projet/src/images/charts.png");
		ImageIcon icon2 = new ImageIcon(getClass().getResource("/images/charts.png"));
		JButton btnDiagrammes = new JButton("Graphes",icon2);
		btnDiagrammes.setHorizontalTextPosition(JButton.RIGHT);
		btnDiagrammes.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnDiagrammes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = lblNewLabel.getText();
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
				String pseudoUtilisateur = lblNewLabel.getText();
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
				String pseudoUtilisateur = lblNewLabel.getText();
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
		
		ImageIcon icon6 = new ImageIcon(getClass().getResource("/images/deconnexion.png"));
		JButton btnSeDeconnecter = new JButton("Se déconnecter",icon6);
		btnProfil.setHorizontalTextPosition(JButton.RIGHT);
		btnSeDeconnecter.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnSeDeconnecter.setForeground(new Color(255, 255, 255));
		btnSeDeconnecter.setBounds(10, 480, 164, 36);
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
		btnProfil.setHorizontalTextPosition(JButton.RIGHT);
		btnMjrActivits1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = lblNewLabel.getText();
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
		btnMjrActivits1.setBounds(-14, 371, 148, 36);
		navigationBar.add(btnMjrActivits1);
		
		ImageIcon icon7 = new ImageIcon(getClass().getResource("/images/compare.png"));
		btnProfil.setHorizontalTextPosition(JButton.RIGHT);
		JButton btnCompamis = new JButton("CompareAmis",icon7);
		btnCompamis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = lblNewLabel.getText();
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
		btnCompamis.setBounds(10, 417, 134, 36);
		navigationBar.add(btnCompamis);
		
		btnAmis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = lblNewLabel.getText();
				AmisW.main(new String[] {pseudoUtilisateur});
				frame.setVisible(false);
				dispose();
			}
		}); 
		
		JPanel boutonChoisi = new JPanel();
		boutonChoisi.setBackground(new Color(147, 191, 207));
		boutonChoisi.setBounds(173, 0, 637, 544);
		contentPane.add(boutonChoisi);
		boutonChoisi.setLayout(null);
		
		searchBar = new JTextField();
		searchBar.setBounds(60, 23, 388, 21);
		boutonChoisi.add(searchBar);
		searchBar.setColumns(10);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.setBackground(new Color(255, 255, 255));
		btnRechercher.setBounds(464, 22, 85, 21);
		btnRechercher.setBorder(null);
		boutonChoisi.add(btnRechercher);
		
		
		Session session = DBConnection.getSession();
		@SuppressWarnings("unused")
		Transaction readTransaction = session.beginTransaction();
		//Query readQuery = session.createQuery("from User p where p.id=:id");
		//User user = (User) session.get(User.class, 2);
		
		User user = (User) session.get(User.class, Select.findUser1(pseudoUtilisateur).getIdUser());
		
		//Sport sport = (Sport) session.get(Sport.class, 5);
		Query query = session.createQuery("FROM Choix WHERE user = :user");
        query.setParameter("user", user);
        // Recuperer la liste des resultats de la requete
        List<Choix> sessions = query.list();
		
        
        int a = 111;
        for (int i = 0; i < sessions.size(); i++) {
        	final int index = i;
		JPanel sportChoisi1 = new JPanel();
		sportChoisi1.setBackground(new Color(240, 240, 240));
		sportChoisi1.setBounds(60, a, 489, 64);
		boutonChoisi.add(sportChoisi1);
		sportChoisi1.setLayout(null);
		a+=104;
		
		JLabel lblSp1 = new JLabel(sessions.get(i).getSport().getNomSport());
		lblSp1.setForeground(new Color(0, 0, 0));
		lblSp1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSp1.setBounds(25, 15, 207, 33);
		sportChoisi1.add(lblSp1);
		
		JButton btnConsulterSp1 = new JButton("Consulter");
		btnConsulterSp1.setBounds(365, 21, 85, 21); 
		btnConsulterSp1.setBorder(null);
		btnConsulterSp1.setBackground(new Color(34,109,104));
		btnConsulterSp1.setForeground(Color.WHITE);
		sportChoisi1.add(btnConsulterSp1);
		btnConsulterSp1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(sessions.get(index).getSport().getNomSport().equals("Kayak") ) {
					String pseudoUtilisateur = lblNewLabel.getText();
					ConsKayak.main(new String[] {pseudoUtilisateur});
					frame.setVisible(false);
					dispose();
					
					
				}else if(sessions.get(index).getSport().getNomSport().equals("Yoga") ) {
					String pseudoUtilisateur = lblNewLabel.getText();
					ConsYoga.main(new String[] {pseudoUtilisateur});
					frame.setVisible(false);
					dispose();
					
				}else if(sessions.get(index).getSport().getNomSport().equals("Musculation") ) {
					String pseudoUtilisateur = lblNewLabel.getText();
					ConsMusculation.main(new String[] {pseudoUtilisateur});
					frame.setVisible(false);
					dispose();
					
				}else if(sessions.get(index).getSport().getNomSport().equals("Jogging") ) {
					String pseudoUtilisateur = lblNewLabel.getText();
					ConsJogging.main(new String[] {pseudoUtilisateur});
					frame.setVisible(false);
					dispose();
					
				}else if(sessions.get(index).getSport().getNomSport().equals("Equitation") ) {
					String pseudoUtilisateur = lblNewLabel.getText();
					ConEquitation.main(new String[] {pseudoUtilisateur});
					frame.setVisible(false);
					dispose();
					
				}else  {
					String pseudoUtilisateur = lblNewLabel.getText();
					ConsTir_a_larc.main(new String[] {pseudoUtilisateur});
					frame.setVisible(false);
					dispose();
					}
				
			}});
		      
		
		
        }
        session.close();
		
		
	}
}
