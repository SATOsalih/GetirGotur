package oop;

import java.io.IOException;

public abstract class AbstractCrtDisplay {

	public void setVisible(boolean b){
	}
	
	abstract void createAndDisplay() throws IOException;
}
