package br.com.bluedot.moviemvp.room.movie;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class MovieSearch {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "tmdb_id")
    private int tmdbId;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] image;

    @ColumnInfo(name = "original_title")
    private String title;

    @ColumnInfo(name = "overview")
    private String overView;

    @ColumnInfo(name = "run_time")
    private int runTime;

    @ColumnInfo(name = "vote_average")
    private Double voteAvarage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTmdbId() {
        return tmdbId;
    }

    public void setTmdbId(int tmdbId) {
        this.tmdbId = tmdbId;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverView() {
        return overView;
    }

    public void setOverView(String overView) {
        this.overView = overView;
    }

    public int getRunTime() {
        return runTime;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    public Double getVoteAvarage() {
        return voteAvarage;
    }

    public void setVoteAvarage(Double voteAvarage) {
        this.voteAvarage = voteAvarage;
    }
}
