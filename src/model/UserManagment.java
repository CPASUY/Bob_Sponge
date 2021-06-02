package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class UserManagment <T> implements Serializable{
	private static final long serialVersionUID = 1L;
	private User<T> root;
	public static final String USERS_FILE_NAME="data/Users.bbd";

	public UserManagment() {
		try {
			loadRootUsers();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addPlayer(User <T> u)  {
		if(root== null) {
			root = u;
		}else {
			addPlayer(root,u);
		}
	}
	public void addPlayer(User<T> current,User<T> newNode) {
		if(current!= null) {
			if(newNode.getScore()>=current.getScore()) {
				User<T> left =current.getLeft();
				if(left != null) {	
					addPlayer(left,newNode);	
				} else {		
					current.setLeft(newNode);		
					newNode.setFather(current);

				}	
			}else if(newNode.getScore()<=current.getScore()) {
				User<T> right = current.getRight();
				if(right != null) {		
					addPlayer(right,newNode);
				} else {	
					current.setRight(newNode);	
					newNode.setFather(current);
				}	
			}
		}
	}
	public ArrayList<User<T>> showList() {
		ArrayList<User<T>> listUsers = new ArrayList<User<T>>();
		return showList(root,listUsers);
	}
	public ArrayList<User<T>> showList(User<T> current,ArrayList<User<T>> users) {
		if (current!= null) {
			showList(current.getRight(),users);
			users.add(current);
			showList(current.getLeft(),users);
		}
		return users;
	}
	public void saveRootUsers() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERS_FILE_NAME));
		oos.writeObject(root);
		oos.close();
	}
	@SuppressWarnings("unchecked")
	public void loadRootUsers() throws IOException, ClassNotFoundException{	
		File f=new File(USERS_FILE_NAME);
		if(f.exists()) {
			ObjectInputStream ois= new ObjectInputStream(new FileInputStream(f));
			root=(User<T>)ois.readObject();
			ois.close();
		}
	}
}
