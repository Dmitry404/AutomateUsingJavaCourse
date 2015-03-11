public class Comment {

    private String comment_body;

    public Comment(){
        comment_body = "";
    }

    public void createNewComment(String body){
        setComment_body(body);
    }

    public String toString(){
        return this.getComment_body();
    }

    public String getComment_body() {
        return comment_body;
    }
    public void setComment_body(String comment_body) {
        this.comment_body = comment_body;
    }
}
