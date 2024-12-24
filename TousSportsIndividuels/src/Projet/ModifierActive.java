package Projet;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Sports.User;
import java.awt.Color;
import javax.swing.border.LineBorder;

import MJAActivite.ACTEquitation;
import MJAActivite.ActJogging;
import MJAActivite.ActKayak;
import MJAActivite.ActMusculation;
import MJAActivite.ActTir;
import MJAActivite.ActYoga;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class ModifierActive extends JFrame {
	private JPanel contentPane;
	private JFrame frame;
	private JTextField textField_Rech;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
			String pseudoUtilisateur = null;
		    if (args != null && args.length > 0) {
		        pseudoUtilisateur = args[0];
		    }
		    ModifierActive window = new ModifierActive(pseudoUtilisateur);
		    //appeler la méthode setVisible() en dehors de la classe ModifierActive
		    //car window.frame est défini en privé et ne peut pas être appelé depuis l'extérieur de la classe
		    //on utilise donc simplement la variable window qui contient déjà notre instance de ModifierActive
		    window.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	private String pseudoUtilisateur;
	public ModifierActive(String pseudoUtilisateur) {
		this.pseudoUtilisateur=pseudoUtilisateur;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame frame = new JFrame();
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
	JPanel boutonChoisi = new JPanel();
	boutonChoisi.setBackground(new Color(147, 191, 207));
	boutonChoisi.setBounds(173, 0, 637, 544);
	contentPane.add(boutonChoisi);
	boutonChoisi.setLayout(null);
	
	navigationBar.setBounds(0, 0, 174, 544);
	contentPane.add(navigationBar);
	navigationBar.setLayout(null);
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
	JLabel lblNewLabel = new JLabel("");
	lblNewLabel.setText(lblNewLabel.getText() + pseudoUtilisateur);
	lblNewLabel.setForeground(new Color(255, 255, 255));
	lblNewLabel.setBounds(32, 49, 121, 29);
	navigationBar.add(lblNewLabel);
	
	ImageIcon icon = new ImageIcon(getClass().getResource("/images/accueil.png"));
	JButton btnAccueil = new JButton("Accueil", icon);
	btnAccueil.setHorizontalTextPosition(SwingConstants.LEADING);
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
	
	
	ImageIcon icon3 =new ImageIcon(getClass().getResource("/images/profil.png"));
	JButton btnProfil = new JButton("Profil",icon3);
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
			String pseudoUtilisateur = lblNewLabel.getText();
			ModifierActive.main(new String[] {pseudoUtilisateur});
			frame.setVisible(false);
			dispose();
		}
	});
	btnMjrActivits1.setHorizontalTextPosition(SwingConstants.RIGHT);
	btnMjrActivits1.setForeground(Color.BLACK);
	btnMjrActivits1.setFont(new Font("Times New Roman", Font.BOLD, 15));
	btnMjrActivits1.setBorder(null);
	btnMjrActivits1.setBackground(Color.WHITE);
	btnMjrActivits1.setBounds(8, 371, 121, 36);
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
	btnCompamis.setBounds(18, 417, 135, 36);
	navigationBar.add(btnCompamis);
	btnAmis.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String pseudoUtilisateur = lblNewLabel.getText();
			AmisW.main(new String[] {pseudoUtilisateur});
			frame.setVisible(false);
			dispose();
		}
	});
	

	
	
	JButton btnNewButton = new JButton("Equitation");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String pseudoUtilisateur = lblNewLabel.getText();
			ACTEquitation.main(new String[] {pseudoUtilisateur});
			
		}
	});
	btnNewButton.setBounds(90, 188, 150, 50);
	boutonChoisi.add(btnNewButton);
	
	JButton btnYoga = new JButton("Yoga");
	btnYoga.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String pseudoUtilisateur = lblNewLabel.getText();
			ActYoga.main(new String[] {pseudoUtilisateur});
			
		}
	});
	btnYoga.setBounds(90, 303, 150, 50);
	boutonChoisi.add(btnYoga);
	
	JButton btnKayak = new JButton("Kayak");
	btnKayak.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String pseudoUtilisateur = lblNewLabel.getText();
			ActKayak.main(new String[] {pseudoUtilisateur});
					}
	});
	btnKayak.setBounds(90, 416, 150, 50);
	boutonChoisi.add(btnKayak);
	
	JButton btnTirALarc = new JButton("Tir a l'arc");
	btnTirALarc.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String pseudoUtilisateur = lblNewLabel.getText();
			ActTir.main(new String[] {pseudoUtilisateur});
					
		}
	});
	btnTirALarc.setBounds(365, 188, 150, 50);
	boutonChoisi.add(btnTirALarc);
	
	JButton btnMusculation = new JButton("Musculation");
	btnMusculation.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String pseudoUtilisateur = lblNewLabel.getText();
			ActMusculation.main(new String[] {pseudoUtilisateur});
		}
	});
	btnMusculation.setBounds(365, 303, 150, 50);
	boutonChoisi.add(btnMusculation);
	
	JButton btnJogging = new JButton("Jogging");
	btnJogging.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String pseudoUtilisateur = lblNewLabel.getText();
			ActJogging.main(new String[] {pseudoUtilisateur});
		}
	});
	btnJogging.setBounds(365, 416, 150, 50);
	boutonChoisi.add(btnJogging);

	
	
	}

}
