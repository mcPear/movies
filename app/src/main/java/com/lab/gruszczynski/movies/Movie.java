package com.lab.gruszczynski.movies;

/**
 * Created by maciej on 14.04.17.
 */
public class Movie {
    private String title;
    private String genre;
    private String year;
    private String description;
    private Boolean watchedByUser=false;
    private int posterDrawable;

    public Movie(String title, String genre, String year) {
        this.title = title;
        this.genre = genre;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public String getYear() {
        return year;
    }

    public Boolean getWatchedByUser() {
        return watchedByUser;
    }

    public void setWatchedByUser(Boolean watchedByUser) {
        this.watchedByUser = watchedByUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPosterDrawable() {
        return posterDrawable;
    }

    public void setPosterDrawable(int posterDrawable) {
        this.posterDrawable = posterDrawable;
    }

}
