package oop;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class PaymentScreen extends AbstractCrtDisplay {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentScreen window = new PaymentScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public PaymentScreen() throws IOException {
		createAndDisplay();
	}
	
	@Override
	void createAndDisplay() throws IOException {
		frame = new JFrame("Payment");
		frame.setBounds(100, 100, 420, 300); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JLabel lblPayment = new JLabel("Payment");
		lblPayment.setBounds(120, 11, 131, 26);
		lblPayment.setFont(new Font("Serif", Font.PLAIN, 16));
		lblPayment.setForeground(Color.BLUE);
		frame.getContentPane().add(lblPayment);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 46, 46, 14);
		frame.getContentPane().add(lblName);

		textField_1 = new JTextField();
		textField_1.setBounds(82, 43, 176, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblCardNumber = new JLabel("Card");
		lblCardNumber.setBounds(10, 92, 46, 14);
		frame.getContentPane().add(lblCardNumber);

		textField_2 = new JTextField();
		textField_2.setBounds(82, 89, 176, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(10, 138, 46, 14);
		frame.getContentPane().add(lblDate);

		textField_3 = new JTextField();
		textField_3.setBounds(82, 135, 176, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		
		JLabel lblCVV = new JLabel("CVV");
		lblCVV.setBounds(10, 184, 46, 14);
		frame.getContentPane().add(lblCVV);

		textField_4 = new JTextField();
		textField_4.setBounds(82, 181, 176, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);


		
		
		JButton btnCancel = new JButton("Cancel ");
		btnCancel.setBounds(130, 228, 89, 23);
		frame.getContentPane().add(btnCancel);

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				try {
					menu.createAndDisplay();
					menu.setVisible(true);
					setVisible(false);
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				frame.dispose();
			}
		});

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(229, 228, 89, 23);
		frame.getContentPane().add(btnConfirm);

		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_1.getText().equals("") || textField_2.getText().equals("")
						|| textField_3.getText().equals("") || textField_4.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Field cannot be empty");
				} else {
					JOptionPane.showMessageDialog(null, "Your order will be delivered soon, thanks for ordering. ");
					MainScreen main = new MainScreen();
					try {
						main.main(null);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					main.setVisible(true);
					frame.dispose();
				}
			}
		});
		
	}

	
}
