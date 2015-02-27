package major;

import helpers.User;

public class author extends User{
	
	String degree;	
	
	public author(String Username, String Password) {
		//super.doLogin(Username, Password);
		this.id = 1L;
		this.getRestDetails(this.id);		
	}
	
	protected void getRestDetails(long Id) {
		/*
		Fill additional user details from DB logic
		*/
		this.degree = "stub";
	}
	
	public void publishArticle(Article article){
		System.out.println("Following article(id:"+ article.id + ") is published:" + article.Header);
	}
	
	public void updateArticle(Article article){
		System.out.println("Following article(id:"+ article.Header + ") was updated");
	}
	
	public void deleteArticle(Article article) {
		// TODO Auto-generated method stub
		System.out.println("Following article(id:"+ article.id + ") was deleted");
	}

		
	
	
	
}
