import java.util.Date;


public class Post {

    private int id;
    private String head;
    private String body;
    private Date createDate;
    private Date modifyDate;
    private String picture;
    private String tag;

    Post(String head, String body, String picture, String tag) {
        this.head = head;
        this.body = body;
        this.createDate = new Date();
        this.modifyDate = new Date();
        this.picture = picture;
        this.tag = tag;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getHead() {
        return head;
    }
    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreateDate() {
        return createDate;
    }
    public Date getModifyDate() {
        return modifyDate;
    }
    public void setModifyDate() {
        this.modifyDate = new Date();
    }

    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
}