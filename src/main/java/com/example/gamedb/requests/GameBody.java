package com.example.gamedb.requests;


import java.util.ArrayList;

public class GameBody {

    private long id;
    private String title;
    private String description;
    private String cover_picture;
    private String picture;

    private ArrayList<Long> genres = new ArrayList<Long>();

    private ArrayList<Long> platforms = new ArrayList<Long>();

    private ArrayList<Long> categories = new ArrayList<Long>();

    public GameBody() {
    }

    public GameBody(long id, String title, String description, String cover_picture, String picture, ArrayList<Long> genres, ArrayList<Long> platforms, ArrayList<Long> categories) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.cover_picture = cover_picture;
        this.picture = picture;
        this.genres = genres;
        this.platforms = platforms;
        this.categories = categories;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public ArrayList<Long> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<Long> genres) {
        this.genres = genres;
    }

    public ArrayList<Long> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(ArrayList<Long> platforms) {
        this.platforms = platforms;
    }

    public ArrayList<Long> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Long> categories) {
        this.categories = categories;
    }
}
