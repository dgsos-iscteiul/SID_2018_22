package config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("User")
public class User {
	
	@XStreamAlias("name")
	private String name;
	@XStreamAlias("password")
	private String password;
	
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void getCredentials() {
		XStream xs = new XStream();
		xs.processAnnotations(User.class);
		Object user = xs.fromXML("credentials/user_credentials.xml");
		System.out.println("User: " + user.toString());
	}
	
	public void setCredentials() throws FileNotFoundException {
		XStream xs = new XStream();
		xs.processAnnotations(User.class);
		String xml = xs.toXML(new User(getName(),getPassword()));
		printToXml(xml);
	}
	
	public void printToXml(String xml) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File("credentials/user_credentials.xml"));
		pw.write(xml);
		pw.flush();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		User user = new User("andree", "12345");
		user.setCredentials();
	}
	
}
