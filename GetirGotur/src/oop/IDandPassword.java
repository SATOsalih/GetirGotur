package oop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class IDandPassword {

		
		HashMap<String,String> users = new HashMap<String,String>();
		
		IDandPassword(){
			
			File userFile = new File("users.txt");
			
			Scanner scanner;
			

			try {
				scanner = new Scanner(userFile);
				
				while(scanner.hasNextLine()) {
					String[] arr = scanner.nextLine().split(",");			
					User u=new User(arr[0],arr[1]);
					users.put(u.getId(),u.getPassword());
				}

			} catch (FileNotFoundException e1) {

			}

		}
		
		public HashMap getUsers(){
			return users;
		}
	
}
