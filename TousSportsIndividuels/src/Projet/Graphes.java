package Projet;

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
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import Graphe.Equitation;
import Graphe.Jogging;

import Graphe.Musculation;
import Graphe.Tir_a_arc;
import Graphe.Yoga;
import Sports.User;

import javax.swing.SwingConstants;

public class Graphes extends JFrame {
	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_Rech;
	 private static final long serialVersionUID = 1L;
	    
	/**
	 * Launch the application.
	 */
	 private String pseudoUtilisateur;
	public static void main(String[] args) {
		String pseudoUtilisateur = null;
	    if (args != null && args.length > 0) {
	        pseudoUtilisateur = args[0];
	    }
	    Graphes window = new Graphes(pseudoUtilisateur);
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
	
	public void setFrameVisible(boolean visible) {
        this.setVisible(visible);
    }
	/*
	 * Create the application.
	 */
	public Graphes(String pseudoUtilisateur) {
		this.pseudoUtilisateur = pseudoUtilisateur;
	       
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(147, 191, 207));
		frame.setBounds(100, 100, 960, 691);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		
		JPanel navigationBar = new JPanel();
		navigationBar.setLayout(null);
		navigationBar.setBackground(new Color(96, 150, 180));
		navigationBar.setBounds(0, 0, 174, 671);
		frame.getContentPane().add(navigationBar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setText(lblNewLabel.getText() + pseudoUtilisateur);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(32, 49, 121, 29);
		navigationBar.add(lblNewLabel);
		
		
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/accueil.png"));
		JButton btnAccueil = new JButton("Accueil", icon);
		btnAccueil.setHorizontalTextPosition(JButton.RIGHT);
		btnAccueil.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAccueil.setForeground(new Color(255, 255, 255));
		btnAccueil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = lblNewLabel.getText();
				Accueil.main(new String[] {pseudoUtilisateur});
				frame.setVisible(false);
				dispose();
			}
		});
		btnAccueil.setBorder(null);
		btnAccueil.setBackground(new Color(96, 150, 180));
		btnAccueil.setBounds(-11, 140, 121, 36);
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
		btnSports.setForeground(Color.WHITE);
		btnSports.setBorder(null);
		btnSports.setBackground(new Color(96, 150, 180));
		btnSports.setBounds(1, 232, 154, 36);
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
		
		btnDiagrammes.setForeground(Color.BLACK);
		btnDiagrammes.setBorder(null);
		btnDiagrammes.setBackground(Color.WHITE);
		btnDiagrammes.setBounds(9, 278, 92, 36);
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
		btnIMC.setBounds(-9, 370, 164, 36);
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
		btnProfil.setForeground(new Color(255, 255, 255));
		btnProfil.setBounds(-20, 186, 131, 36);
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
		btnSeDeconnecter.setBounds(10, 601, 154, 36);
		navigationBar.add(btnSeDeconnecter);
		
		ImageIcon icon4 = new ImageIcon(getClass().getResource("/images/amis.png"));
		JButton btnAmis = new JButton("Amis",icon4);
		btnAmis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = lblNewLabel.getText();
				AmisW.main(new String[] {pseudoUtilisateur});
				frame.setVisible(false);
				dispose();
			}
		});
		btnProfil.setHorizontalTextPosition(JButton.RIGHT);
		btnAmis.setForeground(Color.WHITE);
		btnAmis.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAmis.setBorder(null);
		btnAmis.setBackground(new Color(96, 150, 180));
		btnAmis.setBounds(-20, 324, 131, 36);
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
		btnMjrActivits1.setBounds(-14, 427, 148, 36);
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
		btnCompamis.setBounds(10, 485, 130, 36);
		navigationBar.add(btnCompamis);
		
		JButton btnNewButton = new JButton("");
		//btnNewButton.setIcon(new ImageIcon(Graphes.class.getResource("/images/yog.jpg")));
		ImageIcon iconYoga = new ImageIcon(new ImageIcon(getClass().getResource("/images/yoga1.png")).getImage().getScaledInstance(220, 200, 30));
		btnNewButton.setIcon(iconYoga);

		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, null, null, null));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = lblNewLabel.getText();
				Yoga.main(new String[] {pseudoUtilisateur});
				frame.setVisible(false);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(20, 108, 148));
		btnNewButton.setBounds(287, 119, 188, 142);
		frame.getContentPane().add(btnNewButton);
		
		JLabel imageYoga = new JLabel("");
		imageYoga.setBounds(313, 121, 80, 154);
		frame.getContentPane().add(imageYoga);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = lblNewLabel.getText();
				Musculation.main(new String[] {pseudoUtilisateur});
				frame.setVisible(false);
				dispose();
			}
		});
		ImageIcon iconMusuclation = new ImageIcon(new ImageIcon(getClass().getResource("/images/musculation2.png")).getImage().getScaledInstance(220, 200, 30));
		btnNewButton_1.setIcon(iconMusuclation);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, null, null, null));
		btnNewButton_1.setBackground(new Color(20, 108, 148));
		btnNewButton_1.setBounds(655, 119, 188, 142);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = lblNewLabel.getText();
				Equitation.main(new String[] {pseudoUtilisateur});
				frame.setVisible(false);
				dispose();
			}
		});
		ImageIcon iconequitation = new ImageIcon(new ImageIcon(getClass().getResource("/images/equitation2.png")).getImage().getScaledInstance(250, 150, 30));
		btnNewButton_2.setIcon(iconequitation);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, null, null, null));
		btnNewButton_2.setBackground(new Color(20, 108, 148));
		btnNewButton_2.setBounds(287, 307, 188, 142);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = lblNewLabel.getText();
				Tir_a_arc.main(new String[] {pseudoUtilisateur});
				frame.setVisible(false);
				dispose();
			}
		});
		ImageIcon icontira = new ImageIcon(new ImageIcon(getClass().getResource("/images/tira2.jpg")).getImage().getScaledInstance(220, 200, 30));
		btnNewButton_2_1.setIcon(icontira);
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, null, null, null));
		btnNewButton_2_1.setBackground(new Color(20, 108, 148));
		btnNewButton_2_1.setBounds(655, 307, 188, 142);
		frame.getContentPane().add(btnNewButton_2_1);
				
		JButton btnNewButton_2_2 = new JButton("");
		ImageIcon iconJogging = new ImageIcon(new ImageIcon(getClass().getResource("/images/Jogging.png")).getImage().getScaledInstance(220, 200, 30));
		btnNewButton_2_2.setIcon(iconJogging);
		btnNewButton_2_2.setForeground(Color.WHITE);
		btnNewButton_2_2.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, null, null, null));
		btnNewButton_2_2.setBackground(new Color(20, 108, 148));
		btnNewButton_2_2.setBounds(287, 484, 188, 142);
		frame.getContentPane().add(btnNewButton_2_2);
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = lblNewLabel.getText();
				Jogging.main(new String[] {pseudoUtilisateur});
				frame.setVisible(false);
				dispose();

			}
		});
		
		JButton btnNewButton_2_3 = new JButton("");
		ImageIcon iconkayak = new ImageIcon(new ImageIcon(getClass().getResource("/images/kayak.jpg")).getImage().getScaledInstance(220, 200, 30));
		btnNewButton_2_3.setIcon(iconkayak);
		btnNewButton_2_3.setForeground(Color.WHITE);
		btnNewButton_2_3.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, null, null, null));
		btnNewButton_2_3.setBackground(new Color(20, 108, 148));
		btnNewButton_2_3.setBounds(655, 484, 188, 142);
		frame.getContentPane().add(btnNewButton_2_3);
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				String pseudoUtilisateur = lblNewLabel.getText();
				//Kayak.main(new String[] {pseudoUtilisateur});
				frame.setVisible(false);
				dispose();

			}
		});
		
		JPanel boutonChoisi = new JPanel();
		boutonChoisi.setBackground(new Color(147, 191, 207));
		boutonChoisi.setLayout(null);
		boutonChoisi.setBounds(171, 0, 894, 710);
		frame.getContentPane().add(boutonChoisi);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(171, 173, 179)));
		textField.setColumns(10);
		textField.setBounds(150, 23, 411, 33);
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
		btnRechercher.setBounds(571, 23, 103, 29);
		boutonChoisi.add(btnRechercher);

		
    }
}
