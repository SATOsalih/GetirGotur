package oop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;




public class MainScreen extends JPanel {

	private JLabel imageLabel;
	private JLabel title;
	private JButton button;
	private static JFrame frame;
	private Panel panel1;
	
	public void createAndDisplayMainScreen() throws IOException {
		JPanel panel=new JPanel(new BorderLayout());
		Image image= ImageIO.read(new File("loginscreen.jpg"));
		Image imageScaled=image.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(imageScaled);
		imageLabel = new JLabel(imageIcon);
		Box box=Box.createVerticalBox();
		panel1=new Panel();
		title=new JLabel("GETIR GOTUR");
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		title.setAlignmentY(0.0f);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 18));
		title.setForeground(Color.GREEN);
		
		button =new JButton("Fill Your Basket Now");
		panel1.add(button);
		button.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(imageLabel, BorderLayout.CENTER);
		panel.add(box, BorderLayout.SOUTH);
		box.add(title);
		box.add(panel1);
		add(panel);
		
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu;
				try {
					menu = new Menu();
					menu.createAndDisplay();
					menu.setVisible(true);
					setVisible(false);
					frame.dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
	}
	
	public static void main(String[] args) throws IOException {
		
		MainScreen mainScreen = new MainScreen();
		mainScreen.createAndDisplayMainScreen();
		frame = new JFrame();
		frame.setTitle("GETIR GOTUR");
		frame.getContentPane().add(mainScreen);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		Menu.readFileAndFillArr();
	}

}
