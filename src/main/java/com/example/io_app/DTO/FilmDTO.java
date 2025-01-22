package com.example.io_app.DTO;

public class FilmDTO {

    private String name;
    private int duration;            // Czas trwania filmu w minutach
    private String description;      // Opis filmu
    private String genre;            // Gatunek filmu
    private String rate;             // Ocena filmu (np. "PG-13", "R")
    private String director;         // Reżyser filmu
    private String language;         // Język filmu

    public FilmDTO(String name, int duration, String description, String genre, String rate, String director, String language) {
        this.name = name;
        this.duration = duration;
        this.description = description;
        this.genre = genre;
        this.rate = rate;
        this.director = director;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "FilmDTO{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                ", description='" + description + '\'' +
                ", genre='" + genre + '\'' +
                ", rate='" + rate + '\'' +
                ", director='" + director + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
