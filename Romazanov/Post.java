package com.company;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Tpayp on 17.11.2014.
 */
public class Post {

    public long id;
    private String nickname;
    private String message;
    private Date timestamp;
    private URL image;
    public List<Comment> commentList;



    public Post(Post post)
    {
        this.id = post.getId() + 1;
        this.timestamp = new Date();
        this.commentList = new ArrayList<>();
    }
    public Post()
    {
        commentList = new ArrayList<Comment>();
    }



    public long getId()
    {
        return id;
    }

    public String getNickname()
    {
        return nickname;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Date getTimestamp()
    {
        return timestamp;
    }

    public URL getImage()
    {
        return image;
    }

    public void setImage(String url) {
        try {
            image = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();

        }
    }



    public List<Comment> getCommentsList()
    {
        return commentList;
    }

    public void addComment(Comment comment) {
        commentList.add(comment);
    }

    public void removeComment(Comment comment) {
        commentList.remove(comment);
    }
}
