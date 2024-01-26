package oop;

public class Main {

	public static void main(String[] args) {
		
		IDandPassword idandPasswords = new IDandPassword();

		new LoginScreen(idandPasswords.getUsers());

	}

}
