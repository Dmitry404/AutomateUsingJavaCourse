import java.util.Date;

/**
 * Created by gtsapock on 2015-02-19.
 */
public class Article {
    private long id;
    private java.util.Date Date;
    public String Subject;
    public String Body;
    public int Rating;
    public int Views;

    public Article(String s, String s1) {
    }

    private void addArticle(String Subject, String Body) {
        this.Subject = Subject;
        this.Body = Body;
    }
}
