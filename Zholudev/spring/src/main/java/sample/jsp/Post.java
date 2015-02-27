package sample.jsp;

public class Post {
    String title;
    String message;
    String url;
    String img;


    public String getTitle(){
        return title;
    }
    public String getMessage(){
        return message;
    }
    public String getUrl(){
        return url;
    }
    public String getImg(){
        return img;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public void setImg(String img){
        this.img = img;
    }

}
