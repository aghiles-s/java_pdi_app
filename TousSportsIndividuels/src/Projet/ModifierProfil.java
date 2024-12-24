package Projet;

import java.awt.EventQueue; 

import Sports.User;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.hibernate.Session;
import org.hibernate.Transaction;

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
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;


public class ModifierProfil extends JFrame {
	private JFrame frame;
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_Rech;
	private JTextField textField_pseudo;
	private JTextField textField_nom;
	private JTextField textField_prenom;
	private JTextField textField_email;
	private JTextField textField_tel;
	private JTextField textField_age;
	private JTextField textField_sexe;
	private JTextField textField_taille;
	private JTextField textField_poids;
	private JPasswordField Field_mdps;
	private JPasswordField Field_newmdps;
	/**
	 * Launch the application.
	 */
	  private String pseudoUtilisateur;
	public static void main(String[] args) {
		String pseudoUtilisateur = null;
	    if (args != null && args.length > 0) {
	        pseudoUtilisateur = args[0];
	    }
	    ModifierProfil frame = new ModifierProfil(pseudoUtilisateur);
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
	public ModifierProfil(String pseudoUtilisateur) {
		this.pseudoUtilisateur = pseudoUtilisateur;
		initialize();
	  }
	private void initialize() {
		frame = new JFrame();
		
		
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
		btnProfil.setBounds(5, 149, 89, 36);
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
		btnMjrActivits1.setBounds(-12, 359, 148, 36);
		navigationBar.add(btnMjrActivits1);
		
		ImageIcon icon7 = new ImageIcon(getClass().getResource("/images/compare.png"));
		btnProfil.setHorizontalTextPosition(JButton.RIGHT);
		JButton btnCompamis = new JButton("Compare Amis",icon7);
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
		btnCompamis.setBounds(10, 405, 143, 36);
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
		
		
		
		JLabel nomLabel = new JLabel("Nom :");
		nomLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nomLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		nomLabel.setBounds(114, 102, 85, 21);
		boutonChoisi.add(nomLabel);
		
		JLabel PrenomLabel = new JLabel("Prénom :");
		PrenomLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		PrenomLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		PrenomLabel.setBounds(114, 134, 85, 21);
		boutonChoisi.add(PrenomLabel);
		
		JLabel ageLabel = new JLabel("Âge :");
		ageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		ageLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		ageLabel.setBounds(114, 230, 85, 21);
		boutonChoisi.add(ageLabel);
		
		JLabel emailLabel = new JLabel("Email :");
		emailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		emailLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		emailLabel.setBounds(114, 166, 85, 21);
		boutonChoisi.add(emailLabel);
		
		JLabel pseudoLabel = new JLabel("Pseudo :");
		pseudoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		pseudoLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		pseudoLabel.setBounds(114, 70, 85, 21);
		boutonChoisi.add(pseudoLabel);
		
		JLabel tailleLabel = new JLabel("Taille :");
		tailleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		tailleLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		tailleLabel.setBounds(114, 294, 85, 21);
		boutonChoisi.add(tailleLabel);
		
		JLabel poidsLabel = new JLabel("Poids :");
		poidsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		poidsLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		poidsLabel.setBounds(114, 326, 85, 21);
		boutonChoisi.add(poidsLabel);
		
		JLabel telLabel = new JLabel("Téléphone :");
		telLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		telLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		telLabel.setBounds(114, 198, 85, 21);
		boutonChoisi.add(telLabel);
		
		JLabel sexeLabel = new JLabel("Sexe :");
		sexeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		sexeLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		sexeLabel.setBounds(114, 262, 85, 21);
		boutonChoisi.add(sexeLabel);
		
		JButton modifBtn = new JButton("Enregistrer");
		modifBtn.addActionListener(new ActionListener() {
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
			if(Field_mdps.getText().equals(Field_newmdps.getText())) {
				
				Session session = DBConnection.getSession();
				Transaction Transaction = null;
				// Code Hibernate a mettre dans la classe Select et renommer a Query //
				//-------------------------------------------------------------------//
				Transaction = session.beginTransaction();
				
				user.setPseudo(textField_pseudo.getText());
				user.setNomUser(textField_nom.getText());
				user.setPrenomUser(textField_prenom.getText());
				user.setEmail(textField_email.getText());
				user.setTel(textField_tel.getText());
				user.setAge(Integer.valueOf(textField_age.getText()));
				user.setSexe(textField_sexe.getText());
				user.setTaille(Double.valueOf(textField_taille.getText()));
				user.setPoids(Double.valueOf(textField_poids.getText()));
				user.setMdps(Field_mdps.getText());
				session.update(user);
	            Transaction.commit();
				
	            String pseudoUtilisateur = lblNewLabel.getText();
				Profil.main(new String[] {pseudoUtilisateur});
				frame.setVisible(false);
				dispose();
				//--------------------------------------------------------------------//
				//user = Select.updateUser(textField_nom.getText(),textField_prenom.getText(),textField_pseudo.getText(),Integer.valueOf(textField_age.getText()),Double.valueOf(textField_taille.getText()),Double.valueOf(textField_poids.getText()),textField_sexe.getText(),textField_email.getText(),textField_tel.getText(),Field_mdps.getText());
			
			} else {
				JLabel LabelverifMdps = new JLabel("");
				LabelverifMdps.setHorizontalAlignment(SwingConstants.RIGHT);
				LabelverifMdps.setFont(new Font("Tahoma", Font.BOLD, 10));
				LabelverifMdps.setForeground(new Color(255, 0, 0));
				LabelverifMdps.setBounds(246, 412, 126, 14);
				boutonChoisi.add(LabelverifMdps);
				
				LabelverifMdps.setText("Mot de passe invalide !");
				}
			}
		});
		
		
		modifBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		modifBtn.setBorder(null);
		modifBtn.setForeground(Color.WHITE);
		modifBtn.setBackground(new Color(20, 108, 148));
		modifBtn.setBounds(285, 492, 118, 36);
		boutonChoisi.add(modifBtn);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = lblNewLabel.getText();
				Profil.main(new String[] {pseudoUtilisateur});
				frame.setVisible(false);
				dispose();
			}
		});
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAnnuler.setBorder(null);
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setBackground(new Color(20, 108, 148));
		btnAnnuler.setBounds(431, 492, 118, 36);
		boutonChoisi.add(btnAnnuler);
		
		JLabel mdpsLabel = new JLabel("Nouveau MDPS :");
		mdpsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		mdpsLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		mdpsLabel.setBounds(81, 358, 118, 21);
		boutonChoisi.add(mdpsLabel);
		
		JLabel newmdpsLabel = new JLabel("Confirmer le MDPS :");
		newmdpsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		newmdpsLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		newmdpsLabel.setBounds(60, 390, 139, 21);
		boutonChoisi.add(newmdpsLabel);
		
		textField_pseudo = new JTextField(user.getPseudo());
		textField_pseudo.setEditable(false);
		textField_pseudo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_pseudo.setBounds(246, 69, 126, 21);
		boutonChoisi.add(textField_pseudo);
		textField_pseudo.setColumns(10);
		
		textField_nom = new JTextField(user.getNomUser());
		textField_nom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_nom.setColumns(10);
		textField_nom.setBounds(246, 101, 126, 21);
		boutonChoisi.add(textField_nom);
		
		textField_prenom = new JTextField(user.getPrenomUser());
		textField_prenom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_prenom.setColumns(10);
		textField_prenom.setBounds(246, 135, 126, 21);
		boutonChoisi.add(textField_prenom);
		
		textField_email = new JTextField(user.getEmail());
		textField_email.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_email.setColumns(10);
		textField_email.setBounds(246, 167, 126, 21);
		boutonChoisi.add(textField_email);
		
		textField_tel = new JTextField(user.getTel());
		textField_tel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_tel.setColumns(10);
		textField_tel.setBounds(246, 199, 126, 21);
		boutonChoisi.add(textField_tel);
		
		textField_age = new JTextField(String.valueOf(user.getAge()));
		textField_age.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_age.setColumns(10);
		textField_age.setBounds(246, 231, 126, 21);
		boutonChoisi.add(textField_age);
		
		textField_sexe = new JTextField(user.getSexe());
		textField_sexe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_sexe.setColumns(10);
		textField_sexe.setBounds(246, 263, 126, 21);
		boutonChoisi.add(textField_sexe);
		
		textField_taille = new JTextField(String.valueOf(user.getTaille()));
		textField_taille.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_taille.setColumns(10);
		textField_taille.setBounds(246, 295, 126, 21);
		boutonChoisi.add(textField_taille);
		
		textField_poids = new JTextField(String.valueOf(user.getPoids()));
		textField_poids.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_poids.setColumns(10);
		textField_poids.setBounds(246, 327, 126, 21);
		boutonChoisi.add(textField_poids);
		
		Field_mdps = new JPasswordField(user.getMdps());
		Field_mdps.setBounds(246, 359, 126, 20);
		boutonChoisi.add(Field_mdps);
		
		Field_newmdps = new JPasswordField(user.getMdps());
		Field_newmdps.setBounds(246, 391, 126, 20);
		boutonChoisi.add(Field_newmdps);
	}
}