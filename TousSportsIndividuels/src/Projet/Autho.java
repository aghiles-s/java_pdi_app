package Projet;


import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;



public class Autho extends JFrame  {

	//public static final String Pseudo = "";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String pseudo;
	private JFrame frame;
	private JTextField txtPseudo;
	private JPasswordField passwordField;
	
	/**
	 * Launch the application.
	 */
	
	public static void setPseudo(String pseudo) {
		Autho.pseudo = pseudo;
	  }

	  public static String getPseudo() {
	    return pseudo;
	  }
	

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Autho window = new Autho();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
	} 
	/**
	 * Create the application.
	 */
	public Autho() {
		 
		initialize();
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);
		
		txtPseudo = new JTextField();
		txtPseudo.setBounds(480, 208, 298, 39);
		txtPseudo.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(txtPseudo);
		txtPseudo.setColumns(10);
		frame.setResizable(false);
		
		JButton btnNewButton = new JButton("Se connecter");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(20, 108, 148));
		btnNewButton.setBounds(496, 385, 110, 30);
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.setBounds(100, 100, 826, 573);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {	
				String pseudo = txtPseudo.getText();
				//Autho.setPseudo(pseudo);
				String password = new String(passwordField.getPassword());
				
				if(txtPseudo.getText().equals("")) {
				    Component[] components = frame.getContentPane().getComponents();
				    for(Component component : components) {
				        if(component instanceof JLabel) {
				            frame.getContentPane().remove(component);
				        }
				    }
				    JLabel lblNewLabel_3 = new JLabel();
				    lblNewLabel_3.setBounds(480, 362, 298, 13);
				    lblNewLabel_3.setForeground(Color.RED); 
				    frame.getContentPane().add(lblNewLabel_3);
				    lblNewLabel_3.setText("Veuillez remplir le champ Pseudo et Mot de passe");
				
		 		}else if(txtPseudo.getText().equals("")|| passwordField.getText().equals("")) {
				    Component[] components = frame.getContentPane().getComponents();
				    for(Component component : components) {
				        if(component instanceof JLabel) {
				            frame.getContentPane().remove(component);
				        }
				    }
				    JLabel lblNewLabel_3 = new JLabel();
				    lblNewLabel_3.setBounds(480, 362, 298, 13);
				    lblNewLabel_3.setForeground(Color.RED); 
				    frame.getContentPane().add(lblNewLabel_3);
				    lblNewLabel_3.setText("Veuillez remplir le champ Pseudo");
				
				} else if(passwordField.getText().equals("")) {
				    Component[] components = frame.getContentPane().getComponents();
				    for(Component component : components) {
				        if(component instanceof JLabel) {
				            frame.getContentPane().remove(component);
				        }
				    }
				    JLabel lblNewLabel_3 = new JLabel();
				    lblNewLabel_3.setBounds(480, 362, 298, 13);
				    lblNewLabel_3.setForeground(Color.RED); 
				    frame.getContentPane().add(lblNewLabel_3);
				    lblNewLabel_3.setText("Veuillez remplir le champ Mot de passe");
				
				} else if(Select.findUser(pseudo,password)== null) {
				    Component[] components = frame.getContentPane().getComponents();
				    for(Component component : components) {
				        if(component instanceof JLabel) {
				            frame.getContentPane().remove(component);
				        }
				    }
				    JLabel lblNewLabel_3 = new JLabel();
				    lblNewLabel_3.setBounds(480, 362, 298, 13);
				    lblNewLabel_3.setForeground(Color.RED); 
				    frame.getContentPane().add(lblNewLabel_3);
				    lblNewLabel_3.setText("pseudo ou mot de passe invalide");
				


				}else {	
					
					 String pseudoUtilisateur = txtPseudo.getText();
					Accueil con = new Accueil(pseudoUtilisateur);
				    con.setVisible(true);
				    ((JFrame) SwingUtilities.getWindowAncestor(btnNewButton)).dispose();   
				    
				    
				   
						
				}	
		}
			
		});
		frame.getContentPane().add(btnNewButton);
		
		
		
		
		JButton btnSinscrire = new JButton("Sinscrire");
		btnSinscrire.setBackground(new Color(20, 108, 148));
		btnSinscrire.setForeground(Color.WHITE);
		btnSinscrire.setBounds(662, 385, 102, 30);
		btnSinscrire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPseudo.setText(null);
				passwordField.setText(null);
				
				inscription ins = new inscription();
		        ins.setVisible(true);
		        ((JFrame) SwingUtilities.getWindowAncestor(btnSinscrire)).dispose();				
			}

			
		});
		btnSinscrire.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSinscrire.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(btnSinscrire);
		
		JLabel lblNewLabel = new JLabel("Pseudo");
		lblNewLabel.setBounds(480, 164, 99, 34);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setBounds(480, 270, 171, 34);
		lblMotDePasse.setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.getContentPane().add(lblMotDePasse);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(480, 314, 298, 39);
		passwordField.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("    Tous sports individuels");
		lblNewLabel_2.setBounds(261, 10, 371, 100);
		lblNewLabel_2.setForeground(new Color(34, 109, 104));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(43, 80, 316, 429);
		
		ImageIcon iconYoga = new ImageIcon(new ImageIcon(getClass().getResource("/images/spo.jpg.png")).getImage().getScaledInstance(300, 300, 30));
		lblNewLabel_1.setIcon(iconYoga);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnSortir = new JButton("Sortir");
		btnSortir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnSortir.setForeground(Color.WHITE);
		btnSortir.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSortir.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSortir.setBackground(new Color(20, 108, 148));
		btnSortir.setBounds(576, 451, 102, 30);
		frame.getContentPane().add(btnSortir);
		
		
		
		
	}
}
