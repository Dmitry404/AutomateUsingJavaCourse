package major;

import helpers.Post;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment extends Post{

	Long CommentId;
	String CommentAuthorUsername;
	String Body;
		
	public Comment(String body){
		this.Body = body;
	}
			
}
