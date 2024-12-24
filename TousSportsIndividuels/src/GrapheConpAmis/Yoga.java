package GrapheConpAmis;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import GrapheMusculation.CamembertPoidsSouleveMusculation;
import GrapheMusculation.CourbeDureeMusculation;
import GrapheMusculation.HistoRepetitionMusculation;
import GrapheYogaCompAmis.CamembertRepetitionYoga;
import GrapheYogaCompAmis.CourbeRtatEspritYoga;
import GrapheYogaCompAmis.DureeHiYoga;
import GraphesYoga.CamembertGraphYogaEtatEsprit;
import GraphesYoga.CamembertGraphYogaRep;
import GraphesYoga.HistoDureeYoga;
import Projet.Accueil;
import Projet.Ami;
import Projet.AmisW;
import Projet.Autho;
import Projet.CompareAmis;
import Projet.CompareGrapheAmis;
import Projet.Graphes;
import Projet.IMCCalculator;
import Projet.ModifierActive;
import Projet.Profil;
import Projet.Select;
import Projet.Sports;
import Sports.User;

public class Yoga extends JFrame{
	private JPanel contentPane;
	private JFrame frame;
	private JTextField textField_Rech;
	private static User user;
	private static String FriendPseudonyme;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		String pseudoUtilisateur = null;
	    if (args != null && args.length > 0) {
	        pseudoUtilisateur = args[0];
	    }
	    Yoga window = new Yoga(user, FriendPseudonyme);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.frame.setVisible(true);
					window.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the application.
	 */
	 private String pseudoUtilisateur;
	public Yoga(User user, String FriendPseudonyme) {
		Yoga.user = user;
		Yoga.FriendPseudonyme = FriendPseudonyme;
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(147, 191, 207));
		frame.setBounds(100, 100,794, 577);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		 
		JPanel boutonChoisi = new JPanel();
		boutonChoisi.setBackground(new Color(147, 191, 207));
		boutonChoisi.setLayout(null);
		boutonChoisi.setBounds(173, 0, 637, 544);
		frame.getContentPane().add(boutonChoisi);
		
		JTextField textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(171, 173, 179)));
		textField.setColumns(10);
		textField.setBounds(60, 23, 388, 21);
		boutonChoisi.add(textField);
		
		JButton btnRechercher = new JButton("Rechercher");
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
		
		btnRechercher.setBorder(null);
		btnRechercher.setBackground(Color.WHITE);
		btnRechercher.setBounds(464, 22, 85, 21);
		boutonChoisi.add(btnRechercher);
		//
		
		
	    

       
		
		
		JPanel navigationBar = new JPanel();
		navigationBar.setLayout(null);
		navigationBar.setBackground(new Color(96, 150, 180));
		navigationBar.setBounds(0, 0, 174, 671);
		frame.getContentPane().add(navigationBar);
		
		
		JButton pseudoUser = new JButton(CompareAmis.user.getPseudo());
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
		btnAccueil.setHorizontalTextPosition(JButton.RIGHT);
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
		btnAccueil.setBounds(5, 103, 93, 36);
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
		btnDiagrammes.setForeground(Color.WHITE);
		btnDiagrammes.setBounds(5, 229, 104, 36);
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
		btnProfil.setHorizontalTextPosition(JButton.RIGHT);
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
		btnSeDeconnecter.setFont(new Font("Times New Roman", Font.BOLD, 17));
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
		btnAmis.setForeground(Color.WHITE);
		btnAmis.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAmis.setBorder(null);
		btnAmis.setBackground(new Color(96, 150, 180));
		btnAmis.setBounds(1, 267, 90, 36);
		navigationBar.add(btnAmis);
		
		ImageIcon icon61 =new ImageIcon(getClass().getResource("/images/rapport-32.png"));
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
		btnMjrActivits1.setBounds(-16, 367, 148, 36);
		navigationBar.add(btnMjrActivits1);
		
		ImageIcon icon7 = new ImageIcon(getClass().getResource("/images/compare.png"));
		btnProfil.setHorizontalTextPosition(JButton.RIGHT);
		JButton btnCompamis = new JButton("Compare Amis",icon7);
		btnCompamis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = pseudoUser.getText();
				CompareGrapheAmis.main(new String[] {pseudoUtilisateur});
				frame.setVisible(false);
				dispose();
			} 
		});
		btnCompamis.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCompamis.setForeground(Color.BLACK);
		btnCompamis.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnCompamis.setBorder(null);
		btnCompamis.setBackground(Color.WHITE);
		btnCompamis.setBounds(10, 413, 142, 36);
		navigationBar.add(btnCompamis);
		btnAmis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = pseudoUser.getText();
				AmisW.main(new String[] {pseudoUtilisateur});
				frame.setVisible(false);
				dispose();
			}
		});
		
		JLabel lblNewLabel = new JLabel("Comparaison entre "+CompareAmis.FriendPseudonyme+ " et " +CompareAmis.user.getPseudo());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(44, 69, 233, 21);
		boutonChoisi.add(lblNewLabel);
		
		
		JButton btnNewButton = new JButton("Durée");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = pseudoUser.getText();
				DureeHiYoga.main(new String[] {pseudoUtilisateur});
				
			}
		});
		btnNewButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnNewButton.setFont(new Font("Segoe UI Emoji", Font.BOLD, 15));
		btnNewButton.setBounds(88, 149, 145, 85);
		boutonChoisi.add(btnNewButton);
		
		JButton btnDistance = new JButton("etatEsprit");
		btnDistance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = pseudoUser.getText();
				CourbeRtatEspritYoga.main(new String[] {pseudoUtilisateur});
				
			}
		});
		btnDistance.setFont(new Font("Segoe UI Emoji", Font.BOLD, 15));
		btnDistance.setBounds(355, 149, 145, 85);
		boutonChoisi.add(btnDistance);
		
		JButton btnVvitesse = new JButton("Repetition");
		btnVvitesse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = pseudoUser.getText();
				CamembertRepetitionYoga.main(new String[] {pseudoUtilisateur});
				
			}
		});
		btnVvitesse.setFont(new Font("Segoe UI Emoji", Font.BOLD, 15));
		btnVvitesse.setBounds(213, 287, 145, 85);
		boutonChoisi.add(btnVvitesse);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = pseudoUser.getText();
				CompareAmis.main(new String[] {pseudoUtilisateur});
				frame.setVisible(false);
				dispose();
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(20, 108, 148));
		btnNewButton_1.setBounds(464, 490, 117, 31);
		boutonChoisi.add(btnNewButton_1);
		
	}
}
