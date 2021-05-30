package model;

import java.util.ArrayList;

public class UserManagment <T>{
	private User<T> root;

	public UserManagment() {
	}
	
	public void addPlayer(String name,double score)  {
		User <T> u=new User<T>(name,score);
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
}
