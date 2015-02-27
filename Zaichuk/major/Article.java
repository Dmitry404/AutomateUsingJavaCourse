package major;

import helpers.Post;

import java.util.Date;

public class Article extends Post{

	Long id;
	String Header;
	String Body;
	String Tags;
		
	public Article(String header, String body, String tags)
	{
		this.id = (long) 1;
		this.Header = header;
		this.Body = body;
		this.Tags = tags;
	}
	
}
