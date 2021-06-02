package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserManagmentTest {

	UserManagment<String> usm;
	
	public void setup1() {
		usm = new UserManagment<>();
	}
	
	public void setup2() {
		setup1();
		User<String> newUser1 = new User<>("anderson", 20);
		User<String> newUser2 = new User<>("juan", 30);
		User<String> newUser3 = new User<>("carolina", 10);
		
		usm.addPlayer(newUser1);
		usm.addPlayer(newUser2);
		usm.addPlayer(newUser3);
	}
	
	public void setup3() {
		setup1();
		User<String> newUser1 = new User<>("anderson", 10);
		User<String> newUser2 = new User<>("juan", 20);
		User<String> newUser3 = new User<>("carolina", 30);
		User<String> newUser4 = new User<>("sebastian", 5);
		User<String> newUser5 = new User<>("jhon", 2);
		
		usm.addPlayer(newUser1);
		usm.addPlayer(newUser2);
		usm.addPlayer(newUser3);
		usm.addPlayer(newUser4);
		usm.addPlayer(newUser5);
	}
	@Test
	void test() {
		setup2();
		assertNotNull(usm.getRoot().getLeft(),"It is null");
		assertNotNull(usm.getRoot().getRight(),"It is null");
		assertEquals(10,usm.getRoot().getRight().getScore(),"It is null");
		assertEquals(30,usm.getRoot().getLeft().getScore(),"It is null");
	}

	@Test
	void test2() {
		setup3();
		assertNotNull(usm.getRoot(),"It is null");
		
		assertEquals("anderson",usm.getRoot().getNickname(),"It is null");
		assertEquals("juan",usm.getRoot().getLeft().getNickname(),"It is null");
		assertEquals("carolina",usm.getRoot().getLeft().getLeft().getNickname(),"It is null");
		assertEquals("sebastian",usm.getRoot().getRight().getNickname(),"It is null");
		assertEquals("jhon",usm.getRoot().getRight().getRight().getNickname(),"It is null");

	}
}
