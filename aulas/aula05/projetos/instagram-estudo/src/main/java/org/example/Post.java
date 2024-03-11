package org.example;

import java.util.ArrayList;

public class Post extends Video {
    private ArrayList<String> comments = new ArrayList<>();

    public Post(String title, User creator) {
        super(title, creator);
    }

    public void comment(User user, String comment) {
        comments.add(user.getName() + ": " + comment);
    }

    public void showComments() {
        for (String comment : comments) {
            System.out.println(comment);
        }
    }
}
