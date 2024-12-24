package Projet;
import Sports.User; 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Activité.ActiviteEquitation;
import Activité.ActiviteJogging;
import GrapheAmis.GrapheEquitationHi;
import GrapheAmis.GrapheJoggingCo;
import GrapheAmis.GrapheKayakCourbe;
import GrapheAmis.GrapheMusculationHi;
import GrapheAmis.GrapheTirHi;
import GrapheAmis.GrapheYogaCam;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Ami extends JFrame {
	private static User user;
	private static String FriendPseudonyme;
	private static String pseudoUtilisateur;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final boolean True = false;
	private static final ActiviteJogging[] ActiviteJogging = null;
	private JPanel contentPane;
	private JTextField textField_Rech;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		String pseudoUtilisateur = null;
	    if (args != null && args.length > 0) {
	        pseudoUtilisateur = args[0];
	    } 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ami frame = new Ami(user, FriendPseudonyme);
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
	 * @return 
	 */
		
		
	public Ami(User user, String FriendPseudonyme) {
		Ami.user = user;
		Ami.FriendPseudonyme = FriendPseudonyme;
		JFrame frame = new JFrame();
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
		navigationBar.setBounds(0, 0, 174, 544);
		contentPane.add(navigationBar);
		navigationBar.setLayout(null);
		
		
		JButton pseudoUser = new JButton(Ami.user.getPseudo());
		pseudoUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pseudoUser.setForeground(Color.WHITE);
		pseudoUser.setBorder(null);
		pseudoUser.setBackground(new Color(96, 150, 180));
		pseudoUser.setBounds(26, 57, 121, 36);
		navigationBar.add(pseudoUser);
		
		
		
		
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/accueil.png"));
		JButton btnAccueil = new JButton("Accueil", icon);
		btnAccueil.setHorizontalTextPosition(SwingConstants.LEADING);
		btnAccueil.setForeground(Color.WHITE);
		btnAccueil.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAccueil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = pseudoUser.getText();
				Accueil.main(new String[] {pseudoUtilisateur});
				frame.setVisible(false);
				dispose();
			}
		});
	
		btnAccueil.setBounds(-12, 103, 121, 36);
		btnAccueil.setBorder(null);
		btnAccueil.setBackground(new Color(96, 150, 180));
		navigationBar.add(btnAccueil);
		
		
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/images/sports.png"));
		JButton btnSports = new JButton("Tous les sports",icon1);
		btnAccueil.setHorizontalTextPosition(JButton.RIGHT);
		btnSports.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = pseudoUser.getText();
				Sports.main(new String[] {pseudoUtilisateur});
				frame.setVisible(false);
				dispose();
			}
			
		});
		btnSports.setForeground(new Color(255, 255, 255));
		btnSports.setBounds(1, 183, 148, 36);
		btnSports.setBorder(null);
		btnSports.setBackground(new Color(96, 150, 180));
		navigationBar.add(btnSports);
		
		ImageIcon icon2 = new ImageIcon(getClass().getResource("/images/charts.png"));
		JButton btnDiagrammes = new JButton("Graphes",icon2);
		btnDiagrammes.setHorizontalTextPosition(JButton.RIGHT);
		btnDiagrammes.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnDiagrammes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = pseudoUser.getText();
				Graphes.main(new String[] {pseudoUtilisateur});
				frame.setVisible(false);
				dispose();
			}
		});
		btnDiagrammes.setForeground(new Color(255, 255, 255));
		btnDiagrammes.setBounds(-2, 229, 121, 36);
		btnDiagrammes.setBorder(null);
		btnDiagrammes.setBackground(new Color(96, 150, 180));
		navigationBar.add(btnDiagrammes);
		
		ImageIcon icon5 = new ImageIcon(getClass().getResource("/images/bmi.png"));
		JButton btnIMC = new JButton("Calcule IMC",icon5);
		btnIMC.setHorizontalTextPosition(JButton.RIGHT);
		btnIMC.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnIMC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = pseudoUser.getText();
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
		btnProfil.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = pseudoUser.getText();
				Profil.main(new String[] {pseudoUtilisateur});
				frame.setVisible(false);
				dispose();
			}
		});
		btnProfil.setForeground(Color.WHITE);
		btnProfil.setBounds(-24, 149, 132, 36);
		btnProfil.setBorder(null);
		btnProfil.setBackground(new Color(96, 150, 180));
		navigationBar.add(btnProfil);
		
		ImageIcon icon6 = new ImageIcon(getClass().getResource("/images/deconnexion.png"));
		JButton btnSeDeconnecter = new JButton("Se déconnecter",icon6);
		btnProfil.setHorizontalTextPosition(JButton.RIGHT);
		btnSeDeconnecter.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSeDeconnecter.setForeground(new Color(255, 255, 255));
		btnSeDeconnecter.setBounds(0, 480, 174, 36);
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
		btnAmis.setForeground(Color.BLACK);
		btnAmis.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAmis.setBorder(null);
		btnAmis.setBackground(Color.WHITE);
		btnAmis.setBounds(8, 267, 83, 36);
		navigationBar.add(btnAmis);
		
		ImageIcon icon61 = new ImageIcon(getClass().getResource("/images/rapport-32.png"));
		JButton btnMjrActivits1 = new JButton("Activités",icon61);
		btnProfil.setHorizontalTextPosition(JButton.RIGHT);
		btnMjrActivits1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = pseudoUser.getText();
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
		btnMjrActivits1.setBounds(-12, 359, 148, 36);
		navigationBar.add(btnMjrActivits1);
		
		ImageIcon icon7 = new ImageIcon(getClass().getResource("/images/compare.png"));
		btnProfil.setHorizontalTextPosition(JButton.RIGHT);
		JButton btnCompamis = new JButton("CompareAmis",icon7);
		btnCompamis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = pseudoUser.getText();
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
		btnCompamis.setBounds(10, 405, 137, 36);
		navigationBar.add(btnCompamis);
		btnAmis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = pseudoUser.getText();
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
		
		//rgb(107, 114, 142)
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.setBackground(new Color(255, 255, 255));
		btnRechercher.setBounds(464, 22, 85, 21);
		btnRechercher.setBorder(null);
		boutonChoisi.add(btnRechercher);
		
		textField_Rech = new JTextField();
		textField_Rech.setBounds(60, 23, 388, 21);
		boutonChoisi.add(textField_Rech);
		textField_Rech.setColumns(10);
		
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new JPanel();
				panel.setBounds(60, 43, 388, 20);
				panel.setLayout(null);
				List<User> users = new ArrayList<>();
				users = Select.ResearchUser(textField_Rech.getText());
				if(textField_Rech.getText().equals("") || users.isEmpty()) {
					JButton button = new JButton("Vide !");
					button.setBackground(new Color(255, 255, 255));
					button.setBounds(0, 0, 388, 20);
					panel.add(button);
				}
				else {
					for (User userR : users) {
						JButton button = new JButton(userR.getPseudo());
						button.setBackground(new Color(255, 255, 255));
						button.setBounds(0,(users.indexOf(userR) * 20), 388, 20);
						button.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Ami ami = new Ami(user,button.getText());
								ami.setVisible(true);
								dispose();
							}
						});
						panel.setBounds(60, 43, 388, 20 + (users.indexOf(userR) * 20));
						panel.add(button);
						}
				}
				boutonChoisi.add(panel);
				
				contentPane.addMouseListener(new MouseListener() {
					@Override
					public void mouseExited(MouseEvent e) {}
					@Override
					public void mouseClicked(MouseEvent e) {
						panel.setVisible(false);}
					@Override
					public void mousePressed(MouseEvent e) {}
					@Override
					public void mouseReleased(MouseEvent e) {
						panel.setVisible(false);}
					@Override
					public void mouseEntered(MouseEvent e) {}
		        });
				btnRechercher.addMouseListener(new MouseListener() {
					@Override
					public void mouseExited(MouseEvent e) {}
					@Override
					public void mouseClicked(MouseEvent e) {}
					@Override
					public void mousePressed(MouseEvent e) {
						panel.setVisible(false);
					}
					@Override
					public void mouseReleased(MouseEvent e) {}
					@Override
					public void mouseEntered(MouseEvent e) {}
		        });
			}
		});
		
		
		boutonChoisi.add(btnRechercher);
		
		JLabel lblNewLabel = new JLabel(FriendPseudonyme);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(60, 71, 95, 21);
		boutonChoisi.add(lblNewLabel); 
		
		if(Select.amiExistePourUtilisateur(user, Select.findUser1(FriendPseudonyme))) {
			JButton btnNewButton = new JButton("Se Désabonner");
			btnNewButton.setBackground(new Color(255, 218, 185));
			btnNewButton.setBounds(437, 71, 112, 21);
			btnNewButton.setBorder(null);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(btnNewButton.getText().equals("Se Désabonner")) {
						btnNewButton.setText("S'abonner");
						btnNewButton.setBackground(new Color(152, 251, 152));
						User user2 = Select.findUser1(FriendPseudonyme);
						Select.deleteAmisByUserAndAmi(user, user2);
					} else {
						if(btnNewButton.getText().equals("S'abonner")) {
							Select.addFriend(user, Select.findUser1(FriendPseudonyme));
							btnNewButton.setText("Se Désabonner");
							btnNewButton.setBackground(new Color(255, 218, 185));
						}
					}
					
				}
			});
			boutonChoisi.add(btnNewButton);
		}
		else {
			JButton btnNewButton = new JButton("S'abonner");
			btnNewButton.setBackground(new Color(152, 251, 152));
			btnNewButton.setBounds(437, 71, 112, 21);
			btnNewButton.setBorder(null);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(btnNewButton.getText().equals("S'abonner")) {
						btnNewButton.setText("Se Désabonner");
						btnNewButton.setBackground(new Color(255, 218, 185));
						Select.addFriend(user, Select.findUser1(FriendPseudonyme));
					} else {
						if(btnNewButton.getText().equals("Se Désabonner")) {
							btnNewButton.setText("S'abonner");
							btnNewButton.setBackground(new Color(152, 251, 152));
							User user2 = Select.findUser1(FriendPseudonyme);
							Select.deleteAmisByUserAndAmi(user, user2);
						}
					}
					
				}
			});
			boutonChoisi.add(btnNewButton);
		}
		
		JButton btnNewButton = new JButton("S'abonner");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(new Color(152, 251, 152));
		btnNewButton.setBounds(437, 71, 112, 21);
		btnNewButton.setBorder(null);
		boutonChoisi.add(btnNewButton);
		
		
			Session session = DBConnection.getSession();
		
		Transaction readTransaction = session.beginTransaction();
		User user1 = (User) session.get(User.class,Select.findUser1(FriendPseudonyme).getIdUser());
		 Query query = session.createQuery("FROM ActiviteEquitation WHERE user = :user ORDER BY id DESC").setMaxResults(1);
        query.setParameter("user", user1);
        // Recuperer la liste des resultats de la requete
        List<ActiviteEquitation> sessions = query.list();
		
         
        
		JLabel lblActiv = new JLabel(" Les dernières activités de  " +FriendPseudonyme );
		lblActiv.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblActiv.setBounds(32, 163, 347, 21);
		boutonChoisi.add(lblActiv);
		
		JButton btnNewButton_1 = new JButton("Equitation");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String FriendPseudonyme = lblNewLabel.getText();
		        GrapheEquitationHi.main(new String[] {FriendPseudonyme});
			}
		});
		btnNewButton_1.setBounds(94, 224, 134, 44);
		boutonChoisi.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Jogging");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String FriendPseudonyme = lblNewLabel.getText();
		        GrapheJoggingCo.main(new String[] {FriendPseudonyme});
			}
		});
		btnNewButton_1_1.setBounds(352, 224, 134, 44);
		boutonChoisi.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Kayak");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String FriendPseudonyme = lblNewLabel.getText();
				GrapheKayakCourbe.main(new String[] {FriendPseudonyme});
			}
		});
		btnNewButton_1_2.setBounds(94, 313, 134, 44);
		boutonChoisi.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("Musculation");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String FriendPseudonyme = lblNewLabel.getText();
				GrapheMusculationHi.main(new String[] {FriendPseudonyme});
			}
		});
		btnNewButton_1_3.setBounds(352, 313, 134, 44);
		boutonChoisi.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_4 = new JButton("Tir a l'arc");
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String FriendPseudonyme = lblNewLabel.getText();
				GrapheTirHi.main(new String[] {FriendPseudonyme});
			}
		});
		btnNewButton_1_4.setBounds(94, 411, 134, 44);
		boutonChoisi.add(btnNewButton_1_4);
		
		JButton btnNewButton_1_5 = new JButton("Yoga");
		btnNewButton_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String FriendPseudonyme = lblNewLabel.getText();
				GrapheYogaCam.main(new String[] {FriendPseudonyme});
			}
		});
		btnNewButton_1_5.setBounds(352, 411, 134, 44);
		boutonChoisi.add(btnNewButton_1_5);
		
		
		/*
		for (ActiviteEquitation p : sessions) {
			
			JPanel dern_activ = new JPanel();
			dern_activ.setBackground(new Color(189, 205, 214));
			dern_activ.setBounds(10,200,159,125);
			boutonChoisi.add(dern_activ);
			dern_activ.setLayout(null);
			
			JLabel lblKayak = new JLabel("Equitation");
			lblKayak.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblKayak.setBounds(	35, 5, 100, 13);
			dern_activ.add(lblKayak);
			
			JLabel lblDuree = new JLabel("Durée");
			lblDuree.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDuree.setBounds(10, 30, 55, 13);
			dern_activ.add(lblDuree);
			
			JLabel lblDistance = new JLabel("Distance");
			lblDistance.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDistance.setBounds(10, 56, 74, 13);
			dern_activ.add(lblDistance);
			
			JLabel lblVitesse = new JLabel("Vitesse");
			lblVitesse.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblVitesse.setBounds(10, 90, 63, 13);
			dern_activ.add(lblVitesse);
			
			JLabel lblDureeR_rempl = new JLabel(Integer.toString(p.getEquitation().getDuree()));
			lblDureeR_rempl.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDureeR_rempl.setBounds(94, 30, 55, 13);
			dern_activ.add(lblDureeR_rempl);
			
			JLabel lblDistanceR__rempl = new JLabel(Double.toString(p.getEquitation().getDistance()));
			lblDistanceR__rempl.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDistanceR__rempl.setBounds(94, 56, 55, 13);
			dern_activ.add(lblDistanceR__rempl);
			
			JLabel lblVitesseR_rempl = new JLabel(Double.toString(p.getEquitation().getVitesse()));
			lblVitesseR_rempl.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblVitesseR_rempl.setBounds(94, 90, 55, 13);
			dern_activ.add(lblVitesseR_rempl);
			
		
	//////////////////////////////////////////////////////////////////////////////
		
		
		Session session1 = DBConnection.getSession();
		Transaction readTransaction1 = session1.beginTransaction();
		User user2 = (User) session.get(User.class, Select.findUser1(FriendPseudonyme).getIdUser());

		Query query1 = session.createQuery("FROM ActiviteJogging WHERE user = :user ORDER BY id DESC").setMaxResults(1);
		query1.setParameter("user", user2);
		// Recuperer la liste des resultats de la requete
		List<ActiviteJogging> sessions1 = query1.list(); 

		for (ActiviteJogging J : sessions1) {
				JPanel dern_activ1 = new JPanel();
				dern_activ1.setBackground(new Color(189, 205, 214));
				dern_activ1.setBounds(200,200,159,125);
				boutonChoisi.add(dern_activ1);
				dern_activ1.setLayout(null);
				
				JLabel lblKayak = new JLabel("Jogging");
				lblKayak.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblKayak.setBounds(	50, 5, 100, 13);
				dern_activ1.add(lblKayak);
				
			JLabel lblDuree1 = new JLabel("Durée");
			lblDuree1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDuree1.setBounds(10, 30, 55, 13);
			dern_activ1.add(lblDuree1);
			
			JLabel lblDistance1 = new JLabel("Distance");
			lblDistance1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDistance1.setBounds(10, 56, 74, 18);
			dern_activ1.add(lblDistance1);
			
			JLabel lblVitesse1 = new JLabel("Vitesse");
			lblVitesse1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblVitesse1.setBounds(10, 90, 63, 18);
			dern_activ1.add(lblVitesse1);
			
			JLabel Altitude = new JLabel("Frequence");
			Altitude.setFont(new Font("Tahoma", Font.BOLD, 14));
			Altitude.setBounds(10, 150, 63, 18);
			dern_activ1.add(Altitude);
			
			
			JLabel lblDureeR_rempl1 = new JLabel(Integer.toString(J.getJogging().getDuree()));
			lblDureeR_rempl1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDureeR_rempl1.setBounds(94, 30, 55, 13);
			dern_activ1.add(lblDureeR_rempl1);
			
			JLabel lblDistanceR__rempl1 = new JLabel(Double.toString(J.getJogging().getDistance()));
			lblDistanceR__rempl1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDistanceR__rempl1.setBounds(94, 56, 55, 18);
			dern_activ1.add(lblDistanceR__rempl1);
			
			JLabel lblVitesseR_rempl1 = new JLabel(Double.toString(J.getJogging().getVitesse()));
			lblVitesseR_rempl1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblVitesseR_rempl1.setBounds(94, 90, 55, 18);
			dern_activ1.add(lblVitesseR_rempl1);
			
			JLabel lblVitesseR_rempl11 = new JLabel(Integer.toString(J.getJogging().getFrequence()));
			lblVitesseR_rempl11.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblVitesseR_rempl11.setBounds(96, 120, 55, 18);
			dern_activ1.add(lblVitesseR_rempl11);
			
       }
       //////////////////////////////////////////
		Session session2 = DBConnection.getSession();
		Transaction readTransaction2 = session2.beginTransaction();
		User user3 = (User) session.get(User.class, Select.findUser1(FriendPseudonyme).getIdUser());

		Query query2 = session.createQuery("FROM ActiviteKayak WHERE user = :user ORDER BY id DESC").setMaxResults(1);
		query2.setParameter("user", user3);
		// Recuperer la liste des resultats de la requete
		List<ActiviteKayak> sessions2 = query2.list(); 
		for (ActiviteKayak p : sessions2) {
			JPanel dern_activ3 = new JPanel();
			dern_activ3.setBackground(new Color(189, 205, 214));
			dern_activ3.setBounds(10,350,159,175);
			boutonChoisi.add(dern_activ3);
			dern_activ3.setLayout(null);
			
			JLabel lblKayak = new JLabel("Kayak");
			lblKayak.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblKayak.setBounds(	50, 5, 100, 13);
			dern_activ3.add(lblKayak);
			
			JLabel lblDuree = new JLabel("Durée");
			lblDuree.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDuree.setBounds(10, 30, 55, 13);
			dern_activ3.add(lblDuree);
			
			JLabel lblDistance = new JLabel("Distance");
			lblDistance.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDistance.setBounds(10, 56, 74, 18);
			dern_activ3.add(lblDistance);
			
			JLabel lblVitesse = new JLabel("Vitesse");
			lblVitesse.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblVitesse.setBounds(10, 90, 63, 18);
			dern_activ3.add(lblVitesse);
			
			JLabel PoidBat = new JLabel("PoidBat");
			PoidBat.setFont(new Font("Tahoma", Font.BOLD, 14));
			PoidBat.setBounds(10, 120, 63, 18);
			dern_activ3.add(PoidBat);
			
			
			
			
			
			JLabel lblDureeR_rempl = new JLabel(Integer.toString(p.getKayak().getDuree()));
			lblDureeR_rempl.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDureeR_rempl.setBounds(94, 30, 55, 13);
			dern_activ3.add(lblDureeR_rempl);
			
			JLabel lblDistanceR__rempl = new JLabel(Double.toString(p.getKayak().getDistance()));
			lblDistanceR__rempl.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDistanceR__rempl.setBounds(94, 56, 55, 18);
			dern_activ3.add(lblDistanceR__rempl);
			
			JLabel lblVitesseR_rempl = new JLabel(Double.toString(p.getKayak().getVitesse()));
			lblVitesseR_rempl.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblVitesseR_rempl.setBounds(94, 90, 55, 18);
			dern_activ3.add(lblVitesseR_rempl);
		    //System.out.println(p);
			
			JLabel lblVitesseR_rempl1 = new JLabel(Double.toString(p.getKayak().getPoidBat()));
			lblVitesseR_rempl1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblVitesseR_rempl1.setBounds(96, 120, 55, 18);
			dern_activ3.add(lblVitesseR_rempl1);
			
		}
		Session session3 = DBConnection.getSession();
		Transaction readTransaction3 = session3.beginTransaction();
		User user4 = (User) session.get(User.class, Select.findUser1(FriendPseudonyme).getIdUser());

		Query query3 = session.createQuery("FROM ActiviteMusculation WHERE user = :user ORDER BY id DESC").setMaxResults(1);
		query3.setParameter("user", user4);
		// Recuperer la liste des resultats de la requete
		List<ActiviteMusculation> sessions3 = query3.list(); 
		for (ActiviteMusculation p : sessions3) {
			JPanel dern_activ = new JPanel();
			dern_activ.setBackground(new Color(189, 205, 214));
			dern_activ.setBounds(400,200,159,125);
			boutonChoisi.add(dern_activ);
			dern_activ.setLayout(null);
			
			JLabel lblKayak = new JLabel("Musculation");
			lblKayak.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblKayak.setBounds(	35, 5, 100, 13);
			dern_activ.add(lblKayak);
			
			JLabel lblDuree = new JLabel("Durée");
			lblDuree.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDuree.setBounds(10, 30, 55, 13);
			dern_activ.add(lblDuree);
			
			JLabel lblDistance = new JLabel("poidsSouleve");
			lblDistance.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDistance.setBounds(10, 56, 74, 13);
			dern_activ.add(lblDistance);
			
			JLabel lblVitesse = new JLabel("repetition");
			lblVitesse.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblVitesse.setBounds(10, 90, 63, 13);
			dern_activ.add(lblVitesse);
			
			JLabel lblDureeR_rempl = new JLabel(Integer.toString(p.getMusculation().getDuree()));
			lblDureeR_rempl.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDureeR_rempl.setBounds(94, 30, 55, 13);
			dern_activ.add(lblDureeR_rempl);
			
			JLabel lblDistanceR__rempl = new JLabel(Double.toString(p.getMusculation().getPoidsSouleve()));
			lblDistanceR__rempl.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDistanceR__rempl.setBounds(94, 56, 55, 13);
			dern_activ.add(lblDistanceR__rempl);
			
			JLabel lblVitesseR_rempl = new JLabel(Integer.toString(p.getMusculation().getRepetition()));
			lblVitesseR_rempl.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblVitesseR_rempl.setBounds(94, 90, 55, 13);
			dern_activ.add(lblVitesseR_rempl);
		    //System.out.println(p);
		}
		Session session4 = DBConnection.getSession();
		Transaction readTransaction4 = session4.beginTransaction();
		User user5 = (User) session.get(User.class, Select.findUser1(FriendPseudonyme).getIdUser());

		Query query4 = session.createQuery("FROM ActiviteTir_a_larc WHERE user = :user ORDER BY id DESC").setMaxResults(1);
		query4.setParameter("user", user5);
		// Recuperer la liste des resultats de la requete
		List<ActiviteTir_a_larc> sessions4 = query4.list(); 
		for (ActiviteTir_a_larc p : sessions4) {
			JPanel dern_activ = new JPanel();
			dern_activ.setBackground(new Color(189, 205, 214));
			dern_activ.setBounds(200,350,159,150);
			boutonChoisi.add(dern_activ);
			dern_activ.setLayout(null);
			
			JLabel lblKayak = new JLabel("Tir a l'arc");
			lblKayak.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblKayak.setBounds(	35, 5, 100, 13);
			dern_activ.add(lblKayak);
			
			JLabel lblDuree = new JLabel("Durée");
			lblDuree.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDuree.setBounds(10, 30, 55, 13);
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
			lblDureeR_rempl.setBounds(94, 30, 55, 13);
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
		Session session5 = DBConnection.getSession();
		Transaction readTransaction5 = session5.beginTransaction();
		User user6 = (User) session.get(User.class, Select.findUser1(FriendPseudonyme).getIdUser());

		Query query5 = session.createQuery("FROM ActiviteYoga WHERE user = :user ORDER BY id DESC").setMaxResults(1);
		query5.setParameter("user", user6);
		// Recuperer la liste des resultats de la requete
		List<ActiviteYoga> sessions5 = query5.list(); 
		for (ActiviteYoga p : sessions5) {
			JPanel dern_activ = new JPanel();
			dern_activ.setBackground(new Color(189, 205, 214));
			dern_activ.setBounds(400,350,159,125);
			boutonChoisi.add(dern_activ);
			dern_activ.setLayout(null);
			
			JLabel lblKayak = new JLabel("Yoga");
			lblKayak.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblKayak.setBounds(	50, 5, 100, 13);
			dern_activ.add(lblKayak);
			
			JLabel lblDuree = new JLabel("Durée");
			lblDuree.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDuree.setBounds(10, 30, 55, 13);
			dern_activ.add(lblDuree);
			
			JLabel lblDistance = new JLabel("Répetition");
			lblDistance.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDistance.setBounds(10, 56, 74, 18);
			dern_activ.add(lblDistance);
			
			JLabel lblVitesse = new JLabel("Etat d'esprit");
			lblVitesse.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblVitesse.setBounds(10, 90, 63, 18);
			dern_activ.add(lblVitesse);
			
			JLabel lblDureeR_rempl = new JLabel(Integer.toString(p.getYoga().getDuree()));
			lblDureeR_rempl.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDureeR_rempl.setBounds(94, 30, 55, 13);
			dern_activ.add(lblDureeR_rempl);
			
			JLabel lblDistanceR__rempl = new JLabel(Integer.toString(p.getYoga().getRepetition()));
			lblDistanceR__rempl.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDistanceR__rempl.setBounds(94, 56, 55, 18);
			dern_activ.add(lblDistanceR__rempl);
			
			JLabel lblVitesseR_rempl = new JLabel(Double.toString(p.getYoga().getEtatEsprit()));
			lblVitesseR_rempl.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblVitesseR_rempl.setBounds(94, 90, 55, 18);
			dern_activ.add(lblVitesseR_rempl);
		    //System.out.println(p);
		}}*/
		
		
	}
}
	
