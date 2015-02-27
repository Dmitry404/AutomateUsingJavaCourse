/**
 * 
 */
package major;

import helpers.User;

/**
 * @author ezaichuk
 *
 */
public class reader extends User{

	String Country;
	String City;
	
	
	public reader(String Username, String Password) {
		super.doLogin(Username, Password);
	}
	
	protected void getRestDetails(long Id) {
		/*
		Fill additional user details from DB logic
		*/
		this.Country = "stub";
		this.City = "stub";
	}
			
	public void publishComment(Comment comment) {
		
	}

	public void updateComment(Comment comment) {
		
		
	}
	
}
