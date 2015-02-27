package com.company;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {

        Controller controller = new Controller();
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Select Action: Post/Comment/Exit");
            String action = in.next();
            switch (action.toLowerCase()) {
                case "post":

                    System.out.println("Select Action: Add/List/Delete/Exit");
                    String actionOnPost = in.next();
                    if (actionOnPost.equalsIgnoreCase("exit") || actionOnPost.equalsIgnoreCase("quit")) {
                        System.out.println("back to ");
                    } else if (actionOnPost.equalsIgnoreCase("add")) {

                        System.out.println("Enter nickname: ");
                        String nickname = in.next();

                        System.out.println("Enter message: ");
                        String msg = in.next();

                        System.out.println("Enter imageURL: ");
                        String imageURL = in.next();

                        Post lastPost = controller.getLastPost();
                        Post post = new Post(lastPost);
                        post.setNickname(nickname);
                        post.setMessage(msg);
                        post.setImage(imageURL);
                        controller.addPost(post);

                        System.out.println();
                    } else if (actionOnPost.equalsIgnoreCase("delete")) {
                        System.out.println("Enter post ID:");
                        long id = in.nextLong();
                        controller.removePost(id);
                        System.out.println("Post #:" + id + " removed");
                    } else if (actionOnPost.equalsIgnoreCase("list")) {
                        List<Post> list = controller.getPostList();
                        for (Post post : list) {
                            System.out.println("-------------------");
                            System.out.println("Post ID: " + post.getId());
                            System.out.println("Nickname: " + post.getNickname());
                            System.out.println("Timestamp: " + post.getTimestamp());
                            System.out.println("Image URL:  " + post.getImage());
                            System.out.println("-------------------");
                        }
                    }
                    break;

                case "comment":

                    System.out.println("Select Action: Add/List/Delete/Exit");
                    String actionOnComment = in.next();
                    if (actionOnComment.equalsIgnoreCase("exit") || actionOnComment.equalsIgnoreCase("quit")) {
                        System.out.println("back to2 ");
                    } else if (actionOnComment.equalsIgnoreCase("add")) {

                        System.out.println("Enter PostID: ");
                        long postId = in.nextLong();

                        System.out.println("Enter nickname: ");
                        String nickname = in.next();

                        System.out.println("Enter message: ");
                        String msg = in.next();

                        System.out.println("Enter imageURL: ");
                        String imageURL = in.next();

                        Comment lastComment = controller.getLastComment(postId);
                        Comment comment = new Comment(lastComment);
                        comment.setNickname(nickname);
                        comment.setMessage(msg);
                        comment.setImage(imageURL);
                        controller.addComment(postId, comment);

                        System.out.println();
                    } else if (actionOnComment.equalsIgnoreCase("delete")) {
                        System.out.println("Enter PostID from which to delete: ");
                        long postId = in.nextLong();
                        Post targetPost = controller.getPost(postId);
                        System.out.println("Enter comment ID to delete:");
                        long id = in.nextLong();

                        Comment targetComment = controller.getComment(targetPost, id);
                        controller.removeComment(targetPost, targetComment);
                        System.out.println("Comment #:" + id + " removed");
                    }
                        else if (actionOnComment.equalsIgnoreCase("list")) {
                        System.out.println("Enter PostID from which to list: ");
                        long postId = in.nextLong();
                        Post targetPost = controller.getPost(postId);

                            List<Comment> commentsList = targetPost.getCommentsList();
                            for (Comment comment : commentsList) {
                                System.out.println("-------------------");
                                System.out.println("Post ID: " + comment.getId());
                                System.out.println("Nickname: " + comment.getNickname());
                                System.out.println("Timestamp: " + comment.getTimestamp());
                                System.out.println("Image URL:  " + comment.getImage());
                                System.out.println("-------------------");
                            }

                        }
                    break;

                case "exit":
                    System.exit(0);
                    break;
            }
        }
    }


}



