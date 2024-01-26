package oop;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class OrderScreen extends AbstractCrtDisplay{

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextArea textArea;

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderScreen window = new OrderScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public OrderScreen() throws IOException {
		createAndDisplay();
	}

	
	@Override
	void createAndDisplay() throws IOException {
		frame = new JFrame("Order Form");
		frame.setBounds(100, 100, 420, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblInfo = new JLabel("Order Info");
		lblInfo.setBounds(120, 11, 131, 26);
		lblInfo.setFont(new Font("Serif", Font.PLAIN, 16));
		lblInfo.setForeground(Color.BLUE);
		frame.getContentPane().add(lblInfo);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 46, 46, 14);
		frame.getContentPane().add(lblName);

		textField_1 = new JTextField();
		textField_1.setBounds(82, 43, 176, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblAddress = new JLabel("Tel No");
		lblAddress.setBounds(10, 92, 46, 14);
		frame.getContentPane().add(lblAddress);

		textField_2 = new JTextField();
		textField_2.setBounds(82, 89, 176, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JLabel lblAddress_1 = new JLabel("Address");
		lblAddress_1.setBounds(10, 137, 62, 14);
		frame.getContentPane().add(lblAddress_1);

		Border border = BorderFactory.createLineBorder(Color.BLACK);
		textArea = new JTextArea();
		textArea.setBounds(82, 132, 236, 85);
		textArea.setMargin(new Insets(10,10,10,10));
		textArea.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		frame.getContentPane().add(textArea);

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
						|| textArea.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Field cannot be empty");
				} else {
					JOptionPane.showMessageDialog(null, "You are redirected to the payment screen... ");
					try {
						PaymentScreen payment = new PaymentScreen();
						payment.main(null);
						payment.setVisible(true);
						setVisible(false);
						frame.dispose();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		Image image = ImageIO.read(new File("delivery.jpg"));
		Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(imageScaled);
		JLabel lblNewLabel = new JLabel(imageIcon);
		lblNewLabel.setBounds(268, 19, 126, 90);
		frame.getContentPane().add(lblNewLabel);

	}

}
