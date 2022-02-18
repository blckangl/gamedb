package com.example.gamedb.models;

public class Game {
    private int uuid;
    private String title;
    private String description;
    private String cover_picture;
    private String picture;

    public Game(int uuid, String title, String description, String cover_picture, String picture) {
        this.uuid = uuid;
        this.title = title;
        this.description = description;
        this.cover_picture = cover_picture;
        this.picture = picture;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCover_picture() {
        return cover_picture;
    }

    public void setCover_picture(String cover_picture) {
        this.cover_picture = cover_picture;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
