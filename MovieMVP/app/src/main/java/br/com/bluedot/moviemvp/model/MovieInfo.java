package br.com.bluedot.moviemvp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieInfo {
    private int id;
    private String title;
    @SerializedName("poster_path")
    private String posterUrl;
    @SerializedName("genre_ids")
    private List<Integer> genres;

    public List<Integer> getGenres() {
        return genres;
    }

    public void setGenres(List<Integer> genres) {
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }
}
