package major;

import helpers.Post;
import helpers.User;

public class Moderator extends User{
	
	WebBlog[] moderatedBlogs;
	
	protected void getRestDetails(long Id) {
		/*
		Fill additional user details from DB logic
		*/
		this.moderatedBlogs = this.getModeratedBlogs(Id);
		
	}


	public void publishArticle(Article article) {
			
	}

	public void updateArticle(Article article) {
		
		
	}

	public void deleteArticle(Article article) {
		
	}

	public void publishComment(Comment comment) {
		
	}

	public void updateComment(Comment comment) {
		
		
	}

	public void deleteComment(Comment comment) {
		
	}	
	
	
	protected WebBlog[] getModeratedBlogs(long moderatorId){
		return moderatedBlogs;		
	}

}
