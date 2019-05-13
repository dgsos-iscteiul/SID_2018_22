package testesJunit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

import config.User;

public class UserTest {

	private User user;

	@Before
	public void executedBeforeEach() {
		user = new User("testUser", "testPW");
	}

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
	
	


}
