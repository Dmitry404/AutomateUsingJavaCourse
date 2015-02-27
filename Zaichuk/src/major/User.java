package major;

public abstract class User {

	Long id;
	String username;
	String password;
	String firstName;
	String lastName;
	String e_mail;
	boolean isLoggedin;
	
	public boolean doLogin(String Username, String Password) {
		
		return isLoggedin;
	}
	
}
