package oop;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import javax.swing.*;

public class LoginScreen implements ActionListener{
	
	private JFrame frame = new JFrame();
	private JButton loginButton = new JButton("Login");
	private JButton clearButton = new JButton("Clear");
	private JTextField userNameField = new JTextField();
	private JPasswordField userPasswordField = new JPasswordField();
	private JLabel userNameLabel = new JLabel("username:");
	private JLabel userPasswordLabel = new JLabel("password:");
	private JLabel messageLabel = new JLabel();
	private HashMap<String,String> userInfo = new HashMap<String,String>();
	
	LoginScreen(HashMap<String,String> users){
		
		userInfo = users;
		
		userNameLabel.setBounds(50,100,75,25);
		userPasswordLabel.setBounds(50,150,75,25);
		
		messageLabel.setBounds(125,250,250,35);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		
		userNameField.setBounds(125,100,200,25);
		userPasswordField.setBounds(125,150,200,25);
		
		loginButton.setBounds(125,200,100,25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		clearButton.setBounds(225,200,100,25);
		clearButton.setFocusable(false);
		clearButton.addActionListener(this);
		
		frame.add(userNameLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userNameField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(clearButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("GETIR GOTUR");
		frame.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==clearButton) {
			userNameField.setText("");
			userPasswordField.setText("");
		}
		
		if(e.getSource()==loginButton) {
			
			String username = userNameField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			
			if(userInfo.containsKey(username)) {
				if(userInfo.get(username).equals(password)) {
					messageLabel.setForeground(Color.green);
					messageLabel.setText("Login successful");
					frame.dispose();
					MainScreen main = new MainScreen();
					try {
						main.main(null);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					main.setVisible(true);
					frame.dispose();
				}
				else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Wrong password");
				}

			}
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("Username not found");
			}
		}
	}	
}
