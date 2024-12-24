package Projet;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Sports.User;

import java.awt.SystemColor;


public class Sports extends JFrame  {
	private JPanel contentPane;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_Rech;
	
	public void setFrameVisible(boolean visible) {
        this.setVisible(visible);
    }
	
	private String pseudoUtilisateur;
	public Sports(String pseudoUtilisateur) {
		this.pseudoUtilisateur = pseudoUtilisateur;
		
	    initialize();
	  }

	
	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		String pseudoUtilisateur = null;
	    if (args != null && args.length > 0) {
	        pseudoUtilisateur = args[0];
	    }
	    Sports window = new Sports(pseudoUtilisateur);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//Sports window = new Sports("pseudo");
					window.frame.setVisible(true);
					window.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	


	/**
	 * Create the application.
	 */
	
	
	private void initialize() {
	
	/**
	 * Initialize the contents of the frame.
	 */

		frame = new JFrame();
		frame.setBounds(100, 100, 1069, 708);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		

		
		
		
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
	///////////////////////
		
		
		
		
		JLabel DesJogging = new JLabel();
		DesJogging.setBackground(new Color(189, 205, 214));
		DesJogging.setOpaque(true);
		DesJogging.setFont(new Font("Arial", Font.BOLD, 14));
		DesJogging.setText("<html><div style='text-align: center;'>" +
	                "<b>Le Jogging est une forme de course à pied à un rythme modéré pratiquée pour rester en forme et se détendre. " +
	                "Il est considéré comme accessible et adapté à différents niveaux de forme physique.</b></div></html>");
		DesJogging.setVisible(false);
		//DesJogging.setVerticalAlignment(SwingConstants.TOP);
		//DesJogging.setPreferredSize(new Dimension(300, 100));
		//panel.add(DesJogging);
		
		DesJogging.setBounds(42, 82, 368, 193);
		DesJogging.setVisible(false);
		boutonChoisi.add(DesJogging);

		JButton Jogging = new JButton("Jogging");
		Jogging.setBackground(new Color(238, 233, 218));
		Jogging.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				DesJogging.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				DesJogging.setVisible(false);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});		
		
		Jogging.setFont(new Font("Tahoma", Font.BOLD, 14));
		Jogging.setBorder(null);
		Jogging.setBounds(84, 171, 218, 68);
		boutonChoisi.add(Jogging);
		
		
		
		JLabel DesEquitation = new JLabel();
		DesEquitation.setBackground(new Color(189, 205, 214));
		DesEquitation.setOpaque(true);
		DesEquitation.setFont(new Font("Arial", Font.BOLD, 14));
		DesEquitation.setText("<html><div style='text-align: center;'>" +
				                "<b>Sport de chevauchement comprenant diverses disciplines,il exige de la coordination, de la confiance en soi, " +
				                 "et de la patience,et peut vous offrir une détente et une connexion avec la nature.<b></div></html>");
		DesEquitation.setVisible(false);
		DesEquitation.setBounds(463, 82, 368, 193);
		DesEquitation.setVisible(false);
		boutonChoisi.add(DesEquitation);
		JButton Equitation = new JButton("Equitation");
		
		Equitation.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				DesEquitation.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				DesEquitation.setVisible(false);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		Equitation.setBackground(new Color(238, 233, 218));
		Equitation.setFont(new Font("Tahoma", Font.BOLD, 14));
		Equitation.setBorder(null);
		Equitation.setBounds(557, 171, 218, 68);
		boutonChoisi.add(Equitation);
