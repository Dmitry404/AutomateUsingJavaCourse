package helpers;


public abstract class User {

	public Long id;
	public String username;
	public String password;
	public String firstName;
	public String lastName;
	public String e_mail;
	boolean isLoggedin;
	
	public boolean doLogin(String Username, String Password) {
		
		this.username = Username;
		this.password = Password;
		this.firstName = "";
		this.lastName = "";
		this.e_mail = "";
		
		return isLoggedin;
	}
	
	public void createUser(){
		
	}
	
	public void deleteUser(){
		
	}
	
	protected void getRestDetails(long userId) {
		
	}
	
	
	
	
}
