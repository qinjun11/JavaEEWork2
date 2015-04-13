package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entry.User;

public class FileManage {
	public FileManage() {

	}
     public void setUser(User u){
    	 List<User>  us = getUser();
    	 String s1;
    	 try {
 			BufferedWriter output = new BufferedWriter(new FileWriter(
 					"E:/xc/Downloads/JavaEEWork2/user.txt"));
 			for (int i = 0; i < us.size(); i++) {
 				
 					s1 = us.get(i).getUsername() + "," + us.get(i).getPassword();
 					output.write(s1, 0, s1.length());
 					output.newLine();
 			}
 			s1 = u.getUsername() + "," + u.getPassword();
				output.write(s1, 0, s1.length());
				output.newLine();
 			output.close();
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}

     }
	public List<User> getUser() {
		List<User>  us = new ArrayList<User>();
		String line;
        String[] s;
		BufferedReader buf = null;
		try {
			buf = new BufferedReader(new FileReader("E:/xc/Downloads/JavaEEWork2/user.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch blockry
			e1.printStackTrace();
		}
		try {
			while ((line = buf.readLine()) != null) {
				 s= line.split(",");
				 User u = new User();
				 u.setUsername(s[0]);
				 u.setPassword(s[1]);
				 us.add(u);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return us;
	}

}
