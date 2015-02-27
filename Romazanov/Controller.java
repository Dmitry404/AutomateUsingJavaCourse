package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tpayp on 17.11.2014.
 */
public class Controller {

    private List<Post> postList;

    public Controller() {
        postList = new ArrayList<Post>();
    }

    public void addPost(Post post) {
        postList.add(post);
    }

    public Post getPost(long id) {
        for (Post post : postList) {
            if (post.getId() == id) {
                return post;
            }
        }
        throw new NullPointerException("The item with id = " + id + " not found");
    }

    public void removePost(long id) {
        Post post = getPost(id);
//        if (post == null) {
//            throw new NullPointerException("The item with id = " + id + " not found");
//        }
        removePost(post);
    }

    public void removePost(Post post) {
        postList.remove(post);
    }

    public Post getLastPost() {
        return postList.isEmpty() ? new Post() : postList.get(postList.size() - 1);
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void removeComment(Post post, Comment comment) {
        post.removeComment(comment);
    }

    public void addComment(long idPost, Comment comment) {
        Post post = getPost(idPost);
        post.addComment(comment);
    }

    public Comment getComment(Post post, long idComment) {
        for (Comment comment : post.getCommentsList()) {
            if (comment.getId() == idComment) {
                return comment;
            }
        }
        return null;
    }

    public Comment getLastComment(long idPost) {
        Post post = getPost(idPost);
        return getLastComment(post);
    }


    public Comment getLastComment(Post post) {
        List<Comment> comments = post.getCommentsList();
        return comments.isEmpty() ? new Comment() : comments.get(comments.size() - 1);
    }
}

