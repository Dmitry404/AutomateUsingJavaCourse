package Blog;

/**
 * Created by asinuk on 16/02/2015.
 */
public class Post {

    private String Title;
    protected User Poster;
    protected String Text;
    protected String Imgurl;

    private Post prevComment;
    private Post nextComment;

    public Post (String Title, User Poster, String Text){
        this.Title = Title;
        this.Poster = Poster;
        this.Text = Text;

        Poster.incPosts();
    }

    public Post (String Title, User Poster, String Text, String Imgurl){
        this(Title, Poster, Text);
        this.Imgurl = Imgurl;

        Poster.incPosts();
    }

    private Post (Post prevComment, User Poster, String Text){
        this("", Poster, Text);
        this.prevComment = prevComment;
    }

    private Post (Post prevComment, User Poster, String Text, String Imgurl){
        this("", Poster, Text, Imgurl);
        this.prevComment = prevComment;
    }

    public String getTitle (){
        return Title;
    }

    public User getPoster (){
        return Poster;
    }

    public String getText (){
        return Text;
    }

    public String getImgurl () {
        return Imgurl;
    }

    public void setText (String Text){
        this.Text = Text;
    }

    public void setImgurl (String Imgurl) {
        this.Imgurl = Imgurl;
    }

    public void addComment (User Poster, String Text){
        if (nextComment == null) {
            nextComment = new Post (this, Poster, Text);
        } else {
            nextComment.addComment(Poster, Text);
        }
    }

    public void addComment (User Poster, String Text, String Imgurl){
        if (nextComment == null) {
            nextComment = new Post (this, Poster, Text, Imgurl);
        } else {
            nextComment.addComment(Poster, Text, Imgurl);
        }
    }

    public Post getComment (int id){
        //TODO exceptions
        if (nextComment != null) {
            return nextComment.getComment(id, 1);
        } else {
            return null;
        }
    }

    private Post getComment (int id, int depth){
        if (id == depth) {
            return this;
        } else {
            if (nextComment != null) {
                return nextComment.getComment(id, depth + 1);
            } else {
                return null;
            }
        }
    }

    public void Delete (){
        //TODO exceptions
        prevComment.nextComment = nextComment;
        nextComment.prevComment = prevComment;
    }

    public void Print (){
        if (prevComment == null){
            System.out.println(Text);
        } else {
            System.out.println("    " + Text);
        }
        if (nextComment != null) nextComment.Print();
    }

    public void PrintComment (){
        System.out.println(Text);
    }
}
