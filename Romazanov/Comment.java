package com.company;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

/**
 * Created by aromazanov on 11/20/2014.
 */
public class Comment {

    private long id;
    private String nickname;
    private String message;
    private Date timestamp;
    private URL image;

    public Comment() {
        timestamp = new Date();
    }
    public  Comment (Comment comment)
    {
        this.id = comment.getId() + 1;
        this.timestamp = new Date();
    }

    public long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public URL getImage() {
        return image;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setImage(URL image) {
        this.image = image;
    }
    public void setImage(String url) {
        try {
            image = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();

        }

    }
}
