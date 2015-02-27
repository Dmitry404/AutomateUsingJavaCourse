package major;

public class WebBlog {

	int blogId;
	String[] topics;
	author[] authors;
	
	public WebBlog(int id){
		blogId = id;
	}
	
	public static void main(String[] args){
	 	Article article = new Article("Science brakethrou", "bla bla bla", "brakethrou");
	 	
	 	author Evgeniy = new author("ez", "12345");
	 	
	 	Evgeniy.publishArticle(article);
	 	
		
	}	
	
}
