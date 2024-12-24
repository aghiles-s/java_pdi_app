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
import Activité.ActiviteKayak;
import Activité.ActiviteMusculation;
import Activité.ActiviteTir_a_larc;
import Activité.ActiviteYoga;
import GrapheAmis.GrapheEquitationHi;
import GrapheAmis.GrapheJoggingCo;
import GrapheAmis.GrapheKayakCourbe;
import GrapheAmis.GrapheMusculationHi;
import GrapheAmis.GrapheTirHi;
import GrapheAmis.GrapheYogaCam;
import GrapheConpAmis.Equitation;
import GrapheConpAmis.Jogging;
import GrapheConpAmis.Kayak;
import GrapheConpAmis.Musculation;
import GrapheConpAmis.Tir;
import GrapheConpAmis.Yoga;
import GrapheEquitaCompAmis.GrapheUtiAmis;
import GrapheEquitation.CamembertGraph;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class CompareAmis extends JFrame {
	public static User user;
	public static String FriendPseudonyme;
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
					CompareAmis frame = new CompareAmis(user, FriendPseudonyme);
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
		
		
	public CompareAmis(User user, String FriendPseudonyme) {
		CompareAmis.user = user;
		CompareAmis.FriendPseudonyme = FriendPseudonyme;
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
		btnAmis.setForeground(Color.WHITE);
		btnAmis.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAmis.setBorder(null);
		btnAmis.setBackground(new Color(96, 150, 180));
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
		btnCompamis.setBackground(new Color(255, 255, 255));
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
		
		
		
		
		
	
         
        
		JLabel lblActiv = new JLabel(" Les dernières activités de  " +FriendPseudonyme+ " et " +CompareAmis.user.getPseudo() );
		lblActiv.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblActiv.setBounds(32, 163, 347, 21);
		boutonChoisi.add(lblActiv);
		
		JButton btnNewButton_1 = new JButton("Equitation");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Equitation.main(new String[] {CompareAmis.user.getPseudo(),FriendPseudonyme});
				frame.setVisible(false);
				dispose();
			}
		});
		btnNewButton_1.setBounds(94, 224, 134, 44);
		boutonChoisi.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Jogging");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String FriendPseudonyme = lblNewLabel.getText();
		       Jogging.main(new String[] {FriendPseudonyme});
		       frame.setVisible(false);
				dispose();
			}
		}); 
		btnNewButton_1_1.setBounds(352, 224, 134, 44);
		boutonChoisi.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Kayak");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String FriendPseudonyme = lblNewLabel.getText();
				Kayak.main(new String[] {FriendPseudonyme});
				frame.setVisible(false);
				dispose();
			}
		});
		btnNewButton_1_2.setBounds(94, 313, 134, 44);
		boutonChoisi.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("Musculation");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String FriendPseudonyme = lblNewLabel.getText();
				Musculation.main(new String[] {FriendPseudonyme});
				frame.setVisible(false);
				dispose();
			}
		});
		btnNewButton_1_3.setBounds(352, 313, 134, 44);
		boutonChoisi.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_4 = new JButton("Tir a l'arc");
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String FriendPseudonyme = lblNewLabel.getText();
				Tir.main(new String[] {FriendPseudonyme});
				frame.setVisible(false);
				dispose();
			}
		});
		btnNewButton_1_4.setBounds(94, 411, 134, 44);
		boutonChoisi.add(btnNewButton_1_4);
		
		JButton btnNewButton_1_5 = new JButton("Yoga");
		btnNewButton_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String FriendPseudonyme = lblNewLabel.getText();
				Yoga.main(new String[] {FriendPseudonyme});
				frame.setVisible(false);
				dispose();
			}
		});
		btnNewButton_1_5.setBounds(352, 411, 134, 44);
		boutonChoisi.add(btnNewButton_1_5);
		
		
		
		
		
	}
}
	
