package oop;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class Menu implements MenuInterface{
	
	static private JFrame frame;
	static private JButton backButton;
	static private JButton orderButton;
	static private JTextField textField;
	static private GridBagConstraints gbc;
	private DefaultTableModel dtm;
	private JTable table;
	
	
	static private JLabel[] snackLabel;
	static private JLabel[] fruitLabel;
	static private JLabel[] vegetableLabel;
	static private JLabel[] foodLabel;
	static private JLabel[] drinkLabel;
	
	private Double[] snackPrice;
	private Double[] fruitPrice;
	private Double[] vegetablePrice;
	private Double[] foodPrice;
	private Double[] drinkPrice;
	
	

	private JSpinner[] snackSpinner;
	private JSpinner[] fruitSpinner;
	private JSpinner[] vegetableSpinner;
	private JSpinner[] foodSpinner;
	private JSpinner[] drinkSpinner;
	
	
	static private JLabel[] snackImage;
	static private JLabel[] fruitImage;
	static private JLabel[] vegetableImage;
	static private JLabel[] foodImage;
	static private JLabel[] drinkImage;
	
	
	private String[] snackImagesArr;
	private String[] fruitImagesArr;
	private String[] vegetableImagesArr;
	private String[] foodImagesArr;
	private String[] drinkImagesArr;
	
	
	private static final int SNACKS = 9;
	private static final int FRUITS = 9;
	private static final int VEGETABLES = 9;
	private static final int FOODS = 9;
	private static final int DRINKS = 9;

	
	private double totalPrice = 0;
	private double sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9;
	private double frp1, frp2, frp3, frp4, frp5, frp6, frp7, frp8, frp9;
	private double vp1, vp2, vp3, vp4, vp5, vp6, vp7, vp8, vp9;
	private double fop1, fop2, fop3, fop4, fop5, fop6, fop7, fop8, fop9;
	private double dp1, dp2, dp3, dp4, dp5, dp6, dp7, dp8, dp9;


	private double total = 0;
	private double snack1, snack2, snack3, snack4, snack5, snack6, snack7, snack8, snack9;
	private double fruit1, fruit2, fruit3, fruit4, fruit5, fruit6, fruit7, fruit8, fruit9;
	private double vegetable1, vegetable2, vegetable3, vegetable4, vegetable5, vegetable6, vegetable7, vegetable8, vegetable9;
	private double food1, food2, food3, food4, food5, food6, food7, food8, food9;
	private double drink1, drink2, drink3, drink4, drink5,drink6,drink7,drink8,drink9;
	
	private double totalSnacks;
	private double totalFruits;
	private double totalVegetables;
	private double totalFoods;
	private double totalDrinks;
	
	
	private static List<Product> snacks = new ArrayList<>();
	private static List<Product> fruits = new ArrayList<>();
	private static List<Product> vegetables = new ArrayList<>();
	private static List<Product> foods = new ArrayList<>();
	private static List<Product> drinks = new ArrayList<>();
	
		
	public static void readFileAndFillArr() {
		
		File productFile = new File("products.txt");
		
		Scanner scanner;
		

		try {
			scanner = new Scanner(productFile);

			while(scanner.hasNextLine()) {
				String[] arr = scanner.nextLine().split(",");
				if(arr[0].equals("Snacks")) {	
					Product p=new Product(arr[0],arr[1],Double.parseDouble(arr[2]),arr[3]);
					snacks.add(p);
				}
				else if(arr[0].equals("Fruits")) {	
					Product p=new Product(arr[0],arr[1],Double.parseDouble(arr[2]),arr[3]);
					fruits.add(p);
				}
				else if(arr[0].equals("Vegetables")) {	
					Product p=new Product(arr[0],arr[1],Double.parseDouble(arr[2]),arr[3]);
					vegetables.add(p);
				}
				else if(arr[0].equals("Foods")) {	
					Product p=new Product(arr[0],arr[1],Double.parseDouble(arr[2]),arr[3]);
					foods.add(p);		
				}
				else if(arr[0].equals("Drinks")) {	
					Product p=new Product(arr[0],arr[1],Double.parseDouble(arr[2]),arr[3]);
					drinks.add(p);
				}
				
			}

		} catch (FileNotFoundException e1) {

		}
		
	}
	
	@Override
	public void createAndDisplay() throws IOException {
		frame = new JFrame("Main Menu ");
		frame.setBounds(100, 100, 750, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		JLabel lblBasket = new JLabel("Basket");
		lblBasket.setBounds(529, 11, 81, 14);

		frame.getContentPane().add(lblBasket);

		table = new JTable();
		backButton = new JButton();
		orderButton = new JButton();
		dtm = new DefaultTableModel(0, 0);
		final String header[] = new String[] { "Food", "Qty", "Price", "Spinner" };
		dtm.setColumnIdentifiers(header);
		dtm.addRow(header);
		table = new JTable();
		table.setModel(dtm);
		table.setBounds(475, 31, 1, 1); 
		table.setSize(245, 300);
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setMinWidth(0); 													
		table.getColumnModel().getColumn(3).setMaxWidth(0); 
		
		table.setShowGrid(false);
		frame.getContentPane().add(table);
		JLabel lblTotal = new JLabel("Total  : ");
		lblTotal.setBounds(519, 340, 46, 14);
		frame.getContentPane().add(lblTotal);
		textField = new JTextField();
		textField.setBounds(585, 340, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		orderButton = new JButton("Order");
		orderButton.setBounds(500, 385, 89, 23);
		frame.getContentPane().add(orderButton);
		backButton = new JButton("Back");
		backButton.setBounds(610, 385, 89, 23);
		frame.getContentPane().add(backButton);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		addSnacks(tabbedPane, "Snacks");
		addFruits(tabbedPane, "Fruits");
		addVegetables(tabbedPane, "Vegetables");
		addFoods(tabbedPane, "Foods");
		addDrinks(tabbedPane, "Drinks");
		tabbedPane.setBounds(18, 11, 450, 450);
		frame.getContentPane().add(tabbedPane);
		frame.setVisible(true);

		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MainScreen menu = new MainScreen();
					menu.main(header);
					menu.setVisible(true);
					frame.dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		orderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Your Basket is Empty");
				} else {
					try {
						OrderScreen order = new OrderScreen();
						order.main(header);
						order.setVisible(true);
						setVisible(false);
						frame.dispose();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}

		});
	}
	
	@Override
	public void addSnacks(JTabbedPane tabbedPane, String text) throws IOException {
		JPanel panel = new JPanel(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 0, 0, 0);
		snackImage = new JLabel[SNACKS];
		snackLabel = new JLabel[SNACKS];
		snackSpinner = new JSpinner[SNACKS];
		snackImagesArr = new String[SNACKS];
		snackPrice = new Double[SNACKS];

		
		for(int i=0;i<snacks.size();i++) {
			snackImagesArr[i]=snacks.get(i).getImageLink();
			String labelName=snacks.get(i).getName();
			snackLabel[i]=new JLabel(labelName);
			snackPrice[i]=snacks.get(i).getPrice();
		}
		
		for (int i = 0; i < SNACKS; i++) {
			
			try {
			
			Image image = ImageIO.read(new File(snackImagesArr[i]));
			Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(imageScaled);
			SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 25, 1);
			snackSpinner[i] = new JSpinner(spnummodel);
			snackSpinner[i].addChangeListener(listenerSnack);
			snackImage[i] = new JLabel(imageIcon);
			}catch(Exception e) {
				System.out.print(e);
			}
		}
		gbc.gridx = 0; 
		for (int i = 0; i < SNACKS; i++) {
			if (i % 3 == 0) {
				gbc.gridy += 2;
				gbc.gridx = 0;
			}
			panel.add(snackImage[i], gbc);
			gbc.gridy++; 
			panel.add(snackLabel[i], gbc);
			gbc.gridy--; 
			gbc.gridx++; 
			panel.add(snackSpinner[i], gbc);
			gbc.gridx++; 
			tabbedPane.addTab(text, panel);
		}
	}
	
	
	
	
	
	@Override
	public void addFruits(JTabbedPane tabbedPane, String text) throws IOException {
		JPanel panel = new JPanel(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 0, 0, 0);
		fruitImage = new JLabel[FRUITS];
		fruitLabel = new JLabel[FRUITS];
		fruitSpinner = new JSpinner[FRUITS];
		fruitImagesArr = new String[FRUITS];
		fruitPrice = new Double[FRUITS];

		for(int i=0;i<fruits.size();i++) {
			fruitImagesArr[i]=fruits.get(i).getImageLink();
			String labelName=fruits.get(i).getName();
			fruitLabel[i]=new JLabel(labelName);
			fruitPrice[i]=fruits.get(i).getPrice();
		}
		
		for (int i = 0; i < FRUITS; i++) {
	
			try {

			Image image = ImageIO.read(new File(fruitImagesArr[i]));
			Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(imageScaled);
			SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 25, 1);
			fruitSpinner[i] = new JSpinner(spnummodel);
			fruitSpinner[i].addChangeListener(listenerFruit);
			fruitImage[i] = new JLabel(imageIcon);
			}catch(Exception e) {
				System.out.print(e);
			}
		}
		gbc.gridx = 0; 
		for (int i = 0; i < FRUITS; i++) {
			if (i % 3 == 0) {
				gbc.gridy += 2;
				gbc.gridx = 0;
			}
			panel.add(fruitImage[i], gbc);
			gbc.gridy++; 
			panel.add(fruitLabel[i], gbc);
			gbc.gridy--; 
			gbc.gridx++; 
			panel.add(fruitSpinner[i], gbc);
			gbc.gridx++;
			tabbedPane.addTab(text, panel);
		}
	}
	
	
	@Override
	public void addVegetables(JTabbedPane tabbedPane, String text) throws IOException {
		JPanel panel = new JPanel(new GridBagLayout());
		gbc = new GridBagConstraints(); 
		gbc.insets = new Insets(10, 0, 0, 0);
		vegetableImage = new JLabel[VEGETABLES];
		vegetableLabel = new JLabel[VEGETABLES];
		vegetableSpinner = new JSpinner[VEGETABLES];
		vegetableImagesArr = new String[VEGETABLES];
		vegetablePrice = new Double[VEGETABLES];

		for(int i=0;i<vegetables.size();i++) {
			vegetableImagesArr[i]=vegetables.get(i).getImageLink();
			String labelName=vegetables.get(i).getName();
			vegetableLabel[i]=new JLabel(labelName);
			vegetablePrice[i]=vegetables.get(i).getPrice();
		}
		
		for (int i = 0; i < VEGETABLES; i++) {

			try {
				
			Image image = ImageIO.read(new File(vegetableImagesArr[i]));
			Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(imageScaled);
			SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 25, 1);
			vegetableSpinner[i] = new JSpinner(spnummodel);
			vegetableSpinner[i].addChangeListener(listenerVegetable);
			vegetableImage[i] = new JLabel(imageIcon);
			}catch(Exception e) {
				System.out.print(e);
			}
		}
		gbc.gridx = 0;
		for (int i = 0; i < VEGETABLES; i++) {
			if (i % 3 == 0) {
				gbc.gridy += 2;
				gbc.gridx = 0;
			}
			panel.add(vegetableImage[i], gbc);
			gbc.gridy++; 
			panel.add(vegetableLabel[i], gbc);
			gbc.gridy--; 
			gbc.gridx++;
			panel.add(vegetableSpinner[i], gbc);
			gbc.gridx++;
			tabbedPane.addTab(text, panel);
		}
	}
	
	
	@Override
	public void addFoods(JTabbedPane tabbedPane, String text) throws IOException {
		JPanel panel = new JPanel(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 0, 0, 0);
		foodImage = new JLabel[FOODS];
		foodLabel = new JLabel[FOODS];
		foodSpinner = new JSpinner[FOODS];
		foodImagesArr = new String[FOODS];
		foodPrice = new Double[FOODS];

		for(int i=0;i<foods.size();i++) {
			foodImagesArr[i]=foods.get(i).getImageLink();
			String labelName=foods.get(i).getName();
			foodLabel[i]=new JLabel(labelName);
			foodPrice[i]=foods.get(i).getPrice();
		}
		for (int i = 0; i < FOODS; i++) {
	
			try {

			Image image = ImageIO.read(new File(foodImagesArr[i]));
			Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(imageScaled);
			SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 25, 1);
			foodSpinner[i] = new JSpinner(spnummodel);
			foodSpinner[i].addChangeListener(listenerFood);
			foodImage[i] = new JLabel(imageIcon);
			}catch(Exception e) {
				System.out.print(e);
			}
		}
		gbc.gridx = 0; 
		for (int i = 0; i < FOODS; i++) {
			if (i % 3 == 0) {
				gbc.gridy += 2;
				gbc.gridx = 0;
			}
			panel.add(foodImage[i], gbc);
			gbc.gridy++; 
			panel.add(foodLabel[i], gbc);
			gbc.gridy--; 
			gbc.gridx++;
			panel.add(foodSpinner[i], gbc);
			gbc.gridx++;
			tabbedPane.addTab(text, panel);
		}
	}
	@Override
	public void addDrinks(JTabbedPane tabbedPane, String text) throws IOException {
		JPanel panel = new JPanel(new GridBagLayout());
		gbc = new GridBagConstraints(); 
		gbc.insets = new Insets(10, 0, 0, 0);
		drinkImage = new JLabel[DRINKS];
		drinkLabel = new JLabel[DRINKS];
		drinkSpinner = new JSpinner[DRINKS];
		drinkImagesArr = new String[DRINKS];
		drinkPrice = new Double[DRINKS];

		for(int i=0;i<drinks.size();i++) {
			drinkImagesArr[i]=drinks.get(i).getImageLink();
			String labelName=drinks.get(i).getName();
			drinkLabel[i]=new JLabel(labelName);
			drinkPrice[i]=drinks.get(i).getPrice();
		}
		for (int i = 0; i < DRINKS; i++) {
	
			try {

			Image image = ImageIO.read(new File(drinkImagesArr[i]));
			Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(imageScaled);
			SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 25, 1); 
			drinkSpinner[i] = new JSpinner(spnummodel);
			drinkSpinner[i].addChangeListener(listenerDrink);
			drinkImage[i] = new JLabel(imageIcon);
			}catch(Exception e) {
				System.out.print(e);
			}
		}
		gbc.gridx = 0; 
		for (int i = 0; i < DRINKS; i++) {
			if (i % 3 == 0) {
				gbc.gridy += 2;
				gbc.gridx = 0;
			}
			panel.add(drinkImage[i], gbc);
			gbc.gridy++; 
			panel.add(drinkLabel[i], gbc);
			gbc.gridy--; 
			gbc.gridx++;
			panel.add(drinkSpinner[i], gbc);
			gbc.gridx++;
			tabbedPane.addTab(text, panel);
		}
	}
	
	
	ChangeListener listenerSnack = new ChangeListener() {
		public void stateChanged(ChangeEvent e) {

			final int quantity = (int) ((JSpinner) e.getSource()).getValue();
			final int rows = table.getRowCount();
			for (int row = 0; row < rows; row++) {
				if (dtm.getValueAt(row, 3) == e.getSource()) {
					if (dtm.getValueAt(row, 0).equals("Chips")) {
						dtm.setValueAt(quantity, row, 1); 
						dtm.setValueAt(sp1 * quantity, row, 2);
						snack1 = sp1 * quantity;

					} else if (dtm.getValueAt(row, 0).equals("Nuts")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(sp2 * quantity, row, 2);
						snack2 = sp2 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Wafer")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(sp3 * quantity, row, 2);
						snack3 = sp3 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Spreads")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(sp4 * quantity, row, 2);
						snack4 = sp4 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Crackers")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(sp5 * quantity, row, 2);
						snack5 = sp5 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Cookies")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(sp6 * quantity, row, 2);
						snack6 = sp6 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Candy")) {

						dtm.setValueAt(quantity, row, 1); 
						dtm.setValueAt(sp7 * quantity, row, 2);
						snack7 = sp7 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Gum")) {

						dtm.setValueAt(quantity, row, 1); 
						dtm.setValueAt(sp8 * quantity, row, 2);
						snack8 = sp8 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Ice Cream")) {

						dtm.setValueAt(quantity, row, 1); 
						dtm.setValueAt(sp9 * quantity, row, 2);
						snack9 = sp9 * quantity;
					}

					if (quantity == 0) {
						dtm.removeRow(row);
					}
					totalSnacks = snack1 + snack2 + snack3 + snack4 + snack5 + snack6 + snack7 + snack8 + snack9;
					total = totalSnacks + totalDrinks + totalFruits+totalFoods+totalVegetables;
					textField.setText(total + "");
					return;
				}
			}

			
			for (int i = 0; i < SNACKS; i++) {
				
				if (snackSpinner[i] == e.getSource()) {
					totalPrice = snackPrice[i];
					switch (snackLabel[i].getText()) {
					case "Chips":
						sp1 = snackPrice[0];
						snack1 = sp1;
						break;
					case "Nuts":
						sp2 = snackPrice[1];
						snack2 = sp2;
						break;
					case "Wafer":
						sp3 = snackPrice[2];
						snack3 = sp3;
						break;
					case "Spreads":
						sp4 = snackPrice[3];
						snack4 = sp4;
						break;
					case "Crackers":
						sp5 = snackPrice[4];
						snack5 = sp5;
						break;
					case "Cookies":
						sp6 = snackPrice[5];
						snack6 = sp6;
						break;
					case "Candy":
						sp7 = snackPrice[6];
						snack7 = sp7;
						break;
					case "Gum":
						sp8 = snackPrice[7];
						snack8 = sp8;
						break;
					case "Ice Cream":
						sp9 = snackPrice[8];
						snack9 = sp9;
						break;
					}
					totalSnacks = snack1 + snack2 + snack3 + snack4 + snack5 + snack6 + snack7 + snack8 + snack9;
					total = totalFoods + totalDrinks + totalSnacks+totalFruits+totalVegetables;
					textField.setText(total + "");
					dtm.addRow(new Object[] { snackLabel[i].getText(), quantity, totalPrice, snackSpinner[i] });
					return;
				}

			}
		}
	};

	ChangeListener listenerFruit = new ChangeListener() {
		public void stateChanged(ChangeEvent e) {

			
			final int quantity = (int) ((JSpinner) e.getSource()).getValue();
			final int rows = table.getRowCount();
			for (int row = 0; row < rows; row++) {
				if (dtm.getValueAt(row, 3) == e.getSource()) {
					if (dtm.getValueAt(row, 0).equals("Banana")) {
						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(frp1 * quantity, row, 2);
						fruit1 = frp1 * quantity;

					} else if (dtm.getValueAt(row, 0).equals("Orange")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(frp2 * quantity, row, 2);
						fruit2 = frp2 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Apple")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(frp3 * quantity, row, 2);
						fruit3 = frp3 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Blueberry")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(frp4 * quantity, row, 2);
						fruit4 = frp4 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Grape")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(frp5 * quantity, row, 2);
						fruit5 = frp5 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Pear")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(frp6 * quantity, row, 2);
						fruit6 = frp6 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Kiwi")) {

						dtm.setValueAt(quantity, row, 1); 
						dtm.setValueAt(frp7 * quantity, row, 2);
						fruit7 = frp7 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Melon")) {

						dtm.setValueAt(quantity, row, 1); 
						dtm.setValueAt(frp8 * quantity, row, 2);
						fruit8 = frp8 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Pineapple")) {

						dtm.setValueAt(quantity, row, 1); 
						dtm.setValueAt(frp9 * quantity, row, 2);
						fruit9 = frp9 * quantity;
					}

					if (quantity == 0) {
						dtm.removeRow(row);
					}
					totalFruits = fruit1 + fruit2 + fruit3 + fruit4 + fruit5 + fruit6 + fruit7 + fruit8 + fruit9;
					total = totalFoods + totalDrinks + totalFruits +totalSnacks+totalVegetables;
					textField.setText(total + "");
					return;
				}
			}

			
			for (int i = 0; i < FRUITS; i++) {
				
				if (fruitSpinner[i] == e.getSource()) {
					totalPrice = fruitPrice[i];
					switch (fruitLabel[i].getText()) {
					case "Banana":
						frp1 = fruitPrice[0];
						fruit1 = frp1;
						break;
					case "Orange":
						frp2 = fruitPrice[1];
						fruit2 = frp2;
						break;
					case "Apple":
						frp3 = fruitPrice[2];
						fruit3 = frp3;
						break;
					case "Blueberry":
						frp4 = fruitPrice[3];
						fruit4 = frp4;
						break;
					case "Grape":
						frp5 = fruitPrice[4];
						fruit5 = frp5;
						break;
					case "Pear":
						frp6 = fruitPrice[5];
						fruit6 = frp6;
						break;
					case "Kiwi":
						frp7 = fruitPrice[6];
						fruit7 = frp7;
						break;
					case "Melon":
						frp8 = fruitPrice[7];
						fruit8 = frp8;
						break;
					case "Pineapple":
						frp9 = fruitPrice[8];
						fruit9 = frp9;
						break;
					}
					totalFruits = fruit1 + fruit2 + fruit3 + fruit4 + fruit5 + fruit6 + fruit7 + fruit8 + fruit9;
					total = totalFruits + totalDrinks + totalSnacks+totalFoods+totalVegetables;
					textField.setText(total + "");
					dtm.addRow(new Object[] { fruitLabel[i].getText(), quantity, totalPrice, fruitSpinner[i] });
					return;
				}

			}
		}

	};

	ChangeListener listenerVegetable = new ChangeListener() {
		public void stateChanged(ChangeEvent e) {

			final int quantity = (int) ((JSpinner) e.getSource()).getValue();
			final int rows = table.getRowCount();
			for (int row = 0; row < rows; row++) {
				if (dtm.getValueAt(row, 3) == e.getSource()) {
					if (dtm.getValueAt(row, 0).equals("Tomato")) {
						dtm.setValueAt(quantity, row, 1); 
						dtm.setValueAt(vp1 * quantity, row, 2);
						vegetable1 = vp1 * quantity;

					} else if (dtm.getValueAt(row, 0).equals("Cucumber")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(vp2 * quantity, row, 2);
						vegetable2 = vp2 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Lemon")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(vp3 * quantity, row, 2);
						vegetable3 = vp3 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Pepper")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(vp4 * quantity, row, 2);
						vegetable4 = vp4 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Onion")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(vp5 * quantity, row, 2);
						vegetable5 = vp5 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Garlic")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(vp6 * quantity, row, 2);
						vegetable6 = vp6 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Eggplant")) {

						dtm.setValueAt(quantity, row, 1); 
						dtm.setValueAt(vp7 * quantity, row, 2);
						vegetable7 = vp7 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Carrot")) {

						dtm.setValueAt(quantity, row, 1); 
						dtm.setValueAt(vp8 * quantity, row, 2);
						vegetable8 = vp8 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Mushroom")) {

						dtm.setValueAt(quantity, row, 1); 
						dtm.setValueAt(vp9 * quantity, row, 2);
						vegetable9 = vp9 * quantity;
					}

					if (quantity == 0) {
						dtm.removeRow(row);
					}
					totalVegetables = vegetable1 + vegetable2 + vegetable3 + vegetable4 + vegetable5 + vegetable6 + vegetable7 + vegetable8 + vegetable9;
					total = totalVegetables + totalDrinks + totalFruits+totalSnacks+totalFoods;
					textField.setText(total + "");
					return;
				}
			}

			
			for (int i = 0; i < VEGETABLES; i++) {
				
				if (vegetableSpinner[i] == e.getSource()) {
					totalPrice = vegetablePrice[i];
					switch (vegetableLabel[i].getText()) {
					case "Tomato":
						vp1 = vegetablePrice[0];
						vegetable1 = vp1;
						break;
					case "Cucumber":
						vp2 = vegetablePrice[1];
						vegetable2 = vp2;
						break;
					case "Lemon":
						vp3 = vegetablePrice[2];
						vegetable3 = vp3;
						break;
					case "Pepper":
						vp4 = vegetablePrice[3];
						vegetable4 = vp4;
						break;
					case "Onion":
						vp5 = vegetablePrice[4];
						vegetable5 = vp5;
						break;
					case "Garlic":
						vp6 = vegetablePrice[5];
						vegetable6 = vp6;
						break;
					case "Eggplant":
						vp7 = vegetablePrice[6];
						vegetable7 = vp7;
						break;
					case "Carrot":
						vp8 = vegetablePrice[7];
						vegetable8 = vp8;
						break;
					case "Mushroom":
						vp9 = vegetablePrice[8];
						vegetable9 = vp9;
						break;
					}
					totalVegetables = vegetable1 + vegetable2 + vegetable3 + vegetable4 + vegetable5 + vegetable6 + vegetable7 + vegetable8 + vegetable9;
					total = totalVegetables + totalDrinks + totalSnacks+totalFoods+totalFruits;
					textField.setText(total + "");
					dtm.addRow(new Object[] { vegetableLabel[i].getText(), quantity, totalPrice, vegetableSpinner[i] });
					return;
				}

			}
		}
	};

	ChangeListener listenerFood = new ChangeListener() {
		public void stateChanged(ChangeEvent e) {

			final int quantity = (int) ((JSpinner) e.getSource()).getValue();
			final int rows = table.getRowCount();
			for (int row = 0; row < rows; row++) {
				if (dtm.getValueAt(row, 3) == e.getSource()) {
					if (dtm.getValueAt(row, 0).equals("Spaghetti")) {
						dtm.setValueAt(quantity, row, 1); 
						dtm.setValueAt(fop1 * quantity, row, 2);
						food1 = fop1 * quantity;

					} else if (dtm.getValueAt(row, 0).equals("Pasta")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(fop2 * quantity, row, 2);
						food2 = fop2 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Rice")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(fop3 * quantity, row, 2);
						food3 = fop3 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Bulghur")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(fop4 * quantity, row, 2);
						food4 = fop4 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Lentil")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(fop5 * quantity, row, 2);
						food5 = fop5 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Soup")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(fop6 * quantity, row, 2);
						food6 = fop6 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Sugar")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(fop7 * quantity, row, 2);
						food7 = fop7 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Beans")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(fop8 * quantity, row, 2);
						food8 = fop8 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Flour")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(fop9 * quantity, row, 2);
						food9 = fop9 * quantity;
					}

					if (quantity == 0) {
						dtm.removeRow(row);
					}
					totalFoods = food1 + food2 + food3 + food4 + food5 + food6 + food7 + food8 + food9;
					total = totalSnacks + totalDrinks + totalFruits+totalFoods+totalVegetables;
					textField.setText(total + "");
					return;
				}
			}

			
			for (int i = 0; i < FOODS; i++) {
				
				if (foodSpinner[i] == e.getSource()) {
					totalPrice = foodPrice[i];
					switch (foodLabel[i].getText()) {
					case "Spaghetti":
						fop1 = foodPrice[0];
						food1 = fop1;
						break;
					case "Pasta":
						fop2 = foodPrice[1];
						food2 = fop2;
						break;
					case "Rice":
						fop3 = foodPrice[2];
						food3 = fop3;
						break;
					case "Bulghur":
						fop4 = foodPrice[3];
						food4 = fop4;
						break;
					case "Lentil":
						fop5 = foodPrice[4];
						food5 = fop5;
						break;
					case "Soup":
						fop6 = foodPrice[5];
						food6 = fop6;
						break;
					case "Sugar":
						fop7 = foodPrice[6];
						food7 = fop7;
						break;
					case "Beans":
						fop8 = foodPrice[7];
						food8 = fop8;
						break;
					case "Flour":
						fop9 = foodPrice[8];
						food9 = fop9;
						break;
					}
					totalFoods = food1 + food2 + food3 + food4 + food5 + food6 + food7 + food8 + food9;
					total = totalFoods + totalDrinks + totalSnacks+totalFruits+totalVegetables;
					textField.setText(total + "");
					dtm.addRow(new Object[] { foodLabel[i].getText(), quantity, totalPrice, foodSpinner[i] });
					return;
				}

			}
		}
	};
	
	
	ChangeListener listenerDrink = new ChangeListener() {
		public void stateChanged(ChangeEvent e) {

			final int quantity = (int) ((JSpinner) e.getSource()).getValue();
			final int rows = table.getRowCount();
			for (int row = 0; row < rows; row++) {
				if (dtm.getValueAt(row, 3) == e.getSource()) {
					if (dtm.getValueAt(row, 0).equals("Water")) {
						dtm.setValueAt(quantity, row, 1); 
						dtm.setValueAt(dp1 * quantity, row, 2);
						drink1 = dp1 * quantity;

					} else if (dtm.getValueAt(row, 0).equals("Coffee")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(dp2 * quantity, row, 2);
						drink2 = dp2 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Ayran")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(dp3 * quantity, row, 2);
						drink3 = dp3 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Coke")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(dp4 * quantity, row, 2);
						drink4 = dp4 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Juice")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(dp5 * quantity, row, 2);
						drink5 = dp5 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Tea")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(dp6 * quantity, row, 2);
						drink6 = dp6 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Energy Drink")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(dp7 * quantity, row, 2);
						drink7 = dp7 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Sparkling Water")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(dp8 * quantity, row, 2);
						drink8 = dp8 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Iced Tea")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(dp9 * quantity, row, 2);
						drink9 = dp9 * quantity;
					}

					if (quantity == 0) {
						dtm.removeRow(row);
					}
					totalDrinks = drink1 + drink2 + drink3 + drink4 + drink5 + drink6 + drink7 + drink8 + drink9;
					total = totalSnacks + totalDrinks + totalFruits+totalFoods+totalVegetables;
					textField.setText(total + "");
					return;
				}
			}

			
			for (int i = 0; i < DRINKS; i++) {
				
				if (drinkSpinner[i] == e.getSource()) {
					totalPrice = drinkPrice[i];
					switch (drinkLabel[i].getText()) {
					case "Water":
						dp1 = drinkPrice[0];
						drink1 = dp1;
						break;
					case "Coffee":
						dp2 = drinkPrice[1];
						drink2 = dp2;
						break;
					case "Ayran":
						dp3 = drinkPrice[2];
						drink3 = dp3;
						break;
					case "Coke":
						dp4 = drinkPrice[3];
						drink4 = dp4;
						break;
					case "Juice":
						dp5 = drinkPrice[4];
						drink5 = dp5;
						break;
					case "Tea":
						dp6 = drinkPrice[5];
						drink6 = dp6;
						break;
					case "Energy Drink":
						dp7 = drinkPrice[6];
						drink7 = dp7;
						break;
					case "Sparkling Water":
						dp8 = drinkPrice[7];
						drink8 = dp8;
						break;
					case "Iced Tea":
						dp9 = drinkPrice[8];
						drink9 = dp9;
						break;
					}
					totalDrinks = drink1 + drink2 + drink3 + drink4 + drink5 + drink6 + drink7 + drink8 + drink9;
					total = totalFoods + totalDrinks + totalSnacks+totalFruits+totalVegetables;
					textField.setText(total + "");
					dtm.addRow(new Object[] { drinkLabel[i].getText(), quantity, totalPrice, drinkSpinner[i] });
					return;
				}

			}
		}
	};


	@Override
	public void setVisible(boolean b) {
	}
	
	
}
