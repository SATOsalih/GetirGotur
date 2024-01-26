package oop;

import java.io.IOException;

import javax.swing.JTabbedPane;

public interface MenuInterface {
		
	public void setVisible(boolean b);
	
	public void createAndDisplay() throws IOException ;
	
	public void addSnacks(JTabbedPane tabbedPane, String text) throws IOException;
	
	public void addFruits(JTabbedPane tabbedPane, String text) throws IOException;
	
	public void addVegetables(JTabbedPane tabbedPane, String text) throws IOException;
	
	public void addFoods(JTabbedPane tabbedPane, String text) throws IOException;
	
	public void addDrinks(JTabbedPane tabbedPane, String text) throws IOException;
}
