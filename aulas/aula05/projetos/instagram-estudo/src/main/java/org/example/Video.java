package org.example;

import java.util.ArrayList;

public class Video {
    private String title = "";
    private String description = "";
    private boolean isOnline = false;
    private User creator;
    private int likes = 0;

    public Video(String title, User creator) {
        this.title = title;
        this.creator = creator;
    }
    public void like(User user) {
        this.likes += 1;
    }

    public int getLikes() {
        return likes;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }
}
