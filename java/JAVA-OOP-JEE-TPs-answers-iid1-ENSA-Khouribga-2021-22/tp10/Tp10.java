

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.event.AncestorListener;

import com.mysql.jdbc.Statement;


import javax.swing.event.AncestorEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Tp10 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tp10 window = new Tp10();
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
	public Tp10() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 509, 363);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("    Ajout d'un Client  ");
		frame.setSize(500,509);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrNom = new JTextArea();
		txtrNom.setBackground(SystemColor.control);
		txtrNom.setText("Nom :");
		txtrNom.setBounds(22, 53, 103, 31);
		frame.getContentPane().add(txtrNom);
		
		textField = new JTextField();
		textField.setBounds(171, 49, 187, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextArea txtrAdrresse = new JTextArea();
		txtrAdrresse.setBackground(SystemColor.control);
		txtrAdrresse.setText("Adresse :");
		txtrAdrresse.setBounds(22, 95, 80, 29);
		frame.getContentPane().add(txtrAdrresse);
		
		textField_1 = new JTextField();
		textField_1.setBounds(171, 89, 187, 31);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JTextArea txtrCodePostal = new JTextArea();
		txtrCodePostal.setBackground(SystemColor.control);
		txtrCodePostal.setText("Code postal ;");
		txtrCodePostal.setBounds(24, 150, 109, 31);
		frame.getContentPane().add(txtrCodePostal);
		
		textField_2 = new JTextField();
		textField_2.setBounds(171, 147, 187, 31);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JTextArea txtrVille = new JTextArea();
		txtrVille.setBackground(SystemColor.control);
		txtrVille.setText(" Ville :");
		txtrVille.setBounds(22, 192, 117, 31);
		frame.getContentPane().add(txtrVille);
		
		textField_3 = new JTextField();
		textField_3.setBounds(171, 192, 187, 31);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JTextArea txtrTelephone = new JTextArea();
		txtrTelephone.setText(" Telephone :");
		txtrTelephone.setBackground(SystemColor.control);
		txtrTelephone.setBounds(22, 246, 129, 31);
		frame.getContentPane().add(txtrTelephone);
		
		textField_4 = new JTextField();
		textField_4.setBounds(171, 240, 187, 36);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JTextArea txtrLogin = new JTextArea();
		txtrLogin.setBackground(SystemColor.control);
		txtrLogin.setText("  Login :");
		txtrLogin.setBounds(24, 300, 127, 36);
		frame.getContentPane().add(txtrLogin);
		
		textField_5 = new JTextField();
		textField_5.setBackground(SystemColor.text);
		textField_5.setBounds(171, 298, 187, 29);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JTextArea txtrMotDePasse = new JTextArea();
		txtrMotDePasse.setBackground(SystemColor.control);
		txtrMotDePasse.setText("Mot de passe : ");
		txtrMotDePasse.setBounds(36, 362, 129, 31);
		frame.getContentPane().add(txtrMotDePasse);
		
		textField_6 = new JTextField();
		textField_6.setBounds(181, 356, 177, 36);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String sq = "insert into t_user values ('"+textField_5.getText()+"','"+textField_6.getText()+"')";
					String sql ="insert into t_client values ('"+textField.getText()+"','"+textField_1.getText()+"','"+textField_2.getText()+"','"+textField_3.getText()+"','"+textField_4.getText()+"')";
	try {
		    			
		    			Class.forName("com.mysql.jdbc.Driver");
		    			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp10?characterEncoding=latin1","root","");
						PreparedStatement st=conn.prepareStatement(sql);
						PreparedStatement l=conn.prepareStatement(sq);
						
						st.executeUpdate(sql);
						l.executeUpdate(sq);
						 
						
		    		
		    		}
		    		
		    	catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}}
		    	
		    });
			
		btnNewButton.setBounds(33, 412, 142, 31);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.setBounds(201, 412, 157, 31);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setBounds(10, 11, 464, 448);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("  Ajout d'un client");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(39, 11, 290, 31);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
