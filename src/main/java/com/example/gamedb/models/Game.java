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
    @Column(name = "cover_picture")
    private String coverPicture;
    private String picture;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Genre> genres = new ArrayList<Genre>();

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Platform> platforms = new ArrayList<Platform>();

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Category> categories = new ArrayList<Category>();

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "release_date")
    private Date releaseDate;


    public Game(long id, String title, String description, String coverPicture, String picture, Collection<Genre> genres, Collection<Platform> platforms, Collection<Category> categories, Date createdAt, Date releaseDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.coverPicture = coverPicture;
        this.picture = picture;
        this.genres = genres;
        this.platforms = platforms;
        this.categories = categories;
        this.createdAt = createdAt;
        this.releaseDate = releaseDate;
    }

    public Game() {

    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
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

    public String getCoverPicture() {
        return coverPicture;
    }

    public void setCoverPicture(String coverPicture) {
        this.coverPicture = coverPicture;
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
