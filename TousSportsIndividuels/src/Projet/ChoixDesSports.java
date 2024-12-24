package Projet;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Sports.Choix;
import Sports.Sport;
import Sports.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import Projet.DBConnection;

public class ChoixDesSports extends JFrame {
	public static ArrayList<Integer> sports = new ArrayList<Integer>();
	public static int nbSports = 0;
	private JFrame frame;
	private JPanel contentPane;
	public static User user;
	/**
	 * Launch the application.
	 */
	
	 
	public static void main(String[] args) {
		String pseudoUtilisateur = null;
		if (args != null && args.length > 0) {
			pseudoUtilisateur = args[0];
	    }
		ChoixDesSports frame = new ChoixDesSports(pseudoUtilisateur);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try { 
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	
	/** 
	 * Create the frame.
	 */
	private String pseudoUtilisateur;
	public ChoixDesSports(String pseudoUtilisateur) {
		this.pseudoUtilisateur = pseudoUtilisateur;
	
		frame = new JFrame(pseudoUtilisateur);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 543);
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_background = new JPanel();
		panel_background.setBackground(Color.WHITE);
		panel_background.setBounds(0, 0, 867, 527);
		contentPane.add(panel_background);
		panel_background.setLayout(null);
		
		String message = "Vous ne pouvez pas sélectionner plus de 4 sports";
		String message2 = "Veuillez sélectionner au moins 2 sports";
		JPanel yoga = new JPanel();
		yoga.setBorder(null);
		yoga.setBounds(83, 73, 162, 158);
		panel_background.add(yoga);
		yoga.setLayout(null);
		yoga.addMouseListener(new MouseListener() {
			int cmpt;
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(cmpt == 0) {
					if(sports.size() < 4) {
						yoga.setBackground(new java.awt.Color(115, 163, 239));
						sports.add(1);
						cmpt++;
//						nbSports++;
					} else {
						JOptionPane.showMessageDialog(null, message, "Oups..", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					yoga.setBackground(new java.awt.Color(240, 240, 240));
					sports.remove(1);
//					nbSports--;
					cmpt--;
				}
//				for (String string : sports) {
//					System.out.println("Sports"+string);
//				}
			}
		});
		
		JLabel imageYoga = new JLabel("");
		imageYoga.setBounds(41, 0, 80, 154);
		yoga.add(imageYoga);
		ImageIcon iconYoga = new ImageIcon(new ImageIcon(getClass().getResource("/images/yog.jpg")).getImage().getScaledInstance(80, 80, 30));
		imageYoga.setIcon(iconYoga);

		
		JLabel lblNewLabel = new JLabel("Yoga");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setLabelFor(this);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(0, 118, 162, 38);
		yoga.add(lblNewLabel);
		
		JPanel tirArc = new JPanel();
		tirArc.setBounds(83, 263, 162, 158);
		panel_background.add(tirArc);
		tirArc.setLayout(null);
		tirArc.addMouseListener(new MouseListener() {
			int cmpt;
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(cmpt == 0) {
					if(sports.size() < 4) {
						tirArc.setBackground(new java.awt.Color(115, 163, 239));
						sports.add(2);
						cmpt++;
//						nbSports++;
					} else {
						JOptionPane.showMessageDialog(null, message, "Oups..", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					tirArc.setBackground(new java.awt.Color(240, 240, 240));
					sports.remove(2);
//					nbSports--;
					cmpt--;
				}
//				for (String string : sports) {
//					System.out.println("Sports"+string);
//				}
			}
		});
		
		JLabel lbl_tirArc = new JLabel("Tir a l'arc");
		lbl_tirArc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_tirArc.setForeground(new Color(0, 0, 0));
		lbl_tirArc.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tirArc.setBounds(28, 121, 113, 37);
		tirArc.add(lbl_tirArc);
		
		JLabel imageTirArc = new JLabel("");
		imageTirArc.setBounds(40, 0, 80, 142);
		tirArc.add(imageTirArc);
		ImageIcon iconTirArc = new ImageIcon(new ImageIcon(getClass().getResource("/images/tira.jpg")).getImage().getScaledInstance(80, 80, 30));
		imageTirArc.setIcon(iconTirArc);
		//imageTirArc.setHorizontalAlignment(ABORT)
		
		JPanel musculation = new JPanel();
		musculation.setBounds(333, 73, 162, 158);
		panel_background.add(musculation);
		musculation.setLayout(null);
		musculation.addMouseListener(new MouseListener() {
			int cmpt;
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(cmpt == 0) {
					if(sports.size() < 4) {
						musculation.setBackground(new java.awt.Color(115, 163, 239));
						sports.add(3);
						cmpt++;
//						nbSports++;
					} else {
						JOptionPane.showMessageDialog(null, message, "Oups..", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					musculation.setBackground(new java.awt.Color(240, 240, 240));
					sports.remove(3);
//					nbSports--;
					cmpt--;
				}
			}
		});
		
		JLabel imageMuscu = new JLabel("");
		imageMuscu.setBounds(42, 31, 80, 91);
		musculation.add(imageMuscu);
		ImageIcon iconMuscu = new ImageIcon(new ImageIcon(getClass().getResource("/images/musuclation.jpg")).getImage().getScaledInstance(80, 80, 30));
		imageMuscu.setIcon(iconMuscu);
		
		JLabel lblNewLabel_1 = new JLabel("Musculation");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(42, 121, 88, 37);
		musculation.add(lblNewLabel_1);
		
		JPanel jogging = new JPanel();
		jogging.setBounds(333, 263, 162, 158);
		panel_background.add(jogging);
		jogging.setLayout(null);
		jogging.addMouseListener(new MouseListener() {
			int cmpt;
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(cmpt == 0) {
					if(sports.size() < 4) {
						jogging.setBackground(new java.awt.Color(115, 163, 239));
						sports.add(4);
						cmpt++;
//						nbSports++;
					} else {
						JOptionPane.showMessageDialog(null, message, "Oups..", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					jogging.setBackground(new java.awt.Color(240, 240, 240));
					sports.remove(4);
//					nbSports--;
					cmpt--;
				}
			}
		});
		
		JLabel imageJogging = new JLabel("");
		imageJogging.setBounds(44, 24, 80, 96);
		jogging.add(imageJogging);
		ImageIcon iconJog = new ImageIcon(new ImageIcon(getClass().getResource("/images/jogging.jpg")).getImage().getScaledInstance(80, 80, 30));
		imageJogging.setIcon(iconJog);
		
		JLabel lblNewLabel_2 = new JLabel("Jogging");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(54, 121, 64, 37);
		jogging.add(lblNewLabel_2);
		
		JPanel equitation = new JPanel();
		equitation.setBounds(574, 73, 162, 151);
		panel_background.add(equitation);
		equitation.setLayout(null);
		equitation.addMouseListener(new MouseListener() {
			int cmpt;
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(cmpt == 0) {
					if(sports.size() < 4) {
						equitation.setBackground(new java.awt.Color(115, 163, 239));
						sports.add(5);
						cmpt++;
//						nbSports++;
					} else {
						JOptionPane.showMessageDialog(null, message, "Oups..", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					equitation.setBackground(new java.awt.Color(240, 240, 240));
					sports.remove(5);
//					nbSports--;
					cmpt--;
				}
			}
		});
		
		JLabel imageEquitation = new JLabel("");
		imageEquitation.setBounds(44, 22, 80, 104);
		equitation.add(imageEquitation);
		ImageIcon iconEquit = new ImageIcon(new ImageIcon(getClass().getResource("/images/equitation.jpg")).getImage().getScaledInstance(80, 80, 30));
		imageEquitation.setIcon(iconEquit);
		
		JLabel lblNewLabel_3 = new JLabel("Equitation");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(44, 114, 80, 37);
		equitation.add(lblNewLabel_3);
		
		JPanel kayak = new JPanel();
		kayak.setBounds(574, 263, 162, 158);
		panel_background.add(kayak);
		kayak.setLayout(null);
		kayak.addMouseListener(new MouseListener() {
			int cmpt;
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(cmpt == 0) {
					if(sports.size() < 4) {
						kayak.setBackground(new java.awt.Color(115, 163, 239));
						sports.add(6);
						cmpt++;
//						nbSports++;
					} else {
						JOptionPane.showMessageDialog(null, message, "Oups..", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					kayak.setBackground(new java.awt.Color(240, 240, 240));
					sports.remove(6);
//					nbSports--;
					cmpt--;
				}
			}
		});
		
		JLabel imageKayak = new JLabel("");
		imageKayak.setBounds(41, 25, 80, 99);
		kayak.add(imageKayak);
		ImageIcon iconKayak = new ImageIcon(new ImageIcon(getClass().getResource("/images/kayak.jpg")).getImage().getScaledInstance(80, 80, 30));
		imageKayak.setIcon(iconKayak);
		
		JLabel lblNewLabel_4 = new JLabel("Kayak");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(57, 121, 64, 37);
		kayak.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Vous pratiquez quel(s) sport(s)?");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(83, 21, 653, 28);
		panel_background.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Enregistrer");
		btnNewButton.setBounds(709, 446, 97, 28);
		panel_background.add(btnNewButton);
		btnNewButton.setBackground(new Color(20, 108, 148));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBorder(null);
		btnNewButton.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_6 = new JLabel();
		lblNewLabel_6.setText(lblNewLabel_6.getText() + pseudoUtilisateur);
		lblNewLabel_6.setBounds(10, 10, 86, 13);
		panel_background.add(lblNewLabel_6);
		btnNewButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Session session = DBConnection.getSession();
				Transaction persistTransaction1 = session.beginTransaction();
				//Transaction persistTransaction1 = session.beginTransaction();
				//a modifier a l utilisateur connecte
				//User user = (User) session.get(User.class, pseudoUtilisateur);
				User user = (User) session.get(User.class, Select.findUser1(pseudoUtilisateur).getIdUser());
				
				//VERIFIER QU'AT LEAST THERE IS 2 CHOICES
				if(sports.size() < 2) {
					JOptionPane.showMessageDialog(null, message2, "Oups..", JOptionPane.ERROR_MESSAGE);
				} else {
					Integer sp1 = sports.get(0);
					Sport sport1 = (Sport) session.get(Sport.class, sp1);
					//System.out.println(sport1.getNomSport());
					Choix ch1 = new Choix(user, sport1);
					session.persist(ch1);
					Integer sp2 = sports.get(1);
					Sport sport2 = (Sport) session.get(Sport.class, sp2);
					//System.out.println(sport2.getNomSport());
					Choix ch2 = new Choix(user, sport2);
					session.persist(ch2);
					String pseudoUtilisateur = lblNewLabel_6.getText();
					 Accueil.main(new String[] {pseudoUtilisateur});
						frame.setVisible(false);
						dispose();		
				}
					Integer sp3;
					Integer sp4;
					if(sports.size() == 3) {
						sp3 = sports.get(2);
						Sport sport3 = (Sport) session.get(Sport.class, sp3);
						Choix ch3 = new Choix(user, sport3);
						session.persist(ch3);
						String pseudoUtilisateur = lblNewLabel_6.getText();
						 Accueil.main(new String[] {pseudoUtilisateur});
							frame.setVisible(false);
							dispose();		
						
						} else if(sports.size() == 4){
						sp3 = sports.get(2);
						Sport sport3 = (Sport) session.get(Sport.class, sp3);
						Choix ch3 = new Choix(user, sport3);
						session.persist(ch3);
						sp4 = sports.get(3);
						
						Sport sport4 = (Sport) session.get(Sport.class, sp4);
						Choix ch4 = new Choix(user, sport4);
						session.persist(ch4);
						String pseudoUtilisateur = lblNewLabel_6.getText();
						 Accueil.main(new String[] {pseudoUtilisateur});
							frame.setVisible(false);
							dispose();		
						
						}
					 
						
						session.getTransaction().commit();
				}
			
			
		});
		}
	

	
	
}
