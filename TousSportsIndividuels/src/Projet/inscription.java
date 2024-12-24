package Projet;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Sports.User;
import Projet.DBConnection;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

public class inscription extends JFrame {

	private JPanel contentPane;
	private JTextField textField_nom;
	private JTextField textField_prenom;
	private JTextField textField_pseudo;
	private JTextField textField_age;
	//private JTextField textField_sexe;
	private String itemSexe;
	private JTextField textField_email;
	private JTextField textField_poids;
	private JTextField taille;
	private JPasswordField textField_mdps;
	private JPasswordField textfieldconfirmmdps;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inscription frame = new inscription();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/*la fonction qui permet de valider un mot de passe en effet le maximum de caracteres est 16,
	 *  le minimum est 8, il doit comporter au moins une majuscule, une miniscule et un caractere special*/
	public static boolean estValide(String mdps) {
		int min =8;
	    int max=16;
	    int chiffre=0;
	    int special=0;
	    int upCount=0;
	    int loCount=0;
		if (mdps.length()>=min&&mdps.length()<=max){   
			for(int i=0;i<mdps.length();i++) {
				char c = mdps.charAt(i);
	            if(Character.isUpperCase(c)){
	                upCount++;
	            }
	            if(Character.isLowerCase(c)){
	                loCount++;
	            }
	            if(Character.isDigit(c)){
	                chiffre++;
	            }
	            if(c>=33&&c<=46||c==64){
	                special++;
	            }
			}
			if(special>=1&&loCount>=1&&upCount>=1&&chiffre>=1){
	            return true;
	        }
        }
		return false;
	}
	
	public static boolean valEmail(String input) {
		String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = emailPat.matcher(input);
		return matcher.find();
	}
	
