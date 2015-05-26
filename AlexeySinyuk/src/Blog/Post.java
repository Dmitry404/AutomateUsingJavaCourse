package Blog;


public class Post {

    private String title;
    protected User poster;
    protected String text;
    protected String imgurl;

    private Post prevComment;
    private Post nextComment;

    public Post (String title, User poster, String text){
        this.title = title;
        this.poster = poster;
        this.text = text;

        Poster.incPosts();
    }

    public Post (String title, User poster, String text, String imgurl){
        this(title, poster, text);
        this.imgurl = imgurl;

        Poster.incPosts();
    }

    public String getTitle (){
        return title;
    }

    public User getPoster (){
        return poster;
    }

    public String getText (){
        return text;
    }

    public String getImgurl () {
        return imgurl;
    }

    public void setText (String text){
        this.text = text;
    }

    public void setImgurl (String imgurl) {
        this.imgurl = imgurl;
    }

    public void addComment (User poster, String text){

    }

    public void addComment (User poster, String text, String imgurl){

    }

    public void Delete (){

    }

    public void Print (){

    }
}
