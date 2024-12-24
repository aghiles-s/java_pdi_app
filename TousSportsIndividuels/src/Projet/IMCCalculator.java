package Projet;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;




public class IMCCalculator extends JFrame {
	public IMCCalculator() {
	}
	/*private JFrame frame;
	frame = new JFrame();
  */
	public void setFrameVisible(boolean visible) {
        this.setVisible(visible);
    }
	public static void main(String[] args) {
		String pseudoUtilisateur = null;
	    if (args != null && args.length > 0) {
	        pseudoUtilisateur = args[0];
	    }
	    IMCCalculator  frame  = new IMCCalculator(pseudoUtilisateur);
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
	
	 private String pseudoUtilisateur;
	    public IMCCalculator(String pseudoUtilisateur) {
			this.pseudoUtilisateur = pseudoUtilisateur;
	        initialize();
	    }
	    
	private void initialize() {
    JFrame frame = new JFrame("IMC Calculator");
    frame.getContentPane().setBackground(UIManager.getColor("Button.focus"));
    //frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(675, 411);
    frame.setResizable(false);
  
    frame.getContentPane().setLayout(null);
    JLabel titleLabel = new JLabel("IMC");
    titleLabel.setForeground(UIManager.getColor("Button.highlight"));
    titleLabel.setBounds(273, 34, 110, 41);
    titleLabel.setFont(new Font("Eras Demi ITC", Font.BOLD, 50));

    JLabel weightLabel = new JLabel("Weight (kg) :");
    weightLabel.setForeground(new Color(255, 255, 255));
    weightLabel.setBounds(193, 105, 110, 21);
    weightLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
    
    JTextField weightField = new JTextField(10);
    weightField.setFont(new Font("Tahoma", Font.PLAIN, 14));
    weightField.setBounds(313, 103, 111, 23);
    
    JLabel heightLabel = new JLabel("Height (cm) :");
    heightLabel.setForeground(new Color(255, 255, 255));
    heightLabel.setBounds(193, 146, 110, 21);
    heightLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
    
    JTextField heightField = new JTextField(10);
    heightField.setFont(new Font("Tahoma", Font.PLAIN, 14));
    heightField.setBounds(313, 144, 111, 23);
    
    JButton calculateButton = new JButton("Calculate");
    calculateButton.setBounds(183, 229, 101, 23);
    calculateButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
    
    JButton resetButton = new JButton("Reset");
    resetButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
    resetButton.setBounds(320, 229, 89, 23);
    
   	
    JButton fermerButton = new JButton("Cancel");
    fermerButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
			Accueil.main(new String[] {pseudoUtilisateur});
			frame.setVisible(false);
			dispose();	
    	}

		
    });
    fermerButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
    fermerButton.setBounds(434, 229, 89, 23);
    
    JLabel resultLabel = new JLabel("");
    resultLabel.setForeground(new Color(255, 255, 255));
    resultLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
    resultLabel.setBounds(56, 279, 256, 23);
    
    JLabel infoLabel1 = new JLabel("");
    infoLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
    infoLabel1.setForeground(new Color(255, 140, 0));
    infoLabel1.setBounds(56, 311, 247, 23);
    JLabel infoLabel2 = new JLabel("");
    infoLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
    infoLabel2.setForeground(new Color(0, 153, 51));
    infoLabel2.setBounds(56, 311, 247, 23);
    JLabel infoLabel3 = new JLabel("");
    infoLabel3.setFont(new Font("Tahoma", Font.PLAIN, 14));
    infoLabel3.setForeground(new Color(255, 215, 0));
    infoLabel3.setBounds(56, 311, 247, 23);
    JLabel infoLabel4 = new JLabel("");
    infoLabel4.setFont(new Font("Tahoma", Font.PLAIN, 14));
    infoLabel4.setForeground(new Color(255, 140, 0));
    infoLabel4.setBounds(56, 311, 247, 23);
    JLabel infoLabel5 = new JLabel("");
    infoLabel5.setFont(new Font("Tahoma", Font.PLAIN, 14));
    infoLabel5.setForeground(new Color(255, 69, 0));
    infoLabel5.setBounds(56, 311, 247, 23);
    JLabel infoLabel6 = new JLabel("");
    infoLabel6.setFont(new Font("Tahoma", Font.PLAIN, 14));
    infoLabel6.setForeground(new Color(255, 0, 0));
    infoLabel6.setBounds(56, 311, 247, 23);


    calculateButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String weightText = weightField.getText();
        String heightText = heightField.getText();
        if (weightText.isEmpty() || heightText.isEmpty() || Double.parseDouble(weightText) < 20 || Double.parseDouble(heightText) < 20) {
          JOptionPane.showMessageDialog(frame, "Please enter valid weight and height.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
        		if (!resultLabel.getText().equals("")){
        			JOptionPane.showMessageDialog(frame, "Please reset first.", "Error", JOptionPane.ERROR_MESSAGE);
        		}
        		else{
			          double weight = Double.parseDouble(weightText);
			          double height = Double.parseDouble(heightText) /100;
			          double imc = weight / (height * height);
			          
			          resultLabel.setText("Your IMC is : " + String.format("%.2f", imc));
			          if (imc < 18.5) {
			        	infoLabel1.setText(infoLabel1.getText() + "You are underweight !");
			          } else if (imc >= 18.5 && imc < 25) {
			        	infoLabel2.setText(infoLabel2.getText() + "You have a normal weight");
			          } else if (imc >= 25 && imc < 30) {
			        	infoLabel3.setText(infoLabel3.getText() + "You are overweight !");
			          } else if (imc >= 30 && imc < 35) {
			        	infoLabel4.setText(infoLabel4.getText() + "You have moderate obesity !");
			          } else if (imc >= 35 && imc < 40) {
			        	infoLabel5.setText(infoLabel5.getText() + "You have severe obesity !");
			          } else {
			        	infoLabel6.setText(infoLabel6.getText() + "You have massive or morbid obesity !");
			          }
        			}
        		}
      	}
    });
   
    resetButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
      	  weightField.setText("");
      	  heightField.setText("");
      	  resultLabel.setText("");
      	  infoLabel1.setText("");
      	  infoLabel2.setText("");
      	  infoLabel3.setText("");
      	  infoLabel4.setText("");
       	  infoLabel5.setText("");
       	  infoLabel6.setText("");
      	  
  		}
      });
    
    frame.getContentPane().add(titleLabel);
    frame.getContentPane().add(weightLabel);
    frame.getContentPane().add(weightField);
    frame.getContentPane().add(heightLabel);
    frame.getContentPane().add(heightField);
    frame.getContentPane().add(calculateButton);
    frame.getContentPane().add(resetButton);
    frame.getContentPane().add(fermerButton);
    frame.getContentPane().add(resultLabel);
    frame.getContentPane().add(infoLabel1);
    frame.getContentPane().add(infoLabel2);
    frame.getContentPane().add(infoLabel3);
    frame.getContentPane().add(infoLabel4);
    frame.getContentPane().add(infoLabel5);
    frame.getContentPane().add(infoLabel6);

    
    JLabel logoLabel = new JLabel("");
    logoLabel.setIcon(new ImageIcon(getClass().getResource("/images/logo_IMC.png")));
    logoLabel.setBounds(10, 20, 50, 50);
    frame.getContentPane().add(logoLabel);
    
    JLabel fondLabel = new JLabel("\r\n");
    fondLabel.setIcon(new ImageIcon(getClass().getResource("/images/fond_IMC.jpg")));
    fondLabel.setBounds(-73, -13, 734, 402);
    frame.getContentPane().add(fondLabel);
    
    frame.setVisible(true);
  }
}