	public static boolean verifierDisponibilitePseudo(String pseudo) {
		Session session = DBConnection.getSession();
		Transaction readTransaction = session.beginTransaction();
	    Query query = session.createQuery("select count(*) from User where pseudo = :pseudo");
	    query.setParameter("pseudo", pseudo);
	    Long count = (Long) query.uniqueResult();
	    session.close();
	    return count == 0;
	}
	/**
	 * Create the frame.
	 */
	public inscription() {
		JFrame frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 577);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton sInscrire = new JButton("S'inscrire");
		sInscrire.setBackground(new Color(20, 108, 148));
		sInscrire.setFont(new Font("Tahoma", Font.BOLD, 14));
		sInscrire.setBorder(null);
		sInscrire.setForeground(Color.WHITE);
		sInscrire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel champ_ob = new JLabel("");
				champ_ob.setFont(new Font("Tahoma", Font.BOLD, 11));
				champ_ob.setForeground(new Color(255, 0, 0));
				champ_ob.setBounds(389, 347, 342, 13);
				contentPane.add(champ_ob);
				String myPass = String.valueOf(textField_mdps.getPassword());
				String confirmPass = String.valueOf(textfieldconfirmmdps.getPassword());
				if(!textField_nom.getText().isEmpty() && !textField_prenom.getText().isEmpty() && !textField_pseudo.getText().isEmpty() &&
					!textField_age.getText().isEmpty() && !textField_poids.getText().isEmpty() && !taille.getText().isEmpty() 
					&& !textField_email.getText().isEmpty() && !(myPass.isEmpty()) && !(confirmPass.isEmpty())) {
//					System.out.println("yes");
					boolean pseudo = verifierDisponibilitePseudo(textField_pseudo.getText());
					
					String pseudoUtilisateur = textField_pseudo.getText();
					ChoixDesSports.main(new String[] {pseudoUtilisateur});
					frame.setVisible(false);
					dispose();
					//System.out.println(pseudo);
					if(pseudo == true) {
						//System.out.println("yes");
						String email = textField_email.getText();
						System.out.println(valEmail(email));
						if(valEmail(textField_email.getText())) {
							if(estValide(myPass)) { 
								if(myPass.equals(confirmPass)) {
									System.out.println("yes");
									Session session = DBConnection.getSession();
									Transaction persistTransaction1 = session.beginTransaction();
									User user = new User(textField_nom.getText(), textField_prenom.getText(), textField_pseudo.getText(), Integer.parseInt(textField_age.getText()), itemSexe, Double.parseDouble(textField_poids.getText()), Double.parseDouble(taille.getText()), textField_email.getText(), myPass);
									//Very useful, the save method can return an auto-generated Id.
									session.save(user);
									persistTransaction1.commit();
									session.close();
								}else {//confirmation incorrecte
									champ_ob.setText("Confirmation de mot de passe incorrecte");
									//System.out.println("confirmation incorrecte");
								}
							} else {//mdps invalide
								champ_ob.setText("Le mot de passe doit être d'au moins 8 caractères de long");
								JLabel mdps_invalide = new JLabel("");
								mdps_invalide.setForeground(Color.RED);
								mdps_invalide.setFont(new Font("Tahoma", Font.BOLD, 11));
								mdps_invalide.setBounds(389, 365, 342, 13);
								contentPane.add(mdps_invalide);
								mdps_invalide.setText("Le mot de passe doit être d'au plus 16 caractères de long");
								
								JLabel mdps_invalide_1 = new JLabel("");
								mdps_invalide_1.setForeground(Color.RED);
								mdps_invalide_1.setFont(new Font("Tahoma", Font.BOLD, 11));
								mdps_invalide_1.setBounds(389, 382, 342, 13);
								contentPane.add(mdps_invalide_1);
								mdps_invalide_1.setText("Le mot de passe doit contenir au moins une");
								
								JLabel mdps_invalide_3 = new JLabel("");
								mdps_invalide_3.setForeground(Color.RED);
								mdps_invalide_3.setFont(new Font("Tahoma", Font.BOLD, 11));
								mdps_invalide_3.setBounds(389, 399, 342, 13);
								contentPane.add(mdps_invalide_3);
								mdps_invalide_3.setText("majuscule et une miniscule");
								
								JLabel mdps_invalide_2 = new JLabel("");
								mdps_invalide_2.setForeground(Color.RED);
								mdps_invalide_2.setFont(new Font("Tahoma", Font.BOLD, 11));
								mdps_invalide_2.setBounds(389, 416, 342, 13);
								contentPane.add(mdps_invalide_2);
								mdps_invalide_2.setText("Le mot de passe doit contenir au moins un chiffre et un");
								
								JLabel mdps_invalide_4 = new JLabel("");
								mdps_invalide_4.setForeground(Color.RED);
								mdps_invalide_4.setFont(new Font("Tahoma", Font.BOLD, 11));
								mdps_invalide_4.setBounds(389, 433, 342, 13);
								contentPane.add(mdps_invalide_4);
								mdps_invalide_4.setText("caractère special");
								//System.out.println("mdps invalide");
							}
						} else { //email invalide
							champ_ob.setText("Veuillez entrer un e-mail valide");
						}
					} else champ_ob.setText("pseudo indisponible");
				} else {
					champ_ob.setText("Tous les champs sont obligatoires");
				}	
			}
		});
		sInscrire.setBounds(517, 448, 102, 30);
		contentPane.add(sInscrire);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(389, 46, 109, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prénom");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(566, 46, 109, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Pseudo");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(389, 95, 109, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Age");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(389, 144, 109, 25);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Sexe");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(566, 144, 109, 25);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("E-mail");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(389, 241, 109, 25);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Mot de passe");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(389, 292, 109, 25);
		contentPane.add(lblNewLabel_6);
		
		textField_nom = new JTextField();
		textField_nom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_nom.setBounds(389, 71, 165, 25);
		contentPane.add(textField_nom);
		textField_nom.setColumns(10);
		textField_nom.setBorder(BorderFactory.createLineBorder(new Color(102, 153, 204)));
		
		textField_prenom = new JTextField();
		textField_prenom.setBounds(566, 71, 165, 25);
		contentPane.add(textField_prenom);
		textField_prenom.setColumns(10);
		textField_prenom.setBorder(BorderFactory.createLineBorder(new Color(102, 153, 204)));
		
		textField_pseudo = new JTextField();
		textField_pseudo.setBounds(389, 120, 342, 25);
		contentPane.add(textField_pseudo);
		textField_pseudo.setColumns(10);
		textField_pseudo.setBorder(BorderFactory.createLineBorder(new Color(102, 153, 204)));
		
		
		textField_age = new JTextField();
		textField_age.setBounds(389, 169, 165, 25);
		contentPane.add(textField_age);
		textField_age.setColumns(10);
		textField_age.setBorder(BorderFactory.createLineBorder(new Color(102, 153, 204)));
		
		textField_email = new JTextField();
		textField_email.setBounds(389, 268, 342, 25);
		contentPane.add(textField_email);
		textField_email.setColumns(10);
		textField_email.setBorder(BorderFactory.createLineBorder(new Color(102, 153, 204)));
		
		textField_mdps = new JPasswordField();
		textField_mdps.setBounds(389, 317, 165, 25);
		contentPane.add(textField_mdps);
		textField_mdps.setColumns(10);
		textField_mdps.setBorder(BorderFactory.createLineBorder(new Color(102, 153, 204)));
		
		textField_poids = new JTextField();
		textField_poids.setBounds(389, 217, 165, 25);
		contentPane.add(textField_poids);
		textField_poids.setColumns(10);
		textField_poids.setBorder(BorderFactory.createLineBorder(new Color(102, 153, 204)));
		
		taille = new JTextField();
		taille.setBounds(566, 217, 165, 25);
		contentPane.add(taille);
		taille.setColumns(10);
		taille.setBorder(BorderFactory.createLineBorder(new Color(102, 153, 204)));
		
		textfieldconfirmmdps = new JPasswordField();
		textfieldconfirmmdps.setBounds(566, 317, 165, 25);
		contentPane.add(textfieldconfirmmdps);
		textfieldconfirmmdps.setColumns(10);
		textfieldconfirmmdps.setBorder(BorderFactory.createLineBorder(new Color(102, 153, 204)));
		
		JLabel lblNewLabel_8 = new JLabel("Poids");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(389, 193, 96, 25);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Taille");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(566, 193, 91, 25);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_confirmmdps = new JLabel("Confirmer le mot de passe");
		lblNewLabel_confirmmdps.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_confirmmdps.setBounds(566, 292, 188, 25);
		contentPane.add(lblNewLabel_confirmmdps);
		
		JButton seConnecter = new JButton("Se connecter");
		seConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Autho.main(null);
				frame.setVisible(false);
				dispose();
			}
		});
		seConnecter.setFont(new Font("Tahoma", Font.BOLD, 16));
		seConnecter.setBounds(503, 488, 147, 30);
		contentPane.add(seConnecter);
		seConnecter.setBackground(Color.WHITE);
		seConnecter.setBorder(null);
		seConnecter.setForeground(new Color(20, 108, 148));
		
		String[] sexe = {"Aucun","Femme", "Homme"};
		JComboBox comboBox_sexe = new JComboBox(sexe);
		comboBox_sexe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox_sexe.setBounds(566, 169, 164, 25);
		contentPane.add(comboBox_sexe);
		comboBox_sexe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				itemSexe = comboBox_sexe.getSelectedItem().toString();
				//System.out.println(itemSexe);
			}
			
		});
		
		JLabel lblNewLabel_Inscription = new JLabel("Inscription");
		lblNewLabel_Inscription.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_Inscription.setBounds(503, 10, 138, 30);
		contentPane.add(lblNewLabel_Inscription);
		lblNewLabel_Inscription.setForeground(new Color(34,109,104));
		
		JLabel imageSP = new JLabel("");
		imageSP.setBounds(43, 61, 316, 334);
		ImageIcon iconYoga = new ImageIcon(new ImageIcon(getClass().getResource("/images/spo.jpg.png")).getImage().getScaledInstance(300, 300, 30));
		imageSP.setIcon(iconYoga);
		contentPane.add(imageSP);
		
	
	}
}