/////////////////////////////////
		
		JLabel desYoga = new JLabel();
		desYoga.setBackground(new Color(189, 205, 214));
		desYoga.setOpaque(true);
		desYoga.setFont(new Font("Arial", Font.BOLD, 14));
		desYoga.setText("<html><div style='text-align: center;'>" +
	                "<b>Le yoga est une pratique millénaire combinant postures, respiration et attention mentale pour améliorer la force " +
	                "la flexibilité, la stabilité, la respiration, la concentration et la sérénité.Il a des bénéfices pour la santé physique et mentale en réduisant le stress,</b>"
	                + "<b> l'anxiété, la douleur et les tensions musculaireset en améliorant la circulation sanguine, la respiration, la posture et la conscience de soi.<b></div></html>");
		desYoga.setVisible(false);
		desYoga.setBounds(42, 273, 368, 193);
		desYoga.setVisible(false);
		boutonChoisi.add(desYoga);
		
		JButton Yoga = new JButton("Yoga");
		Yoga.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				desYoga.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				desYoga.setVisible(false);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		Yoga.setBackground(new Color(238, 233, 218));
		Yoga.setFont(new Font("Tahoma", Font.BOLD, 14));
		Yoga.setBorder(null);
		Yoga.setBounds(84, 336, 225, 68);
		boutonChoisi.add(Yoga);
		
		
		JLabel DesMusculation = new JLabel();
		DesMusculation.setBackground(new Color(189, 205, 214));
		DesMusculation.setOpaque(true);
		DesMusculation.setFont(new Font("Arial", Font.BOLD, 14));
		DesMusculation.setText("<html><div style='text-align: center;'>" +
				 "<b>Sport de chevauchement comprenant diverses disciplines,il exige de la coordination, de la confiance en soi " +
                "et de la patience,et peut vous offrir une détente et une connexion avec la nature.<b></div></html>");
		DesMusculation.setVisible(false);
		DesMusculation.setBounds(463, 267, 368, 193);
		DesMusculation.setVisible(false);
		boutonChoisi.add(DesMusculation);
		
		JButton Musculation = new JButton("Musculation");
		Musculation.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				DesMusculation.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				DesMusculation.setVisible(false);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		Musculation.setBackground(new Color(238, 233, 218));
		Musculation.setFont(new Font("Tahoma", Font.BOLD, 14));
		Musculation.setBorder(null);
		Musculation.setBounds(557, 336, 225, 68);
		boutonChoisi.add(Musculation);
		
		
		
		JLabel DesTir = new JLabel("");
		DesTir.setBackground(new Color(189, 205, 214));
		DesTir.setOpaque(true);
		DesTir.setFont(new Font("Arial", Font.BOLD, 14));
		DesTir.setText("<html><div style='text-align: center;'>" +
	                "<b>Le Tir à l'Arc est un sport de précisionconsistant à tirer des flèches sur des cibles fixes ou en mouvement à des distances variables avec un arc.  " +
	                "Il peut améliorer la coordination œil-main, la concentration, la patience et la stratégie.</b></div></html>");
		DesTir.setVisible(false);
		DesTir.setBounds(42, 427, 368, 193);
		DesTir.setVisible(false);
		boutonChoisi.add(DesTir);
		JButton btnNewButton_1_1_1_1 = new JButton("Tir à l’arc");
		btnNewButton_1_1_1_1.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				DesTir.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				DesTir.setVisible(false);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton_1_1_1_1.setBackground(new Color(238, 233, 218));
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1_1_1.setBorder(null);
		btnNewButton_1_1_1_1.setBounds(84, 536, 225, 68);
		boutonChoisi.add(btnNewButton_1_1_1_1);
		
		
		
		
		
		JLabel lblNewLabel_5 = new JLabel();
		lblNewLabel_5.setBackground(new Color(189, 205, 214));
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_5.setText("<html><div style='text-align: center;'>" +
	                "<b>Le Canoë-Kayak est un sport nautique consistantà pagayer sur l'eau avec un canoë ou un kayak pour améliorer  " +
	                "la force physique, l'endurance, l'équilibre, la coordination et le bien-être mental.</b></div></html>");
		lblNewLabel_5.setVisible(false);
		lblNewLabel_5.setBounds(463, 414, 368, 193);
		lblNewLabel_5.setVisible(false);
		boutonChoisi.add(lblNewLabel_5);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("Canoë-kayak");
		btnNewButton_1_1_1_1_1.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				lblNewLabel_5.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				lblNewLabel_5.setVisible(false);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton_1_1_1_1_1.setBackground(new Color(238, 233, 218));
		btnNewButton_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1_1_1_1.setBorder(null);
		btnNewButton_1_1_1_1_1.setBounds(557, 536, 218, 68);
		boutonChoisi.add(btnNewButton_1_1_1_1_1);
		
		
		
		
		JPanel navigationBar = new JPanel();
		navigationBar.setLayout(null);
		navigationBar.setBackground(new Color(96, 150, 180));
		navigationBar.setBounds(0, 0, 185, 671);
		frame.getContentPane().add(navigationBar);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setText(lblNewLabel.getText() + pseudoUtilisateur);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(26, 48, 121, 29);
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
				dispose();}
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
		btnSports.setForeground(new Color(0, 0, 0));
		btnSports.setBorder(null);
		btnSports.setBackground(new Color(255, 255, 255));
		btnSports.setBounds(10, 232, 145, 36);
		navigationBar.add(btnSports);
		
		ImageIcon icon2 =new ImageIcon(getClass().getResource("/images/charts.png"));
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
		
		btnDiagrammes.setForeground(Color.WHITE);
		btnDiagrammes.setBorder(null);
		btnDiagrammes.setBackground(new Color(96, 150, 180));
		btnDiagrammes.setBounds(-9, 278, 131, 36);
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
		btnSeDeconnecter.setBounds(10, 616, 154, 36);
		navigationBar.add(btnSeDeconnecter);
		
		ImageIcon icon4 = new ImageIcon(getClass().getResource("/images/amis.png"));
		JButton btnAmis = new JButton("Amis",icon4);
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
		btnMjrActivits1.setBounds(-11, 428, 148, 36);
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
		btnCompamis.setBounds(10, 490, 137, 36);
		navigationBar.add(btnCompamis);
		btnAmis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = lblNewLabel.getText();
				AmisW.main(new String[] {pseudoUtilisateur});
				frame.setVisible(false);
				dispose();

			}
		});
		JButton Modifier = new JButton("Modifier");
		Modifier.setBackground(new Color(20, 108, 148));
		Modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pseudoUtilisateur = lblNewLabel.getText();
				ModifierSports.main(new String[] {pseudoUtilisateur});
				frame.setVisible(false);
				dispose();	
			
			}
		});
		Modifier.setFont(new Font("Tahoma", Font.BOLD, 14));
		Modifier.setForeground(Color.WHITE);
		Modifier.setBounds(702, 617, 133, 45);
		boutonChoisi.add(Modifier);
		
		
		

		
		
		
	}
}
