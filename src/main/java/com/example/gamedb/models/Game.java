package com.example.gamedb.models;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @Type(type = "text")
    private String description;
    private String cover_picture;
    private String picture;

    @OneToMany(fetch = FetchType.LAZY)
    private Collection<Genre> genres = new ArrayList<Genre>();

    @OneToMany(fetch = FetchType.LAZY)
    private Collection<Platform> platforms = new ArrayList<Platform>();

    @OneToMany(fetch = FetchType.LAZY)
    private Collection<Category> categories = new ArrayList<Category>();



    public Game(long id, String title, String description, String cover_picture, String picture, Collection<Genre> genres, Collection<Platform> platforms, Collection<Category> categories) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.cover_picture = cover_picture;
        this.picture = picture;
        this.genres = genres;
        this.platforms = platforms;
        this.categories = categories;
    }

    public Game() {

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

    public Collection<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Collection<Genre> genres) {
        this.genres = genres;
    }

    public Collection<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(Collection<Platform> platforms) {
        this.platforms = platforms;
    }

    public Collection<Category> getCategories() {
        return categories;
    }

    public void setCategories(Collection<Category> categories) {
        this.categories = categories;
    }
}
