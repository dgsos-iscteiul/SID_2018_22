package testesJunit;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.*;
import org.junit.jupiter.api.Test;

import config.User;

public class UserTest {

	private User user = new User("testUser", "testPW");;

	@Test
	public void testGetName() {
		assertEquals("testUser", user.getName());
	}
	
	@Test
	public void testSetName() {	
		user.setName("testUsertest");
		assertEquals("testUsertest", user.getName());
	}
	
	@Test
	public void testGetPassword() {
		assertEquals("testPW", user.getPassword());
	}
	
	@Test
	public void testSetPassword() {	
		user.setPassword("testPWtest");
		assertEquals("testPWtest", user.getPassword());
	}
	
	@Test
	public void testGetCredentials() {
		assertNotNull(user.getCredentials());
	}
	
	@Test
	public void setCredentials() throws FileNotFoundException {
		user.setCredentials();
		assertNotNull(user.getCredentials());
	}
	
	


}
