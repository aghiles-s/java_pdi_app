package Projet;
import Sports.User;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Profil extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final boolean True = false;
	private JPanel contentPane;
	private JTextField textField_Rech;
	private JFrame frame;
	/**
	 * Launch the application.
	 */
	 private String pseudoUtilisateur;

		public static void main(String[] args) {
			String pseudoUtilisateur =null;
		    if (args != null && args.length > 0) {
		        pseudoUtilisateur = args[0];
		    }
		    Profil frame = new Profil(pseudoUtilisateur);
		    
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
	 * @return 
	 */
		public Profil(String pseudoUtilisateur) {
			this.pseudoUtilisateur = pseudoUtilisateur;
			
			initialize();
		  }
		private void initialize() {
			frame = new JFrame();
			
			this.pseudoUtilisateur=pseudoUtilisateur;
			User user = Select.findUser1(pseudoUtilisateur);
		
		
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setText(lblNewLabel.getText() + pseudoUtilisateur);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(32, 49, 121, 29);
		navigationBar.add(lblNewLabel);

		
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/accueil.png"));
		JButton btnAccueil = new JButton("Accueil", icon);
		btnAccueil.setHorizontalTextPosition(JButton.RIGHT);
		btnAccueil.setForeground(Color.WHITE);
		btnAccueil.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAccueil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = lblNewLabel.getText();
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
				String pseudoUtilisateur = lblNewLabel.getText();
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
		btnProfil.setForeground(Color.BLACK);
		btnProfil.setBounds(5, 149, 81, 36);
		btnProfil.setBorder(null);
		btnProfil.setBackground(Color.WHITE);
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
		btnAmis.setBounds(-28, 267, 147, 36);
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
		btnMjrActivits1.setBounds(-12, 363, 148, 36);
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
		btnCompamis.setBounds(17, 409, 136, 36);
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
		
		JLabel nomLabel = new JLabel("Nom :");
		nomLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		nomLabel.setBounds(152, 97, 85, 21);
		boutonChoisi.add(nomLabel);
		
		JLabel PrenomLabel = new JLabel("Prénom :");
		PrenomLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		PrenomLabel.setBounds(152, 118, 85, 21);
		boutonChoisi.add(PrenomLabel);
		
		JLabel ageLabel = new JLabel("Âge :");
		ageLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		ageLabel.setBounds(152, 181, 85, 21);
		boutonChoisi.add(ageLabel);
		
		JLabel emailLabel = new JLabel("Email :");
		emailLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		emailLabel.setBounds(152, 139, 85, 21);
		boutonChoisi.add(emailLabel);
		
		JLabel pseudoLabel = new JLabel("Pseudo :");
		pseudoLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		pseudoLabel.setBounds(152, 76, 85, 21);
		boutonChoisi.add(pseudoLabel);
		
		JLabel tailleLabel = new JLabel("Taille :");
		tailleLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		tailleLabel.setBounds(152, 223, 85, 21);
		boutonChoisi.add(tailleLabel);
		
		JLabel poidsLabel = new JLabel("Poids :");
		poidsLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		poidsLabel.setBounds(152, 244, 85, 21);
		boutonChoisi.add(poidsLabel);
		
		JLabel telLabel = new JLabel("Téléphone :");
		telLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		telLabel.setBounds(152, 160, 85, 21);
		boutonChoisi.add(telLabel);
		
		JLabel sexeLabel = new JLabel("Sexe :");
		sexeLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		sexeLabel.setBounds(152, 202, 85, 21);
		boutonChoisi.add(sexeLabel);
		
		JLabel pseudoresultLabel = new JLabel(user.getPseudo());
		pseudoresultLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pseudoresultLabel.setBounds(276, 76, 198, 21);
		boutonChoisi.add(pseudoresultLabel);
		
		JLabel nomresultLabel = new JLabel(user.getNomUser());
		nomresultLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nomresultLabel.setBounds(276, 97, 198, 21);
		boutonChoisi.add(nomresultLabel);
		
		JLabel prenomresultLabel = new JLabel(user.getPrenomUser());
		prenomresultLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		prenomresultLabel.setBounds(276, 118, 198, 21);
		boutonChoisi.add(prenomresultLabel);
		
		JLabel mailresultLabel = new JLabel(user.getEmail());
		mailresultLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		mailresultLabel.setBounds(276, 139, 198, 21);
		boutonChoisi.add(mailresultLabel);
		
		JLabel ageresultLabel = new JLabel(String.valueOf(user.getAge()));
		ageresultLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ageresultLabel.setBounds(276, 181, 198, 21);
		boutonChoisi.add(ageresultLabel);
		
		JLabel tailleresultLabel = new JLabel(String.valueOf(user.getTaille()));
		tailleresultLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tailleresultLabel.setBounds(276, 223, 198, 21);
		boutonChoisi.add(tailleresultLabel);
		
		JLabel poidsresultLabel = new JLabel(String.valueOf(user.getPoids()));
		poidsresultLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		poidsresultLabel.setBounds(276, 244, 198, 21);
		boutonChoisi.add(poidsresultLabel);
		
		JLabel telresultLabel = new JLabel(user.getTel());
		telresultLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		telresultLabel.setBounds(276, 160, 198, 21);
		boutonChoisi.add(telresultLabel);
		
		JLabel sexeresultLabel = new JLabel(user.getSexe());
		sexeresultLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		sexeresultLabel.setBounds(276, 202, 198, 21);
		boutonChoisi.add(sexeresultLabel);
		
		JButton modifBtn = new JButton("Modifier\r\n");
		modifBtn.setForeground(new Color(255, 255, 255));
		modifBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifierProfil modifprofil = new ModifierProfil(pseudoUtilisateur);
				modifprofil.setVisible(true);
				dispose();
			}
		});
		modifBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		modifBtn.setBackground(new Color(20, 108, 148));
		modifBtn.setBounds(431, 492, 118, 36);
		boutonChoisi.add(modifBtn);
		
		JLabel suggestLabel = new JLabel("Suggestions :");
		suggestLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		suggestLabel.setBounds(84, 297, 118, 21);
		boutonChoisi.add(suggestLabel);
		
		JLabel profilLabel = new JLabel("Profil :");
		profilLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		profilLabel.setBounds(84, 55, 118, 21);
		boutonChoisi.add(profilLabel);
		
		
		User UserSuggere1 = Select.findRandomUser(pseudoUtilisateur);
		User UserSuggere2 = Select.findRandomUser(pseudoUtilisateur);
		if (UserSuggere1.getSexe().equals("f") || UserSuggere1.getSexe().equals("F")) {
			JLabel photoUserF = new JLabel("");
			photoUserF.setIcon(new ImageIcon(getClass().getResource("/images/avatar_femme.png")));
			photoUserF.setHorizontalAlignment(SwingConstants.CENTER);
			photoUserF.setBounds(152, 329, 112, 112);
			boutonChoisi.add(photoUserF);
			JButton user1_pseudo = new JButton(UserSuggere1.getPseudo());
			user1_pseudo.setBorder(null);
			user1_pseudo.setBackground(new Color(255,255,255));
			user1_pseudo.setBounds(152, 451, 112, 21);
			boutonChoisi.add(user1_pseudo);
			user1_pseudo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Ami ami = new Ami(user,user1_pseudo.getText());
					ami.setVisible(true);
					dispose();
				}
			});
		}
		else {
			JLabel photoUserF = new JLabel("");
			photoUserF.setIcon(new ImageIcon(getClass().getResource("/images/avatar_homme.png")));
			photoUserF.setHorizontalAlignment(SwingConstants.CENTER);
			photoUserF.setBounds(152, 329, 112, 112);
			boutonChoisi.add(photoUserF);
			JButton user1_pseudo = new JButton(UserSuggere1.getPseudo());
			user1_pseudo.setBorder(null);
			user1_pseudo.setBackground(new Color(255,255,255));
			user1_pseudo.setBounds(152, 451, 112, 21);
			boutonChoisi.add(user1_pseudo);
			user1_pseudo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Ami ami = new Ami(user,user1_pseudo.getText());
					ami.setVisible(true);
					dispose();
				}
			});
		}
		
		if (UserSuggere2.getSexe().equals("h") || UserSuggere2.getSexe().equals("H")) {
			JLabel PhotoUserH = new JLabel("");
			PhotoUserH.setIcon(new ImageIcon(getClass().getResource("/images/avatar_homme.png")));
			PhotoUserH.setHorizontalAlignment(SwingConstants.CENTER);
			PhotoUserH.setBounds(320, 329, 112, 112);
			boutonChoisi.add(PhotoUserH);
			JButton user2_pseudo = new JButton(UserSuggere2.getPseudo());
			user2_pseudo.setBorder(null);
			user2_pseudo.setBackground(new Color(255,255,255));
			user2_pseudo.setBounds(320, 451, 112, 21);
			boutonChoisi.add(user2_pseudo);
			user2_pseudo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Ami ami = new Ami(user,user2_pseudo.getText());
					ami.setVisible(true);
					dispose();
				}
			});
		}
		else {
			JLabel PhotoUserH = new JLabel("");
			PhotoUserH.setIcon(new ImageIcon(getClass().getResource("/images/avatar_femme.png")));
			PhotoUserH.setHorizontalAlignment(SwingConstants.CENTER);
			PhotoUserH.setBounds(320, 329, 112, 112);
			boutonChoisi.add(PhotoUserH);
			JButton user2_pseudo = new JButton(UserSuggere2.getPseudo());
			user2_pseudo.setBorder(null);
			user2_pseudo.setBackground(new Color(255,255,255));
			user2_pseudo.setBounds(320, 451, 112, 21);
			boutonChoisi.add(user2_pseudo);
			user2_pseudo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Ami ami = new Ami(user,user2_pseudo.getText());
					ami.setVisible(true);
					dispose();
				}
			});
		}
		
	}
}