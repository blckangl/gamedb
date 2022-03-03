package com.example.gamedb.models;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Genre> genres = new ArrayList<Genre>();

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Platform> platforms = new ArrayList<Platform>();

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Category> categories = new ArrayList<Category>();

    @CreationTimestamp
    private Date created_at;

    private Date release_date;


    public Game(long id, String title, String description, String cover_picture, String picture, Collection<Genre> genres, Collection<Platform> platforms, Collection<Category> categories, Date created_at, Date release_date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.cover_picture = cover_picture;
        this.picture = picture;
        this.genres = genres;
        this.platforms = platforms;
        this.categories = categories;
        this.created_at = created_at;
        this.release_date = release_date;
    }

    public Game() {

    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
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
