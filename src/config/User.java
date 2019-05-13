package config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 *  * @author jasbs1-iscteiul
 *  * @version 1.0
 */

@XStreamAlias("User")
public class User {
	
	/** The name. */
	@XStreamAlias("name")
	private String name;
	
	/** The password. */
	@XStreamAlias("password")
	private String password;
	
	/**
	 * Instantiates a new user.
	 *
	 * @param name the name
	 * @param password the password
	 */
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Gets the credentials.
	 *
	 * @return the credentials
	 */
	public void getCredentials() {
		XStream xs = new XStream();
		xs.processAnnotations(User.class);
		Object user = xs.fromXML("credentials/user_credentials.xml");
		System.out.println("User: " + user.toString());
	}
	
	/**
	 * Sets the credentials.
	 *
	 * @throws FileNotFoundException the file not found exception
	 */
	public void setCredentials() throws FileNotFoundException {
		XStream xs = new XStream();
		xs.processAnnotations(User.class);
		String xml = xs.toXML(new User(getName(),getPassword()));
		printToXml(xml);
	}
	
	/**
	 * Prints the to xml.
	 *
	 * @param xml the xml
	 * @throws FileNotFoundException the file not found exception
	 */
	public void printToXml(String xml) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File("credentials/user_credentials.xml"));
		pw.write(xml);
		pw.flush();
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws FileNotFoundException the file not found exception
	 */
	public static void main(String[] args) throws FileNotFoundException {
		User user = new User("sebastiao", "12345");
		user.setCredentials();
	}
	
}
